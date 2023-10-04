package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    // You can add custom queries here if needed
}

