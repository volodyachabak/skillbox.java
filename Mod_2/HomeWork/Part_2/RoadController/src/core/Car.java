package core;

public class Car
{
    //Объект класа String
    public String number;
    //Переменная типа int
    public int height;
    //Переменная типа double
    public double weight;
    //Переменная типа boolean
    public boolean hasVehicle;
    //Переменная типа boolean
    public boolean isSpecial;

    public String toString()
    {
        //Объект класа String
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}