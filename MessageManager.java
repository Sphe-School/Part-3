import java.util.ArrayList;

public class MessageManager {

    private ArrayList<Message> messages = new ArrayList<>();

    public void addMessage(Message msg) {
        messages.add(msg);
    }

    public void displayAllMessages() {

        if(messages.isEmpty()){
            System.out.println("No messages found.");
            return;
        }

        for(Message msg : messages){
            System.out.println("--------------------");
            System.out.println(msg.printMessage());
        }
    }

    public void displayLongestMessage() {

        if(messages.isEmpty()){
            System.out.println("No messages available.");
            return;
        }

        Message longest = messages.get(0);

        for(Message msg : messages){
            if(msg.getMessage().length() >
               longest.getMessage().length()){
                longest = msg;
            }
        }

        System.out.println("\nLongest Message:");
        System.out.println(longest.printMessage());
    }

    public Message searchByID(int id){

        for(Message msg : messages){

            if(msg.getMessageID() == id){
                return msg;
            }
        }

        return null;
    }

    public void searchByRecipient(String recipient){

        boolean found = false;

        for(Message msg : messages){

            if(msg.getRecipientCell().equals(recipient)){
                System.out.println(msg.printMessage());
                found = true;
            }
        }

        if(!found){
            System.out.println("No messages found.");
        }
    }

    public boolean deleteByHash(String hash){

        for(int i = 0; i < messages.size(); i++){

            if(messages.get(i)
                .getMessageHashValue()
                .equals(hash)){

                messages.remove(i);
                return true;
            }
        }

        return false;
    }
}
