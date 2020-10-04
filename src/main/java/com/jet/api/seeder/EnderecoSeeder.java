package com.jet.api.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jet.api.enums.TipoEndereco;
import com.jet.api.enums.TipoLogradouro;
import com.jet.api.models.Endereco;
import com.jet.api.repositories.EnderecoRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EnderecoSeeder {

	@Autowired
	EnderecoRepository service;

	@EventListener
	public void seedEndereco(ContextRefreshedEvent event) {
		try {
			log.info("Criando enderecos....");
			criandoEnderecos();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void criandoEnderecos() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua");
		endereco.setNome("Antoni de França");
		endereco.setNumero(6);
		endereco.setComplemento("3° andar");
		endereco.setCEP("08945-415");
		endereco.setBairro("Centro");
		endereco.setCidade("São Paulo");
		endereco.setEstado("S.P");
		endereco.setPais("Brasil");
		endereco.setTipo(TipoLogradouro.RUA);
		endereco.setTipoEndereco(TipoEndereco.COMERCIAL);

		service.save(endereco);

	}
}
