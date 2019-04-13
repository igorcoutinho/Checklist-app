package com.checklist.api.repositories;


import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.checklist.api.entities.Tarefa;
import com.checklist.api.entities.Usuario;
import com.checklist.api.enums.TipoEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class TarefaRepositoryTest {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String NOME = "Arrumar cozinha";
	
	@Before
	public void setUp() throws Exception {
		Usuario usuario = this.usuarioRepository.save(obterDadosUsuario());
		this.tarefaRepository.save(obterDadosTarefa(usuario));
	}

	@After
	public final void tearDown() {
		this.usuarioRepository.deleteAll();
	}
	
	private Tarefa obterDadosTarefa(Usuario usuario) throws NoSuchAlgorithmException {
		Tarefa tarefa = new Tarefa();
		tarefa.setNome(NOME);
		tarefa.setArquivado(false);
		tarefa.setTipoTarefa(TipoEnum.DIARIA);
		tarefa.setUsuario(usuario);
		return tarefa;
	}
	
	private Usuario obterDadosUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor Coutinho");
		usuario.setCpf("00097120383");
		return usuario;
	}
	
}
