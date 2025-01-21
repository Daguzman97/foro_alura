package com.alura_forohub.application.controller;

import com.alura_forohub.application.model.topico.*;
import com.alura_forohub.application.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TemaController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public ResponseEntity<DtoResponseTema> registrarTopico(@RequestBody @Valid DtoRegistroTema dtoRegistroTema,
                                                           UriComponentsBuilder uriComponentsBuilder) {
        Tema tema = topicoRepository.save(new Tema(dtoRegistroTema));
        DtoResponseTema dtoResponseTema = new DtoResponseTema(tema.getId(), tema.getTitulo(), tema.getMensaje(),
                tema.getAutor(), tema.getCurso());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(tema.getId()).toUri();
        return ResponseEntity.created(url).body(dtoResponseTema);
    }

    @GetMapping
    public List<DtoListarTema> listarTopicos() {
        return topicoRepository.findAll().stream().map(DtoListarTema::new).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoListarTema> muestraTopico(@PathVariable Long id){
        Tema tema = topicoRepository.getReferenceById(id);
        var datosTopico =new DtoListarTema(tema);
        return ResponseEntity.ok(datosTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizaTopico(@RequestBody @Valid DtoActualizacionTema dtoActualizacionTema, @PathVariable Long id){
        Tema tema = topicoRepository.getReferenceById(id);
        var nuevosDatos = tema.actualizarDatos(dtoActualizacionTema);
        return ResponseEntity.ok(nuevosDatos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Tema tema = topicoRepository.getReferenceById(id);
        topicoRepository.delete(tema);
    }

}
