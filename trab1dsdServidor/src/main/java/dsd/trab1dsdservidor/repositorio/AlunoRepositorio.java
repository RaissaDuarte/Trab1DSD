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
    private List<Aluno> bancoDeDados;

    public AlunoRepositorio() {
        bancoDeDados = new ArrayList<>();
    }

    public void add(Aluno aluno) {
        bancoDeDados.add(aluno);
    }

    public void excluir(String cpf) {
        for (int i = 0; i < bancoDeDados.size(); i++) {
            if (bancoDeDados.get(i).getCpf().equals(cpf)) {
                bancoDeDados.remove(i);
                return;
            }
        }
    }

    public void editar(String cpf, String novoNome, String novoEndereco, String novaTurma) {
        for (Aluno aluno : bancoDeDados) {
            if (aluno.getCpf().equals(cpf)) {
                aluno.setNome(novoNome);
                aluno.setEndereco(novoEndereco);
                aluno.setTurma(novaTurma);
                return;
            }
        }
    }

    public List<Aluno> listar() {
        return new ArrayList<>(bancoDeDados);
    }

    public Aluno get(String cpf) {
        for (Aluno aluno : bancoDeDados) {
            if (aluno.getCpf().equals(cpf)) {
                return aluno;
            }
        }
        return null;
    }
}
