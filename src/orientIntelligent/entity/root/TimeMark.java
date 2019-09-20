package orientIntelligent.entity.root;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-19
 */
public class TimeMark {

    private String currentTime;
    private int delaySecond;

    public TimeMark(String currentTime, int delaySecond) {
        this.currentTime = currentTime;
        this.delaySecond = delaySecond;
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
