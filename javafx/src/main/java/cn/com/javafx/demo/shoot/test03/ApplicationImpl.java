package cn.com.javafx.demo.shoot.test03;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-13
 */
public class ApplicationImpl extends Application {

    private Stage stage;
    private Scene scene;
    private Parent parent;
    private List<Node> nodeList = new ArrayList();
    private DoubleProperty widthProperty = new SimpleDoubleProperty(600);
    private DoubleProperty heightProperty = new SimpleDoubleProperty(450);

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        initSence();
        initStage();
        initEvent();
    }

    public void initSence() {
        setScene(getScene());
        scene.widthProperty().add(widthProperty);
        scene.heightProperty().add(heightProperty);
    }

    public void initEvent() {
        getScene().setOnMouseClicked(e -> {
            System.out.println(e.getButton());
            switch (e.getButton()) {
                case PRIMARY:
                    System.out.println("左键" + e);
                    setWidth(getWidth() - 10);
                    setHeight(getHeight() - 10);
                    break;
                case SECONDARY:
                    System.out.println("右键" + e);
                    setWidth(getWidth() + 10);
                    setHeight(getHeight() + 10);
                    break;
            }
        });
    }

    public void initStage() {
        this.stage = stage;
        widthProperty.addListener(e -> this.stage.setWidth(widthProperty.get()));
        heightProperty.addListener(e -> this.stage.setHeight(heightProperty.get()));
        stage.setScene(getScene());
        stage.setWidth(widthProperty.get());
        stage.setHeight(heightProperty.get());
        stage.setResizable(false);
        stage.show();
    }

    public double getWidth() {
        return widthProperty.get();
    }

    public void setWidth(double width) {
        this.widthProperty.set(width);
    }

    public double getHeight() {
        return heightProperty.get();
    }

    public void setHeight(double height) {
        this.heightProperty.set(height);
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void addNodes(Node... nodes) {
        this.nodeList.addAll(Arrays.asList(nodes));
    }
}
