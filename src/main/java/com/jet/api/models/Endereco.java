package com.jet.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jet.api.enums.TipoEndereco;
import com.jet.api.enums.TipoLogradouro;

import lombok.Data;

@Data
@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 7449936580410661035L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_endereco")
	private Long idEndereco;
	private String Logradouro;
	private String Nome;
	private int Numero;
	private String Complemento;
	private TipoEndereco tipoEndereco;
	private TipoLogradouro tipo;
	private String CEP;
	private String Bairro;
	private String Cidade;
	private String Estado;
	private String Pais;

}
