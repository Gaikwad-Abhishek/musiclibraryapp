package com.musiclibraryapp.entity;

import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long songId;

    private String songTitle;

    private Double songDuration;

    private Long streams;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genreId;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album albumId;

    @CreationTimestamp
    private Date createdAt;
}