package ru.eltex.app.java.shop;

import java.io.Serializable;
import java.util.UUID;

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
}
