package com.checklist.api.services;

import java.util.Optional;

import com.checklist.api.entities.Tarefa;

public interface TarefaService {

	/**
	 * Persiste uma tareafa na base de dados.
	 * 
	 * @param tarefa
	 * @return Tarefa
	 */
	Tarefa persistir(Tarefa funcionario);
	
	/**
	 * Busca e retorna um funcionário dado um nome.
	 * 
	 * @param nome
	 * @return Optional<Tarefa>
	 */
	Optional<Tarefa> buscarPorNome(String nome);
	
	/**
	 * Busca e retorna um funcionário por ID.
	 * 
	 * @param id
	 * @return Optional<Tarefa>
	 */
	Optional<Tarefa> buscarPorId(Long id);
	
}
