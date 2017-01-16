
package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
/**
 *
 * @author mmoureperez
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try{
			System.out.println("Creando socket cliente");
			Socket clienteSocket=new Socket("localhost",5555);
			System.out.println("Estableciendo la conexion");
			
			/*InetSocketAddress addr=new InetSocketAddress("localhost",5556);
                        clienteSocket.bind(addr);
			clienteSocket.connect(addr);*/
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

			InputStream is = clienteSocket.getInputStream();
			OutputStream os= clienteSocket.getOutputStream();

			System.out.println("Enviando mensaje");

			String num1="mensaje desde el cliente";
			os.write(num1.getBytes());

			System.out.println("Mensaje enviado");

			System.out.println("Cerrando el socket cliente");

			clienteSocket.close();

			System.out.println("Terminado");

			}catch (IOException e) {
				e.printStackTrace();
			}
	}
}	
