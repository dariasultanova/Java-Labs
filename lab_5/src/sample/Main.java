package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.InputStream;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Lab5");
        Group root = new Group();
        Scene scene = new Scene(root, 450, 400, Color.LAVENDER);
        stage.setScene(scene);

        Button[] buttons = new Button[4];
        for(int i = 0; i < 4; i++) {
            buttons[i] = new Button();
        }
        for(int i = 0; i < 4; i++) {
            buttons[i].setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        }

        int y = 0;
        for(int i = 0; i < 4; i++) {
            y += 70;
            buttons[i].setLayoutY(y);
        }
        buttons[0].setLayoutX(152);
        buttons[1].setLayoutX(126);
        buttons[2].setLayoutX(100);
        buttons[3].setLayoutX(146);

        buttons[0].setText("Lab 1. Students");
        buttons[1].setText("Lab 2. Exchange Rates");
        buttons[2].setText("Lab 3. Trainer and Sportsman");
        buttons[3].setText("Lab 4. Decrement");

        for(int i = 0; i < 4; i++) {
            root.getChildren().add(buttons[i]);
        }

        Button backButton = new Button();
        backButton.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 18));
        backButton.setLayoutX(20);
        backButton.setLayoutY(350);
        backButton.setText("Menu");
        backButton.setOnAction(event -> {
            root.getChildren().clear();
            for(int i = 0; i < 4; i++)
                root.getChildren().add(buttons[i]);
        });


        buttons[0].setOnAction(event -> {
            root.getChildren().clear();

            Label newLabel = new Label();
            newLabel.setText("Input number of students and month number.\nFor example: 20 7");
            newLabel.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            newLabel.setLayoutX(20);
            newLabel.setLayoutY(10);

            TextField textField = new TextField();
            textField.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textField.setLayoutX(20);
            textField.setLayoutY(50);

            TextArea textArea = new TextArea();
            textArea.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textArea.setLayoutX(20);
            textArea.setLayoutY(100);
            textArea.setPrefRowCount(13);
            textArea.setPrefColumnCount(28);

            textField.setOnAction(event1 -> {
                try {
                    String in = textField.getText();
                    String[] args = new String[2];
                    for (int i = 0; i < 2; i++) {
                        args[i] = "";
                    }

                    if (in.contains(" ")){
                        args[0] = in.substring(0, in.indexOf(" "));
                        args[1] = in.substring(in.indexOf(" ") + 1);
                    }

                    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "C:/Users/Дарья/Desktop/Java/javalabs/5var/lab_5/lab1.jar", args[0], args[1]);
                    Process process = processBuilder.start();
                    InputStream inputStream = process.getInputStream();
                    InputStream errorStream = process.getErrorStream();

                    process.waitFor();

                    String out = new String(inputStream.readAllBytes());
                    String err = new String(errorStream.readAllBytes());

                    if (err.isEmpty()) {
                        textArea.setStyle("-fx-text-fill: black;");
                        textArea.setText(out);
                    } else {
                        textArea.setStyle("-fx-text-fill: red;");
                        textArea.setText(err);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root.getChildren().addAll(newLabel, textField, backButton, textArea);
        });


        buttons[1].setOnAction(event -> {
            root.getChildren().clear();

            Label newLabel = new Label();
            newLabel.setText("Input currency, transaction and amount.\nFor example: USD BUY 50");
            newLabel.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            newLabel.setLayoutX(20);
            newLabel.setLayoutY(10);

            TextField textField = new TextField();
            textField.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textField.setLayoutX(20);
            textField.setLayoutY(50);

            TextArea textArea = new TextArea();
            textArea.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textArea.setLayoutX(20);
            textArea.setLayoutY(100);
            textArea.setPrefRowCount(13);
            textArea.setPrefColumnCount(28);

            textField.setOnAction(event1 -> {
                try {
                    String in = textField.getText();
                    String[] args = new String[3];
                    for (int i = 0; i < 3; i++) {
                        args[i] = "";
                    }

                    if (in.contains(" ")){
                        args[0] = in.substring(0, in.indexOf(" "));
                        args[1] = in.substring(in.indexOf(" ") + 1, in.indexOf(" ", in.indexOf(" ") + 1));
                        args[2] = in.substring(in.indexOf(" ", in.indexOf(" ") + 1) + 1);
                    }

                    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "C:/Users/Дарья/Desktop/Java/javalabs/5var/lab_5/lab2.jar", args[0], args[1], args[2]);
                    Process process = processBuilder.start();
                    InputStream inputStream = process.getInputStream();
                    InputStream errorStream = process.getErrorStream();

                    process.waitFor();

                    String out = new String(inputStream.readAllBytes());
                    String err = new String(errorStream.readAllBytes());

                    if (err.isEmpty()) {
                        textArea.setStyle("-fx-text-fill: black;");
                        textArea.setText(out);
                    } else {
                        textArea.setStyle("-fx-text-fill: red;");
                        textArea.setText(err);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root.getChildren().addAll(newLabel, textField, backButton, textArea);
        });


        buttons[2].setOnAction(event -> {
            root.getChildren().clear();

            Label newLabel = new Label();
            newLabel.setText("Input number of tasks.\nFor example: 20");
            newLabel.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            newLabel.setLayoutX(20);
            newLabel.setLayoutY(10);

            TextField textField = new TextField();
            textField.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textField.setLayoutX(20);
            textField.setLayoutY(50);

            TextArea textArea = new TextArea();
            textArea.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textArea.setLayoutX(20);
            textArea.setLayoutY(100);
            textArea.setPrefRowCount(13);
            textArea.setPrefColumnCount(28);

            textField.setOnAction(event1 -> {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "C:/Users/Дарья/Desktop/Java/javalabs/5var/lab_5/lab3.jar", textField.getText());
                    Process process = processBuilder.start();
                    InputStream inputStream = process.getInputStream();
                    InputStream errorStream = process.getErrorStream();

                    process.waitFor();

                    String out = new String(inputStream.readAllBytes());
                    String err = new String(errorStream.readAllBytes());

                    if (err.isEmpty()) {
                        textArea.setStyle("-fx-text-fill: black;");
                        textArea.setText(out);
                    } else {
                        textArea.setStyle("-fx-text-fill: red;");
                        textArea.setText(err);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root.getChildren().addAll(newLabel, textField, backButton, textArea);
        });


        buttons[3].setOnAction(event -> {
            root.getChildren().clear();

            Label newLabel = new Label();
            newLabel.setText("Input number of threads and decrement number.\nFor example: 5 15");
            newLabel.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            newLabel.setLayoutX(20);
            newLabel.setLayoutY(10);

            TextField textField = new TextField();
            textField.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textField.setLayoutX(20);
            textField.setLayoutY(50);

            TextArea textArea = new TextArea();
            textArea.setFont(Font.font("serif", FontWeight.NORMAL, FontPosture.REGULAR, 14));
            textArea.setLayoutX(20);
            textArea.setLayoutY(100);
            textArea.setPrefRowCount(13);
            textArea.setPrefColumnCount(28);

            textField.setOnAction(event1 -> {
                try {
                    String in = textField.getText();
                    String[] args = new String[2];
                    for (int i = 0; i < 2; i++) {
                        args[i] = "";
                    }

                    if (in.contains(" ")){
                        args[0] = in.substring(0, in.indexOf(" "));
                        args[1] = in.substring(in.indexOf(" ") + 1);
                    }

                    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "C:/Users/Дарья/Desktop/Java/javalabs/5var/lab_5/lab4.jar", args[0], args[1]);
                    Process process = processBuilder.start();
                    InputStream inputStream = process.getInputStream();
                    InputStream errorStream = process.getErrorStream();

                    process.waitFor();

                    String out = new String(inputStream.readAllBytes());
                    String err = new String(errorStream.readAllBytes());

                    if (err.isEmpty()) {
                        textArea.setStyle("-fx-text-fill: black;");
                        textArea.setText(out);
                    } else {
                        textArea.setStyle("-fx-text-fill: red;");
                        textArea.setText(err);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            root.getChildren().addAll(newLabel, textField, backButton, textArea);
        });

        stage.show();
    }
}
