package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.dto.EntityDTOMapper;
import com.musiclibraryapp.dto.SongDTO;
import com.musiclibraryapp.dto.UserDTO;
import com.musiclibraryapp.entity.Album;
import com.musiclibraryapp.entity.Genre;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.repository.SongRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    private final SongRepository songRepository;
    
    @Autowired
    EntityDTOMapper dtoMapper;

    @Autowired
    UserService userService;

    @Autowired
    ArtistSongService artistSongService;

    @Autowired
    DirectorSongService directorSongService;
    
    @Autowired
    GenreService genreService;
    
    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Optional<Song> getSongById(Long songId) {
        return songRepository.findById(songId);
    }

    public Song createSong(Song song) {
        return songRepository.save(song);
    }
    
    public boolean createSong(Album album,List<SongDTO> songs) {
        User user = album.getArtistId();
    	
    	for(SongDTO songDTO : songs) {
    		
    		Song song = new Song();
	        song.setSongId(songDTO.getSongId());
	        song.setSongTitle(songDTO.getSongTitle());
	        song.setSongDuration(songDTO.getSongDuration());
	        song.setStreams(songDTO.getStreams());
	        song.setGenreId(genreService.getGenreById(songDTO.getGenreId()).get());
	        song.setAlbumId(album);
	        System.out.println(songDTO.getArtist());
    		songRepository.save(song);
//    		for(UserDTO artist: songDTO.getArtist()) {
//    			artistSongService.createArtistSong(artist, song);
//    			System.out.println(artist);
//    		}
            artistSongService.createArtistSong(user, song);
            System.out.println("director name - " +songDTO.getDirectorName() );
            if(songDTO.getDirectorName() != null && !songDTO.getDirectorName().isEmpty()){
                directorSongService.createDirectorSong(userService.getByName(songDTO.getDirectorName()).get(), song);
            }
            else{
                directorSongService.createDirectorSong(user, song);
            }
    	}
        
    	return true;
    }

    public Song updateSong(Long songId, Song updatedSong) {
        Optional<Song> existingSong = songRepository.findById(songId);

        if (existingSong.isPresent()) {
            updatedSong.setSongId(existingSong.get().getSongId());
            return songRepository.save(updatedSong);
        } else {
            throw new IllegalArgumentException("Song not found with ID: " + songId);
        }
    }

    public void deleteSong(Long songId) {
        songRepository.deleteById(songId);
    }

    public List<Song> searchSongsByPartialTitle(String partialTitle) {
        //return songRepository.findByPartialSongTitle(partialTitle);
        return songRepository.findByPartialSongTitleWithTop2Streams(partialTitle);
    }
    
//    public List<Song> getSongbyGenre(Long genreId){
//    	return songRepository.findSongWithGenreId(genreId);
//    }

    public List<Song> getSongsByGenreId(long genreId) {
        return songRepository.findByGenreId(genreService.getGenreById(genreId).get());
    }

    public List<Song> getSongBySongTitle(String songName) {
        return songRepository.findBySongTitle(songName);
    }
}
