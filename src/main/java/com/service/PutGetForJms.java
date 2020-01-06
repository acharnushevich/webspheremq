package com.service;

/*WebsphereMQ classes for Jms*/

import com.ibm.msg.client.jms.JmsConnectionFactory;
import com.ibm.msg.client.jms.JmsFactoryFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import com.service.type.*;

import javax.jms.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PutGetForJms {

    private static final String hostName = "hostName"; // Host name or IP address
    private static final int port = 1414; // Listener port for your queue manager
    private static final String user = "user"; // User name that application uses to connect to MQ
    private static final String password = "password"; // Password that the application uses to connect to MQ
    private static final String channel = "CONN"; // Channel name
    private static final String qManager = "QM"; // Queue manager name
    private static final String qName = "QUEUE"; // Queue that the application uses to put and get messages to and from

    public static void main(String[] args) {
        try {
            JmsFactoryFactory ff = JmsFactoryFactory.getInstance(WMQConstants.WMQ_PROVIDER);
            JmsConnectionFactory cf = ff.createConnectionFactory();

            cf.setStringProperty(WMQConstants.WMQ_HOST_NAME, hostName);
            cf.setIntProperty(WMQConstants.WMQ_PORT, port);
            cf.setStringProperty(WMQConstants.WMQ_CHANNEL, channel);
            cf.setIntProperty(WMQConstants.WMQ_CONNECTION_MODE, WMQConstants.WMQ_CM_CLIENT);
            cf.setStringProperty(WMQConstants.WMQ_QUEUE_MANAGER, qManager);
            cf.setBooleanProperty(WMQConstants.USER_AUTHENTICATION_MQCSP, true);
            cf.setStringProperty(WMQConstants.USERID, user);
            cf.setStringProperty(WMQConstants.PASSWORD, password);

            JMSContext context = cf.createContext();
            Destination destination = context.createQueue("queue:///" + qName);

            String requestE = setRequestE();
            TextMessage message = context.createTextMessage(requestE);
            JMSProducer producer = context.createProducer();
            producer.send(destination, message);

            JMSConsumer consumer = context.createConsumer(destination);
            String receivedMessage = consumer.receiveBody(String.class, 15000);

            System.out.println("This mess:\n" + receivedMessage);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    private static String setRequestE(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        REQUESTELEMENT requestelement = new REQUESTELEMENT();
        SYSTEME systeme = new SYSTEME();
        DATAE datae = new DATAE();
        DATAE.MESSAGE message = new DATAE.MESSAGE();

        systeme.setREQUESTID(UUID.randomUUID().toString());
        systeme.setREPLYID("Id");

        message.setPERSONID("Id");
        message.setDATE(formatter.format(new Date()));
        message.setTEXT("Text");

        datae.setMESSAGE(message);
        requestelement.setSYSTEM(systeme);
        requestelement.setDATA(datae);

        return convertXmlToString(requestelement, REQUESTELEMENT.class);
    }

    public static String convertXmlToString(Object request, Class cl) {
        JAXBContext jaxbContext = null;
        String mess = "";
        try {
            jaxbContext = JAXBContext.newInstance(cl);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(request, sw);
            mess = sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return mess;
    }
}