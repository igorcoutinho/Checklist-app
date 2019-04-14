package com.checklist.api.services;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.checklist.api.entities.Atividade;

public interface AtividadeService {
	
	/**
	 * Retorna uma lista paginada de atividades de uma determinada tarefa.
	 * 
	 * @param tarefaId
	 * @param pageRequest
	 * @return Page<Lancamento>
	 */
	Page<Atividade> buscarPorAtividadeId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * Retorna uma atividade por ID.
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Atividade> buscarPorId(Long id);
	
	/**
	 * Persiste uma atividade na base de dados.
	 * 
	 * @param atividade
	 * @return Atividade
	 */
	Atividade persistir(Atividade atividade);
	
	/**
	 * Remove uma atividade da base de dados.
	 * 
	 * @param id
	 */
	void remover(Long id);

}
