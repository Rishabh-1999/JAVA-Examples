import java.io.*;
import java.io.*;
import java.net.*;
import java.util.*;

class CollectionsClientA implements Runnable{
    int serverport=20,clientip;
    DatagramSocket ds;
    Thread recThread;
    static String name;

    CollectionsClientA() throws Exception{
        clientip=50;
        ds=new DatagramSocket(clientip);
        recThread=new Thread(this);
        recThread.start();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        String register="register "+name;
        DatagramPacket dp1=new DatagramPacket(register.getBytes(),register.length(),InetAddress.getLocalHost(),serverport);
        ds.send(dp1);

        while(true){
            String data=br.readLine();
            if(data.equals("EXIT")){
                break;
            }
            DatagramPacket dp=new DatagramPacket(data.getBytes(),data.length(),InetAddress.getLocalHost(),serverport);
            ds.send(dp);
        }
    }

    public void run(){
        byte b[]=new byte[1000];
        while(true){
            try{
                DatagramPacket dp=new DatagramPacket(b,b.length);
                ds.receive(dp);
                String data=new String(b,0,dp.getLength());
                System.out.println(data);
            }catch(Exception E){

            }
        }
    }

    public static void main(String []args) throws Exception{
        Scanner sc =new Scanner(System.in); 
        name=sc.nextLine();
        CollectionsClientA cp=new CollectionsClientA();
    }
}