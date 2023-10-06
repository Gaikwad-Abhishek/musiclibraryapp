package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.dto.PlaylistDTO;
import com.musiclibraryapp.dto.SongDTO;
import com.musiclibraryapp.entity.Playlist;
import com.musiclibraryapp.entity.PlaylistSong;
import com.musiclibraryapp.repository.PlaylistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    
    @Autowired
    SongService songService;
    
    @Autowired
    PlaylistSongService playlistSongService;
    
    @Autowired
    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId);
    }

    public Playlist createPlaylist(PlaylistDTO playlistDTO) {
    	Playlist newplayPlaylist = new Playlist() ;
    	newplayPlaylist.setPlaylistName(playlistDTO.getPlaylistName());
    	newplayPlaylist.setPlaylistDescription(playlistDTO.getPlaylistDescription());
        return playlistRepository.save(newplayPlaylist);
    }
    
    public boolean addSonglistToPlaylist(Playlist playlist,PlaylistDTO playlistDTO) {
    	if(playlistDTO.getSongs() != null){
    	for(SongDTO addToplaylist: playlistDTO.getSongs()) {
    		
    		PlaylistSong addSong = new PlaylistSong();
    		addSong.setSongId(songService.getSongById(addToplaylist.getSongId()).get());
    		addSong.setPlaylistId(playlist);
    		playlistSongService.createPlaylistSong(addSong);
    		
    	}
    	return true;
        }
        return false;
    }
    
    public boolean addSongToPlaylist(Playlist playlist,Long songId) {
    	
    		PlaylistSong addSong = new PlaylistSong();
    		addSong.setSongId(songService.getSongById(songId).get());
    		addSong.setPlaylistId(playlist);
    		playlistSongService.createPlaylistSong(addSong);
    		
    	return true;
    }

    public boolean removeSongFromPlaylist(Long songId, Long PlaylistId){
        playlistSongService.deletePlaylistSong(songId,PlaylistId);
        return true;
    }


    public Playlist updatePlaylist(Long playlistId, Playlist updatedPlaylist) {
        Optional<Playlist> existingPlaylist = playlistRepository.findById(playlistId);

        if (existingPlaylist.isPresent()) {
            updatedPlaylist.setPlaylistId(existingPlaylist.get().getPlaylistId());
            return playlistRepository.save(updatedPlaylist);
        } else {
            throw new IllegalArgumentException("Playlist not found with ID: " + playlistId);
        }
    }

    public void deletePlaylist(Long playlistId) {
        playlistRepository.deleteById(playlistId);
    }
}
