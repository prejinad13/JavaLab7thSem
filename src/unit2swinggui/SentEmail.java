package unit2swinggui;

public class SentEmail {
    private final String recipient;
    private final String subject;
    private final String message;
    private final String attachment;

    public SentEmail(String recipient, String subject, String message, String attachment) {
        this.recipient = recipient;
        this.subject = subject;
        this.message = message;
        this.attachment = attachment;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getAttachment() {
        return attachment;
    }
}