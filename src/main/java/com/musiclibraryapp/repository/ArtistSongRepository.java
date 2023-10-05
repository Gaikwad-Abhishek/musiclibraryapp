package com.musiclibraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiclibraryapp.entity.ArtistSong;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;

public interface ArtistSongRepository extends JpaRepository<ArtistSong, Long> {

    @Query("SELECT a.song FROM ArtistSong a " +
           "WHERE a.artist.name LIKE %:partialArtistName%" 
         //  + "ORDER BY a.streams DESC " 
        //   + "LIMIT 2"
           )
    List<Song> findSongByPartialArtistName(String partialArtistName);

}

