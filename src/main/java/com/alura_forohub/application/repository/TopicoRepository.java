package com.alura_forohub.application.repository;

import com.alura_forohub.application.model.topico.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Tema, Long> {

}
