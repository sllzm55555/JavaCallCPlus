package orientIntelligent.entity;

import java.io.Serializable;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-19
 */
public class ExtraMessage implements Serializable {

    private EventWarnningCount eventWarnningCount;
    private TimeMark timeMark;
    private byte[] authorization;

    public EventWarnningCount getEventWarnningCount() {
        return eventWarnningCount;
    }

    public void setEventWarnningCount(EventWarnningCount eventWarnningCount) {
        this.eventWarnningCount = eventWarnningCount;
    }

    public TimeMark getTimeMark() {
        return timeMark;
    }

    public void setTimeMark(TimeMark timeMark) {
        this.timeMark = timeMark;
    }

    public byte[] getAuthorization() {
        return authorization;
    }

    public void setAuthorization(byte[] authorization) {
        this.authorization = authorization;
    }
}
