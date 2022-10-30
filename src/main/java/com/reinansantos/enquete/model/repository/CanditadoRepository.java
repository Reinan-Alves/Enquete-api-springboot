package com.reinansantos.enquete.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reinansantos.enquete.model.entity.Candidato;

public interface CanditadoRepository extends JpaRepository<Candidato, Long> {

}
