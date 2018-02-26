package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML public TextField operation;
    public static String MainContent = "";
    public static String content = "";
    public char[][] SpecialOperators = {{'%', '/'}, {'x', '*'}};

    @Override
    public void initialize(URL location, ResourceBundle resources) { }

    public void Simple(ActionEvent event) {
        CheckError();
        String number = getNumber(event);

        content += number;
        MainContent += number;
        operation.setText(content);


    }

    public void Complex(ActionEvent event) {
        CheckError();
        String Operator = getNumber(event);
        for(int i=0;i<2;i++) {

            if(String.valueOf(SpecialOperators[i][0]).equals(Operator)) {
                content += Operator;
                MainContent += Operator.replace(SpecialOperators[i][0], SpecialOperators[i][1]);

            }
        }
        operation.setText(content);

    }

    public void CheckError() {
        if(content.equals("SYNTAXERROR")) {
            content = "";
            MainContent = "";
        }
    }

    public void Equal(ActionEvent event) {
        try {
            execute e = new execute();
            e.getResult(operation);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    public void Reset(ActionEvent event) {
        operation.setText("");
        MainContent = "";
        content = "";
    }

    public void BackSpace(ActionEvent event) {
         char[] MainArr = MainContent.toCharArray();
         char[] contentArr = content.toCharArray();
         MainContent = RemoveLast(MainArr);

         content = RemoveLast(contentArr);
         operation.setText(content);
    }

    public String RemoveLast(char[] Arr) {
        String string = "";
        for(int i=0;i<Arr.length-1;i++) {
            string += String.valueOf(Arr[i]);
        }

        return string;
    }

    public String getNumber(ActionEvent event) {
        String val = event.getSource().toString();
        return String.valueOf(val.charAt(val.length()-2));
    }
}
