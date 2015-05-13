package compression_algorithms;


import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * HuffmanAlg is a class to compress and decompress data from an InputStream into an OutputStream.
 * HuffmanAlg extends CommonCompressor.
 * HuffmanAlg compresses text by separating word and keeping their indexes.
 * HuffmanAlg is based on huffman's compression algorithm.
 * @author Hido Pinto
 * @see CommonCompressor
 * @see InputStream
 * @see OutputStream
 */
public class HuffmanAlg extends CommonCompressor{
	
	int numberOfCharacters;
	
	/**
	 * HuffmanAlg constructor.
	 * @param out - the destination to the compressed/decompressed data
	 */
	public HuffmanAlg(OutputStream out) {
		super(out);
		this.numberOfCharacters=0;
	}
	
	/**
	 * compresses data based on huffman's compression algorithm.
	 * @param s - the source to the data we want to compress. 
	 * @return OutputStream - the destination of the compressed data.
	 */
	@Override
	public OutputStream compress(InputStream s) throws IOException {
		String input = this.InputStreamToString(s);
		HashMap<Character, Hchar> dict = this.HuffmanTreeCreator(input);
		
		String dic = "";
		for(Hchar hc : dict.values()){
			dic+=(hc.character);
			dic+=("~");
			dic+=(hc.binRep);
			dic+=("~");
		}
		dic+="fin~";
		//out.write(("Compressed txt:"+System.getProperty("line.separator")+"~").getBytes());

		ObjectOutputStream o = new ObjectOutputStream(out);
		o.writeObject(dic);
		
		
		String bits = "";
		for(char c: input.toCharArray()){ // writes the text
			Hchar hc=dict.get(c);
			bits+=(hc.binRep);
		}
		
		BitSet bitRep = fromStringToBitset(bits);
		o.writeObject(bitRep);
		
		return out; 
	}
	
	/**
	 * a function to convert a String in the form of '0's and '1's to BitSet.
	 * @param s - a String in the form of '0's and '1's.
	 * @return BitSet.
	 */
	public BitSet fromStringToBitset(String s)
	 {
		BitSet b=new BitSet();
		b.set(s.length());
		for(int i=0;i<s.length();i++)
			if(s.charAt(i)=='1')
				b.set(i);
		return b;
	 }
	
	/**
	 * a function to convert a BitSet to a String in the form of '0's and '1's.
	 * @param b - a BitSet.
	 * @return String.
	 */
	public String fromBitsetToString(BitSet b){
		String str = "";
		for(int i=0;Math.pow(2, i)<=convert(b);i++){
			if(b.get(i)==true)
			{
				str+="1";
			}
			else
			{
				str+="0";
			}
		}
		return str;
	}
	
	/**
	 * decompresses data readin the dictionary given in the beginning of the data.
	 * @param s - the source to the data we want to decompress. 
	 * @return OutputStream - the destination of the decompressed data.
	 */
	@Override
	public OutputStream decompress(InputStream s) throws IOException, ClassNotFoundException{
		
		ObjectInputStream in = new ObjectInputStream(s);
		String input = (String) in.readObject();
		HashMap<String,String> dict = new HashMap<String, String>();
		String[] lines = input.split("~");
		int i=0;
		while(!lines[i].equals("fin"))
		{
			dict.put(lines[i+1],lines[i]);
			i+=2;
		}
		//dictionary is done
		
		
		BitSet bits = (BitSet) in.readObject();
		

		String data="";
		String word="";
		for(int j=0;j<bits.length();j++)
		{
			if(bits.get(j)==true)
			{
				word+="1";
			}
			else
			{
				word+="0";
			}
			if(dict.containsKey(word))
			{
				String ch=dict.get(word);
				if(ch.equals("/r"))
					data+="\r";
				else{
					if(ch.equals("/n"))
						data+="\n";
					else
						data+=ch;
				}
				word="";
			}
		}
		
		
		out.write(data.getBytes());
		return out;
	}
	
	/**
	 * a function to build a huffman tree based on DFS.
	 * @param node - the head node.
	 * @param bin - a String in the form of '0's and '1's.
	 * @see Hchar
	 */
	private void DFSbinRep(Hchar node,String bin) {
		node.binRep=bin; 
		if(node.left!=null){
			DFSbinRep(node.left, bin+"0");
		}
		if(node.right!=null){
			DFSbinRep(node.right, bin+"1");
		}
	} 

	/**
	 * creates the dictionary to the text we want to compress.
	 * @param input - text we want to compress.
	 * @return HashMap<String, ArrayList<Integer>> - a dictionary. saves the word and a String in the form of '0's and '1's that describes it.
	 */
	private HashMap<Character, Hchar> HuffmanTreeCreator(String input){
		// count appearances of characters 
		HashMap<Character, Hchar> countAppearance=new HashMap<>();
		for(char c: input.toCharArray()){
			Hchar hc=countAppearance.get(c);
			if(hc==null){
				hc=new Hchar();
				if(c!='\n' && c!='\r')
					hc.character=""+c;
				if(c=='\n')
					hc.character = "/n";
				if(c=='\r')
					hc.character = "/r";
				hc.count=0;
				countAppearance.put(c, hc);
			}
			hc.count++;
		}
		
		// adds the characters to pq=priority queue
		PriorityQueue<Hchar> pq=new PriorityQueue<Hchar>(
				new Comparator<Hchar>(){
				 @Override
				 public int compare(Hchar o1, Hchar o2) {
				 return o1.count-o2.count;
				 }
				});

		pq.addAll(countAppearance.values());
		
		// compresses all nodes into a head node
		while(pq.size()>1){
			 Hchar hc0=pq.poll();
			 Hchar hc1=pq.poll();
			 Hchar hc2=new Hchar();

			 hc2.count=hc0.count+hc1.count;
			 hc2.character=hc0.character+hc1.character;
			 hc2.left=hc0;
			 hc2.right=hc1;

			 pq.add(hc2);

		} 
		Hchar top=pq.peek();
		numberOfCharacters=top.count; //saves the number of characters in input
		

		DFSbinRep(top,""); //build a binary tree out of the first node
		
		return countAppearance;
	}
	
	/**
	 * a finction to convert a BitSet to long.
	 * @param bits - a BitSet.
	 * @return long.
	 */
	public long convert(BitSet bits) {
	    long value = 0L;
	    for (int i = 0; i < bits.length(); ++i) {
	    	value += bits.get(i) ? (1L << i) : 0L;
	    }
	    return value;
	}
	
		
}
