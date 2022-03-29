package com.example.demo.controller.form;

import com.example.demo.modelo.Topico;
import com.example.demo.repository.TopicoRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class AtualizacaoTopicoForm {

    @Getter @Setter @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @Getter @Setter @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;

    public Topico atualizar(Long id, TopicoRepository topicoRepository) {
        Topico topico = topicoRepository.getById(id);

        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);

        return topico;
    }
}
