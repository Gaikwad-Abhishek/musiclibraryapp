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
@Table(name = "director_song")
public class DirectorSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "director_song_id")
    private Long directorSongId;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private User director;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    private Long streams;
    
}
