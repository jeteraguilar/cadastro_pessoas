package com.jet.api.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import lombok.Getter;

@Getter
public enum TipoDependente {

	ESPOSA("Esposa"), FILHO("Filho"), PAI("Pai"), MÃE("Mãe");

	private String descricao;

	TipoDependente(String descricao) {
		this.descricao = descricao;
	}

	public static List<TipoDependente> getAll() {
		return new ArrayList<>(EnumSet.allOf(TipoDependente.class));
	}
}
