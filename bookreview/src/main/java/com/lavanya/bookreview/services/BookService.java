package com.lavanya.bookreview.services;

import com.lavanya.bookreview.model.Book;
import com.lavanya.bookreview.repository.BookRepository;
import com.lavanya.bookreview.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    @Autowired
    private ReviewRepository reviewRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public boolean deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Book updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setBookName(updatedBook.getBookName());
            book.setGenre(updatedBook.getGenre());
            book.setLaunchYear(updatedBook.getLaunchYear());
            book.setAuthor(updatedBook.getAuthor());
            return bookRepository.save(book);
        }
        return null;
    }

    

    public List<Book> findBooksByRatingGreaterThan(float rating) {
        return reviewRepository.findBooksByRatingGreaterThan(rating);
    }

    public List<Book> findBooksByYear(String year) {
        return bookRepository.findBooksByYear(year);
    }
}

