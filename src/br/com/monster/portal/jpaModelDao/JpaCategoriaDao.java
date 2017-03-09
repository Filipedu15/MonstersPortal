package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Categoria;
import br.com.monster.portal.modelDao.CategoriaDao;

@Repository
public class JpaCategoriaDao implements CategoriaDao {

	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Categoria categoria) {
			 manager.persist(categoria);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Categoria> Read() {
			
		    	Query query = manager
				        .createQuery("SELECT pro "
				        		+ "FROM Categoria pro "
				        		+ "ORDER BY pro.id_categoria ASC");

				@SuppressWarnings("unchecked")
				List<Categoria> categorias = query.getResultList();

			return categorias;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Categoria categoria) {
			manager.merge(categoria);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Categoria categoria) {
		   // Procura o ID
			Categoria categorias = manager.find(Categoria.class, categoria.getId_categoria());
			// Deleta
			manager.remove(categorias);
	   }

	@Override
	public Object Find_publico(String nome_categoria, Categoria categoria) {
		
    	Query query = manager
		        .createQuery("SELECT pro "
		        		+ "FROM Categoria pro "
		        		+ "WHERE nome_categoria = :Nome "
		        		+ "ORDER BY pro.id_categoria ASC");
		
		query.setParameter("Nome", (String) nome_categoria);

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.getResultList();

		return categorias;
	}

	@Override
	public List<Categoria> Find_produto_cat(String nome_categoria, Categoria categoria) {

		Query query = manager
		        .createQuery("SELECT cat "
		        		+ "FROM Categoria cat "
		        		+ "WHERE cat.id_categoria IN "
		        		+ "(SELECT categoria FROM Produto pro) "
		        		+ "AND cat.nome_categoria LIKE :Nome ");

		query.setParameter("Nome", (String) "%"+nome_categoria+"%");

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.getResultList();

		return categorias;
	}
}
