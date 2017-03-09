package br.com.monster.portal.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "acesso")
public class Acessos {
	
	@Id
	@GeneratedValue
	private Long id_acesso;
	
	@NotNull
	@Column(name = "ace_hora")
	private Time hora_acessos;
	
	@NotNull
	@Column(name = "ace_data")
	private Date data_acessos;
	
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	
	@ManyToOne
	@JoinColumn(name = "cliente_id_cliente", insertable=true, updatable=true)
	private Cliente cliente;
	
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/
	
	public Long getId_acessos() {
		return id_acesso;
	}

	public void setId_acessos(Long id_acessos) {
		this.id_acesso = id_acessos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Time getHora_acessos() {
		return hora_acessos;
	}

	public void setHora_acessos(Time hora_acessos) {
		this.hora_acessos = hora_acessos;
	}

	public Date getData_acessos() {
		return data_acessos;
	}

	public void setData_acessos(Date data_acessos) {
		this.data_acessos = data_acessos;
	}
	
	
}
