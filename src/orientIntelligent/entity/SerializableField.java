package orientIntelligent.entity;

import orientIntelligent.jni.Cenumclass;

public class SerializableField {
    /**
     * 时间标签
     */
    private int tpv;
    /**
     * 当前帧位置
     */
    private Cenumclass.CurrentFramePosition currentFramePosition;
    /**
     * 回复标志位
     */
    private int con;
    /**
     *PSEQ∕RSEQ
     */
    private int seq;

    public SerializableField(int tpV, Cenumclass.CurrentFramePosition currentFramePosition, int CON, int SEQ) {
        tpv = tpV;
        this.currentFramePosition = currentFramePosition;
        this.con = CON;
        this.seq = SEQ;
    }

    public SerializableField() {
    }

    public int getTpv() {
        return tpv;
    }

    public void setTpv(int tpv) {
        this.tpv = tpv;
    }

    public Cenumclass.CurrentFramePosition getCurrentFramePosition() {
        return currentFramePosition;
    }

    public void setCurrentFramePosition(Cenumclass.CurrentFramePosition currentFramePosition) {
        this.currentFramePosition = currentFramePosition;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
