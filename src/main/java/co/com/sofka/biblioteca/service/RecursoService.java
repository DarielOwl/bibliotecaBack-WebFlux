package co.com.sofka.biblioteca.service;

import co.com.sofka.biblioteca.model.Recurso;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoService {

    //CRUD-------------------------------------
    Mono<Recurso> save(Recurso cliente);

    Mono<Recurso> delete(String id);

    Mono<Recurso> update(String id, Recurso cliente);

    Flux<Recurso> findAll();

    Mono<Recurso> findById(String id);


    //Another Functions--------------------------
    Mono<String> disponibilidadById(String id);

    Mono<String> prestarRecursoById(String id);

    Flux<Recurso> recomendarRecursosByTipo(String tipo);

    Flux<Recurso> recomendarRecursosByCategoria(String categoria);

    Flux<Recurso> recomendarRecursosByCategoriaAndTipo(String categoria, String tipo);

    Mono<String> devolverRecursoById(String id);

}
