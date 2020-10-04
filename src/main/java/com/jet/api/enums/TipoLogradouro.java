package com.jet.api.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import lombok.Getter;

@Getter
public enum TipoLogradouro {

	RUA("Rua"), AVENIDA("Avenida"), ESTRADA("Estrada");

	private String descricao;

	TipoLogradouro(String descricao) {
		this.descricao = descricao;
	}

	public static List<TipoLogradouro> getAll() {
		return new ArrayList<>(EnumSet.allOf(TipoLogradouro.class));
	}
}
