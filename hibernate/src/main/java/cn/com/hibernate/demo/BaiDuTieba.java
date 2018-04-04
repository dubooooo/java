package cn.com.hibernate.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dubooooo@126.com 2018-04-03
 */
@Entity
public class BaiDuTieba {

    @Id
    private String id;
    @Column
    private String tieba_name;
    private String title;
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTieba_name() {
        return tieba_name;
    }

    public void setTieba_name(String tieba_name) {
        this.tieba_name = tieba_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "cn.com.hibernate.demo.BaiDuTieba{" + "id='" + id + '\'' + ", tieba_name='" + tieba_name + '\'' + ", title='" + title + '\'' + ", content='" + content + '\'' + '}';
    }
}
