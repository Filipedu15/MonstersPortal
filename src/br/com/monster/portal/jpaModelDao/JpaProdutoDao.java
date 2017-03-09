package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Imagem;
import br.com.monster.portal.model.Produto;
import br.com.monster.portal.modelDao.ProdutoDao;

@Repository
public class JpaProdutoDao implements ProdutoDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Produto produto, Imagem imagem) {
			 manager.persist(produto);
			 manager.flush();
			 manager.persist(imagem);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Produto> Read() {
			
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima)");
		    	

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

			return produtos;
		}

		public List<Produto> Read_publico() {
			
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true");
		    	

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

			return produtos;
		}

		public List<Produto> Read_destacado() {
			
			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.destaque_produto = true");
		    	

				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();

			return produtos;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Produto produto) {
			manager.merge(produto);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Produto produto) {
		   // Procura o ID
			Produto produtos = manager.find(Produto.class, produto.getId_produto());
			// Deleta
			manager.remove(produtos);
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Find				
	    * ----------------------------------
	    * 
	    */
	   
		public List<Produto> Find(String nome_prod, Produto produto) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.nome_produto LIKE :Nome "
			        		+ "AND pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) ");
			
			query.setParameter("Nome", (String) "%"+nome_prod+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
		@Override
		public List<Produto> Find_publico(String nome_produto, Produto produto) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.nome_produto = :Nome");
			
			query.setParameter("Nome", (String) nome_produto);
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
		
		@Override
		public List<Produto> Find_Many_publico(String nome_produto, Produto produto) {

			Query query = manager
			        .createQuery("SELECT pro "
			        		+ "FROM Produto pro "
			        		+ "WHERE pro.id_produto IN "
			        		+ "(SELECT produto FROM Imagem ima) "
			        		+ "AND pro.publicado_produto = true "
			        		+ "AND pro.nome_produto LIKE :Nome");
			
			query.setParameter("Nome", (String) "%"+nome_produto+"%");
	
				@SuppressWarnings("unchecked")
				List<Produto> produtos = query.getResultList();
	
			return produtos;
			
		}
}
