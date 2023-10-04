package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.PlaylistSong;

public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, Long> {
  
}

