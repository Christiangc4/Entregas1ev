import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Procesos extends Thread{


    String textoTraducir, textoTraducido;
    protected final String URLTraductor = "https://translate.google.es/";


    public Procesos(String textoTraducir, String textoTraducido) {
        this.textoTraducir = textoTraducir;
        this.textoTraducido = textoTraducido;
    }
    public Procesos (){

    }

    public void crearArchivoPowershell (Runtime runtime, BufferedReader stdout) throws IOException, InterruptedException {

        try {
            File file = new File("c\\Users\\%userName%\\Escritorio\\traducir.ps1");
            BufferedWriter bw =  new BufferedWriter(new FileWriter(file)) ;
            if(file.exists()) {
                bw.write("[System.Windows.Forms.SendKeys]::SendWait()");
            } else {

            }
            bw.close();


            ProcessBuilder pb = new ProcessBuilder("cmd", "echo  > ", "");
            pb.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }





                /*Process process = runtime.exec("powershell.exe  C:\\Users\\quiqu\\Escritorio\\DAM2\\PSP\\");

                process.getOutputStream().close();
                String line;
                 stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while ((line = stdout.readLine()) != null){
                    System.out.println(line);
                }

                TimeUnit.SECONDS.sleep(2);
            }*/



    }


    public void copiarPegar(){

    }




    public void abrirTraductor(){

        if (java.awt.Desktop.isDesktopSupported()) {
            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                try {
                    java.net.URI uri = new java.net.URI(URLTraductor);
                    desktop.browse(uri);
                } catch (URISyntaxException | IOException ex) {
                    Logger.getLogger(Procesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void pingTraductor(){
        String direccionIP = "80.58.61.250";

    }






    //*Con este método devuelvo un objeto de la clase Document con el contenido de HTML de la web que me permitirá parsearlo con los métodos de la libreria JSoup*/
    public Document getHtmlDocument(String url) throws IOException {

        Document doc = (Document) Jsoup.connect(url).timeout(100000).get();


        Elements ps = (Elements) doc.getElementById("VIiyi");



       return doc;
    }


    /*public void sacarCoordenadasRaton(){
        addActionListener(Object::notifyAll);
    }
               addMouseMotionListener(new MouseMotionAdapter(){
             @Override
         public void mouseMoved(MouseEvent evento){
                        evento.getX();
                 System.out.println(evento.getX(),evento.getY());
                                    //getX y getY devuelve valores de las coordenadas del puntero.
                                           //evento.getX(),evento.getY();
                         }
         });*/

    public void sacarTextoTraducido() throws IOException {
        Document document = getHtmlDocument(URLTraductor);


        Elements entradas = (Elements) document.getElementsByTagName("VIiyi");

        //Elements entradas = document.getDocumentElement().not("c-wiz.P6w8m");

        for (Element elem : entradas) {
            String textoCopiarTraductor = elem.getElementsByClass("VIiyi").text();



        }













    }

    public void capturarTeclas   () throws InterruptedException, AWTException, IOException {
        String command = "notepad.exe";
        Runtime run = Runtime.getRuntime();
        run.exec(command);


        Robot robot = new Robot();
        /*robot.keyPress(KeyEvent.VK_W);

        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_L);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_C);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_E);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_SPACE);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_J);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_A);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_P);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_O);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_I);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_N);
        Thread.sleep(500);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(500);*/
    }






    public String getTextoTraducir() {
        return textoTraducir;
    }

    public void setTextoTraducir(String textoTraducir) {
        this.textoTraducir = textoTraducir;
    }

    public String getTextoTraducido() {
        return textoTraducido;
    }

    public void setTextoTraducido(String textoTraducido) {
        this.textoTraducido = textoTraducido;
    }


}



