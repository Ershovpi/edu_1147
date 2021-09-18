import java.util.Scanner;

/*
 *  ***Гостиница***
 *  1) Гостиница
 *  2) Номера (кол-во мест(1-3), сан.узел(есть/нет), питание(есть/нет), wifi(есть/нет), свободен/занят)
 *
 *   *Задание для лабораторной работы №4*
 *   Освободить комнату
 *   Вывести свойства комнаты
 *   Показать комнаты с WiFi
 *   Показать комнаты с WC
 *   Показать комнаты с Eat
 *   Показать комнаты по кол-ву спальных мест
 *   Отобразить список команд
 * */
public class Main {
    public static void main(String[] args) {
        Room[] rooms = {
                new Room((byte) 1,false,false,true,(byte) 11),
                new Room((byte) 2,true,true,false,(byte) 12),
                new Room((byte) 1,false,true,true,(byte) 13),
                new Room((byte) 3,true,false,false,(byte) 21),
                new Room((byte) 2,false,false,false,(byte) 22),
                new Room((byte) 1,true,true,true,(byte) 23),
                new Room((byte) 3,false,true,false,(byte) 31),
                new Room((byte) 3,true,true,false,(byte) 32),
                new Room((byte) 1,false,false,true,(byte) 33),
        };
        Hotel hotel = new Hotel(rooms);
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите команду");
            command = scanner.nextLine();
            if(command.equals("getFreeRooms")){
                hotel.getFreeRooms();
            }else if (command.equals("getWifiRooms")){
                hotel.getWifiRooms();
            }else if (command.equals("getWcRooms")){
                hotel.getWcRooms();
            }else if (command.equals("getEatRooms")){
                hotel.getEatRooms();
            }else if (command.equals("getSleepRooms")){
                System.out.print("Введите количество спальных комнат: ");
                byte roomQuantity = (byte) scanner.nextInt();
                hotel.getSleepRooms(roomQuantity);
            }else if (command.equals("getRoomFeatures")){
                System.out.print("Введите номер комнаты: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.getRoomFeatures(roomNumber);
            }else if(command.equals("reserveRoom")) {
                System.out.print("Введите номер комнаты для бронирования: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.reserveRoom(roomNumber);
            }else if(command.equals("freeRoom")){
                System.out.print("Введите номер освобождаемой комнаты: ");
                byte roomNumber = (byte) scanner.nextInt();
                hotel.freeRoom(roomNumber);
            }else if (command.equals("exit")){
                break;
            }else if (command.equals("")){

            }else {
                if (!command.equals("help"))
                    System.out.println("Неверная команда. Список возможных команд:");
                String help = "*----*\n" +
                        "getFreeRooms - показать все свободные номера\n" +
                        "getWifiRooms - показать все номера c WiFi\n"+
                        "getWcRooms - показать все номера c туалетом\n"+
                        "getEatRooms - показать все номера c едой\n"+
                        "getSleepRooms - показать все номера c указанным количеством комнат\n"+
                        "getRoomFeatures - показать свойства номера\n"+
                        "reserveRoom - забронировать номер\n" +
                        "freeRoom - забронировать номер\n" +
                        "exit - выход из программы\n" +
                        "help - вывод подсказки по командам\n" +
                        "*----*";
                System.out.println(help);
            }
        }

    }
}
