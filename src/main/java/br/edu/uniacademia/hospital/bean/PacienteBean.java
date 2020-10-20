/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.bean;

import br.edu.uniacademia.hospital.dao.EnderecoDAO;
import br.edu.uniacademia.hospital.dao.FuncionarioDAO;
import br.edu.uniacademia.hospital.dao.PacienteDAO;
import br.edu.uniacademia.hospital.dao.ProntuarioDAO;
import br.edu.uniacademia.hospital.model.Enderecos;
import br.edu.uniacademia.hospital.model.Funcionarios;
import br.edu.uniacademia.hospital.model.Pacientes;
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
public class PacienteBean implements Serializable {

    @Inject
    private Pacientes pacientes;

    @Inject
    private Enderecos enderecos;

    @Inject
    private Prontuarios prontuarios;

    @Inject
    private Funcionarios funcionarios;

    private Long pacienteId;

    private Long enderecoId;

    private Long prontuarioId;

    private Long funcionarioId;

    private List<Pacientes> pacienteList;

    @Inject
    private PacienteDAO pacidao;

    @Inject
    private EnderecoDAO enddao;

    @Inject
    private ProntuarioDAO prodao;

    @Inject
    private FuncionarioDAO fundao;

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public List<Pacientes> getPacienteList() {
        if (this.pacienteList == null) {
            this.pacienteList = this.pacidao.listaTodos();
        }
        return pacienteList;
    }

    public List<Funcionarios> getFuncionarios() {
        return this.fundao.listaTodos();
    }

    public void carregarPacientesPeloId() {
        this.pacientes = this.pacidao.buscarPorId(pacienteId);
    }

    public void gravarProntuario() {
        Prontuarios prontuario = this.prodao.buscarPorId(this.prontuarioId);
        Funcionarios funcionario = this.fundao.buscarPorId(funcionarioId);
        this.funcionarios.adicionaProntuario(prontuario);
        this.pacientes.adicionaProntuario(prontuario);
    }

    @Transacional
    public String gravar() {
        if (this.pacientes.getIdPaciente() == null) {
            this.enddao.adiciona(this.enderecos);
            System.out.println("Endereço ID " + this.enderecos.getIdEndereco());
            this.prodao.adiciona(this.prontuarios);
            this.gravarProntuario();
            this.pacientes.setEndereco(this.enderecos);
            this.pacidao.adiciona(this.pacientes);
            this.pacienteList = this.pacidao.listaTodos();
        } else {
            this.enddao.atualiza(this.enderecos);
            this.pacidao.atualiza(this.pacientes);
        }
        this.prontuarios = new Prontuarios();
        this.pacientes = new Pacientes();
        this.enderecos = new Enderecos();

        return "paciente?faces-redirect=true";
    }

    @Transacional
    public void remover(Pacientes pacientes) {
        System.out.println("Removendo Funcionario " + pacientes.getNomePaciente());
        this.pacidao.remove(pacientes);
        this.pacienteList = this.pacidao.listaTodos();
    }

    public void carregar(Pacientes pacientes) {
        System.out.println("Carregar paciente");
        this.pacientes = this.pacidao.buscarPorId(pacientes.getIdPaciente());
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos enderecos) {
        this.enderecos = enderecos;
    }

    public Long getProntuarioId() {
        return prontuarioId;
    }

    public void setProntuarioId(Long prontuarioId) {
        this.prontuarioId = prontuarioId;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Prontuarios getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(Prontuarios prontuarios) {
        this.prontuarios = prontuarios;
    }

    public void setFuncionarios(Funcionarios funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

}
