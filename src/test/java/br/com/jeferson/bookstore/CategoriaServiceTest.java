package br.com.jeferson.bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.repositories.CategoriaRepository;
import br.com.jeferson.bookstore.service.CategoriaService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

	private static final Integer CATEGORIA_ID = 1;
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Test
	public void testFindById() {
		Categoria categoria = this.categoriaService.findById(CATEGORIA_ID);
		assertEquals(categoria.getId(), CATEGORIA_ID);
	}
}
