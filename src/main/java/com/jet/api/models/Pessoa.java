package com.jet.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 7449936580410661035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;

	private String Nome;

	private String Apelido_NomeFantasia;

	private String CPF_CNPJ;

	private String Profissao;

	private double Salario;

	private String DataNascimento;

}
