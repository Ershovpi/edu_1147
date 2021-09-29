package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(8188);
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Подключился новый клиент");
                User currentUser = new User(socket);
                users.add(currentUser);
                currentUser.setOut(new DataOutputStream(currentUser.getSocket().getOutputStream()));
                currentUser.setIn(new DataInputStream(currentUser.getSocket().getInputStream()));
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String text;
                        try {
                            String userName;
                            Boolean isUsed = false;
                            currentUser.getOut().writeUTF("Ваше имя: ");
                            userName = currentUser.getIn().readUTF();
                            for (User user : users)
                                    while (userName.equals(user.getUserName())) {
                                        currentUser.getOut().writeUTF("Такое имя уже есть, введите другое");
                                        userName = currentUser.getIn().readUTF();
                                    }
                            currentUser.setUserName(userName);
                            for (User user : users) {
                                user.getOut().writeUTF("К чату присоединился "+currentUser.getUserName());
                            }

                            while (true) {
                                text = currentUser.getIn().readUTF();
                                if(text.equals("/onlineUsers")) {
                                    String names = "Пользователи онлайн: ";
                                    for (User user : users) {
                                        names += user.getUserName() + ", ";
                                    }
                                    currentUser.getOut().writeUTF(names); // Отправили список
                                }else if (text.indexOf("/m")==0){
                                    String[] splittedText = text.split(" ");
                                    for (User user : users)
                                        if(user.getUserName().equals(splittedText[1])){
                                            user.getOut().writeUTF("Лично от "+currentUser.getUserName()+": "+splittedText[2]);
                                            break;
                                        }
                                }else{
                                    // Рассылка сообщения
                                    System.out.println(currentUser.getUserName()+": " + text);
                                    for (User user : users) {
                                        if (currentUser.getUuid().equals(user.getUuid())) continue;
                                        user.getOut().writeUTF(currentUser.getUserName()+": " + text);
                                    }
                                }
                            }
                        } catch (IOException exception) {
                            users.remove(currentUser);
                            for (User user : users) {
                                try {
                                    user.getOut().writeUTF(currentUser.getUserName()+" покинул чат");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(currentUser.getUserName()+" покинул чат");
                        }
                    }
                });
                thread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
