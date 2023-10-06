package com.musiclibraryapp.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.musiclibraryapp.entity.User;


public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findByName(String name);

    List<User> findAll();
}