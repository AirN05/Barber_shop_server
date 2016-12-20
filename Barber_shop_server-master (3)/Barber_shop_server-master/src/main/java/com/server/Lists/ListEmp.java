package com.server.Lists;


import com.server.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListEmp {

    private List<Employee> list = new ArrayList<Employee>();
    public List<Employee> getLast() {
        return list;
    }
    public void setLast(List<Employee> last) {
        this.list = last;
    }
}
