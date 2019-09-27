package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-19
 */
public class TimeMark {
    private int pfc;
    private String currentTime;
    private int delaySecond;

    public TimeMark(int pfc, String currentTime, int delaySecond) {
        this.pfc = pfc;
        this.currentTime = currentTime;
        this.delaySecond = delaySecond;
    }

    public int getPfc() {
        return pfc;
    }

    public void setPfc(int pfc) {
        this.pfc = pfc;
    }

    public TimeMark() {
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public int getDelaySecond() {
        return delaySecond;
    }

    public void setDelaySecond(int delaySecond) {
        this.delaySecond = delaySecond;
    }
}
