/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dsd.trab1dsdservidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author 08168578902
 */
public class ServidorMain {
    
    //listas bd
    public static List<String> pessoasList = new ArrayList<>();
    

    public static void main(String[] args) throws IOException {
        
        //inicia servidor 
        ServerSocket servidor = new ServerSocket(2456);
        servidor.setReuseAddress(true);
        
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");
        
        Socket conexao = null;
        
        try {
            
            //aguarda conexao
            System.out.println("Servidor iniciado, aguardando conexao");
            conexao = servidor.accept();
            
            //conecta
            System.out.println("Conexao recebida");
         
            //entra em modo conversa 
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            PrintWriter out = new PrintWriter (conexao.getOutputStream(), true);
         
            System.out.println("Olá, seja bem vindo ao sistema Hickmann");
            System.out.println("Qual objeto voce gostaria de manipular?" + "\n" + "1 - Escola" +
                "\n" + "2 - Pessoa");
            
            //le qual objeto quer manipular
            String objeto = in.readLine();
            switch(objeto) {
                case "pessoa":
                    out.println("Objeto pessoa selecionado");
                break;
            }
            
            //le a manipulação
            String mensagem = in.readLine();
            //separa a primeira parte que é o comando
            String[] parteMensagem = mensagem.split(";");
            String opComando = parteMensagem[0].trim().toLowerCase();
            
            //separa o resto que é os dados
            int ind = mensagem.indexOf(';');
            String dados = mensagem.substring(ind + 1).trim();
            
            switch (opComando) {
                case "INSERT":
                    AddPessoa(dados);
                break;
                
                case "LIST":
                    ListTodasPessoas();
                break;
            }
            
        } catch (Exception e) {
            System.out.println("Deu exception");
            e.printStackTrace();
        } 
    }
    
    //operacoes para pessoa 
    public static void AddPessoa(String dados){
        pessoasList.add(dados);
    }
    public static void UpdatePessoa(){
        
    }
    public static void GetPessoa(){
        
    }
    public static void DeletePessoa(){
        
    }
    public static List<String> ListTodasPessoas(){
        return pessoasList;
    }
    
}
