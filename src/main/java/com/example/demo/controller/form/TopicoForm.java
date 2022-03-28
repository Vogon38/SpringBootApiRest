package com.example.demo.controller.form;

import com.example.demo.modelo.Curso;
import com.example.demo.modelo.Topico;
import com.example.demo.repository.CursoRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {

    @Getter @Setter @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @Getter @Setter @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;
    @Getter @Setter @NotNull @NotEmpty
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
