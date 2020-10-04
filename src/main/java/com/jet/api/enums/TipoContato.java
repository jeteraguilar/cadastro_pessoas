package com.jet.api.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import lombok.Getter;

@Getter
public enum TipoContato {

	CONTATO("Contato"), RESIDENCIAL("Residencial"), COMERCIAL("Comercial");

	private String descricao;

	TipoContato(String descricao) {
		this.descricao = descricao;
	}

	public static List<TipoContato> getAll() {
		return new ArrayList<>(EnumSet.allOf(TipoContato.class));
	}

}
