package com.server.Lists;


import com.server.entity.ClearReservation;

import java.util.ArrayList;
import java.util.List;

public class ListClearReservation {

    private List<ClearReservation> list = new ArrayList<ClearReservation>();
    public List<ClearReservation> getLast() {
        return list;
    }
    public void setLast(List<ClearReservation> last) {
        this.list = last;
    }
}
