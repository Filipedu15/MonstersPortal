package br.com.monster.portal.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	private long id_pedido;
	
	@NotNull(message="{pedido.numero.NotEmpty}")
	@Size(min=1, max=100, message = "{pedido.numero.Size}")
	@Column(name = "ped_numero")
	private String numero_pedido;
	
	@NotNull(message="{pedido.preco.NotEmpty}")
	@Column(name = "ped_preco")
	private float preco_pedido;
	
	@NotNull(message="{pedido.qtd.NotEmpty}")
	@Size(min=1, max=100, message = "{pedido.qtd.Size}")
	@Column(name = "ped_qtd")
	private String qtd_pedido;
	
	@NotNull(message="{pedido.forma_de_pagamento.NotEmpty}")
	@Size(min=1, max=100, message = "{pedido.forma_de_pagamento.Size}")
	@Column(name = "ped_forma_de_pagamento")
	private String forma_de_pagamento_pedido;
	
	@Column(name = "ped_custo_forma_de_pagamento")
	private float custo_forma_de_pagamento_pedido;
	
	@NotNull(message="{pedido.frete_custo.NotEmpty}")
	@Column(name = "ped_custo_frete")
	private float custo_frete_pedido;
	
	@NotNull(message="{pedido.parcelas.NotEmpty}")
	@Column(name = "ped_parcelas")
	private long parcelas_pedido;
	
	@NotNull(message="{pedido.status.NotEmpty}")
	@Column(name = "ped_status")
	private long status_pedido;
	
	@NotNull(message="{pedido.peso.NotEmpty}")
	@Size(min=1, max=20, message = "{pedido.peso.Size}")
	@Column(name = "ped_peso")
	private String peso_pedido;
	
	@NotNull(message="{pedido.altura.NotEmpty}")
	@Size(min=1, max=10, message = "{pedido.altura.Size}")
	@Column(name = "ped_altura")
	private String altura_pedido;
	
	@NotNull(message="{pedido.largura.NotEmpty}")
	@Size(min=1, max=10, message = "{pedido.largura.Size}")
	@Column(name = "ped_largura")
	private String largura_pedido;
	
	@NotNull(message="{pedido.commprimento.NotEmpty}")
	@Size(min=1, max=10, message = "{pedido.comprimento.Size}")
	@Column(name = "ped_comprimento")
	private String comprimento_pedido;
	
	@NotNull(message="{pedido.data.NotEmpty}")
	@Temporal(TemporalType.DATE)
	@Column(name = "ped_data")
	private Date data_pedido;
	
	@NotNull(message="{pedido.hora.NotEmpty}")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ped_hora")
	private Date hora_pedido;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "ped_entrega_data")
	private Calendar entrega_data_pedido;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ped_entrega_hora")
	private Calendar entrega_hora_pedido;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	

	// RECEBE
	//@-ManyToMany(cascade = CascadeType.ALL)
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "pedido_has_produto", catalog = "public",
				joinColumns = { @JoinColumn(name = "pedido_id_pedido") },
				inverseJoinColumns = { @JoinColumn(name = "produto_id_produto") })
	private Set<Produto> produto;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(String numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public float getPreco_pedido() {
		return preco_pedido;
	}

	public void setPreco_pedido(float preco_pedido) {
		this.preco_pedido = preco_pedido;
	}

	public String getQtd_pedido() {
		return qtd_pedido;
	}

	public void setQtd_pedido(String qtd_pedido) {
		this.qtd_pedido = qtd_pedido;
	}

	public String getForma_de_pagamento_pedido() {
		return forma_de_pagamento_pedido;
	}

	public void setForma_de_pagamento_pedido(String forma_de_pagamento_pedido) {
		this.forma_de_pagamento_pedido = forma_de_pagamento_pedido;
	}

	public float getCusto_forma_de_pagamento_pedido() {
		return custo_forma_de_pagamento_pedido;
	}

	public void setCusto_forma_de_pagamento_pedido(float custo_forma_de_pagamento_pedido) {
		this.custo_forma_de_pagamento_pedido = custo_forma_de_pagamento_pedido;
	}

	public float getCusto_frete_pedido() {
		return custo_frete_pedido;
	}

	public void setCusto_frete_pedido(float custo_frete_pedido) {
		this.custo_frete_pedido = custo_frete_pedido;
	}

	public long getParcelas_pedido() {
		return parcelas_pedido;
	}

	public void setParcelas_pedido(long parcelas_pedido) {
		this.parcelas_pedido = parcelas_pedido;
	}

	public long getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(long status_pedido) {
		this.status_pedido = status_pedido;
	}

	public String getPeso_pedido() {
		return peso_pedido;
	}

	public void setPeso_pedido(String peso_pedido) {
		this.peso_pedido = peso_pedido;
	}

	public String getAltura_pedido() {
		return altura_pedido;
	}

	public void setAltura_pedido(String altura_pedido) {
		this.altura_pedido = altura_pedido;
	}

	public String getLargura_pedido() {
		return largura_pedido;
	}

	public void setLargura_pedido(String largura_pedido) {
		this.largura_pedido = largura_pedido;
	}

	public String getComprimento_pedido() {
		return comprimento_pedido;
	}

	public void setComprimento_pedido(String comprimento_pedido) {
		this.comprimento_pedido = comprimento_pedido;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date date) {
		this.data_pedido = date;
	}

	public Calendar getEntrega_data_pedido() {
		return entrega_data_pedido;
	}

	public void setEntrega_data_pedido(Calendar entrega_data_pedido) {
		this.entrega_data_pedido = entrega_data_pedido;
	}

	public Date getHora_pedido() {
		return hora_pedido;
	}

	public void setHora_pedido(Date date) {
		this.hora_pedido = date;
	}

	public Calendar getEntrega_hora_pedido() {
		return entrega_hora_pedido;
	}

	public void setEntrega_hora_pedido(Calendar entrega_hora_pedido) {
		this.entrega_hora_pedido = entrega_hora_pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Produto> getProduto() {
		return produto;
	}

	public void setProduto(Set<Produto> produto) {
		this.produto = produto;
	}
	
}
