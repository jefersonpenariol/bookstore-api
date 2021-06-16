package br.com.jeferson.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id); 
		return categoria.orElse(null);
	}
}
