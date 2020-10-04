package com.jet.api.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jet.api.enums.TipoContato;
import com.jet.api.models.Telefone;
import com.jet.api.repositories.TelefoneRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TelefoneSeeder {

	@Autowired
	TelefoneRepository service;

	@EventListener
	public void seedPessoa(ContextRefreshedEvent event) {
		try {
			log.info("Criando pessoas....");
			criandoTelefones();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void criandoTelefones() {
		Telefone telefone = new Telefone();
		telefone.setCodigoPais(55);
		telefone.setDDD("11");
		telefone.setNumero("98745-0000");
		telefone.setTipo(TipoContato.COMERCIAL);

		service.save(telefone);

	}
}
