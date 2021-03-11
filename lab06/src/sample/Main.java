package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Main extends Application {

    private static double[] avgHousingPricesByYear = {
            247381.0, 264171.4, 287715.3, 294736.1,
            308431.4, 322635.9, 340253.0, 363153.7
    };

    private static double[] avgCommercialPricesByYear = {
            1121585.3, 1219479.5, 1246354.2, 1295364.8,
            1335932.6, 1472362.0, 1583521.9, 1613246.3
    };

    private static String[] ageGroups = { "18-25", "26-35", "36-45", "46-55", "56-65", "65+"};

    private static int[] purchasesByAgeGroup = { 648, 1021, 2453, 3173, 1868, 2247};

    private static Color[] pieColours = { Color.AQUA, Color.GOLD, Color.DARKORANGE, Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("lab06");
        int WindowWidth = 1200;
        int WindowHeight = 800;
        int barGap = 10;
        double rectHeight= 1150;
        double rectWidth = 50;

        int horizontal = 50, vertical = 20;

        /*
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Year");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");

        BarChart bc = new BarChart(xAxis,yAxis);
        bc.setTitle("Bar Chart");

        XYChart.Series avgHousingYear = new XYChart.Series();
        avgHousingYear.setName("Red");
        int index = 1;

        for (double value : avgHousingPricesByYear){
            avgHousingYear.getData().add(new XYChart.Data(String.valueOf(index), value));
            index++;
        }
        XYChart.Series avgCommercialYear = new XYChart.Series();
        avgCommercialYear.setName("Blue");
        index = 1;

        for (double value : avgCommercialPricesByYear){
            avgCommercialYear.getData().add(new XYChart.Data(String.valueOf(index), value));
            index++;
        }
        */

        //bc.getData().addAll(avgHousingYear, avgCommercialYear);
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Group root = new Group();
        Scene scene  = new Scene(root,WindowWidth,WindowHeight);
        primaryStage.setTitle("lab06");
        primaryStage.setScene(scene);

        Group rectGroup = new Group();
        double commercialMax = 1613246.3;
        double housingMax = 363153.7;

        for (double value : avgHousingPricesByYear) {
            Rectangle rect = new Rectangle(100+barGap,(700-(value/commercialMax)*500), 20,(value/commercialMax)*500);
            barGap += 50;
            rect.setStroke(Color.RED);
            rect.setFill(Color.RED);
            root.getChildren().add(rect);
            rectGroup.getChildren().add(rect);
        }

        barGap = 30;

        for (double value : avgCommercialPricesByYear) {
            Rectangle rect = new Rectangle(100+barGap,(700-(value/commercialMax)*500), 20,(value/commercialMax)*500);
            barGap += 50;
            rect.setStroke(Color.BLUE);
            rect.setFill(Color.BLUE);
            root.getChildren().add(rect);
            rectGroup.getChildren().add(rect);
        }

        root.getChildren().add(rectGroup);


        int totalpurchasesByAgeGroup = 0;

        for (int value : purchasesByAgeGroup){
            totalpurchasesByAgeGroup += value;
        }

        System.out.println(totalpurchasesByAgeGroup);
        Group arcGroup = new Group();

        double arcOffset = 0;
        int colorIndex = 0;
        for (int value : purchasesByAgeGroup){
            Arc arc = new Arc();
            arc.setCenterX(900f);
            arc.setCenterY(400f);
            arc.setRadiusX(180);
            arc.setRadiusY(180);
            arc.setStartAngle(0.0+arcOffset);
            //System.out.println("Offset at start is " + arcOffset);
            double length = (double) value/totalpurchasesByAgeGroup;
            //System.out.println("Arc Length of index " + colorIndex + " is " + length);
            double effectiveLength = length*360;
            arc.setLength(effectiveLength);
            arc.setType(ArcType.ROUND);
            arc.setStroke(pieColours[colorIndex]);
            arc.setFill(pieColours[colorIndex]);
            root.getChildren().add(arc);
            arcGroup.getChildren().add(arc);
            colorIndex++;
            arcOffset += length*360;

            //System.out.println("Offset at end is " + arcOffset);
        }

        root.getChildren().add(arcGroup);

        primaryStage.show();

        //bc.lookupAll(".default-color0.chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: blue;"));
        //bc.lookupAll(".default-color1.chart-bar").forEach(n -> n.setStyle("-fx-bar-fill: red;"));


    }


    public static void main(String[] args) {
        launch(args);
    }
}
