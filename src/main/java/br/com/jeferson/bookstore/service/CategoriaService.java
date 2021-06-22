package br.com.jeferson.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.dtos.CategoriaDTO;
import br.com.jeferson.bookstore.exceptions.ObjectNotFoundException;
import br.com.jeferson.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	private static final String NOT_FOUND_MESSAGE_ERROR = "Objeto Não Encontrado!";
	private static final String SEPARATOR = " ";

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				NOT_FOUND_MESSAGE_ERROR + SEPARATOR + "ID: " + id + SEPARATOR + Categoria.class.getSimpleName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria createCategoria(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Integer id, CategoriaDTO categoriaDTO) {
		Categoria categoriaUpToDate = this.findById(id);
		categoriaUpToDate.setNome(categoriaDTO.getNome());
		categoriaUpToDate.setDescricao(categoriaDTO.getDescricao());

		return categoriaRepository.save(categoriaUpToDate);
	}

	public void delete(Integer id) {
		findById(id);
		categoriaRepository.deleteById(id);
	}
}
