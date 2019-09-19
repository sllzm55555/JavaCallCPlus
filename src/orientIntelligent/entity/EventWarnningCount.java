package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-19
 */
public class EventWarnningCount {

    private int importantEventCount;
    private int ordinaryEventCount;

    public int getImportantEventCount() {
        return importantEventCount;
    }

    public void setImportantEventCount(int importantEventCount) {
        this.importantEventCount = importantEventCount;
    }

    public int getOrdinaryEventCount() {
        return ordinaryEventCount;
    }

    public void setOrdinaryEventCount(int ordinaryEventCount) {
        this.ordinaryEventCount = ordinaryEventCount;
    }

    public EventWarnningCount(int importantEventCount, int ordinaryEventCount) {
        this.importantEventCount = importantEventCount;
        this.ordinaryEventCount = ordinaryEventCount;
    }

    public EventWarnningCount() {
    }
}
