package com.server.entity;


import java.util.ArrayList;
import java.util.List;

public class ListImage {

    private List<Home> list = new ArrayList<Home>();

    public List<Home> getLast() {
        return list;
    }
    public void setList(List<Home> last) {
        this.list = last;
    }
}
