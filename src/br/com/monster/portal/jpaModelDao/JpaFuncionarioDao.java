package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Funcionario;
import br.com.monster.portal.modelDao.FuncionarioDao;

@Repository
public class JpaFuncionarioDao implements FuncionarioDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Funcionario funcionario) {
			 manager.persist(funcionario);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Funcionario> Read() {
			
		    	Query query = manager
				        .createQuery("SELECT fun "//16
				        		+ "FROM Funcionario fun INNER JOIN fun.cargo car "//33
				        		+ "WHERE fun.cargo = car.id_cargo "
								+ "ORDER BY fun.id_funcionario ASC");

				@SuppressWarnings("unchecked")
				List<Funcionario> funcionarios = query.getResultList();

			return funcionarios;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Funcionario funcionario) {
			manager.merge(funcionario);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Funcionario funcionario) {
		   // Procura o ID
			Funcionario funcionarios = manager.find(Funcionario.class, funcionario.getId_funcionario());
			// Deleta
			manager.remove(funcionarios);
	   }

		/*
		 * -------------------------
		 * 		Existência			
		 * -------------------------
		 */
	   

		public boolean FuncionarioExiste(Funcionario funcionario) {
			// Pega o dado digitado pelo usuário
			String usuario = funcionario.getUsuario_funcionario();
			String senha = funcionario.getSenha_funcionario();
						
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT fun FROM Funcionario as fun "
							+ "WHERE fun.usuario_funcionario = :usuario "
							+ "AND fun.senha_funcionario = :senha");

						query.setParameter("usuario", (String) usuario);
						query.setParameter("senha", (String) senha);
			
			@SuppressWarnings("unchecked")
			List<Funcionario> funcionarios = query.getResultList();
			
			if (!funcionarios.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
	   
}
