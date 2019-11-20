package orientIntelligent.entity;

import java.util.List;

public class Data {

    private TimeFlag timeFlag;
    private List<DataUnit> dataUnitList;

    public TimeFlag getTimeFlag() {
        return timeFlag;
    }

    public void setTimeFlag(TimeFlag timeFlag) {
        this.timeFlag = timeFlag;
    }

    public List<DataUnit> getDataUnitList() {
        return dataUnitList;
    }

    public void setDataUnitList(List<DataUnit> dataUnitList) {
        this.dataUnitList = dataUnitList;
    }
}
