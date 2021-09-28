package inheritance.inheritance.tut.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sms_notification")
@Data
public class SmsNotification extends Notification{

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
}
