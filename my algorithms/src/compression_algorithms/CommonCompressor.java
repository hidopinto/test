package compression_algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * an abstract class that is common to every other class which implements Compressor.
 * @author Hido Pinto
 * @see Compressor
 */
public abstract class CommonCompressor implements Compressor {

	OutputStream out;
	
	/**
	 * CommonCompressor constructor.
	 * @param out - the destination for the data.
	 */
	public CommonCompressor(OutputStream out) {
		super();
		this.out = out;
	}

	/**
	 * a method which reads from an InputStream and returns a data in String.
	 * @param in - the source to read data from.
	 * @return String which contains the data in the InputStream.
	 * @throws IOException
	 */
	public String InputStreamToString(InputStream in) throws IOException{
		 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		 StringBuilder strOut = new StringBuilder();
		 String newLine = System.getProperty("line.separator");
		 String line;
		 while ((line = reader.readLine()) != null) {
			 strOut.append(line);
		     strOut.append(newLine);
		 }
		 return strOut.toString();
	}

}
