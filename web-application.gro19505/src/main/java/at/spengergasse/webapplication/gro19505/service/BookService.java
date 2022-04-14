package at.spengergasse.webapplication.gro19505.service;

import at.spengergasse.webapplication.gro19505.model.Books;
import at.spengergasse.webapplication.gro19505.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BookService {

    List<Books> getAllBooks();

    Books saveBook(Books book);

    Books getBookById(Long id);
    Books updateBook(Books book);

    void deleteBookById(Long id);
}
