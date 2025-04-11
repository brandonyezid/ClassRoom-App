package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttendanceRepositories extends JpaRepository<Attendance, Integer> {
}
