package com.jet.api.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jet.api.models.Cadastro;
import com.jet.api.repositories.CadastroRepository;

@RestController
@RequestMapping(path = "/cadastro")
public class CadastroResources {

	private CadastroRepository cadastroRepository;

	public CadastroResources(CadastroRepository cadastroRepository) {
		super();
		this.cadastroRepository = cadastroRepository;
	}

	@PostMapping
	public ResponseEntity<Cadastro> save(@RequestBody Cadastro cadastro) {
		cadastroRepository.save(cadastro);
		return new ResponseEntity<>(cadastro, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Cadastro>> getAll() {
		List<Cadastro> cadastros = new ArrayList<>();
		cadastros = cadastroRepository.findAll();
		return new ResponseEntity<>(cadastros, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Cadastro>> getById(@PathVariable Long id) {
		Optional<Cadastro> cadastro;
		try {
			cadastro = cadastroRepository.findById(id);
			return new ResponseEntity<Optional<Cadastro>>(cadastro, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Cadastro>> deleteById(@PathVariable Long id) {
		try {
			cadastroRepository.deleteById(id);
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Cadastro>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro newCadastro) {
		return cadastroRepository.findById(id).map(cadastro -> {
			cadastro.setEndereco(newCadastro.getEndereco());
			cadastro.setDependente(newCadastro.getDependente());
			cadastro.setTelefone(newCadastro.getTelefone());
			cadastro.setPessoa(newCadastro.getPessoa());

			Cadastro cadastroUpdate = cadastroRepository.save(cadastro);
			return ResponseEntity.ok().body(cadastroUpdate);
		}).orElse(ResponseEntity.notFound().build());

	}

}
