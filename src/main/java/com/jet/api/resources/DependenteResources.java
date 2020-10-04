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

import com.jet.api.models.Dependente;
import com.jet.api.repositories.DependenteRepository;

@RestController
@RequestMapping(path = "/dependentes")
public class DependenteResources {

	private DependenteRepository dependenteRepository;

	public DependenteResources(DependenteRepository dependenteRepository) {
		super();
		this.dependenteRepository = dependenteRepository;
	}

	@PostMapping
	public ResponseEntity<Dependente> save(@RequestBody Dependente dependente) {
		dependenteRepository.save(dependente);
		return new ResponseEntity<>(dependente, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Dependente>> getAll() {
		List<Dependente> dependentes = new ArrayList<>();
		dependentes = dependenteRepository.findAll();
		return new ResponseEntity<>(dependentes, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Dependente>> getById(@PathVariable Long id) {
		Optional<Dependente> dependente;
		try {
			dependente = dependenteRepository.findById(id);
			return new ResponseEntity<Optional<Dependente>>(dependente, HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Dependente>>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Optional<Dependente>> deleteById(@PathVariable Long id) {
		try {
			dependenteRepository.deleteById(id);
			return new ResponseEntity<Optional<Dependente>>(HttpStatus.OK);
		} catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Dependente>>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Dependente> update(@PathVariable Long id, @RequestBody Dependente newDependente) {
		return dependenteRepository.findById(id).map(dependente -> {
			dependente.setNomeCompleto(newDependente.getNomeCompleto());
			dependente.setTipoDependente(newDependente.getTipoDependente());//
			Dependente dependenteUpdate = dependenteRepository.save(dependente);
			return ResponseEntity.ok().body(dependenteUpdate);
		}).orElse(ResponseEntity.notFound().build());

	}

}
