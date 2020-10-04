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

import com.jet.api.models.Pessoa;
import com.jet.api.repositories.PessoaRepository;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaResources {

	private PessoaRepository pessoaRepository;

	public PessoaResources(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}

	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody Pessoa pessoa) {
		pessoaRepository.save(pessoa);
		return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> getAll() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas = pessoaRepository.findAll();
		return new ResponseEntity<>(pessoas, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Pessoa>> getById(@PathVariable Long id) {
		Optional<Pessoa> pessoa;
		try {
			pessoa = pessoaRepository.findById(id);
			return new ResponseEntity<Optional<Pessoa>>(pessoa, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Pessoa>> deleteById(@PathVariable Long id) {
		try {
			pessoaRepository.deleteById(id);
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Pessoa>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa newPessoa) {
		return pessoaRepository.findById(id).map(pessoa -> {
			pessoa.setNome(newPessoa.getNome());
			pessoa.setApelido_NomeFantasia(newPessoa.getApelido_NomeFantasia());
			pessoa.setCPF_CNPJ(newPessoa.getCPF_CNPJ());
			pessoa.setProfissao(newPessoa.getProfissao());
			pessoa.setSalario(newPessoa.getSalario());
			pessoa.setDataNascimento(newPessoa.getDataNascimento());

			Pessoa pessoaUpdate = pessoaRepository.save(pessoa);
			return ResponseEntity.ok().body(pessoaUpdate);
		}).orElse(ResponseEntity.notFound().build());

	}

}
