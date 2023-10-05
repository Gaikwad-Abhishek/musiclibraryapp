package com.musiclibraryapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.AlbumDTO;
import com.musiclibraryapp.dto.SongDTO;
import com.musiclibraryapp.entity.Album;
import com.musiclibraryapp.repository.AlbumRepository;
import com.musiclibraryapp.service.AlbumService;
import com.musiclibraryapp.service.SongService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/music-library")
//Album - Song Addition 
public class MediaController {
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	SongService songService;
	
	@PostMapping("/create-album")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        // Implement the logic to create a new album and return it
		Album newAlbum = albumService.createAlbum(albumDTO);
		songService.createSong(albumDTO.getAlbumSongs());
		return ResponseEntity.noContent().build();
    }

    @PostMapping("{albumId}/delete")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long albumId) {
        // Implement the logic to delete an album by its ID
        // Return an appropriate response, e.g., HttpStatus.NO_CONTENT for success
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/{songId}/delete")
    public ResponseEntity<Void> deleteSong(@PathVariable Long songId) {
        // Implement the logic to delete a song by its ID
        // Return an appropriate response, e.g., HttpStatus.NO_CONTENT for success
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/{songId}/update")
    public ResponseEntity<SongDTO> updateSong(
            @PathVariable Long songId,
            @RequestBody SongDTO updatedSong) {
        // Implement the logic to update a song and return the updated song
    	return ResponseEntity.noContent().build();
    }
}
