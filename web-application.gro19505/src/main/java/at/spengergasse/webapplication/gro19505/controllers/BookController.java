package at.spengergasse.webapplication.gro19505.controllers;


import at.spengergasse.webapplication.gro19505.repositories.BookRepository;
import at.spengergasse.webapplication.gro19505.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import at.spengergasse.webapplication.gro19505.model.Books;

import java.util.List;


@Controller
public class BookController {

    private BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());

        return "/list";
    }

    @GetMapping("/books/new")
    public String createBookForm(Model model){

        Books book = new Books();
        model.addAttribute("book",book);
        return "/create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("books") Books book){
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model)  {
        model.addAttribute("book", bookService.getBookById(id));
        return "edit_student";

    }

    @PostMapping("/books/{id}")
    public String updateBook(@PathVariable Long id ,@ModelAttribute("books") Books book, Model model){

        Books existingBook = bookService.getBookById(id);
        existingBook.setId(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());

        bookService.updateBook(existingBook);

        return "redirect:/books";
    }
    @GetMapping("/books/{id}")
    public String deleteBook(@PathVariable Long id)          {
        bookService.deleteBookById(id);
        return "redirect:/books";
    }


/*
    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(Books book){
        bookRepository.save(book);
    }
*/

}
