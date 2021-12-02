import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.w3c.dom.*;

import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.EventListener;
import java.util.Scanner;


public class Main extends Thread {

//**
// ! La idea es que el texto traducido automáticamente se seleccione y se copie en el traductor
//!  Despues coge el texto traducido y lo copia y te lo guarda en un archivo en el ordenador local


   /* public Main(String textoTraducir, String textoTraducido) {
        super(textoTraducir, textoTraducido);
    }*/

    public static void main(String[] args) throws IOException, AWTException {
        String url = "https://translate.google.es/?sl=es&tl=en&op=translate";

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Clipboard c1 = new Clipboard("portapapeles");



        Robot mouse = new Robot();

        Procesos proceso = new Procesos();
        Scanner teclado = new Scanner(System.in);
        String textoTraducir;
        String textoTraducido;


        System.out.println("Bienvenido al traductor de IntelliJ!!" +
                "De esta manera podrás guardarte un fichero con tu texto traducido en tu ordenador");

        System.out.println("Introduce el texto que quieres traducir: ");

        textoTraducir  = teclado.nextLine();

        System.out.println("El traductor se abrirá en breves");
//ENVIAR LOG A LA RED DE LO QUE QUIERA TRADUCIR EL USUARIO
        try
        {
            int port = 2020;
            //224.0.0.1 ... 224.0.0.255
            InetAddress multicastGroupIP = InetAddress.getByName("224.0.0.5");
            System.out.println(multicastGroupIP);
            MulticastSocket socket = new MulticastSocket(port);

            socket.joinGroup(multicastGroupIP);
            byte[] mensajeRed = ("Christian Quiere Traducir al español : "+textoTraducir).getBytes();


            DatagramPacket send = new DatagramPacket(mensajeRed, mensajeRed.length, multicastGroupIP, port);
            socket.send(send);

            byte[] bufer = new byte[1000];
            String linea;

            while (true)
            {
                DatagramPacket receive = new DatagramPacket(bufer, bufer.length);
                socket.receive(receive);
                linea = new String(receive.getData(), 0, receive.getLength());
                System.err.println("Recibido: " + linea);

                //Break if "Bye"
                if (linea.equals("ADIOS CHICOS"))
                {
                    socket.close();
                    break;
                }
            }
            socket.leaveGroup(multicastGroupIP);
        } catch (SocketException e) {}
        catch (IOException e) {}





        try {


            //mueve el raton hacia el texto para copiarlo
            //Comprueba si hace ping a la IP


            // espera 3 segundos y abre el link del traductor
            Thread.sleep(3000);
            proceso.abrirTraductor();

            //espera 2 segundos y mueve el raton hacia la casilla de traducir
            Thread.sleep(2000);
            mouse.mouseMove(1300,280);

            //!
            System.out.println((proceso.getHtmlDocument(url).getElementsByTagName("J0lOec")));

proceso.abrirTraductor();
            Elements entradas = (Elements) proceso.getHtmlDocument(url).getElementById("J0lOec");
            System.out.println(  proceso.getHtmlDocument(url).getElementsByTagNameNS(url,"J0lOec"));
            System.out.println(proceso.getHtmlDocument(url).getElementById("J0lOec"));
            System.out.println( proceso.getHtmlDocument(url).getElementById("J0lOec").getTextContent());
            System.out.println(entradas);









        } catch (NullPointerException | InterruptedException e) {
// Mensaje en caso de que falle al abrir el link
            //System.err.println("No se ha podido abrir el traductor");
            e.getStackTrace();

        }



        //! TOCAR TECLA E
        // mouse. keyPress(KeyEvent.VK_E);
       //keyB.keyPress(KeyEvent.VK_WINDOWS);
        //c1.setContents(getHtmlDocument(url).getElementById(proceso.getTextoTraducido()));



    }

}

