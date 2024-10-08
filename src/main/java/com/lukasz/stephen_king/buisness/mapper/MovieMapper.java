package com.lukasz.stephen_king.buisness.mapper;

import com.lukasz.stephen_king.domain.MovieDetailsDomain;
import com.lukasz.stephen_king.domain.MovieDomain;
import com.lukasz.stephen_king.infrastructure.movie.Movie;
import com.lukasz.stephen_king.infrastructure.movie.MovieDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDomain mapToDomain(Movie movie);

    MovieDetailsDomain mapToDomain(MovieDetails movieDetails);
}
