package pl.kfrak;

public class MessageDisplayer {
    private String message = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void displayText() {
        System.out.println(this.getMessage());
    }
}