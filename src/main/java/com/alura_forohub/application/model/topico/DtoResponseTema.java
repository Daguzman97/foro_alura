package com.alura_forohub.application.model.topico;

public record DtoResponseTema(
        Long id,
        String titulo,
        String mensaje,
//        LocalDateTime fechaCreacion,
        String autor,
        String curso) {
}
