package com.reinansantos.enquete.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.reinansantos.enquete.model.entity.Candidato;
import com.reinansantos.enquete.model.repository.CanditadoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CandidatoService {

	private final CanditadoRepository candidatoRepository;

	// crud Service

	public String create(Candidato candidato) {
		candidatoRepository.save(candidato);
		return "Criado com Id " + candidato.getId();
	}

	public List<Candidato> readAll() {

		return candidatoRepository.findAll();

	}

	public ResponseEntity<Candidato> readBydId(Long id) {

		return candidatoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());

	}

	public ResponseEntity<Candidato> update(Long id, Candidato candidato) {

		return candidatoRepository.findById(id).map(record -> {
			record.setNome(candidato.getNome());
			record.setVotos(candidato.getVotos());
			Candidato updated = candidatoRepository.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<?> delete(Long id) {

		return candidatoRepository.findById(id).map(record -> {
			candidatoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
