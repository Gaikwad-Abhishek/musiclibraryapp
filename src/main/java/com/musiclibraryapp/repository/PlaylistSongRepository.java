package com.musiclibraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.musiclibraryapp.entity.PlaylistSong;
import com.musiclibraryapp.entity.Song;

import jakarta.transaction.Transactional;

import java.util.List;
import com.musiclibraryapp.entity.Playlist;


public interface PlaylistSongRepository extends JpaRepository<PlaylistSong, Long> {
 
    @Query("SELECT ps.songId FROM PlaylistSong ps WHERE ps.playlistId.playlistId = ?1")
    List<Song> findSongsByPlaylistId(Long playlistId);

    // @Transactional
    // void deleteBySongIdAndPlaylistId(Long songId, Long playlistId);
    @Transactional
    @Modifying
    @Query("DELETE FROM PlaylistSong ps WHERE ps.songId.songId = ?1 AND ps.playlistId.playlistId = ?2")
    void deleteBySongIdAndPlaylistId(Long songId, Long playlistId);
}

