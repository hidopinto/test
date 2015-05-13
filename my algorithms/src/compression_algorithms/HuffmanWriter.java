package compression_algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

/**
 * HuffmanWriter is a Writer that writes a compressed data based on HuffmanAlg.
 * extends Writer.
 * @author Hido Pinto
 * @see HuffmanAlg
 * @see Writer
 */
public class HuffmanWriter extends Writer{
	HuffmanAlg huff;
	Writer w;
	
	/**
	 * HuffmanWriter constructor.
	 * @param w - the destination to write the compressed data.
	 * @throws FileNotFoundException
	 */
	public HuffmanWriter(Writer w) throws FileNotFoundException{
		super();
		this.w=w;
		huff = new HuffmanAlg(new FileOutputStream("resources/comprees.txt"));
	}

	/**
	 * close HuffmanWriter
	 */
	@Override
	public void close() throws IOException {
		w.close();
		
	}

	/**
	 * flush HuffmanWriter
	 */
	@Override
	public void flush() throws IOException {
		w.flush();
		
	}

	/**
	 * compresses, and writes the compressed data in cbuf.
	 * @param cbuf - buffer that contains the data.
	 * @param off - start index to write from cbuf.
	 * @param len - length of chars to write from cbuf.
	 */
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		
		OutputStream Fout = new FileOutputStream("resources/huffInput.txt");
		String str = "";
		
		for(int i=0; i<len ; i++)
			 str += cbuf[i+off];
		byte[] bytes = str.getBytes();
		
		Fout.write(bytes, off, len);
		Fout.close();
		InputStream is = new FileInputStream("resources/huffInput.txt");
		huff.compress(is);
		
		is = new FileInputStream("resources/comprees.txt");
		String s = huff.InputStreamToString(is);
		w.write(s.toCharArray(), 0, s.length());
		
		w.close();
		is.close();
		
		return;
	}
	
}
