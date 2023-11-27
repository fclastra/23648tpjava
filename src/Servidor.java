import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

   public static void main(String[] args) {

       ServerSocket servidor = null;
       Socket sc = null;
       DataInputStream in;
       DataOutputStream out;

       // Puerto de nuestro servidor
       final int PUERTO = 1234;

       try {
           // Creamos el socket del servidor
           servidor = new ServerSocket(PUERTO);
           System.out.println("Servidor iniciado");

           // Siempre estará escuchando peticiones
           while (true) {

               // Espero a que un cliente se conecte
               sc = servidor.accept();

               System.out.println("Cliente conectado");
               in = new DataInputStream(sc.getInputStream());
               out = new DataOutputStream(sc.getOutputStream());

               // Le envío un mensaje
               out.writeUTF("¡Hola mundo desde el servidor!");

               // Cierro el socket
               sc.close();
               System.out.println("Cliente desconectado");

           }

       } catch (IOException ex) {
           ex.printStackTrace();
       }

   }

}
