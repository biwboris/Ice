package pocket;

import client.RealObj;

import java.io.Serializable;
import java.util.ArrayList;

public class ToClient implements Serializable{
    private ToClientType t;
    private ArrayList <RealObj> objs;
    private String s;

    public ToClient(ToClientType t, String s) {
        this.t = t;
        this.s = s;
    }

    public ToClient(ArrayList <RealObj> objs) {
        this.objs = objs;
        this.t = ToClientType.GAME;
    }

    public ToClientType getT() {
        return t;
    }

    public void setT(ToClientType t) {
        this.t = t;
    }

    public ArrayList<RealObj> getObjs() {
        return objs;
    }

    public void setObjs(ArrayList<RealObj> objs) {
        this.objs = objs;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
