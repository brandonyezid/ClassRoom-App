package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Student;
import com.example.APIClassRoom.repositories.IStudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServices {

    @Autowired // inyección de dependencias
    IStudentRepositories repositori;

    // guardar
    public Student saveStudent(Student dataStudent) throws Exception {
        try {
            return this.repositori.save(dataStudent);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // modificar
    public Student modifyStudent(Integer id, Student dataStudent) throws Exception {
        try {
            Optional<Student> studentSearch = this.repositori.findById(id);

            if (studentSearch.isPresent()) {
                studentSearch.get().setGrade(dataStudent.getGrade()); // modificando un campo viejo
                return this.repositori.save(studentSearch.get());
            } else {
                throw new Exception("estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar por id
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repositori.findById(id);
            if (studentSearch.isPresent()) {
                return studentSearch.get();
            } else {
                throw new Exception("estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar todos
    public Iterable<Student> searchAllStudents() throws Exception {
        try {
            return this.repositori.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar
    public String deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repositori.findById(id);
            if (studentSearch.isPresent()) {
                this.repositori.deleteById(id);
                return "Estudiante eliminado correctamente";
            } else {
                throw new Exception("estudiante no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
