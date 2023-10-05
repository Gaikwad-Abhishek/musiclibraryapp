package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.dto.SongDTO;
import com.musiclibraryapp.entity.Playlist;
import com.musiclibraryapp.entity.PlaylistSong;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.repository.PlaylistSongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistSongService {
    private final PlaylistSongRepository playlistSongRepository;


    @Autowired
    public PlaylistSongService(PlaylistSongRepository playlistSongRepository) {
        this.playlistSongRepository = playlistSongRepository;
    }

    public List<PlaylistSong> getAllPlaylistSongs() {
        return playlistSongRepository.findAll();
    }

    public List<Song> getPlaylistSongs(Long playlistId) {
        return playlistSongRepository.findSongsByPlaylistId(playlistId);
    }

    public Optional<PlaylistSong> getPlaylistSongById(Long playlistSongId) {
        return playlistSongRepository.findById(playlistSongId);
    }

    public PlaylistSong createPlaylistSong(PlaylistSong playlistSong) {
        return playlistSongRepository.save(playlistSong);
    }

    public PlaylistSong updatePlaylistSong(Long playlistSongId, PlaylistSong updatedPlaylistSong) {
        Optional<PlaylistSong> existingPlaylistSong = playlistSongRepository.findById(playlistSongId);

        if (existingPlaylistSong.isPresent()) {
            updatedPlaylistSong.setPlaylistSongId(existingPlaylistSong.get().getPlaylistSongId());
            return playlistSongRepository.save(updatedPlaylistSong);
        } else {
            throw new IllegalArgumentException("Playlist Song not found with ID: " + playlistSongId);
        }
    }

    public void deletePlaylistSong(Long playlistSongId) {
        playlistSongRepository.deleteById(playlistSongId);
    }
}
