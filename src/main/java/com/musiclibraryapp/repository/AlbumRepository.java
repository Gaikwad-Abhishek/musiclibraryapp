package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {

}

