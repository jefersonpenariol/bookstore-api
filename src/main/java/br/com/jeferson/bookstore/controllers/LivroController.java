package br.com.jeferson.bookstore.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.jeferson.bookstore.domain.Livro;
import br.com.jeferson.bookstore.dtos.LivroDTO;
import br.com.jeferson.bookstore.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findLivroById(@PathVariable Integer id) {
		Livro livro = livroService.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "id_categoria", defaultValue = "0") Integer idCategoria){
		List<Livro> livros = livroService.findAll(idCategoria);
		List<LivroDTO> livroDTO = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDTO);
	}
}