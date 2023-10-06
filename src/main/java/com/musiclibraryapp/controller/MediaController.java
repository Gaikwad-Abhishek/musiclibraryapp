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

import com.musiclibraryapp.dto.AlbumDTO;
import com.musiclibraryapp.dto.SongDTO;
import com.musiclibraryapp.entity.Album;
import com.musiclibraryapp.entity.Genre;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.repository.AlbumRepository;
import com.musiclibraryapp.service.AlbumService;
import com.musiclibraryapp.service.GenreService;
import com.musiclibraryapp.service.SongService;
import com.musiclibraryapp.service.UserService;

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

    @Autowired
    UserService userService;
	
	@Autowired
	GenreService genreService;
	
	@PostMapping("/create-album")
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
       
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
		Album newAlbum = albumService.createAlbum(username,albumDTO);
		songService.createSong(newAlbum,albumDTO.getAlbumSongs());
		return ResponseEntity.noContent().build();
    }

    @PostMapping("{albumId}/delete")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long albumId) {
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/{songId}/delete")
    public ResponseEntity<Void> deleteSong(@PathVariable Long songId) {
    	return ResponseEntity.noContent().build();
    }

    @PostMapping("/{songId}/update")
    public ResponseEntity<SongDTO> updateSong(
            @PathVariable Long songId,
            @RequestBody SongDTO updatedSong) {
    	return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/get-genre")
    public ResponseEntity<List<Genre>> getGenre(){
    	return ResponseEntity.ok(genreService.getAllGenres());
    }

    @GetMapping("/artist")
    public ResponseEntity<List<User>> getArtist(){
    	return ResponseEntity.ok(userService.getAllUsers());
    }
}
