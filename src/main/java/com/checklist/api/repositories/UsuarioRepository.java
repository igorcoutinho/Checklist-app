package com.checklist.api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.checklist.api.entities.Usuario;


public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

	@Transactional(readOnly = true)
	Usuario findByCpf(String cpf);
}
