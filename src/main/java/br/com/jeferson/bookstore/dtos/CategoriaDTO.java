package br.com.jeferson.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.jeferson.bookstore.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Campo nome requerido!")
	@Length(min = 2, max = 100, message = "Campo nome deve ter no mínimo 3 e máximo 100 caracteres.")
	private String nome;
	
	@Length(min = 2, max = 200, message = "Campo descrição deve ter no mínimo 3 e máximo 200 caracteres.")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria categoria) {
		super();
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaDTO other = (CategoriaDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
