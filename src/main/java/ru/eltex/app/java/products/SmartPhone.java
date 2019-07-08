package ru.eltex.app.java.products;
import ru.eltex.app.java.enums.*;
import java.util.UUID;

public class SmartPhone extends Electronics {
    private SimType simType;
    private SimVal valSim;
    public SmartPhone(){
        setTitle(Title.SMARTPHONE);
        id= UUID.randomUUID();
    }
    public SmartPhone(boolean a) {
        if(a) {
            setTitle(Title.SMARTPHONE);
            id = UUID.randomUUID();
            create();

        }
    }

    public SmartPhone(SimType simType, SimVal valSim, int price, Firm firm, String mark, OS os){
        id= UUID.randomUUID();
        this.simType =simType;
        this.valSim=valSim;
        setFirm(firm);
        setMark(mark);
        setTitle(Title.MOBILEPHONE);
        setOs(os);
        setPrice(price);
    }


    @Override
    public void create() {
        counter++;
        simType= SimType.class.getEnumConstants()[(int)((Math.random())*SimType.class.getEnumConstants().length)];
        valSim=SimVal.class.getEnumConstants()[(int)((Math.random())*SimVal.class.getEnumConstants().length)];
        setFirm(Firm.class.getEnumConstants()[(int)((Math.random())*Firm.class.getEnumConstants().length)]);
        setMark("1");
        setOs(OS.class.getEnumConstants()[(int)((Math.random())*OS.class.getEnumConstants().length)]);
        setPrice((int)(Math.random()*50000));
    }

    @Override
    public void read() {
        System.out.println("ID: "+id+"\nНазвание: "+getTitle()+"\nФирма: "+getFirm()+"\nМодель: "+getMark()+"\nОперационная система: "+getOs()+"\nТип симкарты:"+simType+"\nКоличество симкарт: "+valSim+"\nЦена: "+getPrice()+" руб");

    }

    @Override
    public void update() {
        try {
            System.out.println("Введите фирму(APPLE, SAMSUNG, NOKIA)");
            setFirm(Firm.valueOf(in.nextLine()));
            System.out.println("Введите модель");
            setMark(in.nextLine());
            System.out.println("Введите операционную систему(ANDROID, IOS, NONE;)");
            setOs(OS.valueOf(in.nextLine()));
            System.out.println("Введите тип симкарты(NORMAL, MICRO");
            simType=SimType.valueOf(in.nextLine());
            System.out.println("Введите количество симкарт(ONE, TWO)");
            valSim=SimVal.valueOf(in.nextLine());
            System.out.println("Введите цену");
            setPrice(in.nextInt());
            System.out.println("Записано");
            in.nextLine();
        }catch (IllegalArgumentException e){
            System.out.println("Введены невозможные данные");
        }
    }

    @Override
    public void delete() {
        counter--;
        id= null;
        simType = null;
        valSim=null;
        setFirm(null);
        setMark(null);
        setTitle(null);
        setOs(null);
        setPrice(0);
    }
}
