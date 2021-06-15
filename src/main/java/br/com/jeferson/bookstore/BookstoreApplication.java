package br.com.jeferson.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.domain.Livro;
import br.com.jeferson.bookstore.repositories.CategoriaRepository;
import br.com.jeferson.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	LivroRepository livroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria();
		categoria.setNome("Informática");
		categoria.setDescricao("Livros de Informática");
		
		Livro livro = new Livro();
		livro.setTitulo("Dando Reset no Computador");
		livro.setNomeAutor("Não existe");
		livro.setTexto("");
		livro.setCategoria(categoria);
		
		categoriaRepository.save(categoria);
		livroRepository.save(livro);
	}
}
