package com.server.Lists;



import com.server.entity.Work;
import java.util.ArrayList;
import java.util.List;

public class ListWork {

    private List<Work> last = new ArrayList<Work>();
    public List<Work> getLast() {
        return last;
    }
    public void setLast(List<Work> list) {
        this.last = list;
    }
}
