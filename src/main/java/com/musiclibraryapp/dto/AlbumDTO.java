package com.musiclibraryapp.dto;

import java.util.Date;
import java.util.List;

import com.musiclibraryapp.entity.User;

public class AlbumDTO {
    private String albumName;
    private Long albumLength;
    private Long numOfSongs;
    private Long streams;  
    private User artist; 
    private Date createdAt;

    private List<SongDTO> albumSongs;

    // Constructors, getters, setters, and other methods

    public Long getStreams() {
        return streams;
    }

    public void setStreams(Long streams) {
        this.streams = streams;
    }

    public User getArtist() {
        return artist;
    }

    public void setArtist(User artist) {
        this.artist = artist;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Long getAlbumLength() {
        return albumLength;
    }

    public void setAlbumLength(Long albumLength) {
        this.albumLength = albumLength;
    }

    public Long getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(Long numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public List<SongDTO> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(List<SongDTO> albumSongs) {
        this.albumSongs = albumSongs;
    }
}

