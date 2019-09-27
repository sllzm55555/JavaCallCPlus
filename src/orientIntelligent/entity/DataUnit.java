package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class DataUnit {

    private int fn;
    private int pn;
    /**
     * 1991年1月1日 20:10:10
     */
    private String heartBeat;
    /**
     * "1.234"  "12.34"  "123.4"  "1234"  "X" ..."XXX.XXXXXXX"
     */
    private String sensorData;

    public DataUnit() {
    }

    public DataUnit(int fn, int pn, String heartBeat, String sensorData) {
        this.fn = fn;
        this.pn = pn;
        this.heartBeat = heartBeat;
        this.sensorData = sensorData;
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

    public String getHeartBeat() {
        return heartBeat;
    }

    public void setHeartBeat(String heartBeat) {
        this.heartBeat = heartBeat;
    }

    public String getSensorData() {
        return sensorData;
    }

    public void setSensorData(String sensorData) {
        this.sensorData = sensorData;
    }
}
