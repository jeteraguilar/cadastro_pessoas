package com.jet.api.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import lombok.Getter;

@Getter
public enum TipoEndereco {

	COMERCIAL("Comercial"), RESIDENCIAL("Residencial"), CONTATO("Contato");

	private String descricao;

	TipoEndereco(String descricao) {
		this.descricao = descricao;
	}

	public static List<TipoEndereco> getAll() {
		return new ArrayList<>(EnumSet.allOf(TipoEndereco.class));
	}
}
