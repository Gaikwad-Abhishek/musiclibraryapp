package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.repository.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long songId) {
        return songRepository.findById(songId);
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    public Song updateSong(Long songId, Song updatedSong) {
        Optional<Song> existingSong = songRepository.findById(songId);

        if (existingSong.isPresent()) {
            updatedSong.setSongId(existingSong.get().getSongId());
            return songRepository.save(updatedSong);
        } else {
            throw new IllegalArgumentException("Song not found with ID: " + songId);
        }
    }

    public void deleteSong(Long songId) {
        songRepository.deleteById(songId);
    }
}
