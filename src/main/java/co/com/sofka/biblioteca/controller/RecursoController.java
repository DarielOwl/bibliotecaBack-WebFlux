package co.com.sofka.biblioteca.controller;

import co.com.sofka.biblioteca.model.Recurso;
import co.com.sofka.biblioteca.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class RecursoController {

    @Autowired
    private RecursoService service;

    //CRUD-------------------------------------
    @GetMapping(value = "/allRecurso")
    private Flux<Recurso> findAll() {
        return this.service.findAll();
    }


    @PostMapping("/addRecurso")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Recurso> save(@RequestBody Recurso recurso) {
        return this.service.save(recurso);
    }


    @PutMapping("/updateRecurso/{id}")
    private Mono<Recurso> update(@PathVariable("id") String id, @RequestBody Recurso recurso) {
        return this.service.update(id, recurso)
                .flatMap(recurso1 -> Mono.just((recurso1)))
                .switchIfEmpty(Mono.empty());

    }


    @DeleteMapping("/removeRecurso/{id}")
    private Mono<Recurso> delete(@PathVariable("id") String id) {
        return this.service.delete(id)
                .flatMap(recurso -> Mono.just((recurso)))
                .switchIfEmpty(Mono.empty());
    }



    //Another Functions--------------------------
    @GetMapping("/buscarRecurso/{id}")
    private Mono<Recurso> findByid(@PathVariable("id") String id) {
        return this.service.findById(id);
    }


    @GetMapping("/disponibilidadRecurso/{id}")
    private Mono<String> disponibilidadById(@PathVariable("id") String id) {
        return this.service.disponibilidadById(id);
    }


    @PutMapping("/prestamoRecurso/{id}")
    private Mono<String> prestarRecursoById(@PathVariable("id") String id) {
        return this.service.prestarRecursoById(id);
    }


    @GetMapping("/recomendacionRecurso/{tipoRecurso}/tipo")
    private Flux<Recurso> recomendarRecursosByTipo(@PathVariable("tipoRecurso") String tipo) {
        return this.service.recomendarRecursosByTipo(tipo);
    }


    @GetMapping("/recomendacionRecurso/{categoriaRecurso}/categoria")
    private Flux<Recurso> recomendarRecursosByCategoria(@PathVariable("categoriaRecurso") String categoria) {
        return this.service.recomendarRecursosByCategoria(categoria);
    }


    @GetMapping("/recomendacionRecurso/{categoriaRecurso}/{tipoRecurso}/categoriaYTipo")
    private Flux<Recurso> recomendarRecursosByCategoriaAndTipo
            (@PathVariable("categoriaRecurso") String categoria, @PathVariable("tipoRecurso") String tipo) {
        return this.service.recomendarRecursosByCategoriaAndTipo(categoria, tipo);
    }


    @PutMapping("/vevolucionRecurso/{id}")
    private Mono<String> devolverRecursoById(@PathVariable("id") String id) {
        return this.service.devolverRecursoById(id);
    }


}
