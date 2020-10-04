package com.jet.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jet.api.models.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
