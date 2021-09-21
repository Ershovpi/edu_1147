public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ольга", "Иванова", 70, null, null);
        Person person2 = new Person("Николай", "Иванов", 68, null, null);
        Person person3 = new Person("Светлана", "Петрова", 77, null,null);
        Person person4 = new Person("Станислав", "Петров", 76, null, null);
        Person person5 = new Person("Иван", "Иванов", 38, person1, person2);
        Person person6 = new Person("Ирина", "Иванова", 35, person3, person4);
        Person person7 = new Person("Василий", "Иванов", 12, person6, person5);

        person1.info();
        person2.info();
        person3.info();
        person4.info();
        person5.info();
        person6.info();
        person7.info();
    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private Person mother;
    private Person father;
    Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }

    void info(){
        String info = "Меня зовут "+this.name+", мне "+this.age+" лет\n";

        if(this.mother != null){
            info += "Мою маму зовут "+this.mother.name+", ей "+this.mother.age+" лет\n";
            if(this.mother.father != null){
                info += "Моего дедушку по маминой линии зовут "+this.mother.father.name+", ему "+this.mother.father.age+" лет\n";
            }
            if(this.mother.mother != null){
                info += "Мою бабушку по маминой линии зовут "+this.mother.mother.name+", ей "+this.mother.mother.age+" лет\n";
            }
        }
        if(this.father != null){
            info += "Моего отца зовут "+this.father.name+", ему "+this.father.age+" лет\n";
            if(this.father.father != null){
                info += "Моего дедушку по папиной линии зовут "+this.father.father.name+", ему "+this.father.father.age+" лет\n";
            }
            if(this.father.mother != null){
                info += "Мою бабушку по папиной линии зовут "+this.father.mother.name+", ей "+this.father.mother.age+" лет\n";
            }
        }

        System.out.println(info);
    }
}
