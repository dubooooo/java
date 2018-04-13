package cn.com.javafx.demo.shoot.test03;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public class GraphicsApplication extends Canvas {

    final static private Logger log = LoggerFactory.getLogger(GraphicsApplication.class);

    private List<Sprite> sprites = new ArrayList();

    private DoubleProperty appWidth = new SimpleDoubleProperty(Constant.WIDTH);//应用的宽度
    private DoubleProperty appHeight = new SimpleDoubleProperty(Constant.HEIGHT);//应用的高度
    private Stage stage;
    private Timeline timeline;
    private int duration = Constant.DURATION;
    private Constant.GameState gameState = Constant.GameState.GAME_MENU;
    private GraphicsContext gc;
    private List<EventHandler> mouseMovedEvents = new ArrayList();

    public GraphicsApplication() {
    }

    public GraphicsApplication(double width, double height) {
        super(width, height);
    }

    public void init() {
        initGraphicsContext();
        initEvents();
        initTimeline();
    }

    public void initGraphicsContext() {
        this.gc = getGraphicsContext2D();
    }

    public void initEvents() {
        getScene().setOnMouseMoved(mouseMovedEvent());
        getScene().setOnKeyPressed(keyPressedEvent());
    }

    public EventHandler<? super KeyEvent> keyPressedEvent() {
        return null;
    }

    public EventHandler<? super MouseEvent> mouseMovedEvent() {
        return new EventHandlerImpl(getMouseMovedEvents());
    }

    public <T extends Event> void addEventHandlers(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        getScene().addEventHandler(eventType, eventHandler);
    }

    public void addMouseMovedEvent(EventHandler<MouseEvent>... eventHandler) {
        getMouseMovedEvents().addAll(Arrays.asList(eventHandler));
    }

    public void removeMouseMovedEvent(EventHandler<MouseEvent>... eventHandler) {
        getMouseMovedEvents().removeAll(Arrays.asList(eventHandler));
    }

    public void timelineEvent(GraphicsContext gc) {
        for (Sprite sprite : getSprites()) {
            sprite.before();
            sprite.draw(gc);
            sprite.after();
        }
    }

    public void initTimeline() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().addAll(getKeyFrame());
    }

    public Sprite getSprite(int index) {
        return sprites.get(index);
    }

    public void addSprite(Sprite... sprite) {
        if (sprite != null) {
            List<Sprite> list = Arrays.asList(sprite);
            for (Sprite spritetemp : list) {
                spritetemp.init(this);
            }
            this.sprites.addAll(list);
        }
    }

    public void removeSprite(Sprite... sprite) {
        this.sprites.removeAll(Arrays.asList(sprite));
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public KeyFrame getKeyFrame() {
        return new KeyFrame(Duration.millis(duration), e -> {
            timelineEvent(gc);
        });
    }

    public Constant.GameState getGameState() {
        return gameState;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public List<EventHandler> getMouseMovedEvents() {
        return mouseMovedEvents;
    }

    public DoubleProperty appWidthProperty() {
        return appWidth;
    }

    public DoubleProperty appHeightProperty() {
        return appHeight;
    }
}

/**
 * 鼠标移动事件
 */
class EventHandlerImpl implements EventHandler {

    final static private Logger log = LoggerFactory.getLogger(EventHandlerImpl.class);

    private List<EventHandler> eventHandlers;

    public EventHandlerImpl(List<EventHandler> mouseEvent) {
        this.eventHandlers = mouseEvent;
    }

    @Override
    public void handle(Event event) {
        for (EventHandler eventHandler : eventHandlers) {
            eventHandler.handle(event);
        }
    }
}