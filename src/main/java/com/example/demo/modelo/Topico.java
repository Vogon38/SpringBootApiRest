package com.example.demo.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Topico {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Getter @Setter private Long id;
	@Getter @Setter private String titulo;
	@Getter @Setter private String mensagem;
	@Getter @Setter private LocalDateTime dataCriacao = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Getter @Setter private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

	@ManyToOne
	@Getter @Setter private Usuario autor;
	
	@ManyToOne
	@Getter @Setter private Curso curso;

	@OneToMany(mappedBy = "topico")
	@Getter @Setter private List<Resposta> respostas = new ArrayList<>();

	public Topico() {}

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
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
		Topico other = (Topico) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}

}
