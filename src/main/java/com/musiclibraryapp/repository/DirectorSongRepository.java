package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.DirectorSong;

public interface DirectorSongRepository extends JpaRepository<DirectorSong, Long> {
}
