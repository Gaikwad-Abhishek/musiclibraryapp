package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musiclibraryapp.entity.Playlist;
import com.musiclibraryapp.entity.User;

import java.util.List;


public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
 
    List<Playlist> findByUserId(User userId);
}

