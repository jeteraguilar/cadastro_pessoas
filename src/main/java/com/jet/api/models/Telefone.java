package com.jet.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jet.api.enums.TipoContato;

import lombok.Data;

@Data
@Entity
@Table(name = "telefone")
public class Telefone implements Serializable {

	private static final long serialVersionUID = 7449936580410661035L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private Long idTelefone;
	private int CodigoPais;
	private String DDD;
	private String numero;
	private TipoContato TipoContato;

}
