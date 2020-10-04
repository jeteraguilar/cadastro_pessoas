package com.jet.api.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jet.api.enums.TipoDependente;
import com.jet.api.models.Dependente;
import com.jet.api.repositories.DependenteRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DependenteSeeder {

	@Autowired
	DependenteRepository service;

	@EventListener
	public void seedDependente(ContextRefreshedEvent event) {
		try {
			log.info("Criando dependentes....");
			criandoDependentes();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void criandoDependentes() {
		Dependente dependente = new Dependente();
		dependente.setNomeCompleto("Hugo Faria");
		dependente.setTipoDependente(TipoDependente.FILHO);

		service.save(dependente);

	}
}
