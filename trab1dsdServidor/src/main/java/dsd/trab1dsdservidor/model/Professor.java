/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.model;

import dsd.trab1dsdservidor.model.Pessoa;

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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    
    
    @Override
    public String toString() {
        return super.toString() + "; Salário: " + salario + "; Matéria: "+ materia; 
    }
    
    
    
}
