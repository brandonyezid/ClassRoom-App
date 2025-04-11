package com.example.APIClassRoom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositories extends JpaRepository<User, Integer> {
}
