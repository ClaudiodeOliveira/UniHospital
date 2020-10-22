package br.edu.uniacademia.hospital.tx;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

/**
 *
 * @author claud
 */
@Transacional
@Interceptor
public class GerenciadorDeTransacao implements Serializable {

	@Inject
	EntityManager manager;

	@AroundInvoke
	public Object executaTX(InvocationContext contexto) throws Exception {

		manager.getTransaction().begin();
		
		// chamar os daos que precisam de um TX
		Object resultado = contexto.proceed();

		manager.getTransaction().commit();

		return resultado;
	}

}
