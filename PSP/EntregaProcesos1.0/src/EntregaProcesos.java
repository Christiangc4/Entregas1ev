import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EntregaProcesos {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            //Comprobar puertos del 80 al 90
            for (int port = 80; port < 90; port++) {
                try {
                    Socket SocketIP = new Socket(args[i], port);
                    System.out.println("Conectar a " + SocketIP.getInetAddress() + " en el puerto " + SocketIP.getPort() + " desde el puerto " + SocketIP.getLocalPort() + " en " + SocketIP.getLocalAddress());
                    SocketIP.close();
                } // end try
                catch (UnknownHostException ex) {
                    System.err.println(ex);
                }
                catch (SocketException ex) {
                    System.err.println(ex);
                }
                catch (IOException ex) {
                    System.err.println(ex);
                }
            } // fin for IP
        } // fin for port
    } // fin main
} // fin ScannerIP


