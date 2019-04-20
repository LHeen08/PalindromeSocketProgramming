//James Heenan

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.*;
import java.io.*;

class server{

    public static void main(String argv[]) throws Exception
    {

	// Create welcoming socket using port 
	ServerSocket welcomeSocket = new ServerSocket(1200);

	System.out.println("Server Ready for Connection");

	// While loop to handle arbitrary sequence of clients making requests
	while(true) {

	    // Waits for some client to connect and creates new socket 
	    // for connection
	    Socket connectionSocket = welcomeSocket.accept();
	    System.out.println("Client Made Connection");                

	    // Create (buffered) input stream attached to connection socket
	    BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

	    // Read input line from socket
	    String word = inFromClient.readLine();

	    System.out.println("From client: " + word);

	    //Create ability to send a string to a socket using PrintWriter
	    OutputStream outstream = connectionSocket.getOutputStream();
		PrintWriter out = new PrintWriter(outstream, true);

		//Convert bool to string for easy transmission through socket
		String palindrome = String.valueOf(isPalindrome(word));

		//Write output line to socket
		out.println(palindrome);
	    System.out.println ("TO CLIENT: " + palindrome);

	    // Close the connection socket
	    connectionSocket.close();

		} 

	}
	
	public static Boolean isPalindrome(String s)
	{

		int l = 0;
		int h = s.length()-1;

		//Lowercase the string
		s = s.toLowerCase();

		while(l <= h) 
        { 
              
            char getAtl = s.charAt(l); 
            char getAth = s.charAt(h); 
              
            // If there is another symbol in left 
            // of sentence 
            if (!(getAtl >= 'a' && getAtl <= 'z')) 
            {
                l++; 
            }
              
            // If there is another symbol in right  
            // of sentence 
            else if(!(getAth >= 'a' && getAth <= 'z')) 
            {
                h--; 
            }
              
            // If characters are equal 
            else if( getAtl == getAth) 
            { 
                l++; 
                h--; 
            } 
              
            // If characters are not equal then 
            // sentence is not palindrome 
            else 
            {
                return false; 
            }
        } 
          
        // Returns true if sentence is palindrome 
        return true;     
    } 



}
	


