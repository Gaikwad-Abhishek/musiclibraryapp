package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.ArtistSong;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.repository.ArtistSongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistSongService {
    private final ArtistSongRepository artistSongRepository;

    @Autowired
    public ArtistSongService(ArtistSongRepository artistSongRepository) {
        this.artistSongRepository = artistSongRepository;
    }

    public List<ArtistSong> getAllArtistSongs() {
        return artistSongRepository.findAll();
    }

    public Optional<ArtistSong> getArtistSongById(Long artistSongId) {
        return artistSongRepository.findById(artistSongId);
    }

    public ArtistSong createArtistSong(User user, Song song) {
        ArtistSong artistSong = new ArtistSong();
        artistSong.setArtist(user);
        artistSong.setSong(song);
        return artistSongRepository.save(artistSong);
    }

    public ArtistSong updateArtistSong(Long artistSongId, ArtistSong updatedArtistSong) {
        Optional<ArtistSong> existingArtistSong = artistSongRepository.findById(artistSongId);

        if (existingArtistSong.isPresent()) {
            updatedArtistSong.setArtistSongId(existingArtistSong.get().getArtistSongId());
            return artistSongRepository.save(updatedArtistSong);
        } else {
            throw new IllegalArgumentException("Artist Song not found with ID: " + artistSongId);
        }
    }

    public void deleteArtistSong(Long artistSongId) {
        artistSongRepository.deleteById(artistSongId);
    }
}
