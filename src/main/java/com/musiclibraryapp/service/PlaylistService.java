package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Playlist;
import com.musiclibraryapp.repository.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId);
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(Long playlistId, Playlist updatedPlaylist) {
        Optional<Playlist> existingPlaylist = playlistRepository.findById(playlistId);

        if (existingPlaylist.isPresent()) {
            updatedPlaylist.setPlaylistId(existingPlaylist.get().getPlaylistId());
            return playlistRepository.save(updatedPlaylist);
        } else {
            throw new IllegalArgumentException("Playlist not found with ID: " + playlistId);
        }
    }

    public void deletePlaylist(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
