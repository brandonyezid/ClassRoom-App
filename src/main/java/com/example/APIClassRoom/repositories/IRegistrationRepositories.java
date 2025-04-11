package com.example.APIClassRoom.repositories;

import jakarta.servlet.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationRepositories extends JpaRepository<Registration, Integer> {
}
