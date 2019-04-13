package com.checklist.api.services;
import com.checklist.api.entities.Usuario;


import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

	/**
	 * Retorna uma usuario dado um CPF.
	 * 
	 * @param cpf
	 * @return Optional<Usuario>
	 */
	Optional<Usuario> buscarPorCpf(String cpf);
	
	/**
	 * Cadastra um novo usuario na base de dados.
	 * 
	 * @param usuario
	 * @return Usuario
	 */
	Usuario persistir(Usuario usuario);
}
