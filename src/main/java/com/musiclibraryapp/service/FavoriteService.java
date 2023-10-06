package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Favorite;
import com.musiclibraryapp.entity.Song;
import com.musiclibraryapp.entity.User;
import com.musiclibraryapp.repository.FavoriteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

    @Autowired
    UserService userService;

    @Autowired
    SongService songService;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }

    public Optional<Favorite> getFavoriteById(Long favoriteId) {
        return favoriteRepository.findById(favoriteId);
    }

    // public void  createOrRemoveFavorite(String username, long songId) {
    //     User user = userService.getByName(username).get();
    //     Song song = songService.getSongById(songId).get();
    //     Favorite existingFavorite = favoriteRepository.findByUserAndSong(user, song);
    //     if (existingFavorite != null) {
    //         favoriteRepository.delete(existingFavorite);
    //     } else {
    //         Favorite newFavorite = new Favorite();
    //         newFavorite.setUser(user);
    //         newFavorite.setSong(song);
    //         favoriteRepository.save(newFavorite);
    //     }
    // }

    public void  createOrRemoveFavorite(String username, String songTitle) {
        User user = userService.getByName(username).get();
        Song song = songService.getSongBySongTitle(songTitle).get(0);
        Favorite existingFavorite = favoriteRepository.findByUserAndSong(user, song);
        if (existingFavorite != null) {
            favoriteRepository.delete(existingFavorite);
        } else {
            Favorite newFavorite = new Favorite();
            newFavorite.setUser(user);
            newFavorite.setSong(song);
            favoriteRepository.save(newFavorite);
        }

    }

    public Favorite updateFavorite(Long favoriteId, Favorite updatedFavorite) {
        Optional<Favorite> existingFavorite = favoriteRepository.findById(favoriteId);

        if (existingFavorite.isPresent()) {
            updatedFavorite.setFavoriteId(existingFavorite.get().getFavoriteId());
            return favoriteRepository.save(updatedFavorite);
        } else {
            throw new IllegalArgumentException("Favorite not found with ID: " + favoriteId);
        }
    }

    public void deleteFavorite(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
}

