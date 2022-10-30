package com.reinansantos.enquete.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinansantos.enquete.model.entity.Candidato;
import com.reinansantos.enquete.service.CandidatoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/candidatos")
@RequiredArgsConstructor
public class CandidatoController {


	private final CandidatoService candidatoService;

	@PostMapping
	@CrossOrigin

	public String create(@RequestBody Candidato candidato) {

		return candidatoService.create(candidato);
	}

	@GetMapping
	@CrossOrigin

	public List<Candidato> readAll() {

		return candidatoService.readAll();
	}

	@GetMapping(path = { "/{id}" })
	@CrossOrigin
	public ResponseEntity<Candidato> readById(@PathVariable Long id) {

		return candidatoService.readBydId(id);
	}

	@PutMapping(value = "/{id}")
	@CrossOrigin
	public ResponseEntity<Candidato> update(@PathVariable("id") Long id, @RequestBody Candidato candidato) {

		return candidatoService.update(id, candidato);
	}

	@DeleteMapping(path = { "/{id}" })
	@CrossOrigin
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		return candidatoService.delete(id);

	}

}