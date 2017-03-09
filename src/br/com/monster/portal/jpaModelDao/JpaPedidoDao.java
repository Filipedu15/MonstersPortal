package br.com.monster.portal.jpaModelDao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.model.Pedido;
import br.com.monster.portal.modelDao.PedidoDao;

@Repository
public class JpaPedidoDao implements PedidoDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */

		public void create(Pedido pedido) {
			//manager.merge(produto);
			manager.flush();
			manager.persist(pedido);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Pedido> Read() {
			
		    	/*Query query = manager
				        .createQuery("SELECT ped "
			        			+ "FROM Pedido ped, Produto prod, pedido_has_produto pedprod "
			        			+ "WHERE pedprod.pedido_id_pedido = ped.id_pedido "
			        			+ "AND pedprod.produto = prod.produto");*/
			Query query = manager
			        .createQuery("SELECT ped "
			        			+ "FROM Pedido ped INNER JOIN ped.cliente cli "
			        			+ "WHERE ped.cliente = cli.id_cliente "
			        			+ "ORDER BY ped.data_pedido DESC");
				@SuppressWarnings("unchecked")
				List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Pedido pedido) {
			manager.merge(pedido);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Pedido pedido) {
		   // Procura o ID
			Pedido pedidos = manager.find(Pedido.class, pedido.getId_pedido());
			// Deleta
			manager.remove(pedidos);
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Find				
	    * ----------------------------------
	    * 
	    */
	   
		public List<Pedido> Find(Date data_pedido, Pedido pedido) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT ped FROM Pedido ped "
			        		+ "WHERE ped.data_pedido = :Date "
			                + "ORDER BY ped.data_pedido ASC");
			
			query.setParameter("Date", (Date) data_pedido);
	
				@SuppressWarnings("unchecked")
				List<Pedido> pedidos = query.getResultList();
	
			return pedidos;
			
		}

		@Override
		public Object Find_pedido_boleto(String numb_ped, Pedido pedido) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT ped "
			        			+ "FROM Pedido ped INNER JOIN ped.cliente cli "
			        			+ "WHERE ped.cliente = cli.id_cliente "
			        			+ "AND ped.numero_pedido = :Numero "
			        			+ "ORDER BY ped.data_pedido DESC");
			query.setParameter("Numero", numb_ped);
			
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

		return pedidos;
		}

		@Override
		public List<Pedido> Find_ped_cli(Cliente clienteInfo, Pedido pedido) {


			System.out.print("------------------------------------------------------- " + clienteInfo + " ---------------------------------------------------------------------------");
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT t FROM Pedido as t "
			        		+ "WHERE t.cliente = :Id "
			                + "ORDER BY t.id_pedido ASC");
			query.setParameter("Id", clienteInfo);
			
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}

		@Override
		public List<Pedido> Pedidos_por_semana() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(ped.id_pedido) as count, ped.data_pedido "
						+ "FROM Pedido as ped "
						+ "WHERE ped.data_pedido BETWEEN CURRENT_DATE -7 AND CURRENT_DATE "
						+ "GROUP BY ped.data_pedido "
						+ "ORDER BY ped.data_pedido");
						
			@SuppressWarnings("unchecked")
			List<Pedido> pedidos = query.getResultList();

			return pedidos;
		}

}
