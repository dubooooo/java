package cn.com.javafx.demo.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.springframework.core.io.ClassPathResource;

/**
 * @author dubooooo@126.com 2018-03-30
 */
public class Sprite extends Parent {

    private enum Direction {
        Left, Right, Up, Down
    }

    private Direction direction = Direction.Left;
    private Direction lastDirection;
    private int x, y, width, height;
    private int index = 0;
    private int indexDiv = 5;
    private ImageView mImageView;
    private int speed = 4;

    public Sprite(int x, int y, int width, int height, String url) {
        try {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            Image actor = new Image(new ClassPathResource(url).getInputStream());
            this.mImageView = new ImageView(actor);
            this.mImageView.setViewport(new Rectangle2D(0, 0, width, height));
            this.mImageView.setLayoutX(x);
            this.mImageView.setLayoutY(y);
            this.getChildren().add(this.mImageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 像下移动
     */
    public void moveDown() {
        this.direction = Direction.Down;
        if (this.lastDirection != this.direction) {
            this.index = 0;
        }
        this.index++;
        if (this.index / this.indexDiv > 2) {
            this.index = 0;
        }
        this.mImageView.setViewport(new Rectangle2D(((this.index / this.indexDiv) % 3) * this.width, ((this.index / this.indexDiv) / 3) * this.height, this.width, this.height));
        this.mImageView.setLayoutY(this.mImageView.getLayoutY() + this.speed);

        this.lastDirection = this.direction;
    }

    /**
     * 像左移动
     */
    public void moveLeft() {
        this.direction = Direction.Left;
        if (this.lastDirection != this.direction) {
            this.index = 3 * this.indexDiv;
        }
        this.index++;
        if (this.index / this.indexDiv > 5) {
            this.index = 3 * this.indexDiv;
        }
        this.mImageView.setViewport(new Rectangle2D(((this.index / this.indexDiv) % 3) * this.width, ((this.index / this.indexDiv) / 3) * this.height, this.width, this.height));
        this.mImageView.setLayoutX(this.mImageView.getLayoutX() - this.speed);

        this.lastDirection = this.direction;
    }

    /**
     * 像右移动
     */
    public void moveRight() {
        this.direction = Direction.Right;
        if (this.lastDirection != this.direction) {
            this.index = 6 * this.indexDiv;
        }
        this.index++;
        if (this.index / this.indexDiv > 8) {
            this.index = 6 * this.indexDiv;
        }
        this.mImageView.setViewport(new Rectangle2D(((this.index / this.indexDiv) % 3) * this.width, ((this.index / this.indexDiv) / 3) * this.height, this.width, this.height));
        this.mImageView.setLayoutX(this.mImageView.getLayoutX() + this.speed);

        this.lastDirection = this.direction;
    }

    /**
     * 像右移动
     */
    public void moveUp() {
        this.direction = Direction.Up;
        if (this.lastDirection != this.direction) {
            this.index = 9 * this.indexDiv;
        }
        this.index++;
        if (this.index / this.indexDiv > 11) {
            this.index = 9 * this.indexDiv;
        }
        this.mImageView.setViewport(new Rectangle2D(((this.index / this.indexDiv) % 3) * this.width, ((this.index / this.indexDiv) / 3) * this.height, this.width, this.height));
        this.mImageView.setLayoutY(this.mImageView.getLayoutY() - this.speed);

        this.lastDirection = this.direction;
    }

    public void move() {

    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
