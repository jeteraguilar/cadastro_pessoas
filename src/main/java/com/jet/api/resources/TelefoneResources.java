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

import com.jet.api.models.Telefone;
import com.jet.api.repositories.TelefoneRepository;

@RestController
@RequestMapping(path = "/telefones")
public class TelefoneResources {

	private TelefoneRepository telefoneRepository;

	public TelefoneResources(TelefoneRepository telefoneRepository) {
		super();
		this.telefoneRepository = telefoneRepository;
	}

	@PostMapping
	public ResponseEntity<Telefone> save(@RequestBody Telefone telefone) {
		telefoneRepository.save(telefone);
		return new ResponseEntity<>(telefone, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Telefone>> getAll() {
		List<Telefone> telefones = new ArrayList<>();
		telefones = telefoneRepository.findAll();
		return new ResponseEntity<>(telefones, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Telefone>> getById(@PathVariable Long id) {
		Optional<Telefone> telefone;
		try {
			telefone = telefoneRepository.findById(id);
			return new ResponseEntity<Optional<Telefone>>(telefone, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Telefone>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Telefone>> deleteById(@PathVariable Long id) {
		try {
			telefoneRepository.deleteById(id);
			return new ResponseEntity<Optional<Telefone>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Telefone>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Telefone> update(@PathVariable Long id, @RequestBody Telefone newTelefone) {
		return telefoneRepository.findById(id).map(telefone -> {
			telefone.setCodigoPais(newTelefone.getCodigoPais());
			telefone.setDDD(newTelefone.getDDD());
			telefone.setNumero(newTelefone.getNumero());
			telefone.setTipo(newTelefone.getTipo());

			Telefone telefoneUpdate = telefoneRepository.save(telefone);
			return ResponseEntity.ok().body(telefoneUpdate);
		}).orElse(ResponseEntity.notFound().build());

	}

}
