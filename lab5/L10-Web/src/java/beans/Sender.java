/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.Resource;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author MkSavin
 */
@ApplicationScoped
public class Sender implements SenderLocal {

    @Resource(mappedName = "amqmsg")
    private Queue queue;

    @Inject
    private JMSContext context;

    public void sendMessage(String txt) {
        context.createProducer().send(queue, txt);
    }
    
}
