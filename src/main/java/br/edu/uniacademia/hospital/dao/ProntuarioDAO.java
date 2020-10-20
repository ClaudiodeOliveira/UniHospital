/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Prontuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author claud
 */
public class ProntuarioDAO implements Serializable {

    @Inject
    EntityManager em;

    private DAO<Prontuarios> dao;
    
    @PostConstruct
    void init(){
        this.dao = new DAO<Prontuarios>(this.em, Prontuarios.class);
    }
    
    public Prontuarios buscarPorId(Long pronturaioId){
        return this.dao.buscaPorId(pronturaioId);
    }
    
    public void adiciona(Prontuarios prontuarios){
        this.dao.adiciona(prontuarios);
    }
    
    public void atualiza(Prontuarios prontuarios){
        this.dao.atualiza(prontuarios);
    }
    
    public void remove(Prontuarios prontuarios){
        this.dao.remove(prontuarios);
    }
    
    public List<Prontuarios> listaTodos(){
        return this.dao.listaTodos();
    }

}
