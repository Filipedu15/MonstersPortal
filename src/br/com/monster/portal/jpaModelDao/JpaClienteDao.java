package br.com.monster.portal.jpaModelDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.monster.portal.model.Cliente;
import br.com.monster.portal.modelDao.ClienteDao;

@Repository
public class JpaClienteDao implements ClienteDao {

	
	@PersistenceContext
	EntityManager manager;
	
	   /*
	    * ----------------------------------
	    *			Método Create			
	    * ----------------------------------
	    * 
	    */
		public void create(Cliente cliente) {
			 manager.persist(cliente);
	    }
	   
	   /*
	    * ----------------------------------
	    *			Método Read				
	    * ----------------------------------
	    * 
	    */
		public List<Cliente> Read() {

			Query query = manager
			        .createQuery("SELECT cli "//16
			        		+ "FROM Cliente cli "
			        		+ "ORDER BY cli.id_cliente DESC");
			
				@SuppressWarnings("unchecked")
				List<Cliente> clientes = query.getResultList();

			return clientes;
		}

	   /*
	    * ----------------------------------
	    *			Método Update			
	    * ----------------------------------
	    * 
	    */
		public void update(Cliente cliente) {
			manager.merge(cliente);
		}
	   
	   /*
	    * ----------------------------------
	    *			Método Delete			
	    * ----------------------------------
	    * 
	    */

	   public void delete(Cliente cliente) {
		   // Procura o ID
			Cliente clientes = manager.find(Cliente.class, cliente.getId_cliente());
			// Deleta
			manager.remove(clientes);
	   }
	   
	   /*
	    * ----------------------------------
	    *			Método Find				
	    * ----------------------------------
	    * 
	    */
	   
		@Override
		public List<Cliente> Find(String nome_cliente, Cliente cliente) {
			
			// Escreve a SQL
			Query query = manager
			        .createQuery("SELECT cli FROM Cliente cli "
			        		+ "WHERE cli.nome_cliente LIKE :Nome "
			                + "ORDER BY nome_cliente DESC");
			
			query.setParameter("Nome", (String) "%"+nome_cliente+"%");
	
				@SuppressWarnings("unchecked")
				List<Cliente> clientes = query.getResultList();
	
			return clientes;
			
		}

		
		@Override
		public boolean UsuarioExiste(Cliente cliente) {
			// Pega o dado digitado pelo usuário
			String usuario = cliente.getUsuario_cliente();
			String senha = cliente.getSenha_cliente();
						
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
							+ "WHERE cli.usuario_cliente = :usuario "
							+ "AND cli.senha_cliente = :senha");
		
							query.setParameter("usuario", (String) usuario);
							query.setParameter("senha", (String) senha);

			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();
							
			if (!clientes.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public List<Cliente> SeUsuarioExiste(Cliente cliente) {
			// Pega o dado digitado pelo usuário
			String usuario = cliente.getUsuario_cliente();
			String senha = cliente.getSenha_cliente();
									
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT cli FROM Cliente as cli "
							+ "WHERE cli.usuario_cliente = :usuario "
							+ "AND cli.senha_cliente = :senha");
					
				query.setParameter("usuario", (String) usuario);
				query.setParameter("senha", (String) senha);

			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();
	
			return clientes;
			
		}

		/*
		 * ---------------------
		 * 		Dashboard		
		 * ---------------------
		 */

		@Override
		public List<Cliente> Qtd_clientes() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli ");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}

		@Override
		public List<Cliente> Qtd_Clientes_Homens() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli "
						+ "WHERE cli.sexo_cliente = :param");

			query.setParameter("param", (String) "true");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}

		@Override
		public List<Cliente> Qtd_Clientes_Mulheres() {
			// Escreve a SQL
			Query query = manager
				.createQuery("SELECT COUNT(cli.id_cliente) as count "
						+ "FROM Cliente as cli "
						+ "WHERE cli.sexo_cliente = :param");

			query.setParameter("param", (String) "false");
						
			@SuppressWarnings("unchecked")
			List<Cliente> clientes = query.getResultList();

			return clientes;
		}
	   
}