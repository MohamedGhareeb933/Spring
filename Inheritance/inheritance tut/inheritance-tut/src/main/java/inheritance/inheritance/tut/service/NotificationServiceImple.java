package inheritance.inheritance.tut.service;


import inheritance.inheritance.tut.dao.NotificationRepository;
import inheritance.inheritance.tut.entity.Notification;
import inheritance.inheritance.tut.sender.NotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationServiceImple implements NotificationService{

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private List<NotificationSender> notificationSenders;

    private Map<Class<? extends Notification>, NotificationSender>
            notificationSenderMap = new HashMap<>();

    @PostConstruct
    @SuppressWarnings( "unchecked" )
    public void init() {
        for ( NotificationSender notificationSender : notificationSenders ) {
            notificationSenderMap.put(
                    notificationSender.appliesTo(),
                    notificationSender
            );
        }
        
    }

    @Override
    @Transactional
    @SuppressWarnings( "unchecked" )
    public void sendCampaign(String name, String message) {
        List<Notification> notifications = notificationRepository.findAll();

        for ( Notification notification : notifications ) {
            notificationSenderMap
                    .get( notification.getClass() )
                    .send( notification );
        }
    }
}
