package at.spengergasse.webapplication.gro19505.repositories;

import org.springframework.data.repository.CrudRepository;

import at.spengergasse.webapplication.gro19505.model.Books;

public interface BookRepository extends CrudRepository<Books, Long> {
}
