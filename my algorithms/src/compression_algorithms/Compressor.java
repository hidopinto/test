package compression_algorithms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Compressor {
	
	public OutputStream compress(InputStream s) throws IOException;
	public OutputStream decompress(InputStream s) throws IOException, ClassNotFoundException;
	
}
