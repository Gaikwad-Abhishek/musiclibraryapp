package com.musiclibraryapp.dto;

public class SongDTO {
    private String songTitle;
    private Double songDuration;
    private Long streams;

    // Constructors, getters, setters, and other methods

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

}

