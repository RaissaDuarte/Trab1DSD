/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package dsd.trab1dsdservidor;

import dsd.trab1dsdservidor.model.Aluno;
import dsd.trab1dsdservidor.model.Pessoa;
import dsd.trab1dsdservidor.repositorio.AlunoRepositorio;
import dsd.trab1dsdservidor.repositorio.EscolaRepositorio;
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

        EscolaRepositorio escolaRep = new EscolaRepositorio();

        //inicia servidor 
        ServerSocket servidor = new ServerSocket(6543);
        servidor.setReuseAddress(true);

        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\n");

        Socket conexao = null;
        String finaliza = "";
       
        try {
            //aguarda conexao
            System.out.println("Servidor iniciado, aguardando conexao");
            conexao = servidor.accept();
            //conecta
            System.out.println("Conexao recebida");
            //entra em modo conversa 
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            PrintWriter out = new PrintWriter(conexao.getOutputStream(), true);

            while (!finaliza.equals("exit")){
            //le qual objeto quer manipular - 1 aluno, 2 professor, 3 escola
            String objeto = in.readLine();
            switch(objeto) {
                case "1":
                    out.println("Objeto aluno selecionado");
                    String mensagem = in.readLine();
                    crudAluno(mensagem, out);
                    System.out.println("aluno cadastrado");
                break;
                
                case "3":
                        out.println("Manipulação de Escola CONFIRMADA: ");
                        System.out.println("Manipulação de Escola...");
                        System.out.println("Selecione um dos Comandos: "
                                + "\n" + "INSERT"
                                + "\n" + "UPDATE"
                                + "\n" + "GET"
                                + "\n" + "DELETE"
                                + "\n" + "LIST");
                        break;
            }
            

//            while (!msgObjeto.equals("exit")) {
//                out.println(msgObjeto);
//
//                System.out.println("Aguardando mensagem...");
//                String msgRecebida = in.readLine();
//                if (msgRecebida == null) {
//                    System.out.println("Chat encerrado pelo outro usuário.");
//                    break;
//                }
            }
        } catch (Exception e) {
            System.out.println("Deu exception");
            e.printStackTrace();
        }
    }

    public static void crudAluno(String dadosAluno, PrintWriter out) {

        //separa a mensagem = "insert"; cpf; nome; endereço; turma 
        String[] parteMensagem = dadosAluno.split(";");

        String comando = parteMensagem[0].trim();

        AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

        switch (comando) {
            case "INSERT":
                String cpf = parteMensagem[1].trim();
                String nome = parteMensagem[2].trim();
                String endereco = parteMensagem[3].trim();
                String turma = parteMensagem[4].trim();
                Aluno aluno = new Aluno(cpf, nome, endereco, turma);
                alunoRepositorio.add(aluno);
                System.out.println("cheguei aqui"+aluno.toString());
               break;

            case "UPDATE":

                break;

            case "GET":

                break;
            case "DELETE":

                break;
            case "LIST":
                List<Aluno> alunos = alunoRepositorio.listarTodosAlunos();
                for (Aluno a : alunos) {
                    out.println(a.toString());
                }
                break;
        }
    }
}
