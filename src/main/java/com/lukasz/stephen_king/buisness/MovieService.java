package com.lukasz.stephen_king.buisness;

import com.lukasz.stephen_king.api.dto.MovieDetailsDto;
import com.lukasz.stephen_king.api.dto.MovieDto;
import com.lukasz.stephen_king.api.dto.mapper.MovieDtoMapper;
import com.lukasz.stephen_king.buisness.dao.MovieDao;
import com.lukasz.stephen_king.buisness.mapper.CastMemberMapper;
import com.lukasz.stephen_king.buisness.mapper.MovieMapper;
import com.lukasz.stephen_king.domain.CastMemberDomain;
import com.lukasz.stephen_king.domain.MovieDetailsDomain;
import com.lukasz.stephen_king.domain.exception.NotFoundException;
import com.lukasz.stephen_king.infrastructure.movie.CastMember;
import com.lukasz.stephen_king.infrastructure.movie.Movie;
import com.lukasz.stephen_king.infrastructure.movie.MovieDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieDao movieDao;
    private final MovieMapper movieMapper;

    private final CastMemberMapper castMemberMapper;
    private final MovieDtoMapper movieDtoMapper;


    public List<MovieDto> getStephenKingMovies() {
        List<Movie> movies = movieDao.getStephenKingMovies();
        return movies.stream()
                .map(movieMapper::mapToDomain)
                .map(movieDtoMapper::mapToDto)
                .toList();

    }

    public MovieDetailsDto getMovieDetails(int id) {
        Optional<MovieDetails> movieDetails = movieDao.getMovieDetails(id);
        if (movieDetails.isEmpty()) {
            throw new NotFoundException("Cannot find movie with id: [%s]".formatted(id));
        } else {
            ArrayList<CastMember> castMembers = movieDao.getMovieCast(id).get();
            ArrayList<CastMemberDomain> castMemberDomains = castMembers.stream()
                    .map(castMemberMapper::mapToDomain)
                    .collect(Collectors.toCollection(ArrayList::new));
            MovieDetailsDomain movieDetailsDomain = movieMapper.mapToDomain(movieDetails.get());
            movieDetailsDomain.setCast(castMemberDomains);
            return movieDtoMapper.mapToDto(movieDetailsDomain);
        }
    }
}
