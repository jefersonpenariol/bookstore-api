package br.com.jeferson.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jeferson.bookstore.domain.Categoria;
import br.com.jeferson.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer>{

	List<Livro> findAllByCategoria(Categoria categoria);

}
