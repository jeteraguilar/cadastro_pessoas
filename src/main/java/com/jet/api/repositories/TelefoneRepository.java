package com.jet.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jet.api.models.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
