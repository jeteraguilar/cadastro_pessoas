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

import com.jet.api.models.Endereco;
import com.jet.api.repositories.EnderecoRepository;

@RestController
@RequestMapping(path = "/enderecos")
public class EnderecoResources {

	private EnderecoRepository enderecoRepository;

	public EnderecoResources(EnderecoRepository enderecoRepository) {
		super();
		this.enderecoRepository = enderecoRepository;
	}

	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return new ResponseEntity<>(endereco, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Endereco>> getAll() {
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = enderecoRepository.findAll();
		return new ResponseEntity<>(enderecos, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Endereco>> getById(@PathVariable Long id) {
		Optional<Endereco> endereco;
		try {
			endereco = enderecoRepository.findById(id);
			return new ResponseEntity<Optional<Endereco>>(endereco, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Endereco>> deleteById(@PathVariable Long id) {
		try {
			enderecoRepository.deleteById(id);
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Endereco>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco newEndereco) {
		return enderecoRepository.findById(id).map(endereco -> {
			endereco.setLogradouro(newEndereco.getLogradouro());
			endereco.setNome(newEndereco.getNome());
			endereco.setNumero(newEndereco.getNumero());
			endereco.setComplemento(newEndereco.getComplemento());
			endereco.setCEP(newEndereco.getCEP());
			endereco.setBairro(newEndereco.getBairro());
			endereco.setCidade(newEndereco.getCidade());
			endereco.setEstado(newEndereco.getEstado());
			endereco.setPais(newEndereco.getPais());
			endereco.setTipo(newEndereco.getTipo());
			endereco.setTipoEndereco(newEndereco.getTipoEndereco());

			Endereco enderecoUpdate = enderecoRepository.save(endereco);
			return ResponseEntity.ok().body(enderecoUpdate);
		}).orElse(ResponseEntity.notFound().build());

	}

}