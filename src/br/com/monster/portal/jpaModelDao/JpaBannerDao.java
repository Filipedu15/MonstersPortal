package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Banner;
import br.com.monster.portal.modelDao.BannerDao;

// Container do Spring
@Repository
public class JpaBannerDao implements BannerDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Banner banner) {
			 manager.persist(banner);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Banner> Read() {
			
	    	Query query = manager
			        .createQuery("SELECT ban "//16
			        		+ "FROM Banner ban INNER JOIN ban.produto pro "//33
			        		+ "WHERE ban.produto = pro.id_produto");

			@SuppressWarnings("unchecked")
			List<Banner> banners = query.getResultList();

			return banners;
		}
		
		public List<Banner> Read_publico() {
			
		    	Query query = manager
				        .createQuery("SELECT ban "//16
				        		+ "FROM Banner ban INNER JOIN ban.produto pro "//33
				        		+ "WHERE ban.produto = pro.id_produto "
								+ "ORDER BY ban.id_banner ASC");

				@SuppressWarnings("unchecked")
				List<Banner> banners = query.getResultList();

			return banners;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Banner banner) {
			manager.merge(banner);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Banner banner) {
		   // Procura o ID
			Banner banners = manager.find(Banner.class, banner.getId_banner());
			// Deleta
			manager.remove(banners);
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Find				
	    * ----------------------------------
	    * 
	    */
	   
		@Override
		public List<Banner> Find(Banner banner) {
			// Pega o dado digitado pelo usuário
			String nome = banner.getNome_banner();
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT t FROM Banner as t "
			        		+ "WHERE t.nome_banner = :Nome "
			                + "ORDER BY id_banner ASC");
			
			query.setParameter("Nome", (String) nome);
	
				@SuppressWarnings("unchecked")
				List<Banner> banners = query.getResultList();
	
			return banners;
			
		}
	   
}
