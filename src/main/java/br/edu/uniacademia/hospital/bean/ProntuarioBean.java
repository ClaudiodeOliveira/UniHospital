/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Prontuarios;
import br.edu.uniacademia.hospital.tx.Transacional;
import java.io.Serializable;

import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author claud
 */
@Named
@ViewScoped
public class ProntuarioBean implements Serializable {

    @Inject
    private Prontuarios prontuarios;

    private Long prontuarioId;

    @Inject
    private ProntuarioDAO dao;

    public Prontuarios getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(Prontuarios prontuarios) {
        this.prontuarios = prontuarios;
    }

    public void carregarProntuarioPeloId() {
        System.out.println("Carregando Prontuario");
        this.prontuarios = this.dao.buscarPorId(prontuarioId);
    }

    @Transacional
    public String gravar() {
        System.out.println("Gravando Prontuaio" + this.prontuarios.getIdProntuario());

        if (this.prontuarios.getIdProntuario() == null) {
            this.dao.adiciona(this.prontuarios);
        } else {
            this.dao.atualiza(this.prontuarios);
        }
        this.prontuarios = new Prontuarios();

        return "prontuarios?faces-redirect=true";

    }

    @Transacional
    public void remover(Prontuarios prontuarios) {
        System.out.println("Removendo tipo funcionario" + prontuarios.getIdProntuario());

        this.dao.remove(prontuarios);
    }

    public List<Prontuarios> getProtuarios() {
        return this.dao.listaTodos();
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }
}
