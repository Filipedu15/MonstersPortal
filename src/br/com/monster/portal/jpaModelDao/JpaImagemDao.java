package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.modelDao.ImagemDao;

@Repository
public class JpaImagemDao implements ImagemDao {

	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Imagem imagem) {
			 manager.persist(imagem);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Imagem> Read() {
			
		    	/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Imagem pro "
				        		+ "ORDER BY pro.id_imagem ASC");

				@SuppressWarnings("unchecked")
				List<Imagem> imagems = query.getResultList();

			return imagems;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Imagem imagem) {
			manager.merge(imagem);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Imagem imagem) {
		   // Procura o ID
			Imagem imagems = manager.find(Imagem.class, imagem.getId_imagem());
			// Deleta
			manager.remove(imagems);
	   }

}
