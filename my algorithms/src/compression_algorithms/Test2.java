package compression_algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Test2 {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		PrintWriter out=new PrintWriter (new HuffmanWriter(new FileWriter("out.hff")));
		out.print("Mississipi river");
		out.flush();
		out.close();
		
		BufferedReader in = new BufferedReader(new HuffmanReader(new FileReader("out.hff")));
		String s= in.readLine();
		in.close();
		
		System.out.println(s);
	}
}
