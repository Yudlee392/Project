/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yudlee
 */
public class Message {
    private String messageContent;
    private Message messageNext;
    public Message (String messageContent){
        this.messageContent = messageContent;
        this.messageNext = null;
    }
    public String getMessageContent(){
        return messageContent;
    }
    public void setMessageContent(String messageContent){
        this.messageContent = messageContent;
    }
    public Message getMessageNext(){
        return messageNext;
    }
    public void setMessageNext(Message messageNext){
        this.messageNext = messageNext;
    }
}
