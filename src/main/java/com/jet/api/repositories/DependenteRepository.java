package com.jet.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jet.api.models.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {

}
