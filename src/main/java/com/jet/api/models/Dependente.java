package com.jet.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jet.api.enums.TipoDependente;

import lombok.Data;

@Data
@Entity
@Table(name = "DEPENDENTE")
public class Dependente implements Serializable {

	private static final long serialVersionUID = 7449936580410661035L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_dependente")
	private Long idDependente;
	private String NomeCompleto;
	private TipoDependente TipoDependente;

}
