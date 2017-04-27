import java.io.*;
import java.net.*;

public final class Ex3Client
{
	public static void main (String[] args) throws IOException
	{
		int numberOfBytes = -1; // stores number of bytes to be received [0,255]
		try
		{
			Socket socket = new Socket ("codebank.xyz", 38103); // make a connection
			if (socket.isConnected())
				System.out.println("Connected to server.");	

			// read in byte that contains number of bytes to be received
			InputStream IS 			= socket.getInputStream();
			InputStreamReader ISR 	= new InputStreamReader(IS, "UTF-8");
			BufferedReader BR 		= new BufferedReader(ISR);
			numberOfBytes 			= BR.read();
			System.out.println("Reading " + numberOfBytes + " bytes.");

			// If not between 0 and 255, quit.
			if ( numberOfBytes > 255 || numberOfBytes < 0 )
			{
				System.out.println("Value is not between 0 and 255!\nProgram will now terminate.");
				System.exit(0);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}