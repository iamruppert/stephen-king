package com.lukasz.stephen_king.domain;

import lombok.*;

import java.sql.Blob;
import java.util.List;

@With
@Setter
@Data
@Builder
@EqualsAndHashCode(of = "bookId")
@ToString(of = {
        "bookId", "year", "title",
        "publisher", "ISBN", "pages", "description", "image", "villains"
})
public class BookDomain {

    Integer bookId;
    Integer year;
    String title;
    String publisher;
    String ISBN;
    Integer pages;
    String description;
    Blob image;
    List<VillainDomain> villains;
}
