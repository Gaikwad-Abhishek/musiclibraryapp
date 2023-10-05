package com.musiclibraryapp.dto;

import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Album;
import com.musiclibraryapp.entity.Genre;
import com.musiclibraryapp.entity.Song;

@Service
public class EntityDTOMapper {
	
	public Song convertToSong(Album album,SongDTO songDTO) {
	    
	        Song song = new Song();
	        song.setSongId(songDTO.getSongId());
	        song.setSongTitle(songDTO.getSongTitle());
	        song.setSongDuration(songDTO.getSongDuration());
	        song.setStreams(songDTO.getStreams());

	        if (songDTO.getGenre() != null) {
	            Genre genre = new Genre();
	            genre.setGenreName(songDTO.getGenre().getGenreName()); // Assuming Genre has a setter for genreName
	            song.setGenreId(genre);
	        }

//	        if (songDTO.getAlbum() != null) {
//	            Album album = new Album();
//	            album.setAlbumName(songDTO.getAlbum().getAlbumName()); // Assuming Album has a setter for albumName
//	            album.setAlbumLength(songDTO.getAlbum().getAlbumLength()); // Assuming Album has a setter for albumLength
//	            album.setNumOfSongs(songDTO.getAlbum().getNumOfSongs()); // Assuming Album has a setter for numOfSongs
//	            song.setAlbumId(album);
//	        }
	        song.setAlbumId(album);

	        song.setCreatedAt(songDTO.getCreatedAt());

	        return song;
	    }
}

