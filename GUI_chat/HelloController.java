package com.example.gui_chat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.ObjectInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class HelloController {
    DataOutputStream out;
    ArrayList<String> usersName = new ArrayList<>();
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField;
    @FXML
    private TextArea onlineUsersTextArea;
    @FXML
    private Button connectBtn;

    @FXML // Обрабтчик кнопки Отправить
    protected void handlerSend(){
        String text = textField.getText();
        try {
            out.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        textArea.appendText(text+"\n");
        textField.clear(); // Очистить textField
        // Запретить редактирование в textArea
          // в hello-view
        // Нужно добавлять текст, а не заменять
    }
    @FXML
    protected void handlerConnection(){
        try {
            Socket socket = new Socket("127.0.0.1", 8188);
            // Поток ввода
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            // Поток вывода
            out = new DataOutputStream(socket.getOutputStream());
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true){
                            String response = "";
                            Object object = ois.readObject();
                            if(object.getClass().equals(usersName.getClass())){
                                usersName = (ArrayList<String>) object;
                                onlineUsersTextArea.clear();
                                for(String username : usersName){
                                    onlineUsersTextArea.appendText(username+"\n");
                                }
                            }else {
                                response = object.toString();
                                textArea.appendText(response+"\n");
                            }
                            /*String response = in.readUTF();*/
                            }
                    }catch (Exception e){
                        System.out.println("Соединение разорвано");
                    }
                }
            });
            thread.start();
            connectBtn.setDisable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}  
