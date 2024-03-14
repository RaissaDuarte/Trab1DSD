/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor;

/**
 *
 * @author 08168578902
 */
public class Professor extends Pessoa{
    private double salario;
    private String materia; 
    

    public Professor(String cpf, String nome, String endereco, double salario, String materia) {
        super(cpf, nome, endereco);
        this.salario = salario;
        this.materia = materia;
    }
    
    
}
