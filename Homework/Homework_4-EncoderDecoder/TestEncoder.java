import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

public class TestEncoder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File(args[0]);
		FileWriter rDec = new FileWriter("decrypted_text.txt");
		FileWriter rEnc = new FileWriter("encrypted_text.txt");
		try {
			Scanner s = new Scanner(f);
			while(s.hasNextLine())
			{
				String line = s.nextLine();
				StringWriter sw = new StringWriter();	
				EncryptorWriter en2 = new EncryptorWriter(sw);
				en2.write(line.toCharArray());
				rEnc.write(sw.toString());

				
				
				StringReader sr = new StringReader(sw.toString());
				DecryptorReader d = new DecryptorReader(sr);
				char[]myData = new char[100]; 
				d.read(myData);

				rDec.write(myData);
			}
			
		}
		
		
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		rEnc.flush();
		rEnc.close();
		rDec.flush();
		rDec.close();
	}

}
