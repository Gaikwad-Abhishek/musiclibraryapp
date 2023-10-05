package com.musiclibraryapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.PlaylistDTO;
import com.musiclibraryapp.entity.Playlist;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.service.FavoriteService;
import com.musiclibraryapp.service.PlaylistService;
import com.musiclibraryapp.service.PlaylistSongService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/user-music")
//playlist - favorite
public class UserMusicController {
	
	@Autowired
	PlaylistService playlistService;

    @Autowired
    PlaylistSongService playlistSongService;

    @Autowired
    FavoriteService favoriteService;
	
	@PostMapping("/create-playlist")
    public ResponseEntity<PlaylistDTO> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        // Implement the logic to create a new playlist and return it
		Playlist createdPlaylist = playlistService.createPlaylist(playlistDTO);
		playlistService.addSonglistToPlaylist(createdPlaylist,playlistDTO);
		return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{songId}/add-to-playlist/{playlistId}")
    public ResponseEntity<PlaylistDTO> addSongToPlaylist(@PathVariable Long songId,
            @PathVariable Long playlistId) {
        // Implement the logic to add a song to a playlist and return the updated playlist
    	playlistService.addSongToPlaylist(playlistService.getPlaylistById(playlistId).get(),songId);
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

    @GetMapping("/{playlistId}/get-playlist-songs")
    public ResponseEntity<List<Song>> getPlaylistById(@PathVariable Long playlistId) {
        // Implement the logic to retrieve a playlist by its ID and return it
    	return ResponseEntity.ok(playlistSongService.getPlaylistSongs(playlistId));
    }

    @GetMapping("/get-public-playlist")
    public ResponseEntity<List<PlaylistDTO>> getAllPlaylists() {
        // Implement the logic to retrieve all playlists and return them as a list
    	return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/get-user-playlist")
    public ResponseEntity<List<PlaylistDTO>> getUserPlaylists() {
        // Implement the logic to retrieve all playlists and return them as a list
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/song/{id}/favourite")
    public ResponseEntity<String> addSongToFavourite(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        favoriteService.createOrRemoveFavorite(username, id);
    	return ResponseEntity.ok("added to favourite");
    }
}
