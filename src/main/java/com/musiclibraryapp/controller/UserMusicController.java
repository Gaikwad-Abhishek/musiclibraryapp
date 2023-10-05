package com.musiclibraryapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.PlaylistDTO;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/user-music")
//playlist - favorite
public class UserMusicController {
	
	
	@PostMapping("/create-playlist")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        // Implement the logic to create a new playlist and return it
		return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{songId}/add-to-playlist/{playlistId}")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(
            @PathVariable Long songId,
            @PathVariable Long playlistId) {
        // Implement the logic to add a song to a playlist and return the updated playlist
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{songId}/remove-from-playlist/{playlistId}")
    public ResponseEntity<PlaylistDTO> removeSongFromPlaylist(
            @PathVariable Long songId,
            @PathVariable Long playlistId) {
        // Implement the logic to remove a song from a playlist and return the updated playlist
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/{playlistId}/update")
    public ResponseEntity<PlaylistDTO> updatePlaylist(
            @PathVariable Long playlistId,
            @RequestBody PlaylistDTO updatedPlaylist) {
        // Implement the logic to update a playlist and return the updated playlist
    	return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-playlist/{playlistId}")
    public ResponseEntity<PlaylistDTO> getPlaylistById(@PathVariable Long playlistId) {
        // Implement the logic to retrieve a playlist by its ID and return it
    	return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all-playlist")
    public ResponseEntity<List<PlaylistDTO>> getAllPlaylists() {
        // Implement the logic to retrieve all playlists and return them as a list
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{id}/add-to-favourite")
    public ResponseEntity<Void> addSongToFavourite(@PathVariable Long id) {
        // Implement the logic to add a song to favorites
        // Return an appropriate response, e.g., HttpStatus.CREATED for success
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{id}/remove-from-favourite")
    public ResponseEntity<Void> removeSongFromFavourite(@PathVariable Long id) {
        // Implement the logic to remove a song from favorites
        // Return an appropriate response, e.g., HttpStatus.NO_CONTENT for success
    	return ResponseEntity.noContent().build();
    }
}
