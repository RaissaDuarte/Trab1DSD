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
            
            conexao = new Socket("10.15.120.73", 6543);
            System.out.println("Conexao estabelecida");
            PrintWriter out = new PrintWriter(conexao.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            
            System.out.println("Olá, seja bem vindo!!!");
            while (true) {
                
//                System.out.println("Aguardando mensagem...");
                //String msgRecebida = in.readLine();
                
                //System.out.println("Mensgem recebida: " + msgRecebida);
                
                System.out.println("Qual objeto voce gostaria de manipular?" + "\n" + "1 - Aluno" +
                "\n" + "2 - Professor"+ "\n" + "3 - Escola"+ "\n" +"Exit - para encerrar");
//                System.out.println("Digite: 1 - para manipular Aluno, 2 - para manipular Professor, 3 - para manipular Escola");
//                System.out.println("Digite 'exit' para sair");
//                
                String objeto = scan.nextLine();

                if (objeto.equals("exit")) {
                    out.println(objeto);
                    System.out.println("Conexão encerrada.");
                    conexao.close();
                    return;
                } 

            switch (objeto) {
                case "1":
                    out.println(objeto);
                    String retorno = in.readLine();
                    System.out.println(retorno);
                    crudAluno(out, scan);
                    System.out.println(in.readLine());                    
                break;
            }

            }
        } catch(IOException e) {
            System.out.println("Deu Exception");
            e.printStackTrace();
        } finally {
            if (conexao != null){
                conexao.close();
                System.out.println("Socket Encerrado...");
            }
        }
        
        
    }
    
    public static void crudAluno(PrintWriter out, Scanner scan){
        System.out.println("Selecione o que voce deseja fazer: " + "\n" + "1 - INSERT"
                                + "\n" + "2 - UPDATE"
                                + "\n" + "3 - GET"
                                + "\n" + "4 - DELETE"
                                + "\n" + "5 - LIST");
        
        String respostaCliente = scan.nextLine();
        
            switch (respostaCliente){
                case "1":
                    System.out.println("Insira o CPF");
                    String cpf = scan.nextLine();
                    System.out.println("Insira o nome");
                    String nome = scan.nextLine();
                    System.out.println("Insira o endereço");
                    String endereco = scan.nextLine();
                    System.out.println("Insira a turma");
                    String turma = scan.nextLine();
                    out.println("INSERT;"+cpf+";"+nome+";"+endereco+";"+turma);
                break;
                
                case "2":
                    System.out.println("Insira o CPF do aluno que voce quer alterar");
                    String cpfup = scan.nextLine();
                    System.out.println("Insira o novo nome");
                    String nomeup = scan.nextLine();
                    System.out.println("Insira o novo endereço");
                    String enderecoup = scan.nextLine();
                    System.out.println("Insira a nova turma");
                    String turmaup = scan.nextLine();
                    out.println("UPDATE;"+cpfup+";"+nomeup+";"+enderecoup+";"+turmaup);
                break;
                
                case "3":
                    System.out.println("Digite o cpf do aluno que voce deseja pesquisar");
                    String cpfget = scan.nextLine();
                    out.println("GET;"+cpfget);
                break;
                
                case "4": 
                    System.out.println("Insira o cpf do aluno que voce deseja excluir");
                    String cpfdel = scan.nextLine();
                    out.println("DELETE;"+cpfdel);
                break;
                
                case "5":
                    out.println("LIST");
                break;
                
                
                    
            } 
    }
}
