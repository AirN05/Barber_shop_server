package com.server.Lists;


import com.server.entity.Price;
import java.util.ArrayList;
import java.util.List;

public class ListPrice {

    private List<Price> last = new ArrayList<Price>();
    public List<Price> getLast() {
        return last;
    }
    public void setLast(List<Price> list) {
        this.last = list;
    }
}
