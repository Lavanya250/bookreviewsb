package com.lavanya.bookreview.repository;

import com.lavanya.bookreview.model.Book;
import com.lavanya.bookreview.model.Review;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT r.book FROM Review r WHERE r.rating > :rating")
    List<Book> findBooksByRatingGreaterThan(@Param("rating") float rating);

}
