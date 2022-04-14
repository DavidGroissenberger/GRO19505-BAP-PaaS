package at.spengergasse.webapplication.gro19505.repositories;

import at.spengergasse.webapplication.gro19505.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
