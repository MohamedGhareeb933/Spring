package inheritance.inheritance.tut.sender;

import inheritance.inheritance.tut.entity.EmailNotification;
import inheritance.inheritance.tut.entity.Notification;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class EmailNotificationSender implements NotificationSender<EmailNotification>{

    protected final Logger logger =  Logger.getLogger(getClass().toString());

    @Override
    public Class<? extends Notification> appliesTo() {
        return EmailNotification.class;
    }

    @Override
    public void send(Notification notification) {
        logger.info(
                "Send Email " +
                notification.getFirstName() + " " +
                notification.getLastName()
        );
    }
}
