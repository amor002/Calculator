package sample;

import javafx.scene.control.TextField;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class execute {

    private Scanner result;
    private BufferedWriter python;

    public execute() throws Exception{

        result = new Scanner(new File("result.txt"));
        python = new BufferedWriter(new FileWriter("python.py"));

        String Code = "from sys import argv\n" +
                "script, operation = argv\n" +
                "with open('result.txt', 'w') as file:\n" +
                "   try:\n" +
                "      exec('res = ' + operation)\n" +
                "      file.write(str(res))\n" +
                "   except:\n" +
                "      file.write('SYNTAX ERROR')";
        python.write(Code);
        python.close();

    }

    public void getResult(TextField MainScreen) throws Exception {
        System.out.println("before result:" +Controller.MainContent);
        Runtime.getRuntime().exec("python3 python.py " + Controller.MainContent).waitFor();
        String res = "";

        while(result.hasNext()) {
            res += result.next();
        }

        MainScreen.setText(res);
        Controller.MainContent = res;
        Controller.content = res;
    }

}
