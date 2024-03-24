/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.repositorio;

import java.util.List;
import dsd.trab1dsdservidor.model.Escola;
import dsd.trab1dsdservidor.model.Aluno;
import dsd.trab1dsdservidor.model.Pessoa;
import dsd.trab1dsdservidor.model.Professor;
import dsd.trab1dsdservidor.repositorio.AlunoRepositorio;
import dsd.trab1dsdservidor.repositorio.ProfessorRepositorio;
import java.util.ArrayList;

/**
 *
 * @author 09562388905
 */
public class EscolaRepositorio {

    private List<Escola> listaEscola;
    ProfessorRepositorio professorRepositorio = new ProfessorRepositorio();
    AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

    public EscolaRepositorio() {
        listaEscola = new ArrayList<>();
    }

    public boolean add(Escola escola) {
        for (Escola escolaListada : listaEscola) {
            if (escola.getID() == escolaListada.getID()) {
                return false;
            }
        }
        listaEscola.add(escola);
        return true;
    }

    public boolean excluir(int id) {
        for (Escola escola : listaEscola) {
            if (escola.getID() == id) {
                listaEscola.remove(escola);
                return true;
            }
        }
        return false;
    }

    public boolean editar(int ID, String nome, String reitor, String mascote, int anoFundacao) {
        for (Escola escola : listaEscola) {
            if (escola.getID() == ID) {
                escola.setNome(nome);
                escola.setReitor(reitor);
                escola.setMascote(mascote);
                escola.setAnoFundacao(anoFundacao);
                return true;
            }
        }
        return false;
    }

    public String listar() { //Tem que listar todas as escolas e todos os alunos e professores associados a ela
        if (listaEscola.isEmpty()) {
            return "0";
        }
        String numeroEscolas = String.valueOf(listaEscola.size());
        String escolasListadas = "";
        for (Escola escola : listaEscola) {
            escolasListadas += escola.toString();
        }
        String msgFinal = numeroEscolas + escolasListadas;
        return msgFinal;
    }

    public String get(int ID) {
        for (Escola escola : listaEscola) {
            if (escola.getID() == ID) {
                return escola.toString();
            }
        }
        return null;
    }

    public boolean vincularPessoa(int idEscola, String cpf) { //Tem que listar todas as escolas e todos os alunos e professores associados a ela
        String getEscola = get(idEscola);
        if (getEscola.isEmpty()) {
            return false;
        } else {
            for (Escola escola : getList()) {
                if (escola.getID() == idEscola) {
                    if (alunoRepositorio.get(cpf) != null) {
                        for (Aluno aluno : alunoRepositorio.getList()) {
                            if (aluno.getCpf().equals(cpf)) {
                                escola.addAluno(aluno);
                                return true;
                            }
                        }
                    } else if (professorRepositorio.get(cpf) != null) {
                        for (Professor professor : professorRepositorio.getList()) {
                            if (professor.getCpf().equals(cpf)) {
                                escola.addProfessor(professor);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public List<Escola> getList() {
        return listaEscola;
    }
}
