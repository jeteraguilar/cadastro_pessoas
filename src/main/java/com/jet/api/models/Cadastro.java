package com.jet.api.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Cadastro")
public class Cadastro implements Serializable {

	private static final long serialVersionUID = 7449936580410661035L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_cadastro")
	private Long idCadastro;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_telefone")
	private Telefone telefone;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_dependente")
	private Dependente dependente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

}
