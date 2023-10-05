package com.musiclibraryapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.dto.AlbumDTO;
import com.musiclibraryapp.entity.Album;
import com.musiclibraryapp.repository.AlbumRepository;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbumById(Long albumId) {
        return albumRepository.findById(albumId);
    }

    public Album createAlbum(AlbumDTO album) {
    	Album newAlbum = new Album();
    	newAlbum.setAlbumName(album.getAlbumName());
        return albumRepository.save(newAlbum);
    }

    public Album updateAlbum(Long albumId, Album updatedAlbum) {
        Optional<Album> existingAlbum = albumRepository.findById(albumId);

        if (existingAlbum.isPresent()) {
            updatedAlbum.setAlbumId(existingAlbum.get().getAlbumId());
            return albumRepository.save(updatedAlbum);
        } else {
            throw new IllegalArgumentException("Album not found with ID: " + albumId);
        }
    }

    public void deleteAlbum(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
