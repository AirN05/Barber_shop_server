package com.server.Lists;


import com.server.entity.Home;

import java.util.ArrayList;
import java.util.List;

public class ListImage {

    private List<Home> list = new ArrayList<Home>();

    public List<Home> getLast() {
        return list;
    }
    public void setLast(List<Home> last) {
        this.list = last;
    }
}
