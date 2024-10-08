package com.lukasz.stephen_king.buisness.mapper;

import com.lukasz.stephen_king.domain.BookDomain;
import com.lukasz.stephen_king.infrastructure.book.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDomain map(Book book);
}
