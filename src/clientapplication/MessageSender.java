package clientapplication;

public interface MessageSender {

    void submitMessage(Message msg);

//метод для оповещения о новом пользователе
    void submitUser (String [] msg);

}
