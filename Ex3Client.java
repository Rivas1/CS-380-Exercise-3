import java.io.*;
import java.net.*;

public final class Ex3Client
{
	public static void main (String[] args) throws IOException
	{
		// int numberOfBytes = -1; // stores number of bytes to be received [0,255]
		int n = -1;
		try
		{
			/* make a connection */
			Socket socket = new Socket ("codebank.xyz", 38103); 
			if (socket.isConnected())
				System.out.println("Connected to server.");	

			/* create stream from Socket */
			InputStream IS = socket.getInputStream();

			/* read in byte that contains number of bytes to be received */
			n = obtain(socket, IS);
			System.out.println("Reading " + n + " bytes."); 

			/* If not between 0 and 255, quit. */
			if ( n > 255 || n < 0 )
			{
				System.out.println("Value is not between 0 and 255!\nProgram will now terminate.");
				System.exit(0);
			}
		}
		catch (IOException e)
		{ e.printStackTrace(); }
	}
	public static int obtain ( Socket socket, InputStream IS ) throws IOException
	{
		try 
		{
			return IS.read();
		}
		catch (IOException e)
		{ e.printStackTrace(); }
		return IS.read();
	}
}