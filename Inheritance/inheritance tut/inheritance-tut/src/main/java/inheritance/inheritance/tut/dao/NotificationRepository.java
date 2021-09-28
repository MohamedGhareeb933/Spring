package inheritance.inheritance.tut.dao;

import inheritance.inheritance.tut.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
