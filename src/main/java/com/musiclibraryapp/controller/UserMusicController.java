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
import com.musiclibraryapp.service.UserService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/user-music")
// playlist - favorite
public class UserMusicController {

    @Autowired
    PlaylistService playlistService;

    @Autowired
    PlaylistSongService playlistSongService;

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    UserService userService;

    @PostMapping("/create-playlist")
    public ResponseEntity<Long> createPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Playlist createdPlaylist = playlistService.createPlaylist(userService.getByName(username).get(),playlistDTO);
        playlistService.addSonglistToPlaylist(createdPlaylist, playlistDTO);
        return ResponseEntity.ok(createdPlaylist.getPlaylistId());
    }

    @PostMapping("/song/{songId}/add-to/{playlistId}")
    public ResponseEntity<String> addSongToPlaylist(@PathVariable Long songId,
            @PathVariable Long playlistId) {
        playlistService.addSongToPlaylist(playlistService.getPlaylistById(playlistId).get(), songId);
        return ResponseEntity.ok("Song Added");
    }

    @PostMapping("/song/{songId}/remove-from/{playlistId}")
    public ResponseEntity<String> removeSongFromPlaylist(
            @PathVariable Long songId,
            @PathVariable Long playlistId) {
        playlistService.removeSongFromPlaylist(songId, playlistId);
        System.out.println(songId + " " + playlistId);
        return ResponseEntity.ok("Song Removed");
    }

    @PostMapping("/{playlistId}/update")
    public ResponseEntity<PlaylistDTO> updatePlaylist(
            @PathVariable Long playlistId,
            @RequestBody PlaylistDTO updatedPlaylist) {
       
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{playlistId}/get-playlist-songs")
    public ResponseEntity<List<Song>> getPlaylistById(@PathVariable Long playlistId) {
        return ResponseEntity.ok(playlistSongService.getPlaylistSongs(playlistId));
    }

    @GetMapping("/get-public-playlist")
    public ResponseEntity<List<Playlist>> getAllPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/get-user-playlist")
    public ResponseEntity<List<Playlist>> getUserPlaylists() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(playlistService.getUserPlaylist(userService.getByName(username).get()));
    }

    // @PostMapping("/song/{id}/favourite")
    // public ResponseEntity<String> addSongToFavourite(@PathVariable Long id) {
    // Authentication authentication =
    // SecurityContextHolder.getContext().getAuthentication();
    // String username = authentication.getName();
    // favoriteService.createOrRemoveFavorite(username, id);
    // return ResponseEntity.ok("added to favourite");
    // }

    @PostMapping("/song/{songName}/favourite")
    public ResponseEntity<String> addSongToFavourite(@PathVariable String songName) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        favoriteService.createOrRemoveFavorite(username, songName);
        return ResponseEntity.ok("added to favourite");

    }
}
