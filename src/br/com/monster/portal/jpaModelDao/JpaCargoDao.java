package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cargo;
import br.com.monster.portal.modelDao.CargoDao;

@Repository
public class JpaCargoDao implements CargoDao {

	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Cargo cargo) {
			 manager.persist(cargo);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Cargo> Read() {

		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Cargo pro "
				        		+ "ORDER BY pro.id_cargo ASC");

				@SuppressWarnings("unchecked")
				List<Cargo> cargos = query.getResultList();

			return cargos;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Cargo cargo) {
			manager.merge(cargo);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Cargo cargo) {
		   // Procura o ID
			Cargo cargos = manager.find(Cargo.class, cargo.getId_cargo());
			// Deleta
			manager.remove(cargos);
	   }
}
