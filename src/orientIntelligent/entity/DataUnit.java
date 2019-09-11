package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class DataUnit {

    private int fn;
    private int pn;
    private byte[] data;

    public DataUnit() {
    }

    public DataUnit(int fn, int pn, byte[] data) {
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
