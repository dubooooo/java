package cn.com.javafx.demo.shoot.test02;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dubooooo@126.com 2018-04-12
 */
public class GraphicsApplication extends Canvas {

    protected enum GameState {GAME_MENU, GAME_START, GAME_CONTINUE, GAME_HELP, GAME_SET, GAME_EXIT, GAME_PAUSE;}

    private List<Sprite> Sprites = new ArrayList();

    private Timeline timeline;
    private int duration = Constant.DURATION;
    private KeyFrame keyFrame;
    private GameState gameState = GameState.GAME_MENU;
    private GraphicsContext gc;
    private List<EventHandler> mouseMovedEvent = new ArrayList();

    public GraphicsApplication(double width, double height) {
        super(width, height);
    }

    public void start() {
        initGraphicsContext();
        initEvents();
        initKeyFrame();
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
        return new EventHandlerImpl(mouseMovedEvent);
    }

    public <T extends Event> void addEventHandlers(EventType<T> eventType, EventHandler<? super T> eventHandler) {
        getScene().addEventHandler(eventType, eventHandler);
    }

    public void addMouseMovedEvent(EventHandler<MouseEvent>... eventHandler) {
        mouseMovedEvent.addAll(Arrays.asList(eventHandler));
    }

    public void removeMouseMovedEvent(EventHandler<MouseEvent>... eventHandler) {
        mouseMovedEvent.removeAll(Arrays.asList(eventHandler));
    }

    public void initKeyFrame() {
        keyFrame = new KeyFrame(Duration.millis(duration), e -> {
            timelineEvent(gc);
        });
    }

    public void timelineEvent(GraphicsContext gc) {
        for (Sprite sprite : Sprites) {
            sprite.before();
            sprite.draw(gc);
            sprite.after();
        }
    }

    public void initTimeline() {
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().addAll(keyFrame);
        timeline.play();
    }

    public Sprite getSprite(int index) {
        return Sprites.get(index);
    }

    public void addSprite(Sprite... sprite) {
        if (sprite != null) {
            List<Sprite> list = Arrays.asList(sprite);
            for (Sprite spritetemp : list) {
                spritetemp.init(this);
            }
            this.Sprites.addAll(list);
        }
    }

    public void removeSprite(Sprite... sprite) {
        this.Sprites.removeAll(Arrays.asList(sprite));
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public KeyFrame getKeyFrame() {
        return keyFrame;
    }

    public void setKeyFrame(KeyFrame keyFrame) {
        this.keyFrame = keyFrame;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

/**
 * 鼠标移动事件
 */
class EventHandlerImpl implements EventHandler {

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