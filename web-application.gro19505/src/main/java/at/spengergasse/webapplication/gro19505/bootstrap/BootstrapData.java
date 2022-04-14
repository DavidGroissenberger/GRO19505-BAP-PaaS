package at.spengergasse.webapplication.gro19505.bootstrap;

import at.spengergasse.webapplication.gro19505.model.Author;
import at.spengergasse.webapplication.gro19505.model.Books;
import at.spengergasse.webapplication.gro19505.model.Publisher;
import at.spengergasse.webapplication.gro19505.repositories.AuthorRepository;
import at.spengergasse.webapplication.gro19505.repositories.BookRepository;
import at.spengergasse.webapplication.gro19505.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisherNr1 = new Publisher("bookpublisherNr1", "Sternengasse 6a", "2483", "Ebreichsdorf", "Austria");

        publisherRepository.save(publisherNr1);



        Author nussbaum = new Author("Günther", "Nussbaum");
        Books pfusch = new Books("Pfusch am Bau", "6666");
        nussbaum.getBooks().add(pfusch);
        pfusch.getAuthors().add(nussbaum);

        pfusch.setPublisher(publisherNr1);
        publisherNr1.getBooks().add(pfusch);


        authorRepository.save(nussbaum);
        bookRepository.save(pfusch);


        Author horvath = new Author("Anton", "Horvath");
        Books horvatsbuch = new Books("Aller Anfang is Horvath", "0001");
        horvath.getBooks().add(horvatsbuch);
        horvatsbuch.getAuthors().add(horvath);

        horvatsbuch.setPublisher(publisherNr1);
        publisherNr1.getBooks().add(horvatsbuch);

       // publisherRepository.save(publisherNr1);
        authorRepository.save(horvath);
        bookRepository.save(horvatsbuch);

        //test
        System.out.println("book count: " + bookRepository.count());
        System.out.println("publisher count: " + publisherRepository.count());





    }
}
