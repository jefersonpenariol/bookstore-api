package br.com.jeferson.bookstore.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.jeferson.bookstore.domain.Livro;
import br.com.jeferson.bookstore.dtos.LivroDTO;
import br.com.jeferson.bookstore.service.LivroService;

@CrossOrigin("*")
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
	public ResponseEntity<List<LivroDTO>> findAll(
			@RequestParam(value = "id_categoria", defaultValue = "0") Integer idCategoria) {
		List<Livro> livros = livroService.findAll(idCategoria);
		List<LivroDTO> livroDTO = livros.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(livroDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> updateLivro(@PathVariable Integer id, @Valid  @RequestBody LivroDTO livroDTO) {
		Livro livroUpToDate = livroService.update(id, livroDTO);
		return ResponseEntity.ok().body(new LivroDTO(livroUpToDate));
	}

	@PatchMapping(value = "/{id}")
	public ResponseEntity<LivroDTO> updateLivroPatch(@Valid @PathVariable Integer id, @Valid @RequestBody LivroDTO livroDTO) {
		Livro livroUpToDate = livroService.update(id, livroDTO);
		return ResponseEntity.ok().body(new LivroDTO(livroUpToDate));
	}

	@PostMapping
	public ResponseEntity<Livro> createLivro(@Valid
			@RequestParam(value = "id_categoria", defaultValue = "0") Integer idCategoria, @Valid @RequestBody Livro livro) {
		Livro newLivro = livroService.createLivro(idCategoria, livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newLivro.getId()).toUri();
		return ResponseEntity.created(uri).body(newLivro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
