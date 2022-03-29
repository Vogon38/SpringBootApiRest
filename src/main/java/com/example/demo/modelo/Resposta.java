package com.example.demo.modelo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Resposta {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Getter	@Setter	private Long id;
	@Getter @Setter private String mensagem;
	@Getter @Setter private LocalDateTime dataCriacao = LocalDateTime.now();

	@ManyToOne
	@Getter @Setter private com.example.demo.modelo.Topico topico;

	@ManyToOne
	@Getter @Setter private com.example.demo.modelo.Usuario autor;

	@Getter @Setter private Boolean solucao = false;

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
		Resposta other = (Resposta) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}

}
