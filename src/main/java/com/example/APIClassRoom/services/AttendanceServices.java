package com.example.APIClassRoom.services;

import com.example.APIClassRoom.helpers.MensajesAPI;
import com.example.APIClassRoom.models.Attendance;
import com.example.APIClassRoom.repositories.IAttendanceRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttendanceServices {

    @Autowired
    IAttendanceRepositories repositories;

    //guardar
    public Attendance saveAttendance(Attendance dataAttendance) throws Exception {
        try {
            return this.repositories.save(dataAttendance);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    //modificar
    public Attendance modifyAttendance(Integer id, Attendance dataAttendance) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.repositories.findById(id);

            if (attendanceSearch.isPresent()) {
                attendanceSearch.get().setDate(dataAttendance.getDate()); // modificando un dato viejo
                return this.repositories.save(attendanceSearch.get());
            } else {
                throw new Exception(MensajesAPI.ATTENDANCE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Attendance searchAttendanceById(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.repositories.findById(id);
            if (attendanceSearch.isPresent()) {
                return attendanceSearch.get();
            } else {
                throw new Exception(MensajesAPI.ATTENDANCE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos
    public Iterable<Attendance> searchAllAttendances() throws Exception {
        try {
            return this.repositories.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar
    public String deleteAttendance(Integer id) throws Exception {
        try {
            Optional<Attendance> attendanceSearch = this.repositories.findById(id);
            if (attendanceSearch.isPresent()) {
                this.repositories.deleteById(id);
                return "Asistencia eliminada correctamente";
            } else {
                throw new Exception(MensajesAPI.ATTENDANCE_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
