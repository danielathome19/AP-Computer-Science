package Q4.EncryptLoginLab;

/*
	Program:	Log in client
				This program implements the client side (i.e. app) of log in
				Protocol message format: "[Type of Message];[data];[data]"
	Created on: 4/27/2023
	Created by: Jiazhen Zhou
	Revised on:
	Revised by:

 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception{
        String SERVER = "localhost";
        final int PORT = 12345;

        Scanner myScanner = new Scanner(System.in);
        //System.out.println(" Input the IP address of the server:");
        //SERVER = myScanner.next();
        //Setup communication with server using the socket
        System.out.println("Connecting to the authentication server...");
        Socket clientSocket = new Socket(SERVER, PORT);
        System.out.println(" Connected.");

        //Set up the interface for sending/receiving packets to/from the server
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        /*** TODO: ALLOW USERS TO TRY UP TO 5 TIMES IF THE USERNAME/PASSWORD IS INCORRECT***/

        //Get login info from the user
        System.out.print("Enter Username:\n");
        String username = myScanner.next();
        System.out.print("Enter Password:\t");
        String password = myScanner.next();

        //Send login info to the authentication server
        String protocolMessage = "loginRequest;" + username + ";" + password;
        System.out.print("Sending request to host...");
        /**TODO: Encrypt the message before sending out *********/
        outToServer.writeBytes(protocolMessage + "\n");
        System.out.println(" Sent.");

        //Handle response from server
        String loginResponse = inFromServer.readLine();
        /**TODO: Decrypt the message *********/
        System.out.println("Response: " + loginResponse);
        String[] parsedLoginResponse = loginResponse.split(";");

        //Handle login response messages
        if(parsedLoginResponse[0].equalsIgnoreCase("loginResponse")) {
            if(parsedLoginResponse[1].equalsIgnoreCase("success")){//success
                System.out.println("Login Succeed! Congratulations!");
                //In the real application, more later operations will be allowed after a successful login
            }else{ //failure
                System.out.println("Login Failed! Either user name or password incorrect!");
            }
        }

        //The session is over, close the socket
        System.out.println("Thank you for using the Login system!");
        clientSocket.close();

    }
}