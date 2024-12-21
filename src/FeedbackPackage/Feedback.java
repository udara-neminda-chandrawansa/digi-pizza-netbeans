package FeedbackPackage;

public class Feedback {
    private String feedback_id;
    private String user_id;
    private String order_id;
    private String feedback_text;
    
    public Feedback(String feedbackID, String userID, String order_id, String feedbackText){
        this.feedback_id = feedbackID;
        this.user_id = userID;
        this.order_id = order_id;
        this.feedback_text = feedbackText;
    }
    
    // getters
    
    public String getID(){
        return this.feedback_id;
    }
    
    public String getUserID(){
        return this.user_id;
    }
    
    public String getOrderID(){
        return this.order_id;
    }
    
    public String getText(){
        return this.feedback_text;
    }
}


interface FeedbackCommand {
    void execute();
}

class CreateFeedbackCommand implements FeedbackCommand {
    private Feedback feedback;
    private String feedback_id;
    private String user_id;
    private String order_id;
    private String feedback_text;


    public CreateFeedbackCommand(Feedback feedback, String feedbackID, String userID, String orderID, String feedbackText) {
        this.feedback = feedback;
        this.user_id = userID;
        this.feedback_id = feedbackID;
        this.order_id = orderID;
        this.feedback_text = feedbackText;
    }

    @Override
    public void execute() {
        feedback = new Feedback(feedback_id, user_id, order_id, feedback_text);
        System.out.println("Feedback Created: " + feedback_id);
    }
}


class FeedbackInvoker {
    private FeedbackCommand command;

    public void setCommand(FeedbackCommand command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}