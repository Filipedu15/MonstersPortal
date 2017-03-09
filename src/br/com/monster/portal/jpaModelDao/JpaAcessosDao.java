package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Acessos;
import br.com.monster.portal.modelDao.AcessosDao;

@Repository
public class JpaAcessosDao implements AcessosDao {
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Acessos acessos) {
			 manager.persist(acessos);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Acessos> Read() {
			
		    	/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Acessos pro "
				        		+ "ORDER BY pro.id_acessos ASC");

				@SuppressWarnings("unchecked")
				List<Acessos> acessos = query.getResultList();

			return acessos;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Acessos acessos) {
			manager.merge(acessos);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Acessos acesso) {
		   // Procura o ID
			Acessos acessos = manager.find(Acessos.class, acesso.getId_acessos());
			// Deleta
			manager.remove(acessos);
	   }
}
