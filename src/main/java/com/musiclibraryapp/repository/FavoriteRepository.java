package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}

