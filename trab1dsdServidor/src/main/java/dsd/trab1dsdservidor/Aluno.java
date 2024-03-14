/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor;

/**
 *
 * @author 08168578902
 */
public class Aluno extends Pessoa {
    private String turma;

    public Aluno(String cpf, String nome, String endereco, String turma) {
        super(cpf, nome, endereco);
        this.turma = turma; 
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    
    
    
}
