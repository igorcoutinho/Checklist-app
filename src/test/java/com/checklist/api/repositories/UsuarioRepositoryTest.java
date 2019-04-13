package com.checklist.api.repositories;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.checklist.api.entities.Usuario;

import com.checklist.api.repositories.UsuarioRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static final String CPF = "00097120383";

	@Before
	public void setUp() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor Coutinho");
		usuario.setCpf(CPF);
		this.usuarioRepository.save(usuario);
	}
	
	@After
    public final void tearDown() { 
		this.usuarioRepository.deleteAll();
	}

	@Test
	public void testBuscarPorCpf() {
		Usuario usuario = this.usuarioRepository.findByCpf(CPF);
		
		assertEquals(CPF, usuario.getCpf());
	}

}