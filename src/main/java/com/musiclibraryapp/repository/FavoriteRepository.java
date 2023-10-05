package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Favorite;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    Favorite findByUserAndSong(User user, Song song);
}

