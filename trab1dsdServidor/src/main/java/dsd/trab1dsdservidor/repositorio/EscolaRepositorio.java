/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.trab1dsdservidor.repositorio;

import java.util.List;
import dsd.trab1dsdservidor.model.Escola;
import java.util.ArrayList;
/**
 *
 * @author 09562388905
 */
public class EscolaRepositorio {
    private List<Escola> listaEscola;
    
    public EscolaRepositorio() {
        listaEscola = new ArrayList<>();
    }
    
    public void add(Escola escola){
        listaEscola.add(escola);
    }
    
    public void excluir(int id){
        for(Escola escola : listaEscola){
            if(escola.getID() == id){
                listaEscola.remove(escola);
            }
        }
    }
    
    public void editar(int ID, String nome, String reitor, String mascote, int anoFundacao) {
        for(Escola escola : listaEscola) {
            if(escola.getID() == ID) {
                escola.setNome(nome);
                escola.setReitor(reitor);
                escola.setMascote(mascote);
                escola.setAnoFundacao(anoFundacao);
            }
        }
    }
    
    public List<Escola> listar() {
        return listaEscola;
    }
    
    public Escola get(int ID){
        for(Escola escola : listaEscola) {
            if(escola.getID() == ID) {
                return escola; 
            }
        }
        return null;
    }   
    
}
