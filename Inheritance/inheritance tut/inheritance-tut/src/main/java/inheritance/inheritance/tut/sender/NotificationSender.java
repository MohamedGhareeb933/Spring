package inheritance.inheritance.tut.sender;

import inheritance.inheritance.tut.entity.Notification;

public interface NotificationSender<T extends Notification> {

    public Class< ? extends Notification > appliesTo();

    public void send(Notification notification);
}
