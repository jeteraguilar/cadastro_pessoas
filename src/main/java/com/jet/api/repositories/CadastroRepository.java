package com.jet.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jet.api.models.Cadastro;

@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
