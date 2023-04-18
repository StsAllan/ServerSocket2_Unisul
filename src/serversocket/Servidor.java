package serversocket;

import java.util.Scanner;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

public class Servidor extends Thread {

    private static int contador = 0;
    private Socket con;
    private BufferedReader in;
    private PrintWriter out;

    public Servidor(Socket socket) {
        try {
            con = socket;
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            out = new PrintWriter(con.getOutputStream(), true);
            contador ++;
            System.out.println("Chegou mais um mano, o total de manos é: "+contador);
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }

    public void run() {
        try {
            out.println("Bem vindo!"); //Escreve ao cliente
            String mensagem = "";
            while ((mensagem = in.readLine()) != null) {
                System.out.println(mensagem);
            }
        } catch (IOException ioe) {
            System.err.println("Problemas de IO");
        }
    }
}
