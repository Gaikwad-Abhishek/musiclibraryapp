package com.musiclibraryapp.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "playlist_id")
    private Long playlistId;

    private String playlistName;

    private String playlistDescription;

    private Long numOfSongs;

    private Double lengthOfPlaylist;
 
    private boolean visibility;

    @ManyToOne
    @JoinColumn(name = "id")
    private User userId;

    @CreationTimestamp
    private Date createdAt;


}

