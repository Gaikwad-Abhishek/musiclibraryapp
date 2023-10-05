package com.musiclibraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiclibraryapp.entity.Song;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("SELECT s FROM Song s WHERE s.songTitle LIKE %:partialTitle%")
    List<Song> findByPartialSongTitle(String partialTitle);

    @Query("SELECT s FROM Song s " +
       "WHERE s.songTitle LIKE %:partialTitle% " +
       "ORDER BY s.streams DESC " +
       "LIMIT 2")
    List<Song> findByPartialSongTitleWithTop2Streams(String partialTitle);


 
}

