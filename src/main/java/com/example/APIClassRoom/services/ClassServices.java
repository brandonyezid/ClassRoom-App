package com.example.APIClassRoom.services;

import com.example.APIClassRoom.helpers.MensajesAPI;
import com.example.APIClassRoom.models.Class;
import com.example.APIClassRoom.repositories.IClassRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // Esta anotación registra el servicio en el contenedor de Spring
public class ClassServices {

    @Autowired
    IClassRepositories repositories;

    // GUARDAR una clase
    public Class saveClass(Class dataClass) throws Exception {
        try {
            return this.repositories.save(dataClass);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // MODIFICAR una clase
    public Class modifyClass(Integer id, Class dataClass) throws Exception {
        try {
            Optional<Class> classSearch = this.repositories.findById(id);
            if (classSearch.isPresent()) {
                classSearch.get().setName(dataClass.getName()); // Modificamos el nombre, puedes añadir más
                return this.repositories.save(classSearch.get());
            } else {
                throw new Exception(MensajesAPI.CLASS_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR por ID
    public Class searchClassById(Integer id) throws Exception {
        try {
            Optional<Class> classSearch = this.repositories.findById(id);
            if (classSearch.isPresent()) {
                return classSearch.get();
            } else {
                throw new Exception(MensajesAPI.CLASS_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // BUSCAR todas las clases
    public Iterable<Class> searchAllClasses() throws Exception {
        try {
            return this.repositories.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // ELIMINAR una clase
    public String deleteClass(Integer id) throws Exception {
        try {
            Optional<Class> classSearch = this.repositories.findById(id);
            if (classSearch.isPresent()) {
                this.repositories.deleteById(id);
                return "Clase eliminada correctamente";
            } else {
                throw new Exception("clase no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
