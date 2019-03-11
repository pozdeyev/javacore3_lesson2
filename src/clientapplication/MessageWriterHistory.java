package clientapplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageWriterHistory {

    String fileName;
    String userSender;
    String userReceiver;
    String message;


    //Конструктор

    public  MessageWriterHistory (String fileName, String userSender, String userReceiver, String message)

    {   this.fileName = fileName;
        this.userSender = userSender;
        this.userReceiver =  userReceiver;
        this.message = message;
    }

    //Метод для записи истории в файл

    void messageWriter(String fileName, String userSender, String userReceiver, String message) throws IOException {

        //Время в обычном формате
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        Date currentDate = new Date();
        String time = sdf.format(currentDate);

        //Получаем разделитель в текущей операционной системе
        String fileSeparator = System.getProperty("file.separator");
        //Запоминаем относительный путь к файлу
        String relativePath = "history" + fileSeparator + fileName +".txt";


        File file = new File(relativePath);


        if (file.createNewFile()){
            System.out.println(relativePath + " файл создан");
        }else System.out.println("Файл " + relativePath + " уже существует в директории проекта");



        FileWriter fr = null;
        BufferedWriter br = null;

        try {
            //для обновления файла нужно инициализировать FileWriter с помощью этого конструктора
            fr = new FileWriter(file,true);
            br = new BufferedWriter(fr);


            br.newLine();
            br.write ("Date: " + time);
            br.newLine();
            br.write (userSender + " --> " + userReceiver);
            br.newLine();
            br.write(message);
            br.newLine();


        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



}
