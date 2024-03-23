/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.repositorio;

import dsd.trab1dsdservidor.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 08168578902
 */
public class ProfessorRepositorio {
    private List<Professor> professoresList;

    public ProfessorRepositorio() {
        professoresList = new ArrayList<>();
    }

    public boolean add(Professor professor) {
        for (Professor p: professoresList){
            if(p.getCpf().equals(professor.getCpf())){
                return false;
            }
        }
        professoresList.add(professor);
        return true;
    }

    public boolean excluir(String cpf) {
        for (int i = 0; i < professoresList.size(); i++) {
            if (professoresList.get(i).getCpf().equals(cpf)) {
                professoresList.remove(i);
                return true;
            }
        }return false;
    }

    public boolean editar(String cpf, String novoNome, String novoEndereco, double novoSalario, String novaMateria) {
        for (Professor professor : professoresList) {
            if (professor.getCpf().equals(cpf)) {
                professor.setNome(novoNome);
                professor.setEndereco(novoEndereco);
                professor.setSalario(novoSalario);
                professor.setMateria(novaMateria);
                return true;
            }
        }return false;
    }

    public String listarTodosProfessores() {
        int contarProfessores = professoresList.size();

        StringBuilder builder = new StringBuilder();
        builder.append(contarProfessores).append("[ ");

        for (Professor professor : professoresList) {
            builder.append(professor.toString()).append("  |||  "); 
        }

        builder.append("]");

        return builder.toString();
    }

    public List<Professor> getList(){
        return professoresList;
    }
    public String get(String cpf) {
        for (Professor professor : professoresList) {
            if (professor.getCpf().equals(cpf)) {
                return professor.toString();
            }
        }
        return null;
    }
}
