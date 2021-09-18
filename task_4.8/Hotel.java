public class Hotel {
    Room[] rooms;

    public Hotel(Room[] rooms) {
        this.rooms = rooms;
    }

    public void getFreeRooms(){
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isFree()) RoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера свободных комнат "+RoomsList);
    }
    public void getWifiRooms(){
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWifi()) RoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с WiFi "+RoomsList);
    }
    public void getWcRooms(){
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isWc()) RoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с туалетом "+RoomsList);
    }
    public void getEatRooms(){
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isEat()) RoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера комнат с едой "+RoomsList);
    }
    public void getSleepRooms(byte roomQuantity){
        String RoomsList = "";
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getQuantity()==roomQuantity) RoomsList += rooms[i].getRoomNumber()+", ";
        }
        System.out.println("Номера c количеством спальных мест "+roomQuantity+": "+RoomsList);
    }
    public void getRoomFeatures(byte roomNumber){
        System.out.println("\nСвойства комнаты номер "+roomNumber);
        System.out.println("-------------------------");
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                System.out.println("Количество комнат: " + room.getQuantity()+"\n"+
                                   "Туалет" + (room.isWc()?" есть":"а нет")+"\n"+
                                   "Еда "+(!room.isEat()?"не ":"")+"включена"+"\n"+
                                   "WiFi " + (room.isWifi()?"есть":"нет")+"\n");
            }
        }
    }
    public void reserveRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                room.setFree(false);
                info = ("Комната номер "+roomNumber+" успешно забронирована");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                info = "Комната "+roomNumber+" занята";
                break;
            }
        }
        System.out.println(info);
    }

    public void freeRoom(byte roomNumber){
        String info = "Такой комнаты не существует";
        for (int i = 0; i < rooms.length; i++) {
            Room room = rooms[i];
            if(room.getRoomNumber() == roomNumber && room.isFree()){
                info = ("Комната номер "+roomNumber+" не занята");
                break;
            }else if(room.getRoomNumber() == roomNumber && !room.isFree()){
                room.setFree(true);
                info = "Комната "+roomNumber+" освобождена";
                break;
            }
        }
        System.out.println(info);
    }
}
