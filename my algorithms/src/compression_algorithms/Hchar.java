package compression_algorithms;

/**
 * Hchar is a class to define a Character to use in HuffmanAlg.
 * @author hido Pinto
 * @see HuffmanAlg.
 */
public class Hchar{
	
	int count;
	String character;
	Hchar left=null,right=null;
	// an inefficient representation, change it to real bits!
	String binRep;
	
	/**
	 * hashcode to Hchar.
	 * @return the hashcode.
	 */
	@Override
	public int hashCode(){return character.hashCode(); }
}
