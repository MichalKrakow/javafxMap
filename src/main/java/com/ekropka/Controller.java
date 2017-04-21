package com.ekropka;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static com.ekropka.App.stage;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;

public class Controller {

    @FXML
    private Button showFolderPicker;

    @FXML
    private TextField folderPath;

    @FXML
    private Button startDownload;

    @FXML
    private Pane mapPane;

    private static final Logger LOGGER = Logger.getLogger( Controller.class.getName() );
    final FileChooser fileChooser = new FileChooser();

    @FXML
    private void initialize()
    {

//        Scene scene = new Scene(pane);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Map Tutorial 2");
//        primaryStage.show();
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {

        if (event.getSource() == showFolderPicker)
        {

        }

        if(event.getSource() == startDownload){
            //downloadSingleFile();
            downloadFile();

        }
    }

    @FXML
    private void handleTextFieldClick(MouseEvent event){
        if (event.getSource() == folderPath){
            getFolderName();
        }
    }

    private void showMap()
    {

    }

    private void downloadFile() {


    }


    private void getFolderName(){
        File file = fileChooser.showOpenDialog(stage);
        if (file == null)
        {
            return;
        }
        FileDataStore store = null;
        try {
            store = FileDataStoreFinder.getDataStore(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFeatureSource featureSource = null;
        try {
            featureSource = store.getFeatureSource();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a map content and add our shapefile to it
        MapContent map = new MapContent();
        map.setTitle("Quickstart");

        Style style = SLD.createSimpleStyle(featureSource.getSchema());
        Layer layer = new FeatureLayer(featureSource, style);
        map.addLayer(layer);

        // Now display the map
        JMapFrame.showMap(map);

    }



}
