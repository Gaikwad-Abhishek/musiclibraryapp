package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.ArtistSong;

public interface ArtistSongRepository extends JpaRepository<ArtistSong, Long> {

}

