package co.com.sofka.biblioteca.repository;

import co.com.sofka.biblioteca.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RecursoRepository extends ReactiveMongoRepository<Recurso, String> {

}
