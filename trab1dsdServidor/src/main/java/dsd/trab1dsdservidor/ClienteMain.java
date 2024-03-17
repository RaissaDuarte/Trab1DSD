/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 08168578902
 */
public class ClienteMain {
    
    public static void main (String[] args) throws IOException {
        
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        Socket conexao = null;
        
        try {
            
            conexao = new Socket("10.15.120.36", 6543);
            System.out.println("Conexao estabelecida");
            PrintWriter out = new PrintWriter(conexao.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            while (true) {
                System.out.println("Olá, seja bem vindo!!!");
                System.out.println("Aguardando mensagem...");
                String msgRecebida = in.readLine();
                
                System.out.println("Mensgem recebida: " + msgRecebida);
                
                System.out.println("Digite: 1 - para manipular Aluno, 2 - para manipular Professor, 3 - para manipular Escola");
                System.out.println("Digite 'exit' para sair");
                
                String msgEnviar = scan.nextLine();

                if(msgEnviar.equals("exit")){
                    System.out.println("Conexão Encerrada...");
                    break;
                }
                out.println(msgEnviar);        
            }
        } catch(Exception e) {
            System.out.println("Deu Exception");
            e.printStackTrace();
        } finally {
            if (conexao != null){
                conexao.close();
                System.out.println("Socket Encerrado...");
            }
        }
    }
}
