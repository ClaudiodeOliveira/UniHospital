/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;

import br.edu.uniacademia.hospital.model.Enderecos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author tassi
 */
public class EnderecoDAO implements Serializable {

    @Inject
    EntityManager em;

    private DAO<Enderecos> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<Enderecos>(this.em, Enderecos.class);
    }

    public Enderecos buscarPorId(Long enderecoId) {
        return this.dao.buscaPorId(enderecoId);
    }

    public void adiciona(Enderecos enderecos) {
        this.dao.adiciona(enderecos);
    }

    public void atualiza(Enderecos enderecos) {
        this.dao.atualiza(enderecos);
    }

    public void remove(Enderecos enderecos) {
        this.dao.remove(enderecos);
    }

    public List<Enderecos> listaTodos() {
        return this.dao.listaTodos();
    }

}
