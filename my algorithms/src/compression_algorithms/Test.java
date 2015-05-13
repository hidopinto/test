package compression_algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//String test = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		String test = "Mississipi river";
		FileWriter Fout = null;
		Fout=new FileWriter("myFile.dat");
		Fout.write(test);
		Fout.close();
		
		FileInputStream fis = new FileInputStream("resources/comprees.txt");
		OutputStream out = new FileOutputStream("C:.Users.Admin.workspace.my algorithms.comprees");
		Compressor myComp = new HuffmanAlg(out);
		out = myComp.compress(fis);
		
		fis = new FileInputStream("C:.Users.Admin.workspace.my algorithms.comprees");
		out = new FileOutputStream("C:.Users.Admin.workspace.my algorithms.decomprees");
		myComp = new HuffmanAlg(out);
		out = myComp.decompress(fis);
		
		
		out.close();
	}
	

}
