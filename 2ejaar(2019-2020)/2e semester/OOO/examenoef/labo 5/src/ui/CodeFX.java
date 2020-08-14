package ui;

import domain.codeContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javax.swing.*;

public class CodeFX {

    private Label firstText;
    private TextField input,result;

    private Button encode, decode;

    public CodeFX(GridPane root) {
        decode = new Button("decode");
        encode = new Button("encode");
        input = new TextField();
        firstText = new Label("Vul hieronder uw tekst in:");
        result = new TextField("restult");
        input.setPromptText("input");
        result.setEditable(false);
        final ComboBox classes = new ComboBox();
        classes.getItems().addAll(
                "Ceasarcode",
                "Spiegeling",
                "DennisCode"
        );
        classes.setValue("Ceasarcode");
        root.add(firstText,0,0);
        root.add(classes,1,0);
        root.add(input, 0,1);
        root.add(encode,0,2);
        root.add(decode,2,2);


        root.add(result,1,2);
        encode.setOnAction( event ->{
            String inputText = input.getText();
            codeContext c;
            if(classes.getValue().equals("Ceasarcode")) {
                c = new codeContext("Ceasarcode",Integer.parseInt(JOptionPane.showInputDialog("Hoeveel plaatsen?")));
            }else if( classes.getValue().equals("DennisCode") ){
                c = new codeContext("Dennis");
            }else{
                c = new codeContext("Spiegeling");
            }
            result.setText(c.encode(inputText));
        });

        decode.setOnAction( event ->{
            String inputText = input.getText();
            codeContext c;
            if(classes.getValue().equals("Ceasarcode")) {
                System.out.println("ok");
                c = new codeContext("Ceasarcode",Integer.parseInt(JOptionPane.showInputDialog("Hoeveel plaatsen?")));
            }else if( classes.getValue().equals("DennisCode") ){
                c = new codeContext("Dennis");
            }else{
                c = new codeContext("Spiegeling");
            }
            System.out.println(c);
            result.setText(c.decode(inputText));

        });



    }
}