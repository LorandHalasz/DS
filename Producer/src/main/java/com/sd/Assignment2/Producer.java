package com.sd.Assignment2;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
public class Producer {

    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.queue}")
    private String queueName;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    @Autowired
    public Producer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Scheduled(fixedDelay = 1000L)
    public void produceMsg(){
        List<Integer> patients= new ArrayList<>();
        patients.add(3);
        patients.add(4);
        patients.add(9);
        patients.add(10);
        Random rand = new Random();
        Integer randomPatient = null;

        File file = new File("./src/main/resources/activity.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                randomPatient = patients.get(rand.nextInt(patients.size()));
                st = st.replaceAll("\\s{2,}", "*").trim();
                String[] tokens = st.split("\\*");

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                try {
                    Date start = formatter.parse(tokens[0]);
                    Date end = formatter.parse(tokens[1]);

                    final CustomMessage message = new CustomMessage(randomPatient, tokens[2], start.getTime(), end.getTime());
                    amqpTemplate.convertAndSend(exchange, routingKey, message);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Fisierul lipseste");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException");
        }
    }
}