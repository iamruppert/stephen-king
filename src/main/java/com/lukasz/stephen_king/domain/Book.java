package com.lukasz.stephen_king.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@With
@Value
@Builder
@EqualsAndHashCode(of = "bookId")
@ToString(of = {
        "bookId", "year", "title",
        "publisher", "ISBN", "pages"
})
public class Book {

    String bookId;
    String year;
    String title;
    String publisher;
    String ISBN;
    Integer pages;

    @JsonCreator
    public Book(@JsonProperty("id") String bookId,
                @JsonProperty("Year") String year,
                @JsonProperty("Title") String title,
                @JsonProperty("Publisher") String publisher,
                @JsonProperty("ISBN") String ISBN,
                @JsonProperty("Pages") Integer pages) {
        this.bookId = bookId;
        this.year = year;
        this.title = title;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.pages = pages;
    }

}
