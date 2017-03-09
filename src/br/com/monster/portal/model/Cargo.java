package br.com.monster.portal.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cargo")
public class Cargo {

	@Id
	@GeneratedValue
	private Long id_cargo;
	
	@NotNull
	@NotEmpty(message="{cargo.nome.NotEmpty}")
	@Size(min=5, max=100, message = "O campo nome deve ter no mínimo 5 caracteres")
	@Column(name = "car_nome")		
	private String nome_cargo;
	
	@NotNull
	@Column (name = "car_padrao") 
	private boolean padrao_cargo;
	
	@NotNull
	@Column (name = " car_permissao")
	private String permissao_cargo;
	/*
	 |--------------------------------------
	 |			Relacionamentos				
	 |--------------------------------------
	 */
	// ENVIA							, CascadeType.REMOVE 
	@OneToMany(cascade = {CascadeType.REMOVE}, mappedBy="cargo", fetch=FetchType.EAGER)
	private Set<Funcionario> funcionario;
	/*
	|---------------------------------------
	|		Getters And Setters(GGAS)				
	|---------------------------------------
	*/

	public Long getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Long id_cargo) {
		this.id_cargo = id_cargo;
	}

	public String getNome_cargo() {
		return nome_cargo;
	}

	public void setNome_cargo(String nome_cargo) {
		this.nome_cargo = nome_cargo;
	}

	public boolean isPadrao_cargo() {
		return padrao_cargo;
	}

	public void setPadrao_cargo(boolean padrao_cargo) {
		this.padrao_cargo = padrao_cargo;
	}

	public String getPermissao_cargo() {
		return permissao_cargo;
	}

	public void setPermissao_cargo(String permissao_cargo) {
		this.permissao_cargo = permissao_cargo;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Set<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
}
