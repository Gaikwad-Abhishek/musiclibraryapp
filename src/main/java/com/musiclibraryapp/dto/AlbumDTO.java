package com.musiclibraryapp.dto;

import java.util.List;

public class AlbumDTO {
    private String albumName;
    private Long albumLength;
    private Long numOfSongs;
    private List<SongDTO> albumSongs;

    // Constructors, getters, setters, and other methods

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

