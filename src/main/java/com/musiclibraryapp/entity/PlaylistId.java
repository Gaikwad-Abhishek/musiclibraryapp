package com.musiclibraryapp.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class PlaylistId implements Serializable {
    private Long playlistId;
    private Long userId;

    // Constructors, getters, and setters
}

