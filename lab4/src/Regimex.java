package jspclass;
import java.util.*;


public class Regimex {
    protected String R = null;
    Calendar C;
    protected Date d = new Date();
    public Regimex(Calendar c) {
        this.C = c;
    }
    public Regimex() {
        this.C = Calendar.getInstance();
    }
    public Integer GetHOUR() {
        return ((Integer)C.get(Calendar.HOUR_OF_DAY));
    }
}