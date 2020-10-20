/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.dao;


import br.edu.uniacademia.hospital.model.TipoFuncionario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author claud
 */
public class TipoFuncionarioDAO implements Serializable {

    @Inject
    EntityManager em;

    private DAO<TipoFuncionario> dao;

    @PostConstruct
    void init() {
        this.dao = new DAO<TipoFuncionario>(this.em, TipoFuncionario.class);
    }

    public TipoFuncionario buscarPorId(Long tipoFuncionarioId) {
        return this.dao.buscaPorId(tipoFuncionarioId);
    }

    public void adiciona(TipoFuncionario tipoFuncionario) {
        this.dao.adiciona(tipoFuncionario);
    }

    public void atualiza(TipoFuncionario tipoFuncionario) {
        this.dao.atualiza(tipoFuncionario);
    }

    public void remove(TipoFuncionario tipoFuncionario) {
        this.dao.remove(tipoFuncionario);
    }

    public List<TipoFuncionario> listaTodos() {
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
