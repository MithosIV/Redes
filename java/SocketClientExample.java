import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
/**
* This class implements java socket client
* @author pankaj
*
*/
public class SocketClientExample {

public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
//get the localhost IP address, if server is running on some other IP, you need to use that
InetAddress host = InetAddress.getLocalHost();
Socket socket = null;
ObjectOutputStream oos = null;
ObjectInputStream ois = null;
//for(int i=0; i<5;i++){
System.out.println("Esto es Roca,Papel,Tijeras");
System.out.println("Elije R, P, S");
Scanner myObj = new Scanner(System.in);
String userMove = new String();

while(true){
//establish socket connection to server
socket = new Socket(host.getHostName(), 9876);
//write to socket using ObjectOutputStream
oos = new ObjectOutputStream(socket.getOutputStream());
userMove = myObj.nextLine();
oos.writeObject(userMove);
System.out.println("Jugaste " + userMove);
//if(i==4)oos.writeObject("exit");
//else oos.writeObject(""+i);
//read the server response message
ois = new ObjectInputStream(socket.getInputStream());
//close resources
ois.close();
oos.close();
Thread.sleep(4000);
}
}
}