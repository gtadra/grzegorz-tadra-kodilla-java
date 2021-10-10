package com.kodilla.exception.nullpointer;

public class NullPointerExceptionRunner {

    public static void main(String[] args){
        User user = null;
        MessageSender messageSender = new MessageSender();

        try {
            messageSender.sendMessageTo(user, "Hallo");
        }catch (MessageNotSentExceptation e){
            System.out.println("Message not send! " + e);
        }
        System.out.println("END");
    }
}
