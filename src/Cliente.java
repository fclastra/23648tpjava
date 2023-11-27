import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

   public static void main(String[] args) {

       Socket sc = null;
       DataInputStream in;
       DataOutputStream out;

       // Puerto del servidor
       final int PUERTO = 1234;

       try {
           // Creamos el socket del cliente
           sc = new Socket("localhost", PUERTO);
           System.out.println("Cliente iniciado");

           // Enviamos un mensaje
           out = new DataOutputStream(sc.getOutputStream());
           out.writeUTF("¡Hola mundo desde el cliente!");

           // Recibimos el mensaje del servidor
           in = new DataInputStream(sc.getInputStream());
           String mensaje = in.readUTF();
           System.out.println(mensaje);

           // Cierro el socket
           sc.close();
           System.out.println("Cliente desconectado");

       } catch (IOException ex) {
           ex.printStackTrace();
       }

   }

}
