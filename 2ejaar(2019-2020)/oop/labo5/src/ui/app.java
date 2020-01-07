package ui;

import domain.*;

import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        List<wagen> list = new ArrayList<>();
        list.add(new elektrisch(15, 15, 15));
        list.add(new branstofw(12, 12, 12));
    }
}
