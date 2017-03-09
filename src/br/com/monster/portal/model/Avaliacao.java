package br.com.monster.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue
	private Long id_avaliacao;
	
	@NotNull(message="{avaliacao.comentario.NotEmpty}")
	@Size(min=5, max=600, message = "{avaliacao.comentario.Size}")
	@Column(name = "ava_comentario")	
	private String comentario_avaliacao;
	
	@NotNull
	@Column(name = "ava_nota")
	private String nota_avaliacao;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	@ManyToOne
	@JoinColumn(name = "produto_id_produto", insertable=true, updatable=true)
	private Produto produto;
	

	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	public Long getId_avaliacao() {
		return id_avaliacao;
	}

	public void setId_avaliacao(Long id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getComentario_avaliacao() {
		return comentario_avaliacao;
	}

	public void setComentario_avaliacao(String comentario_avaliacao) {
		this.comentario_avaliacao = comentario_avaliacao;
	}

	public String getNota_avaliacao() {
		return nota_avaliacao;
	}

	public void setNota_avaliacao(String nota_avaliacao) {
		this.nota_avaliacao = nota_avaliacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
