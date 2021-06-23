package br.com.jeferson.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.jeferson.bookstore.domain.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Campo Título é requerido!")
	private String titulo;
	
	@NotEmpty(message = "Campo Nome do Autor é requerido!")
	@Length(min = 2, max = 100, message = "Campo Nome do Autor deve ter no mínimo 3 e máximo 100 caracteres.")
	private String nomeAutor;
	
	private String texto;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.nomeAutor = livro.getNomeAutor();
		this.texto = livro.getTexto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
