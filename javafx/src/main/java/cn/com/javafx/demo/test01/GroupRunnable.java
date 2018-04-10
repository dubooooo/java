package cn.com.javafx.demo.test01;

import javafx.scene.Group;

/**
 * @author dubooooo@126.com 2018-04-09
 */
public class GroupRunnable implements Runnable {

    private Group group;

    public GroupRunnable(Group group) {
        this.group = group;
    }

    @Override
    public void run() {
        try {
            group.setOnKeyPressed(event -> {
                System.out.println(event);
            });
            Thread.sleep(3000);
            group.getChildren().remove(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
