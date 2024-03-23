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
    private List<Aluno> alunoslist ;

    public AlunoRepositorio() {
        alunoslist = new ArrayList<>();
    }

    public boolean add(Aluno aluno) {
        for (Aluno a: alunoslist){
            if(aluno.getCpf().equals(a.getCpf())){
                return false;
            }
        }
        alunoslist.add(aluno);
        return true;
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

    public String listarTodosAlunos() {
        int contarAlunos = alunoslist.size();
        StringBuilder builder = new StringBuilder();
        builder.append(contarAlunos).append(" [[ ");

        for (Aluno a: alunoslist){
            builder.append(a.toString()).append("  |||  ");
        }
        builder.append(" ]]");
        return (builder.toString());
    }

    public List<Aluno> getList(){
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
