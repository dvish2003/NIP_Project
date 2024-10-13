package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            boolean rem = true;
            Socket socket = new Socket("localhost", 8888);
            do {
                System.out.println("Enter Massage : ");
                String massage = new Scanner(System.in).nextLine();
                DataOutputStream dataOutputStream  = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(massage);
                dataOutputStream.flush();

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String massage_1 = dataInputStream.readUTF();

                if (massage_1 != null){
                    System.out.println("Reply : " + massage_1);
                }else{
                    System.out.println("massage is null");
                    rem = false;

                }
            }while (rem);
            socket.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
