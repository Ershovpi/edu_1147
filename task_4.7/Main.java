/*
Реализуй в классе Fox интерфейс Animal.
Учти, что создавать дополнительные классы и удалять методы нельзя!

Требования:
•	Интерфейс Animal должен быть реализован в классе Fox.
•	В интерфейсе Animal нужно объявить метод getColor.
•	Дополнительные классы или интерфейсы создавать нельзя.
*/

public class Main {
    public static void main(String[] args){
        Fox fox = new Fox("лиса",4, "цвет");
        System.out.println("Лиса "+fox.getName()+" "+fox.getColor());
    }
}

interface Animal{
    String getColor();
    String getName();
}

class Fox implements Animal{
    public Fox(String nickname, int age, String color) {}
    @Override
    public String getName() {
        return "Патрикеевна";
    }
    @Override
    public String getColor() {
        return "рыжая";
    }
}
