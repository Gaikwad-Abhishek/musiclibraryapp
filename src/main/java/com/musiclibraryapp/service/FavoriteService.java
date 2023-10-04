package com.musiclibraryapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musiclibraryapp.entity.Favorite;
import com.musiclibraryapp.repository.FavoriteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;

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

    public Favorite createFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
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

