package com.musiclibraryapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musiclibraryapp.dto.AlbumDTO;
import com.musiclibraryapp.dto.SearchDTO;
import com.musiclibraryapp.entity.ArtistSong;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.service.AlbumService;
import com.musiclibraryapp.service.ArtistSongService;
import com.musiclibraryapp.service.DirectorSongService;
import com.musiclibraryapp.service.SongService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    SongService songService;

    @Autowired
    ArtistSongService artistSongService;

    @Autowired
    DirectorSongService directorSongService;

    @Autowired
    AlbumService albumService;


    @PostMapping("/by")
    public ResponseEntity<List> serchBy(@RequestBody SearchDTO searchDTO){
        System.out.println("#####################################");
        System.out.println("Song name- " + searchDTO.getSearchTitle());
        List DummyList = new ArrayList<>();
        if(searchDTO.getSearchBy().equals("Song")){
            return ResponseEntity.status(HttpStatus.OK).body(searchBySong(searchDTO.getSearchTitle()));
        }
        if(searchDTO.getSearchBy().equals("Artist")){
            return ResponseEntity.status(HttpStatus.OK).body(searchByArtist(searchDTO.getSearchTitle()));
        }
        if(searchDTO.getSearchBy().equals("Album")){
            return ResponseEntity.status(HttpStatus.OK).body(searchByAlbum(searchDTO.getSearchTitle()));
        }
        if(searchDTO.getSearchBy().equals("Director")){
            return ResponseEntity.status(HttpStatus.OK).body(searchByDirector(searchDTO.getSearchTitle()));
        }
  
        return ResponseEntity.status(HttpStatus.OK).body(DummyList);
    }

    public List searchBySong(String searchTitle){
        System.out.println("Inside search by song");
        List allSong = new ArrayList<>();
        allSong = songService.searchSongsByPartialTitle(searchTitle);
        return allSong;
    }

    public List searchByArtist(String searchTitle){
        System.out.println("Inside search by artist");
        List allSong = new ArrayList<>();
        allSong = artistSongService.findSongsByPartialArtistName(searchTitle);
        return allSong;
    }

    @GetMapping("/genre/{genreId}")
    public List<Song> getSongByGenre(@PathVariable Long genreId){
//    	return songService.getSongbyGenre(genreId);
//    	return songService.getAllSongs();
        return songService.getSongsByGenreId(genreId);
    }
    
    public List searchByDirector(String searchTitle){
        System.out.println("Inside search by director");
        List allSong = new ArrayList<>();
        allSong = directorSongService.findSongsByPartialDirectorName(searchTitle);
        return allSong;
    }

    public List searchByAlbum(String searchTitle){
        System.out.println("Inside search by Album");
        List allAlbum = new ArrayList<>();
        allAlbum = albumService.findTop5AlbumsByPartialAlbumName(searchTitle);
        return allAlbum;
    }



    
}
