
package cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
            //creación del socket pasando la dirección IP y el puerto del servidor
            Socket clienteSocket = new Socket("localhost", 5555);
            System.out.println("Estableciendo la conexion");

            //Flujo para recibir los datos del servidor
           // InputStream is = clienteSocket.getInputStream();
            BufferedReader is = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            System.out.println("Enviando mensaje");
            //Flujo para enviar los datos al servidor 
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
            //leemos el resultado enviado por el servidor
            System.out.println("resultado de la operacion: " + is.readLine());
          

            System.out.println("Cerrando el socket cliente");
            //cerramos conexión
            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}	
