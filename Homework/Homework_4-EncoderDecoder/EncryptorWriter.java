import java.io.IOException;
import java.io.Writer;

public class EncryptorWriter extends Writer {

	private Writer wr;
	
	public EncryptorWriter(Writer w) {
		this.wr = w;
	}
	
	@Override
	public void write(char[] buff, int offset, int len) throws IOException {
		char[] encodeBuf = new char[len*3+1];
		for (int i = 0; i<len*3; i+= 3) {
			for(int j=0; j<3;j++) {
				encodeBuf[i+j] = buff[(i/3)+offset]; 
			}
		}
		this.wr.write(encodeBuf,0,len*3);
	}
	
	
	@Override
	public void close() throws IOException {
		this.wr.close();
		
	}

	@Override
	public void flush() throws IOException {
		this.wr.flush();
	}
	


}
