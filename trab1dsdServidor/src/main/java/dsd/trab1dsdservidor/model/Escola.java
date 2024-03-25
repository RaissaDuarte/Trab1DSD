/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.model;

import dsd.trab1dsdservidor.model.Aluno;
import dsd.trab1dsdservidor.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 09562388905
 */
public class Escola {
    private int ID;
    private String nome;
    private String reitor;
    private String mascote;
    private int anoFundacao;
    private List<Professor> listaProfessores;
    private List<Aluno> listaAlunos;

    public Escola(int ID, String nome, String reitor, String mascote, int anoFundacao) {
        this.ID = ID;
        this.nome = nome;
        this.reitor = reitor;
        this.mascote = mascote;
        this.anoFundacao = anoFundacao;
        this.listaAlunos = new ArrayList<>();
        this.listaProfessores = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReitor() {
        return reitor;
    }

    public void setReitor(String reitor) {
        this.reitor = reitor;
    }

    public String getMascote() {
        return mascote;
    }

    public void setMascote(String mascote) {
        this.mascote = mascote;
    }

    public int getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(int anoFundacao) {
        this.anoFundacao = anoFundacao;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }
    
    public void addProfessor(Professor professor){
        listaProfessores.add(professor);
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
    
    public void addAluno(Aluno aluno){
        listaAlunos.add(aluno);
    }

    @Override
    public String toString() {
        return ID + ";" + nome + ";" + reitor + ";" + mascote + ";" + anoFundacao + ";" ;
    }
    
}
