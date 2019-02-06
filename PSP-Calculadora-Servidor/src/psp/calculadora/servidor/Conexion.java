package psp.calculadora.servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Conexion {

    Calculo cal = new Calculo();

    Boolean condicionCierre = true;

    byte[] mensaje;

    ServerSocket serverSocket;
    InetSocketAddress addr;
    //Socket newSocket;
    InputStream is;
    OutputStream os;

    public Conexion() {

        try {
            System.out.println("Creando socket servidor");

            serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            addr = new InetSocketAddress("localhost", 5555);
            serverSocket.bind(addr);

            System.out.println("Aceptando conexiones");
            Socket newSocket = serverSocket.accept();

            System.out.println("Conexión recibida" + " " + newSocket);

            is = newSocket.getInputStream();
            os = newSocket.getOutputStream();

            do {
                mensaje = new byte[500];
                is.read(mensaje);

                System.out.println("Mensaje recibido: " + new String(mensaje));

                os.write(cal.calculo(new String(mensaje)).getBytes());
            } while (true);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
