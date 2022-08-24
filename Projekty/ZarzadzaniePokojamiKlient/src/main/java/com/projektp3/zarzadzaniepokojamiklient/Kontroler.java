package com.projektp3.zarzadzaniepokojamiklient;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Kontroler
{
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToTabelaBudynkow(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("TabelaBudynkow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,700,700);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMainMenu(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,700,700);
        stage.setScene(scene);
        stage.show();
    }
}
