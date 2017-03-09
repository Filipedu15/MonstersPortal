package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Fornecedor;
import br.com.monster.portal.modelDao.FornecedorDao;

@Repository
public class JpaFornecedorDao implements FornecedorDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Fornecedor fornecedor) {
			 manager.persist(fornecedor);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Fornecedor> Read() {
			
		    	Query query = manager
				        .createQuery("SELECT forn "//16
				        		+ "FROM Fornecedor forn "
								+ "ORDER BY forn.id_fornecedor ASC");

				@SuppressWarnings("unchecked")
				List<Fornecedor> fornecedores = query.getResultList();

			return fornecedores;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Fornecedor fornecedor) {
			manager.merge(fornecedor);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Fornecedor fornecedor) {
		   // Procura o ID
			Fornecedor fornecedores = manager.find(Fornecedor.class, fornecedor.getId_fornecedor());
			// Deleta
			manager.remove(fornecedores);
	   }
	 
}
