package com.example.demo.controller.dto;

import com.example.demo.modelo.StatusTopico;
import com.example.demo.modelo.Topico;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoTopicoDto {

    @Getter private Long id;
    @Getter private String titulo;
    @Getter private String mensagem;
    @Getter private LocalDateTime dataCriacao;
    @Getter private String nomeAutor;
    @Getter private StatusTopico status;
    @Getter private List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor().getNome();
        this.status = topico.getStatus();
        this.respostas = new ArrayList<>();

        this.respostas.addAll(topico.getRespostas()
                .stream()
                .map(RespostaDto::new)
                .collect(Collectors.toList()));
    }

}
