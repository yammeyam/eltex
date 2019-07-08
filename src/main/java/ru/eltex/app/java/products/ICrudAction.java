package ru.eltex.app.java.products;

public interface ICrudAction {
    //Заполнение объекта случайными значениями и инкремент счётчика
    void create ();

    //Bывод данных на экран
    void read();

    //Ввод данных с клавиатуры
    void update();

    //Принудительное зануление данных в объекте и декремент счетчика.
    void delete ();
}
