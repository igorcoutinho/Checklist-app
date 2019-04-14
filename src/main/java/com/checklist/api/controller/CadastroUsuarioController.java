package com.checklist.api.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checklist.api.dtos.CadastroUsuarioDto;
import com.checklist.api.entities.Usuario;
import com.checklist.api.response.Response;
import com.checklist.api.services.UsuarioService;

@RestController
@RequestMapping("/api/cadastrar-usuario")
@CrossOrigin(origins = "*")
public class CadastroUsuarioController {
	
	private static final Logger log = LoggerFactory.getLogger(CadastroUsuarioController.class);
	
	@Autowired
	private UsuarioService usuarioService;
	
	public CadastroUsuarioController() {
		
	}
	
	/**
	 * Cadastra um usuario no sistema.
	 * 
	 * @param cadastroUsuarioto
	 * @param result
	 * @return ResponseEntity<Response<CadastroUsuarioto>>
	 * @throws NoSuchAlgorithmException
	 */
	
	@PostMapping
	public ResponseEntity<Response<CadastroUsuarioDto>> cadastrar(@Valid @RequestBody CadastroUsuarioDto cadastroUsuarioto,
			BindingResult result) throws NoSuchAlgorithmException {
		log.info("Cadastrando Usuario: {}", cadastroUsuarioto.toString());
		Response<CadastroUsuarioDto> response = new Response<CadastroUsuarioDto>();

		validarDadosExistentes(cadastroUsuarioto, result);
		Usuario usuario = this.converterDtoParaUsuario(cadastroUsuarioto);
		

		if (result.hasErrors()) {
			log.error("Erro validando dados de cadastro PJ: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		this.usuarioService.persistir(usuario);
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Verifica se o usuario já existe na base de dados.
	 * 
	 * @param cadastroUsuarioDto
	 * @param result
	 */
	private void validarDadosExistentes(CadastroUsuarioDto cadastroUsuarioDto, BindingResult result) {
		this.usuarioService.buscarPorCpf(cadastroUsuarioDto.getCpf())
				.ifPresent(emp -> result.addError(new ObjectError("usuario", "Usuario já existente.")));

	}
	
	/**
	 * Converte os dados do DTO para usuario.
	 * 
	 * @param cadastroUsuarioDto
	 * @return Usuario
	 */
	private Usuario converterDtoParaUsuario(CadastroUsuarioDto cadastroUsuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setCpf(cadastroUsuarioDto.getCpf());
		usuario.setNome(cadastroUsuarioDto.getNome());

		return usuario;
	}
	
	
	
}
