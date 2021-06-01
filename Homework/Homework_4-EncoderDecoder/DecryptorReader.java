import java.io.IOException;
import java.io.Reader;

public class DecryptorReader extends Reader{
	private Reader r;
	
	public DecryptorReader(Reader r) {
		this.r = r;
	}
	
	@Override
	public int read(char[] buff, int offset, int len) throws IOException {
		int numOfChars = 0;
		int how_much_read = 0 , i  = 0;
		char[] tmp = new char[len];
		
		while((how_much_read = r.read(tmp,0,3)) >= 3) {
			numOfChars += how_much_read;
				if (tmp[0] == tmp[1] || tmp[0]==tmp[2])
					buff[i++]=tmp[0];
				else if (buff[1]==tmp[2])
					buff[i++] = tmp[1];
				else
					buff[i++] = (char)(-1);
		}
		return numOfChars;
	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		r.close();
	}
}
