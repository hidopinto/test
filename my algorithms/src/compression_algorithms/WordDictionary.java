package compression_algorithms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * WordDictionary is a class to compress and decompress data from an InputStream into an OutputStream.
 * WordDictionary extends CommonCompressor.
 * WordDictionary compresses text by separating word and keeping their indexes.
 * @author Hido Pinto
 * @see CommonCompressor
 * @see InputStream
 * @see OutputStream
 */
public class WordDictionary extends CommonCompressor{
	
	/**
	 * WordDictionary constructor.
	 * @param out - the destination to the compressed/decompressed data
	 */
	public WordDictionary(OutputStream out) {
		super(out);
	}
	
	/**
	 * compresses data by separating word and keeping their indexes.
	 * @param s - the source to the data we want to compress. 
	 * @return OutputStream - the destination of the compressed data.
	 */
	@Override
	public OutputStream compress(InputStream s) throws IOException {
		
		String input = this.InputStreamToString(s);
		HashMap<String, ArrayList<Integer>> dict = this.GetStringDict(input);
		
		StringBuffer sb = new StringBuffer();
		
		for (String word: dict.keySet())
		{
			if(!word.equals("\r\n")){
				sb.append(System.getProperty("line.separator") + word + ":");
				ArrayList<Integer> indices = dict.get(word);
				for (int index : indices)
				{
					sb.append(index + ",");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
		String compressed = sb.toString();
		
		byte[] compressedBytes = compressed.getBytes();
		
		out.write(compressedBytes);
		
		return out;
	}

	/**
	 * decompresses data by separating word and keeping their indexes.
	 * @param s - the source to the data we want to decompress. 
	 * @return OutputStream - the destination of the decompressed data.
	 */
	@Override
	public OutputStream decompress(InputStream s) throws IOException {
		
		HashMap<String, String> dict = new HashMap<String, String>(); //the first string is only numbers!
		String[] lines = this.InputStreamToString(s).split(System.getProperty("line.separator"));
		String lastLine=null;
		
		for (String line : lines){  //creates the hashmap
			if(!line.equals("")){
				String[] value = line.split(":");
				if(value.length > 1){
					String[] integers = value[1].split(",");
					if(value[0].equals("")){
						dict.put(value[1],lastLine);
					}
					else{
						for(String integer : integers){
							dict.put(integer, value[0]);
						}
					}
				}
				else
						lastLine=value[0];
			}
		}
		
		String word = dict.get("0");
		for(int i=1;word!=null;i++){
			out.write(word.getBytes()); //writes the decompressed txt
			out.write(" ".getBytes());
			word = dict.get(""+i);
		}
		
		
		return out;
	}
	
	/**
	 * creates the dictionary to the text we want to compress.
	 * @param input - text we want to compress.
	 * @return HashMap<String, ArrayList<Integer>> - a dictionary. saves the word and it's indexes;
	 */
	private HashMap<String, ArrayList<Integer>> GetStringDict(String input){
		HashMap<String, ArrayList<Integer>> dict = new HashMap<String, ArrayList<Integer>>();
		String[] sp = input.split(" ");
		
		for (int i = 0; i < sp.length; i++)
		{
			String word = sp[i];
			ArrayList<Integer> indices;
			
			if (dict.containsKey(word))
				indices = dict.get(word);
			else
				indices = new ArrayList<Integer>();
			
			indices.add(i);
			dict.put(word, indices);
		}		
		
		return dict;
	}

}
