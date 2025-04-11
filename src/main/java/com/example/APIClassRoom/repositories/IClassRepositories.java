package com.example.APIClassRoom.repositories;
import com.example.APIClassRoom.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepositories extends JpaRepository<Class, Integer> {


}
