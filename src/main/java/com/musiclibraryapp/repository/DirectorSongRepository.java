package com.musiclibraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiclibraryapp.entity.DirectorSong;
import com.musiclibraryapp.entity.Song;

public interface DirectorSongRepository extends JpaRepository<DirectorSong, Long> {

    @Query("SELECT d.song FROM DirectorSong d " +
           "WHERE d.director.name LIKE %:partialArtistName%" 
         //  + "ORDER BY a.streams DESC " 
        //   + "LIMIT 2"
           )
    List<Song> findSongByPartialDirectorName(String partialArtistName);
}
