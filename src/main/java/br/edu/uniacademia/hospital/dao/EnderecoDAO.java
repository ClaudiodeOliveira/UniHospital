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

    /*  public static TipoFuncionarioDAO getInstance() {
        if (tipoFuncionarioDAO == null) {
            tipoFuncionarioDAO = new TipoFuncionarioDAO();
        }
        return tipoFuncionarioDAO;
    }

    public TipoFuncionario buscar(String nome) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from TipoFuncionario a where a.nomeTipoFuncionario =:nome ");
        query.setParameter("nome", nome);

        List<TipoFuncionario> categoria = query.getResultList();
        if (categoria != null && categoria.size() > 0) {
            return categoria.get(0);
        }

        return null;
    }

    public List<TipoFuncionario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TipoFuncionario As a");
        return query.getResultList();
    }

    public void remover(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoFuncionario)) {
            tipoFuncionario = em.merge(tipoFuncionario);
        }
        em.remove(tipoFuncionario);
        em.getTransaction().commit();
    }

    public TipoFuncionario persistir(TipoFuncionario tipoFuncionario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoFuncionario = em.merge(tipoFuncionario);
            em.getTransaction().commit();
            System.out.println("Registro TipoFuncionario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoFuncionario;
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(" delete from TipoFuncionario ");
        query.executeUpdate();
        em.getTransaction().commit();
    }*/
}
