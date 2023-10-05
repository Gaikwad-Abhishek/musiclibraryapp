package com.musiclibraryapp.dto;

import java.util.Date;
import java.util.List;

import com.musiclibraryapp.entity.User;

public class SongDTO {
    
	private Long songId;  
    private String songTitle;
    private Double songDuration;
    private Long streams;
    private Long genreId;
    private List<UserDTO> aristList;
    private AlbumDTO album;  
    private Date createdAt;
    

    // Constructors, getters, setters, and other methods

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public Double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(Double songDuration) {
        this.songDuration = songDuration;
    }

    public Long getStreams() {
        return streams;
    }

    public void setStreams(Long streams) {
        this.streams = streams;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public AlbumDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDTO album) {
        this.album = album;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setArtist(List<UserDTO> artistList){
    	this.aristList = artistList;
    }
    
    public List<UserDTO> getArtist(){
    	return aristList;
    }
}

