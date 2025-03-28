package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Teacher;
import com.example.APIClassRoom.repositories.ITeacherRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServices {

    @Autowired //inyeccion de dependecia
    ITeacherRepositories repository;

    //en el servicio creamos los metodos necesarios segun los servivios a ofrecer

    //guardar
    public Teacher guardarDocente(Teacher dataTeacher) throws Exception{
        try{
            return this.repository.save(dataTeacher);
        }catch (Exception mistake){

            throw  new Exception(mistake.getMessage());

        }

    }

    //modificar
    //buscar por id
    //buscar todos
    //eliminar
}
