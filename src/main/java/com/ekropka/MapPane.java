package com.ekropka;

import javafx.scene.layout.Pane;
import org.geotools.data.FileDataStore;
import org.geotools.data.FileDataStoreFinder;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.map.FeatureLayer;
import org.geotools.map.MapContent;
import org.geotools.renderer.lite.StreamingRenderer;
import org.geotools.styling.SLD;
import org.geotools.styling.Style;
import org.geotools.swing.JMapPane;

import java.io.IOException;
import java.util.logging.Logger;
import java.awt.Rectangle;

/**
 * Created by Ekropka on 20.04.2017.
 */
public class MapPane extends JMapPane {

    private static final Logger LOGGER = Logger.getLogger( Controller.class.getName() );
    private MapContent map;
    private MapCanvas canvas;

    public MapPane()
    {
        setRenderer(new StreamingRenderer());
        canvas = new MapCanvas(400,240);
        try {
            FileDataStore store = FileDataStoreFinder
                    .getDataStore(this.getClass().getClassLoader().getResource("maps/landuse.shp"));
            SimpleFeatureSource featureSource = store.getFeatureSource();
            map = new MapContent();
            map.setTitle("Quickstart");
            Style style = SLD.createSimpleStyle(featureSource.getSchema());
            FeatureLayer layer = new FeatureLayer(featureSource, style);
            map.addLayer(layer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setMapContent(map);
        LOGGER.warning("CREATED");
    }
}
