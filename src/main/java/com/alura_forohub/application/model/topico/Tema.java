package com.alura_forohub.application.model.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private Boolean status;
    private String autor;
    private String curso;
    private Integer respuestas;

    public Tema(DtoRegistroTema dtoRegistroTema) {
        this.titulo = dtoRegistroTema.titulo();
        this.mensaje = dtoRegistroTema.mensaje();
        this.status = true;
        this.autor = dtoRegistroTema.autor();
        this.curso = dtoRegistroTema.curso();
        this.fechaCreacion = LocalDateTime.now();
        this.respuestas = 0;
    }

    public DtoResponseTema actualizarDatos (DtoActualizacionTema dtoActualizacionTema) {
        if (dtoActualizacionTema.titulo() != null) {
            this.titulo = dtoActualizacionTema.titulo();
        }
        if (dtoActualizacionTema.mensaje() != null) {
            this.mensaje = dtoActualizacionTema.mensaje();
        }
        if (dtoActualizacionTema.autor() != null) {
            this.autor = dtoActualizacionTema.autor();
        }
        if (dtoActualizacionTema.curso() != null) {
            this.curso = dtoActualizacionTema.curso();
        }
        return new DtoResponseTema(this.id, this.titulo, this.mensaje, this.autor, this.curso);
    }
}
