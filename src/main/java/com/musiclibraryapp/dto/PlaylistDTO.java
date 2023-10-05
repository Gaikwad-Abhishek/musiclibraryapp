package com.musiclibraryapp.dto;

import java.util.Date;
import java.util.List;

import com.musiclibraryapp.entity.User;

public class PlaylistDTO {
    private Long playlistId;
    private String playlistName;
    private String playlistDescription;
    private Long numOfSongs;
    private Double lengthOfPlaylist;
    private boolean visibility;
    private User user;
    private Date createdAt;
    private List<SongDTO> songs;

    // Constructors, getters, setters, and other methods

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescription) {
        this.playlistDescription = playlistDescription;
    }

    public Long getNumOfSongs() {
        return numOfSongs;
    }

    public void setNumOfSongs(Long numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public Double getLengthOfPlaylist() {
        return lengthOfPlaylist;
    }

    public void setLengthOfPlaylist(Double lengthOfPlaylist) {
        this.lengthOfPlaylist = lengthOfPlaylist;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }
}
