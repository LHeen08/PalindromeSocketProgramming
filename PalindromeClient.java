//James Heenan

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.*;
import java.io.*;

class client {

    public static void main(String argv[]) throws Exception
    {  


    while(true)
    {
		// Create client socket with connection to server 
		Socket clientSocket = new Socket("localhost", 1200);
		
		// Create output stream attached to socket
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

		// Create (buffered) input stream attached to socket
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	

		// Read line from user
    	System.out.println("Please enter a string");

    	//Create ability to send a string to a socket using PrintWriter
		OutputStream outstream = clientSocket.getOutputStream();
		PrintWriter out = new PrintWriter(outstream, true);

		//Create Buffered input stream attached to command line
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

    	//Read the string from the command line 
		String toSend = reader.readLine();


		//If the string to send is Null close the connection
		if(toSend.length() == 0)
		{
			System.out.println("Exitng...");
			break;
		}

		//Write line to server
		out.println(toSend);
		System.out.println ("TO SERVER: " + toSend);

		System.out.println("Is it a Palindrome? "); 

		//Read line from server 
		String toPrint = inFromServer.readLine();
		System.out.println("From server: " + toPrint);

	

		// Close the sockets
		outToServer.close();
		inFromServer.close();
		clientSocket.close();
	}
	
			
    } 

} 