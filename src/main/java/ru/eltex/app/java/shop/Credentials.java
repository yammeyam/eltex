package ru.eltex.app.java.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.UUID;
@JsonAutoDetect
public class Credentials implements Serializable {
    public Credentials() {
        id =UUID.randomUUID();
        surname="Surname";
        name="Name";
        patronymic="Patronymic";
        email="Email";
    }

    public Credentials(String surname, String name, String patronymic, String email) {
        id =UUID.randomUUID();
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.email = email;
    }



    private UUID id;//ID
    private String surname;//Фамилия
    private String name;//Имя
    private String patronymic;//Отчество
    private String email;//e-mail
    public void printCred(){
        System.out.println("ID: "+id+"\nФамилия: "+surname+"\nИмя "+name+"\nОтчество: "+patronymic+"\ne-mail: "+email+"\n");
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
