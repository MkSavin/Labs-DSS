/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

/**
 *
 * @author MkSavin
 */
//
//@MessageDriven(activationConfig = {
//    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "amqmsg"),
//    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//})
public class Reciever implements MessageListener {
    
    @Resource(mappedName = "amqmsg")
    private Queue amqmsg;

    @javax.inject.Inject
    @JMSConnectionFactory("amqres")
    private JMSContext context;

    public static List<String> messages = new ArrayList<String>();

    @Override
    public void onMessage(Message rcvMessage) {
        try {
            messages.add(((TextMessage) rcvMessage).getText());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void sendJMSMessageToAmqmsg(String messageData) {
        context.createProducer().send(amqmsg, messageData);
    }

}
