package com.sd.Assignment3.controller;

import com.sd.Assignment3.AllReplies;
import com.sd.Assignment3.RPCClient;
import com.sd.Assignment3.Reply;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class JavaFXController {

    private static LocalDateTime localDateTime;
    private static boolean newDay;
    private int minutes;

    @FXML
    private TableView<Reply> tableView;
    @FXML
    private TableColumn<Reply, String> patient;
    @FXML
    private TableColumn<Reply, String> medication;
    @FXML
    private TableColumn<Reply, String> startDate;
    @FXML
    private TableColumn<Reply, String> endDate;
    @FXML
    private TableColumn<Reply, String> dosage;
    @FXML
    private TableColumn<Reply, String> intakeTime;
    @FXML
    private Button takeMedication;
    @FXML
    private Label time;

    @FXML
    public void initialize() {
        patient.setCellValueFactory(new PropertyValueFactory<Reply, String>("name"));
        medication.setCellValueFactory(new PropertyValueFactory<Reply, String>("medicationName"));
        startDate.setCellValueFactory(new PropertyValueFactory<Reply, String>("startDate"));
        endDate.setCellValueFactory(new PropertyValueFactory<Reply, String>("endDate"));
        dosage.setCellValueFactory(new PropertyValueFactory<Reply, String>("dosage"));
        intakeTime.setCellValueFactory(new PropertyValueFactory<Reply, String>("intakeInterval"));
        localDateTime = LocalDateTime.now();
        minutes = 30;
        newDay = true;
        Timeline date = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    localDateTime = localDateTime.plusMinutes(minutes);
                    System.out.println(localDateTime.toString());
                }));
        date.setCycleCount(Animation.INDEFINITE);
        date.play();

        Timeline setClock = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    time.setText("Time: " + localDateTime.getYear() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getDayOfMonth() + " " +
                            localDateTime.getHour() + ":" + localDateTime.getMinute() + ":" + localDateTime.getSecond());
                }));
        setClock.setCycleCount(Animation.INDEFINITE);
        setClock.play();

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {

                    if(newDay){
                        RPCClient client = new RPCClient("localhost", 50051);
                        ObservableList<Reply> obsListAllReplies = tableView.getItems();
                        List<Reply> listAllReplies = new ArrayList<>(obsListAllReplies);
                        AllReplies replies = AllReplies.newBuilder().addAllRepliesList(listAllReplies).build();
                        System.out.println(client.greetTrans(replies));
                        try {
                            ObservableList<Reply> list = FXCollections.observableArrayList();
                            AllReplies allReplies = client.greet(localDateTime.getYear() + "-" + localDateTime.getMonthValue() + "-" + localDateTime.getDayOfMonth());
                            for(int i = 0; i < allReplies.getRepliesListCount(); i++){
                                Reply reply = allReplies.getRepliesList(i);
                                String[] tokens = reply.getIntakeInterval().split(",");

                                String[] hours = new String[2];
                                int cnt = 0;
                                Pattern p = Pattern.compile("\\d+");
                                Matcher m = p.matcher(tokens[0]);
                                while (m.find()) {
                                    hours[cnt++] = m.group();
                                }
                                if(cnt != 0){
                                    Reply.Builder builder = reply.toBuilder();
                                    builder = builder.setIntakeInterval(hours[0] + "-" + hours[1]);
                                    reply = builder.build();
                                    list.add(reply);
                                    cnt = 0;
                                }
                                m = p.matcher(tokens[1]);
                                while (m.find()) {
                                    hours[cnt++] = m.group();
                                }
                                if(cnt != 0){
                                    Reply.Builder builder = reply.toBuilder();
                                    builder = builder.setIntakeInterval(hours[0] + "-" + hours[1]);
                                    reply = builder.build();
                                    list.add(reply);
                                    cnt = 0;
                                }
                                m = p.matcher(tokens[2]);
                                while (m.find()) {
                                    hours[cnt++] = m.group();
                                }
                                if(cnt != 0){
                                    Reply.Builder builder = reply.toBuilder();
                                    builder = builder.setIntakeInterval(hours[0] + "-" + hours[1]);
                                    reply = builder.build();
                                    list.add(reply);
                                }
                            }
                            System.out.println(list.toString());
                            tableView.setItems(list);

                        } finally {
                            try {
                                client.shutdown();
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                        }
                        newDay = false;
                    }

                    if(localDateTime.getHour() == 23 && localDateTime.getMinute() >= 60 - minutes)
                        newDay = true;
                }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void takeMedication(){
        ObservableList<Reply> replies;
        ObservableList<Reply> allReplies;

        replies = tableView.getSelectionModel().getSelectedItems();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(replies.get(0).getIntakeInterval());
        m.find();
        int hours1 = Integer.parseInt(m.group());
        m.find();
        int hours2 = Integer.parseInt(m.group());

        if(hours1 <= localDateTime.getHour() && localDateTime.getHour() <= hours2) {
            allReplies = tableView.getItems();

            ObservableList<Reply> repliesToShow = FXCollections.observableArrayList();
            for (Reply reply : allReplies) {
                if (!reply.getName().equals(replies.get(0).getName()) || !reply.getIntakeInterval().equals(replies.get(0).getIntakeInterval()))
                    repliesToShow.add(reply);
            }

            RPCClient client = new RPCClient("localhost", 50051);
            System.out.println(client.greetPositiveTrans(replies.get(0)));

            try {
                client.shutdown();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            tableView.setItems(repliesToShow);
        }
    }

}