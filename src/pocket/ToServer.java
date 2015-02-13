package pocket;

import java.io.Serializable;
import java.util.ArrayList;

public class ToServer implements Serializable{
    private ArrayList <Integer> i;
    private String s;
    private ToServerType t;

    public ToServer(ToServerType t, ArrayList <Integer> i, String s) {
        this.t = t;
        this.i = i;
        this.s = s;
    }

    public ArrayList<Integer> getI() {
        return i;
    }

    public void setI(ArrayList<Integer> i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public ToServerType getT() {
        return t;
    }

    public void setT(ToServerType t) {
        this.t = t;
    }
}
