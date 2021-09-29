import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:/java/ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1){
                if(i==13) continue; // Возврат каретки, то пропускаем иттерацию
                else if(i == 10){ // Перенос строки
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    result = "";
                    CheckProxy checkProxy = new CheckProxy (ip, port);
                    checkProxy.start();
                }else if(i==9) { // Табуляция
                    result += ":";
                }else{ // Остальные символы
                    result += (char) i;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

class CheckProxy extends Thread {
    String ip;
    int port;

    // Конструктор
    public CheckProxy (String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    // Метод checkProxy принимает на вход ip и port которые мы читаем построчно из файла
    // Результат выводит на экран
    // Если ip рабочий, то сервер нам его возваращает
    // Если нет, то случается Exception и мы пишем на экран, что ip не работает!
    private void checkProxy(String ip, int port){
        try {
            // Создаём объект прокси
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip,port));
            // Указываем, к какому ресурсу нужно подключиться, данный ресурс https://vozhzhaev.ru/test.php
            // в ответ всегда отдаст вам ip
            URL url = new URL("https://vozhzhaev.ru/test.php");
            // Открываем соединение
            URLConnection URLConnection = url.openConnection(proxy);
            // Сохраняем ответ в поток ввода
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(URLConnection.getInputStream())
            );
            // Переменная, в которую в формате строки кладём ответ от сервера
            String inputLine;
            // Читаем ответ от сервера, пока не встретится null
            while ((inputLine = in.readLine()) != null) {
                System.out.println("IP: " + inputLine + " - работает!");
                String outputText = ip + ":" + port+"\n";
                byte [] buffer = outputText.getBytes();
                FileOutputStream fos = new FileOutputStream ("c:/java/good_ip.txt", true);
                fos.write(buffer);
                fos.close();
            }
            // Закрываем поток ввода
            in.close();

        } catch (IOException e) {
            // Если ip не доступен, то будет Exception, но мы его обрабатываем и выводим инфо на экран
            System.out.println("IP: "+ip+" не работает!");
        }
    }
    @Override
    public void run() {
        this.checkProxy(this.ip, this.port);
    }
}
