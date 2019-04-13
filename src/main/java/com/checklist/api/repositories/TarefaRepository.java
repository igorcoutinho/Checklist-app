package com.checklist.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.checklist.api.entities.Tarefa;


@Transactional(readOnly = true)
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	Tarefa findByNome(String nome);
}
