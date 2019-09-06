import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;

class Client implements Serializable
{
    int clientip;
    String name;
}

public class CollectionsSever implements Runnable {
    int clientport=10,serverport=20;
    DatagramSocket ds;
    Thread recThread;
    HashMap <Integer,Client> cl;

    CollectionsSever() throws Exception
    {
        cl=new HashMap<>();
        ds = new DatagramSocket(serverport);
        recThread=new Thread(this);
        recThread.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String data=br.readLine();
            if(data.equals("EXIT")){
                break;
            }
            DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),clientport);
            ds.send(dp);
        }
        ds.close();
    }

    public void run() 
    {
        byte b[]=new byte[1000];
        while(true)
        {
            try
            {
                DatagramPacket dp=new DatagramPacket(b,b.length);
                ds.receive(dp);
                String data=new String(b,0,dp.getLength());
                System.out.println(data);
                if( data.length() >=8 && ("register").equals(data.substring(0,8)))
                {
                    //System.out.println("--"+data.substring(0,8));
                    initClient(data,dp.getPort());
                    //System.out.println("-------------"+cl.toString());
                }
                else if(data.length()>=4 && ("LIVE").equals(data.substring(0,4)))
                {
                    //System.out.println("-------------"+cl.get(dp.getPort()));
                    if(cl.get(dp.getPort())!=null) {
                        System.out.println("live activated");
                        sendOtherPeopleData(dp.getPort());
                        
                    }
                }
                else if(data.length()>=5 && ("SEND ").equals(data.substring(0,5)))
                {
                    System.out.println("GOT SEND Message");
                    System.out.println(sendMessageToUser(data));
                }   
                System.out.println(data);
            }catch(Exception e){
                System.out.print(e.getMessage());
            }
        }
    }

    void initClient(String data,int port)
    {
        List<String> splits = new ArrayList<String>();
        Collections.addAll(splits,data.split(" "));
        splits.removeAll(Arrays.asList("", null));
        Client c=new Client();
        //System.out.print(splits.toString());
        c.name=splits.get(1);
        System.out.print("Registered in name of "+splits.get(1));
        c.clientip=port;
        cl.put(port, c);
        //System.out.print(c.name);
    }

    void sendOtherPeopleData(int port)
    {
        try{
        Iterator hmIterator = cl.entrySet().iterator();
        while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            if(((Client)mapElement.getValue()).clientip!=port)
            {
                Client tempclass=(Client)mapElement.getValue();
                String temp="Client : "+tempclass.name+" Port No : "+tempclass.clientip;
                System.out.println(temp);
                DatagramPacket dp=new DatagramPacket(temp.getBytes(),temp.length(),InetAddress.getLocalHost(),port);
                ds.send(dp);
            }
        }  
    }catch(Exception e)
    {
        System.out.print(e.getMessage());
    }
            // DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),clientport);
            // ds.send(dp);
    }

    boolean sendMessageToUser(String data)
    {

        List<String> splits = new ArrayList<String>();
        Collections.addAll(splits,data.split(" "));
        splits.removeAll(Arrays.asList("", null));
        System.out.println(splits.toString());

       // if(splits.get(0)=="SEND" && splits.get(1)=="TO" && splits.get(3)=="THAT")
        //{
            try{
                Iterator hmIterator = cl.entrySet().iterator();
                while (hmIterator.hasNext()) { 
                    Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
                        Client tempclass=(Client)mapElement.getValue();
                        System.out.println(splits.get(2) +" "+tempclass.name);
                        if((tempclass.name).equals(splits.get(2)))
                        {
                            StringBuilder s=new StringBuilder("");
                            for(int i=4;i<splits.size();i++)
                            {
                                s.append(splits.get(i));
                                s.append(" ");
                            }
                            DatagramPacket dp=new DatagramPacket((s.toString()).getBytes(),(s.toString()).length(),InetAddress.getLocalHost(),tempclass.clientip);
                            ds.send(dp);            
                            return true;
                        }
                }  
            }catch(Exception e)
            {
                System.out.print(e.getMessage());
            }       
        //}
        return false;
    }

    public static void main(String []args) throws Exception{
        CollectionsSever sp=new CollectionsSever();
    }
}