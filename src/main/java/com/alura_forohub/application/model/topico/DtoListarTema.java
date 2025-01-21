package com.alura_forohub.application.model.topico;

import java.time.LocalDateTime;

public record DtoListarTema(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Boolean status,
        String autor,
        String curso
) {
    public DtoListarTema(Tema tema) {
        this(tema.getId(), tema.getTitulo(), tema.getMensaje(), tema.getFechaCreacion(), tema.getStatus(), tema.getAutor(), tema.getCurso());
    }
}
