package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.ArtistSong;
import com.musiclibraryapp.entity.DirectorSong;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.repository.DirectorSongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorSongService {
    private final DirectorSongRepository directorSongRepository;

    @Autowired
    public DirectorSongService(DirectorSongRepository directorSongRepository) {
        this.directorSongRepository = directorSongRepository;
    }

    public List<DirectorSong> getAllDirectorSongs() {
        return directorSongRepository.findAll();
    }

    public Optional<DirectorSong> getDirectorSongById(Long directorSongId) {
        return directorSongRepository.findById(directorSongId);
    }

    public DirectorSong createDirectorSong(User user, Song song) {
        DirectorSong directorSong = new DirectorSong();
        directorSong.setDirector(user);
        directorSong.setSong(song);
        return directorSongRepository.save(directorSong);
    }

    // public ArtistSong createArtistSong(User user, Song song) {
    //     ArtistSong artistSong = new ArtistSong();
    //     artistSong.setArtist(user);
    //     artistSong.setSong(song);
    //     return artistSongRepository.save(artistSong);
    // }

    public DirectorSong updateDirectorSong(Long directorSongId, DirectorSong updatedDirectorSong) {
        Optional<DirectorSong> existingDirectorSong = directorSongRepository.findById(directorSongId);

        if (existingDirectorSong.isPresent()) {
            updatedDirectorSong.setDirectorSongId(existingDirectorSong.get().getDirectorSongId());
            return directorSongRepository.save(updatedDirectorSong);
        } else {
            throw new IllegalArgumentException("Director Song not found with ID: " + directorSongId);
        }
    }

    public void deleteDirectorSong(Long directorSongId) {
        directorSongRepository.deleteById(directorSongId);
    }

    public List<Song> findSongsByPartialDirectorName(String partialDirectorName) {
        return directorSongRepository.findSongByPartialDirectorName(partialDirectorName);
    }
}

