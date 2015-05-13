package compression_algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/**
 * HuffmanReader is a class to read compressed text based on HuffmanAlg.
 * HuffmanReader extends Reader.
 * @author Hido Pinto
 * @see HuffmanAlg
 * @see Reader
 */
public class HuffmanReader extends Reader{
	
	HuffmanAlg huff;
	Reader r;
	
	/**
	 * HuffmanReader constructor.
	 * @param r - the source to read the data.
	 * @throws FileNotFoundException
	 */
	public HuffmanReader(Reader r) throws FileNotFoundException{
		super();
		this.r =r;
		huff = new HuffmanAlg(new FileOutputStream("resources/decomprees.txt"));
	}
	
	/**
	 * close HuffmanReader.
	 */
	@Override
	public void close() throws IOException {
		r.close();
		
	}

	/**
	 * decompresses and reads the data in cbuf.
	 * @param cbuf - buffer that contains the compressed data.
	 * @param off - start index to read from cbuf.
	 * @param len - length of chars to read from cbuf.
	 * @return number of chars read.
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		
		int toRead = r.read(cbuf, off, len);
		
		OutputStream os = new FileOutputStream("resources/huffInput.txt");
		String str = "";
		
		for(int i=0; i<toRead ; i++)
			 str += cbuf[i+off];
		byte[] bytes = str.getBytes();
		
		os.write(bytes, off, toRead);
		os.close();
		InputStream is = new FileInputStream("resources/huffInput.txt");
		try {
			huff.decompress(is);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		is = new FileInputStream("resources/decomprees.txt");
		
		String s = huff.InputStreamToString(is);
		is.close();
		
		StringBuffer sb = new StringBuffer();
		
		int min = Math.min(s.length(), toRead);
		
		for(int i=0; i<min ; i++){ //to remove all nulls. lets the real text stays
			
			String ch = "" + s.charAt(i);
			if(ch == "")
				break;
			sb.append(ch);
		}
		s = sb.toString();
		
		char[] result = s.substring(0, s.length()-1).toCharArray();
		System.arraycopy(result, 0, cbuf, off, result.length);
		
		return cbuf.length;
	}

}
