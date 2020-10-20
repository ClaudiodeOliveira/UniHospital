/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uniacademia.hospital.service;

import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;

/**
 * REST Web Service
 *
 * @author tassi
 */
@Path("servicosTipoFuncionario")
@RequestScoped
public class ServicosTipoFuncionario {

    /*@Context
    private UriInfo context;

    /**
     * Creates a new instance of ServicosTipoFuncionarioResource
     */
    /*public ServicosTipoFuncionario() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizar(TipoFuncionario tf) {
        TipoFuncionarioDAO.getInstance().persistir(tf);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void gravar(TipoFuncionario tf) {
        TipoFuncionarioDAO.getInstance().persistir(tf);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TipoFuncionario> buscarTodos() {
        return TipoFuncionarioDAO.getInstance().buscarTodas();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TipoFuncionario buscar(TipoFuncionario tf) {
        return TipoFuncionarioDAO.getInstance().buscar(tf.getNomeTipoFuncionario());
    }

    @DELETE
    @Path("{id}")
    public void remover(TipoFuncionario tf) {
        TipoFuncionarioDAO.getInstance().remover(tf);
    }*/

}
