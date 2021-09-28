package inheritance.inheritance.tut.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "email_notification")
@Data
public class EmailNotification extends Notification {

    @Column(name = "email", nullable = false)
    private String email;
}
