package br.com.jeferson.bookstore;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.dtos.CategoriaDTO;
import br.com.jeferson.bookstore.repositories.CategoriaRepository;
import br.com.jeferson.bookstore.service.CategoriaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaServiceTest {

	private static final Integer CATEGORIA_ID = 1;

	@MockBean
	CategoriaRepository categoriaRepository;

	@Autowired
	CategoriaService categoriaService;

	Categoria categoria = new Categoria();

	@Test
	public void testFindById() {
		Categoria categoriaMock = new Categoria();
		categoriaMock.setId(CATEGORIA_ID);
		when(categoriaRepository.findById(CATEGORIA_ID)).thenReturn(Optional.of(categoriaMock));
		Categoria categoria = this.categoriaService.findById(CATEGORIA_ID);
		assertEquals(categoria.getId(), CATEGORIA_ID);
	}

	@Test
	public void testFindAll() {
		List<Categoria> categoriasMock = new ArrayList<Categoria>();
		when(categoriaRepository.findAll()).thenReturn(categoriasMock);

		List<Categoria> categorias = categoriaService.findAll();
		assertNotNull(categorias);
	}

	@Test
	public void testCreateCategoria() {
		categoria.setId(CATEGORIA_ID);
		categoria.setNome("Categoria Teste");
		BDDMockito.given(categoriaRepository.save(Mockito.any(Categoria.class))).willReturn(new Categoria());
		categoria = this.categoriaService.createCategoria(categoria);

		assertNotNull(categoria);
	}

	@Test
	public void testUpdateCategoria() {
		categoria.setId(CATEGORIA_ID);
		categoria.setNome("Categoria Teste");
		Categoria categoriaToUpdate = new Categoria();
		categoriaToUpdate.setNome("Novo Nome");
		CategoriaDTO categoriaDTO = new CategoriaDTO(categoriaToUpdate);

		Categoria categoriaMock = new Categoria();
		categoriaMock.setId(CATEGORIA_ID);
		BDDMockito.given(categoriaRepository.save(categoria)).willReturn(categoria);
		when(categoriaRepository.findById(CATEGORIA_ID)).thenReturn(Optional.of(categoriaMock));
		categoria = this.categoriaService.update(categoria.getId(), categoriaDTO);

		assertEquals(categoria.getNome(), categoriaToUpdate.getNome());
	}
}
