package orientIntelligent.entity;

import java.io.Serializable;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class DataUnit implements Serializable {

    private int fn;
    private int pn;
    /**
     * 1991年1月1日 20:10:10
     */
//    private String heartBeat;
    /**
     * "1.234"  "12.34"  "123.4"  "1234"  "X" ..."XXX.XXXXXXX"
     */
//    private String sensorData;
    /**
     * 下行 Td_c/Td_d/Td_m {"timeFlag":{"min":mValue,"hour":hValue,"day":dValue,"mon":mValue,"year":yValue},"density":val,"points":val}
     * str = "timeFlag":{"min":mValue,"hour":hValue,"day":dValue,"mon":mValue,"year":yValue}
     * 上行 [ {str,"Fs1":val,"Fs2":val,"Fs3":val ...},{},{},{},...]
     */
    private String data;

    public DataUnit() {
    }

    public DataUnit(int fn, int pn, String data) {
        this.fn = fn;
        this.pn = pn;
        this.data = data;
    }

    public int getFn() {
        return fn;
    }

    public void setFn(int fn) {
        this.fn = fn;
    }

    public int getPn() {
        return pn;
    }

    public void setPn(int pn) {
        this.pn = pn;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
