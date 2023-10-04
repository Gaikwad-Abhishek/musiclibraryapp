package com.musiclibraryapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist_song")
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlistsong_id")
    private Long playlistSongId;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song songId;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlistId;
    
}
