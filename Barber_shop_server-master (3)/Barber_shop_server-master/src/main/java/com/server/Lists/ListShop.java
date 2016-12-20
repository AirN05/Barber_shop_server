package com.server.Lists;


import com.server.entity.Shop;

import java.util.ArrayList;
import java.util.List;

public class ListShop {

    private List<Shop> last = new ArrayList<Shop>();
    public List<Shop> getLast() {
        return last;
    }
    public void setLast(List<Shop> list) {
        this.last = list;
    }
}
