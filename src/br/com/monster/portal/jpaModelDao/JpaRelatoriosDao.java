package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Relatorios;
import br.com.monster.portal.modelDao.RelatoriosDao;

@Repository
public class JpaRelatoriosDao implements RelatoriosDao {
	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Relatorios relatorios) {
			 manager.persist(relatorios);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Relatorios> Read() {
			
		    	/*Query query = manager
				        .createQuery("SELECT pro "//16
				        		+ "FROM Produto pro INNER JOIN pro.produto pro "//33
				        		+ "WHERE pro.produto = pro.id_produto "
								+ "ORDER BY pro.id_Produto ASC");*/
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Relatorios pro "
				        		+ "ORDER BY pro.id_relatorios ASC");

				@SuppressWarnings("unchecked")
				List<Relatorios> relatorios = query.getResultList();

			return relatorios;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Relatorios relatorios) {
			manager.merge(relatorios);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Relatorios relatorio) {
		   // Procura o ID
			Relatorios relatorios = manager.find(Relatorios.class, relatorio.getId_relatorios());
			// Deleta
			manager.remove(relatorios);
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Find				
	    * ----------------------------------
	    * 
	    */
	   
		public List<Relatorios> Find(Relatorios relatorio) {
			// Pega o dado digitado pelo usuário
			String nome = relatorio.getQuando_relatorios();
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT t FROM Relatorios as t "
			        		+ "WHERE t.nome_Relatorios = :Nome "
			                + "ORDER BY id_Relatorios ASC");
			
			query.setParameter("Nome", (String) nome);
	
				@SuppressWarnings("unchecked")
				List<Relatorios> relatorios = query.getResultList();
	
			return relatorios;
			
		}
}
