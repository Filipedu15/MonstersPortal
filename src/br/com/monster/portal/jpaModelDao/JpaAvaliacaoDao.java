package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Avaliacao;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.AvaliacaoDao;
@Repository
public class JpaAvaliacaoDao implements AvaliacaoDao {
	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Avaliacao avaliacao) {
			 manager.persist(avaliacao);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Avaliacao> Read(String nome_produto, Produto produto, Avaliacao avaliacao) {

		    	Query query = manager
				        .createQuery("SELECT ava "
				        		+ "FROM Avaliacao ava INNER JOIN ava.produto pro "
				        		+ "WHERE ava.produto = pro.id_produto "
				        		+ "AND pro.nome_produto = :Nome "
				        		+ "ORDER BY ava.id_avaliacao ASC");
				
				query.setParameter("Nome", (String) nome_produto);

				@SuppressWarnings("unchecked")
				List<Avaliacao> avaliacaos = query.getResultList();

			return avaliacaos;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Avaliacao avaliacao) {
			manager.merge(avaliacao);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Avaliacao avaliacao) {
		   // Procura o ID
			Avaliacao avaliacaos = manager.find(Avaliacao.class, avaliacao.getId_avaliacao());
			// Deleta
			manager.remove(avaliacaos);
	   }

}