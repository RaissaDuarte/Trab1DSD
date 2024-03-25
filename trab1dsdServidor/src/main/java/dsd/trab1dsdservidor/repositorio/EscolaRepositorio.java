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
    private ProfessorRepositorio professorRepositorio = new ProfessorRepositorio();
    private AlunoRepositorio alunoRepositorio = new AlunoRepositorio();

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

    public String listar() {
        int contarEscolas = listaEscola.size();

        StringBuilder builder = new StringBuilder();
        builder.append(contarEscolas).append("[ ");

        for (Escola escola : listaEscola) {
            builder.append(escola.toString()).append("  |||  ");
        }

        builder.append("]");

        return builder.toString();
    }


    public String get(int ID) {
        for (Escola escola : listaEscola) {
            if (escola.getID() == ID) {
                return escola.toString();
            }
        }
        return null;
    }

    public boolean vincularPessoa(int idEscola, String cpf) {
        Escola escolaSelecionada = new Escola();
        String msg = "";
        for (Escola escola : this.getList()) {
            if (escola.getID() == idEscola) {
                escolaSelecionada = escola;
                msg += escolaSelecionada.toString();
                boolean pessoaEncontrada = false;
                if (alunoRepositorio.get(cpf) != null) {
                    msg += alunoRepositorio.get(cpf);
                    pessoaEncontrada = true;
                    break; // interrompe o loop, pois a pessoa foi encontrada
                }
                if (!pessoaEncontrada) {
                    if (professorRepositorio.get(cpf) != null) {
                        msg += professorRepositorio.get(cpf);
                    }
                }
                if (pessoaEncontrada) {
                    return true; // pessoa encontrada e vinculada com sucesso
                }
            }
        }
        return false; // falha na vinculação
    }

    public List<Escola> getList() {
        return listaEscola;
    }

    public String listarVinculados() { //Tem que listar todas as escolas e todos os alunos e professores associados a ela
        if (listaEscola.isEmpty()) {
            return "0";
        }
        String escolasListadas = "";
        for (Escola escola : listaEscola) {
            escolasListadas += escola.toString();
            if (escola.getListaProfessores() == null) {
                for (Professor professor : professorRepositorio.getList()) {
                    escolasListadas += professor.toString();
                }
            } else if (escola.getListaAlunos() != null) {
                for (Aluno aluno : alunoRepositorio.getList()) {
                    escolasListadas += aluno.toString();
                }
            }
        }
        return escolasListadas;
    }
}
