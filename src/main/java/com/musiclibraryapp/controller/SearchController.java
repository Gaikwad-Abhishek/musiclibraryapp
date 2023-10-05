package com.musiclibraryapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.AlbumDTO;
import com.musiclibraryapp.dto.SearchDTO;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.service.SongService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    SongService songService;


    @PostMapping("/by")
    public ResponseEntity<List> serchBySong(@RequestBody SearchDTO searchDTO){
        System.out.println("Song name- " + searchDTO.getSearchTitle());
        List allSong = new ArrayList<>();
        allSong = songService.searchSongsByPartialTitle(searchDTO.getSearchTitle());
        return ResponseEntity.status(HttpStatus.OK).body(allSong);
    }

    
    
}
