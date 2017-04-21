package com.ekropka;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;

import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.Layer;
import org.geotools.map.MapContent;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapFrame;
import org.geotools.swing.data.JFileDataStoreChooser;

/**
 * Hello world!
 *
 */
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{

//        MapCanvas canvas = new MapCanvas(1024, 768);
//        Pane pane = new Pane(canvas.getCanvas());
//        Scene scene = new Scene(pane);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Map Tutorial 2");
//        primaryStage.show();


        stage = primaryStage;
        //MapCanvas canvas = new MapCanvas(1024, 768);

        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Map downloader");
        primaryStage.setScene(new Scene(root, 800, 420));
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}