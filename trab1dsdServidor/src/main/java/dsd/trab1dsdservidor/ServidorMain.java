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
         
            
            //le qual objeto quer manipular - 1 aluno, 2 professor, 3 escola
            String objeto = in.readLine();
            switch(objeto) {
                case "1":
                    out.println("Objeto pessoa selecionado");
                    String mensagem = in.readLine();
                    crudAluno(mensagem);
                break;
            }
            
            
        } catch (Exception e) {
            System.out.println("Deu exception");
            e.printStackTrace();
            }
    }
    
    
        public static void crudAluno(String dadosAluno) {
            
            //separa a mensagem = "insert"; cpf; nome; endereço; 
            String[] parteMensagem = dadosAluno.split(";");
            
            String comando = parteMensagem[0].trim();
            String cpf = partesMensagem
            
            
            
            
            //separa o resto que é os dados
            int ind = mensagem.indexOf(';');
            String dados = mensagem.substring(ind + 1).trim();
            
            switch (opComando) {
                case "INSERT":
                    
                break;
                
                case "LIST":
                    
                break;
            }
        }
    
        
       
        
        
}
