package com.server.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name="work")
public class Work {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private long id_work;

    @Column(name="image",nullable = false)
    private String image;

    public long getId_image() {
        return id_work;
    }

    public void setId_image(long id_image) {
        this.id_work = id_image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
