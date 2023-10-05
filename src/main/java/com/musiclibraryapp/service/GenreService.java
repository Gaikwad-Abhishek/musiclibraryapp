package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Genre;
import com.musiclibraryapp.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(long genreId) {
        return genreRepository.findById(genreId);
    }
    
//    public Optional<Genre> getGenreByName(long genreId) {
//        return genreRepository.findByName(genreId);
//    }

    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre updateGenre(long genreId, Genre updatedGenre) {
        Optional<Genre> existingGenre = genreRepository.findById(genreId);

        if (existingGenre.isPresent()) {
            updatedGenre.setGenreId(existingGenre.get().getGenreId());
            return genreRepository.save(updatedGenre);
        } else {
            throw new IllegalArgumentException("Genre not found with ID: " + genreId);
        }
    }

    public void deleteGenre(long genreId) {
        genreRepository.deleteById(genreId);
    }
}

