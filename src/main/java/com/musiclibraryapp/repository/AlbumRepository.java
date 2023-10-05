package com.musiclibraryapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musiclibraryapp.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query("SELECT a FROM Album a WHERE a.albumName LIKE %:partialAlbumName% " +
           "ORDER BY a.streams DESC")
    List<Album> findTop5AlbumsByPartialAlbumName(String partialAlbumName);

}

