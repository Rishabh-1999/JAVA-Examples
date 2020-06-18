import Rishabh.DS.*;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Testing
{
	public static void main(String[] agrs)
	{
		Rishabh.DS.SinglyLinkedList<String> t=new SinglyLinkedList<String>();
		t.addFirst("3");
		t.addFirst("2");
		t.addFirst("1");
		System.out.println(t.toString());
		t.addFirst("5");
		t.checkPalindrome();
		t.sort();
		System.out.println(t.toString());
		t.sort();
	
	}
}