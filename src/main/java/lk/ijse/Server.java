package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            boolean rem = true;
            //server socket
            ServerSocket serverSocket = new ServerSocket(8888);
            //local socket
            Socket socket = serverSocket.accept();
            do {
//                System.out.println("Client Accepted!");
                //data reading option
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                //sout
                String massage = dataInputStream.readUTF();
                if (massage != null) {
                    System.out.println("Client's Massage : " + massage );

                    //request to the server
                    System.out.println("Enter Server reply : ");
                    String massage1 = new Scanner(System.in).nextLine();

                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.flush();
                    dataOutputStream.writeUTF(massage1);
                }else {
                    System.out.println("Client msg null");
                    rem = false;
                }
            }while (rem);
            //close
            socket.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}