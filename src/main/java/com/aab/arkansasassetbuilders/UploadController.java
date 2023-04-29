package com.aab.arkansasassetbuilders;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.DataBase;
import model.DataObject;
import parsing.FileParser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class UploadController {
    private Desktop desktop = Desktop.getDesktop();
    private Stage stage;
    private Scene scene;
    private Parent root;
    public File file;
    @FXML
    private TextField fileName;
    @FXML
    private TextField taxYearField;

    @FXML
    private ComboBox<String> isFederal;

    @FXML
    private void initialize () throws SQLException{
        ObservableList<String> listItems = FXCollections.observableArrayList();
        listItems.add("Federal");
        listItems.add("State");
        listItems.add("Neither");
        isFederal.setItems(listItems);
        DataBase.initializeDB();
    }

    public void switchToFilter(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HelloScreen.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.setMaximized(true);
        stage.show();
    } // for button that takes you to the search and filter screen


//https://community.oracle.com/tech/developers/discussion/2578911/how-do-i-add-use-filechooser-on-or-with-scene-builder
//https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
    // this opens file explorer and lets you select a file and keeps the file name
    public void setFileChooser(ActionEvent event) throws IOException{ // this is witchcraft that I found on the internet
        final FileChooser fileChooser = new FileChooser();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        file = fileChooser.showOpenDialog(stage);
        fileName.setText(String.valueOf(file)); //so you can see what file was uploaded on the screen

    }


    @FXML
    private void saveFile() {
        try{
            if (file.exists()){
                FileParser parser = new FileParser(file);
                Map<String, HashMap<String, String>> data = parser.data;
                for (String key: data.keySet()){
                    if (!Objects.equals(taxYearField.getText(), "")){
                        String taxYear = taxYearField.getText();
                        data.get(key).put("TAXYEAR", taxYear);
                    }
                    if (isFederal.getValue().equals("Federal")){
                        data.get(key).put("FEDERAL", "1");
                    } else if (isFederal.getValue().equals("State")){
                        data.get(key).put("FEDERAL", "0");
                    } else {
                        data.get(key).put("FEDERAL", "2");
                    }
                }
                for (String key: data.keySet()){
                    DataBase.insertClient(data.get(key), key);
                    DataBase.insertDemographic(data.get(key), key);
                    DataBase.insertReturnData(data.get(key), key);
                    DataBase.insertQuestion(data.get(key), key);
                    DataBase.insertTaxYear(data.get(key));
                }
            }
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Upload Successful");
            successAlert.initOwner(fileName.getScene().getWindow());
            successAlert.showAndWait();
        }catch (Exception e){
            System.err.println(e);
            Alert alert = new Alert(Alert.AlertType.ERROR, "Upload Failed! Please ensure that the selected file is valid and all information correct!");
            alert.initOwner(fileName.getScene().getWindow());
            alert.showAndWait();
        }
    }
}