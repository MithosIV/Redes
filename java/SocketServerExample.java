import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.Random;

/**
* This class implements java Socket server
* @author pankaj
*
*/
public class SocketServerExample {


//static ServerSocket variable
private static ServerSocket server;
//socket server port on which it will listen
private static int port = 9876;

public static void main(String args[]) throws IOException, ClassNotFoundException{
//create the socket server object
server = new ServerSocket(port);

//keep listens indefinitely until receives 'exit' call or program terminates
while(true){
System.out.println("Waiting for the client move");
//creating socket and waiting for client connection
Socket socket = server.accept();
//read from socket to ObjectInputStream object
ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//convert ObjectInputStream object to String

String userMove = (String) ois.readObject();
System.out.println("Message Received: " + userMove);
//create ObjectOutputStream object
ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//write object to Socket
//oos.writeObject("Hi Player");

String computerMove = new String();

Scanner myObj = new Scanner(System.in);


Random random = new Random();
int randomNumber = random.nextInt(0,2);

switch(randomNumber)
{
case 0:
	computerMove = "scissors";
	break;
case 1:
	computerMove = "rock";
	break;
case 2:
	computerMove = "paper";
	break;
}

System.out.println("La computadora eligio " + computerMove);



if (userMove.equals(computerMove))
{
	System.out.println("its a draw");
	oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("Its a draw");


}
else if (userMove.equals("r") && computerMove.equals("scissors"))
{
	System.out.println("User wins");
		oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("user Wins");
}
else if (userMove.equals("p") && computerMove.equals("rock"))
{
	System.out.println("User wins");
	oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("User wins");
}
else if (userMove.equals("s") && computerMove.equals("paper"))
{
	System.out.println("User wins");
	oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("User Wins");
}
else if (userMove.equals("s") && computerMove.equals("rock"))
{
		System.out.println("Computer wins");
			oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("Computer Wins");
}
else if (userMove.equals("p") && computerMove.equals("scissors"))
{
		System.out.println("Computer wins");
			oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("Computer Wins");
}
else if (userMove.equals("r") && computerMove.equals("paper"))
{
		System.out.println("Computer wins");
			oos = new ObjectOutputStream(socket.getOutputStream());
	oos.writeObject("Computer wins");
}
//close resources
ois.close();
oos.close();
socket.close();
//terminate the server if client sends exit request
if(userMove.equalsIgnoreCase("exit")) break;
System.out.println("Shutting down Socket server!!");
//close the ServerSocket object
server.close();
}

}
}