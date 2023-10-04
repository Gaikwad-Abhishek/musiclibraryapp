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
@Table(name = "artist_song")
public class ArtistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_song_id")
    private Long artistSongId;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private User artist;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    private Long streams;
    
}
