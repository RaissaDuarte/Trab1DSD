/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.repositorio;

import dsd.trab1dsdservidor.model.Aluno;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 08168578902
 */
public class AlunoRepositorio {
    private List<Aluno> alunoslist;

    public AlunoRepositorio() {
        alunoslist = new ArrayList<>();
    }

    public void add(Aluno aluno) {
        alunoslist.add(aluno);
    }

    public boolean excluir(String cpf) {
        for (int i = 0; i < alunoslist.size(); i++) {
            if (alunoslist.get(i).getCpf().equals(cpf)) {
                alunoslist.remove(i);
                return true;
            }
        }return false;
    }

    public boolean editar(String cpf, String novoNome, String novoEndereco, String novaTurma) {
        for (Aluno aluno : alunoslist) {
            if (aluno.getCpf().equals(cpf)) {
                aluno.setNome(novoNome);
                aluno.setEndereco(novoEndereco);
                aluno.setTurma(novaTurma);
                return true;
            }
            
        }return false;
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoslist;
    }

    public String get(String cpf) {
        for (Aluno aluno : alunoslist) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno.toString();
            }
        }
        return null;
    }
}
