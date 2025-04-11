package com.example.APIClassRoom.helpers;

public enum MensajesAPI {

    TEACHER_NOT_FOUND("El docente que buscas no se encuentra en BD"),
    STUDENT_NOT_FOUND("El estudiante que busca no se encuentra en BD"),
    USER_NOT_FOUND("El usuario que busca no se encuentra en BD"),
    ATTENDANCE_NOT_FOUND("la asistencia que busca no se encuentra en BD"),
    COURSE_NOT_FOUND("El curso que busca no se encuentra en BD"),
    QUALIFICATION_NOT_FOUND("La calificacion que busca no se encuentra en BD"),
    REGISTRATION_NOT_FOUND("El registro que busca no se encuentra en BD"),
    CLASS_NOT_FOUND("La clase que busca no se encuentra en BD");
    private String text;

    MensajesAPI(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }



}
