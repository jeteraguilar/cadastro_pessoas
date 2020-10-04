package com.jet.api.seeder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.jet.api.models.Pessoa;
import com.jet.api.repositories.PessoaRepository;

@Component
@Slf4j
public class PessoaSeeder {

	@Autowired
	PessoaRepository service;

	@EventListener
	public void seedPessoa(ContextRefreshedEvent event) {
		try {
			log.info("Criando pessoas....");
			criandoPessoas();
		} catch (Exception e) {
			log.error(e.getMessage());
		}

	}

	private void criandoPessoas() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("André Luiz Fonseca");
		pessoa.setApelido_NomeFantasia("Fonseca");
		pessoa.setCPF_CNPJ("83.230.227/0001-50");
		pessoa.setProfissao("Técnico");
		pessoa.setSalario(3000);
		pessoa.setDataNascimento("15/08/1985");

		service.save(pessoa);

	}
}
