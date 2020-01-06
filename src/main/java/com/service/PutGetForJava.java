package com.service;

/*WebsphereMQ classes for Java*/

import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import com.service.type.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PutGetForJava {
    private static final String hostName = "hostName"; // Host name or IP address
    private static final int port = 1414; // Listener port for your queue manager
    private static final int CCSID = 1208; // Coded character set identifier
    private static final String user = "user"; // User name that application uses to connect to MQ
    private static final String password = "password"; // Password that the application uses to connect to MQ
    private static final String channel = "CONN"; // Channel name
    private static final String qManager = "QM"; // Queue manager name
    private static final String qName = "QUEUE"; // Queue that the application uses to put and get messages to and from

    public static void main(String args[]) {
        try {
            MQEnvironment.hostname = hostName;
            MQEnvironment.port = port;
            MQEnvironment.channel = channel;
            MQEnvironment.userID = user;
            MQEnvironment.password = password;
            MQEnvironment.CCSID = CCSID;

            MQQueueManager qMgr = new MQQueueManager(qManager);
            int openOptions = MQConstants.MQOO_OUTPUT;
            MQQueue queue = qMgr.accessQueue(qName, openOptions);

            MQMessage msg = new MQMessage();
            msg.characterSet = 1208;
            msg.format = MQC.MQFMT_STRING;
            String msgString = setRequestA();
            msg.writeString(msgString);

            MQPutMessageOptions pmo = new MQPutMessageOptions();
            queue.put(msg, pmo);

            try {
                ReadMessage(qName, qMgr);
            } catch (Exception e) {
                e.printStackTrace();
            }

            queue.close();
            qMgr.disconnect();
        } catch (MQException ex) {
            ex.printStackTrace();
            System.out.println("A WebSphere MQ Error occurred : Completion Code " + ex.completionCode + " Reason Code " + ex.reasonCode);
        } catch (java.io.IOException ex) {
            System.out.println("An IOException occurred whilst writing to the message buffer: " + ex);
        }
    }

    public static void ReadMessage(String queueName, MQQueueManager qMgr) throws Exception {
        int options = MQC.MQOO_INQUIRE + MQC.MQOO_FAIL_IF_QUIESCING + MQC.MQOO_INPUT_SHARED;

        MQQueue myQueue = qMgr.accessQueue(queueName, options);

        MQMessage mgMessage = new MQMessage();
        MQGetMessageOptions gmo = new MQGetMessageOptions();
        gmo.options = MQC.MQGMO_NO_WAIT + MQC.MQGMO_FAIL_IF_QUIESCING;
        gmo.matchOptions = MQC.MQMO_NONE;
        gmo.waitInterval = 15000;

        myQueue.get(mgMessage, gmo);
        int length = mgMessage.getMessageLength();
        System.out.println("This mess:\n" + mgMessage.readStringOfByteLength(length));
    }

    private static String setRequestA() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        REQUESTATTRIBUTE requestattribute = new REQUESTATTRIBUTE();
        SYSTEMA systema = new SYSTEMA();
        DATAA dataa = new DATAA();
        DATAA.MESSAGE message = new DATAA.MESSAGE();

        SYSTEMA.REQUESTID requestid = new SYSTEMA.REQUESTID();
        requestid.setValue(UUID.randomUUID().toString());
        systema.setREQUESTID(requestid);

        SYSTEMA.REPLYID replyid = new SYSTEMA.REPLYID();
        replyid.setValue("Id");
        systema.setREPLYID(replyid);

        DATAA.MESSAGE.PERSONID personid = new DATAA.MESSAGE.PERSONID();
        personid.setValue("Id");
        message.setPERSONID(personid);

        DATAA.MESSAGE.DATE date = new DATAA.MESSAGE.DATE();
        date.setValue(formatter.format(new Date()));
        message.setDATE(date);

        DATAA.MESSAGE.TEXT text = new DATAA.MESSAGE.TEXT();
        text.setValue("Text");
        message.setTEXT(text);

        dataa.setMESSAGE(message);
        requestattribute.setSYSTEM(systema);
        requestattribute.setDATA(dataa);

        return convertXmlToString(requestattribute, REQUESTATTRIBUTE.class);
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
