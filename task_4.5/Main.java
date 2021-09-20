/*
Создать абстрактный класс Animal с характеристиками животного.
Создать класс Horse который наследуется от Animal, в классе Horse реализовать метод public void run(){ System.out.println("Игого, я поскакал(а)"); }
Создать класс Pegasus который наследуется от Horse, в классе Pegasus реализовать метод public void fly(){ System.out.println("Игого, я полетел(а)"); }
Создать объект лошади и вызвать метод run();
Создать объект пегаса и вызвать метод fly();
*/

public class Main{
    public static void main(String[] args) {
        Horse mustang = new Horse("Мустанг", "Рысак", 4);
        mustang.run();
        Pegasus pegasus = new Pegasus("Летун", "Птиц", 3);
        pegasus.fly();
    }
}

abstract class Animal {
    String nickname;
    String breed;
    int age;
    public Animal(String nickname, String breed, int age) {
        this.nickname = nickname;
        this.breed = breed;
        this.age = age;
    }
}

class Horse extends Animal{
    public Horse(String nickname, String breed, int age) {
        super(nickname, breed, age);
    }
    public void run(){
        System.out.println("Иго-го, я поскакал");
    }
}

class Pegasus extends Horse{
    public Pegasus(String nickname, String breed, int age) {
        super(nickname, breed, age);
    }
    public void fly(){
        System.out.println("Иго-го, я полетел");
    }
}
