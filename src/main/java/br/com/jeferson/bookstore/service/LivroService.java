package br.com.jeferson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.domain.Livro;
import br.com.jeferson.bookstore.dtos.LivroDTO;
import br.com.jeferson.bookstore.exceptions.ObjectNotFoundException;
import br.com.jeferson.bookstore.repositories.LivroRepository;

@Service
public class LivroService {

	private static final String NOT_FOUND_MESSAGE_ERROR = "Objeto Não Encontrado!";
	private static final String SEPARATOR = " ";

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException(
				NOT_FOUND_MESSAGE_ERROR + SEPARATOR + "ID: " + id + SEPARATOR + Livro.class.getSimpleName()));
	}

	public List<Livro> findAll(Integer idCategoria) {
		Categoria categoria = categoriaService.findById(idCategoria);
		return livroRepository.findAllByCategoria(categoria);
	}

	public Livro update(Integer id, LivroDTO livroDTO) {
		Livro livroUpToDate = this.findById(id);
		livroUpToDate.setTitulo(livroDTO.getTitulo());
		livroUpToDate.setNomeAutor(livroDTO.getNomeAutor());
		livroUpToDate.setTexto(livroDTO.getTexto());

		return livroRepository.save(livroUpToDate);
	}

	public Livro createLivro(Integer idCategoria, Livro livro) {
		Categoria categoria = categoriaService.findById(idCategoria);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
	}

	public void delete(Integer id) {
		Livro livro = this.findById(id);
		livroRepository.delete(livro);
	}
}
