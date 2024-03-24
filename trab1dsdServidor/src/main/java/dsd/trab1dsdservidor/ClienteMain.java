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
            
            
            System.out.println("Olá, seja bem vindo!!!");
           while (true) {
                System.out.println("Qual objeto voce gostaria de manipular?" + "\n" + "1 - Aluno" +
                "\n" + "2 - Professor"+ "\n" + "3 - Escola");

                String objeto = scan.nextLine();
                
                
            conexao = new Socket("10.15.120.73", 6543);
            System.out.println("Conexao estabelecida");
            PrintWriter out = new PrintWriter(conexao.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            
                

            switch (objeto) {
                case "1":
                    
                    out.println(objeto);
                    String retorno = in.readLine();
                    System.out.println(retorno);
                    crudAluno(out, scan);
                    System.out.println(in.readLine());       
                    conexao.close();
                break;
                case"2":
                    out.println(objeto);
                    String retornoProfessor = in.readLine();
                    System.out.println(retornoProfessor);
                    crudProfessor(out, scan);
                    System.out.println(in.readLine());
                    conexao.close();
                break;    

                case "3":
                    out.println(objeto);
                    String retornoEscola = in.readLine();
                    System.out.println(retornoEscola);
                    crudEscola(out, scan);
                    System.out.println(in.readLine());
                    conexao.close();
                break;
            }

            }
        } catch(IOException e) {
            System.out.println("Deu Exception");
            e.printStackTrace();
        } 
    }

//--------------------------------------------------------------------------------------------------------------------------
    
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
    
    
    public static void crudProfessor(PrintWriter out, Scanner scan){
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
                    System.out.println("Insira o salario");
                    String salario = scan.nextLine();
                    System.out.println("Insira a materia");
                    String materia = scan.nextLine();
                    out.println("INSERT;"+cpf+";"+nome+";"+endereco+";"+salario+";"+materia);
                break;
                
                case "2":
                    System.out.println("Insira o CPF do professor que voce quer alterar");
                    String cpfup = scan.nextLine();
                    System.out.println("Insira o novo nome");
                    String nomeup = scan.nextLine();
                    System.out.println("Insira o novo endereço");
                    String enderecoup = scan.nextLine();
                    System.out.println("Insira o novo salário");
                    String salarioup = scan.nextLine();
                    System.out.println("Insira a nova materia");
                    String materiaup = scan.nextLine();
                    out.println("UPDATE;"+cpfup+";"+nomeup+";"+enderecoup+";"+salarioup+";"+materiaup);
                break;
                
                case "3":
                    System.out.println("Digite o cpf do professor que voce deseja pesquisar");
                    String cpfget = scan.nextLine();
                    out.println("GET;"+cpfget);
                break;
                
                case "4": 
                    System.out.println("Insira o cpf do professor que voce deseja excluir");
                    String cpfdel = scan.nextLine();
                    out.println("DELETE;"+cpfdel);
                break;
                
                case "5":
                    out.println("LIST");
                break;                    
            } 
    }
    
    public static void crudEscola(PrintWriter out, Scanner scan){
        System.out.println("Selecione o que voce deseja fazer: " + "\n" + "1 - INSERT"
                                + "\n" + "2 - UPDATE"
                                + "\n" + "3 - GET"
                                + "\n" + "4 - DELETE"
                                + "\n" + "5 - LIST" 
                                + "\n" + "6 - VINCULAR PESSOA");
        
        String respostaCliente = scan.nextLine();
        
            switch (respostaCliente){
                case "1":
                    System.out.println("Insira o ID");
                    String id = scan.nextLine();
                    System.out.println("Insira o nome");
                    String nome = scan.nextLine();
                    System.out.println("Insira o reitor");
                    String reitor = scan.nextLine();
                    System.out.println("Insira o mascote");
                    String mascote = scan.nextLine();
                    System.out.println("Insira o ano de fundação");
                    String anoFundacao = scan.nextLine();
                    out.println("INSERT;"+id+";"+nome+";"+reitor+";"+mascote+";"+anoFundacao);
                break;
                
                case "2":
                    System.out.println("Insira o ID da Escola que voce quer alterar");
                    String idUp = scan.nextLine();
                    System.out.println("Insira o novo nome");
                    String nomeUp = scan.nextLine();
                    System.out.println("Insira o novo reitor");
                    String reitorUp = scan.nextLine();
                    System.out.println("Insira o novo mascote");
                    String mascoteUp = scan.nextLine();
                    System.out.println("Insira o novo ano de fundação");
                    String anoFundacaoUp = scan.nextLine();
                    out.println("UPDATE;"+idUp+";"+nomeUp+";"+reitorUp+";"+mascoteUp+";"+anoFundacaoUp);
                break;
                
                case "3":
                    System.out.println("Digite o id da escola que voce deseja pesquisar");
                    String idGet = scan.nextLine();
                    out.println("GET;"+idGet);
                break;
                
                case "4": 
                    System.out.println("Insira o id da escola que voce deseja excluir");
                    String idDel = scan.nextLine();
                    out.println("DELETE;"+idDel);
                break;
                
                case "5":
                    out.println("LIST");
                break;
                
                case "6":
                    //Verifica se existe a escola a ser vinculado
                    //verifica se existe pessoa a ser vinculada
                    //Verifica se essa pessoa já está vinculada da essa escola
                    //Vincula
                    System.out.println("Insira o ID Escola");
                    String idEscola = scan.nextLine();
                    System.out.println("Insira o CPF da Pessoa(Aluno/Professor)");
                    String cpf = scan.nextLine();
                    out.println("VINCULAR-PESSOA;"+idEscola+";"+cpf);
                break;                    
            } 
    }
}
