package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
 
}

