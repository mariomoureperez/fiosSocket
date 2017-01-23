
package cliente;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author mmoureperez
 */
public class Cliente extends Thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            System.out.println("Creando socket cliente");
            Socket clienteSocket = new Socket("localhost", 5555);
            System.out.println("Estableciendo la conexion");

            /*InetSocketAddress addr=new InetSocketAddress("localhost",5556);
            clienteSocket.bind(addr);
            clienteSocket.connect(addr);*/
            //BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            InputStream is = clienteSocket.getInputStream();
            OutputStream os = clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");

            DataOutputStream salidaServidor = new DataOutputStream(clienteSocket.getOutputStream());

            int num1 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el primer numero"));
            int oper = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la operación:\n0= +\n1= -\n2= x\n3= /"));
            int num2 = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el segundo numero"));

            //Se escribe en el servidor usando su flujo de datos
            salidaServidor.write(num1);
            salidaServidor.write(num2);
            salidaServidor.write(oper);
            /*
            0==suma
            1==resta
            2==multiplicacion
            3==division
            */
            System.out.println("Mensaje enviado");

            System.out.println("resultado de la operacion: " + is.read());

            System.out.println("Cerrando el socket cliente");

            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}	
