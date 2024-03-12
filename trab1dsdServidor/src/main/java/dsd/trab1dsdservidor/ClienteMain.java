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
            
            conexao = new Socket("10.15.120.36", 2456);
            System.out.println("Conexao estabelecida");
            PrintWriter out = new PrintWriter(conexao.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao.getInputStream()));

            while (true) {
                System.out.println("Olá, seja bem vindo ao sistema Hickmann");
                System.out.println("Qual objeto voce gostaria de manipular?" + "\n" + "1 - Escola" +
                "\n" + "2 - Pessoa");
            
            //seleção do objeto 
            int objeto = 2;
            switch (scan) {
                Case "1" :
                    
            }
            
            
        } catch (Exception e) {
            System.out.println("Deu exception");
            e.printStackTrace();
        }
        
    }
}
