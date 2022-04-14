package at.spengergasse.webapplication.gro19505.service;


import at.spengergasse.webapplication.gro19505.model.Books;
import at.spengergasse.webapplication.gro19505.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService
{

    private BookRepository bookRepo;

    public BookServiceImpl(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public List<Books> getAllBooks() {
        return (List<Books>) bookRepo.findAll();
    }

    @Override
    public Books saveBook(Books book) {
        return bookRepo.save(book);
    }

    @Override
    public Books getBookById(Long id) {
        return bookRepo.findById(id).get();
    }

    @Override
    public Books updateBook(Books book) {
        return bookRepo.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }


}
