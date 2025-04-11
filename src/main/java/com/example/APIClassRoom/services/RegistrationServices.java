package com.example.APIClassRoom.services;

import com.example.APIClassRoom.helpers.MensajesAPI;
import com.example.APIClassRoom.models.Registration;
import com.example.APIClassRoom.repositories.IRegistrationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServices {

    @Autowired // inyección de dependencias
    IRegistrationRepositories repositorye;

    // guardar
    public Registration saveRegistration(Registration dataRegistration) throws Exception {
        try {
            return this.repositorye.save(dataRegistration);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // modificar
    public Registration modifyRegistration(Integer id, Registration dataRegistration) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repositorye.findById(id);

            if (registrationSearch.isPresent()) {
                registrationSearch.get().setRegistrationDate(dataRegistration.getRegistrationDate());
                // Puedes modificar más campos aquí si es necesario
                return this.repositorye.save(registrationSearch.get());
            } else {
                throw new Exception("registro no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar por id
    public Registration searchRegistrationById(Integer id) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repositorye.findById(id);
            if (registrationSearch.isPresent()) {
                return registrationSearch.get();
            } else {
                throw new Exception(MensajesAPI.REGISTRATION_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar todos
    public Iterable<Registration> searchAllRegistrations() throws Exception {
        try {
            return this.repositorye.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar
    public String deleteRegistration(Integer id) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repositorye.findById(id);
            if (registrationSearch.isPresent()) {
                this.repositorye.deleteById(id);
                return "Registro eliminado correctamente";
            } else {
                throw new Exception(MensajesAPI.REGISTRATION_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
