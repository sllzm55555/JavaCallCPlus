package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageEntity {

    //方向
    private String direction;
    //国家代码
    private String countyCode;
    //行政区划
    private String adminZoneCode;
    //机器型号(应该是存在数据库中的字段)
    private int robotModelCode;
    //序列号(每位的值不能大于f)
    private String serializableCode;
    //请求类型
    private String requestType;
    //结果
    private String isConfirm;
    //附加信息


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getAdminZoneCode() {
        return adminZoneCode;
    }

    public void setAdminZoneCode(String adminZoneCode) {
        this.adminZoneCode = adminZoneCode;
    }

    public int getRobotModelCode() {
        return robotModelCode;
    }

    public void setRobotModelCode(int robotModelCode) {
        this.robotModelCode = robotModelCode;
    }

    public String getSerializableCode() {
        return serializableCode;
    }

    public void setSerializableCode(String serializableCode) {
        this.serializableCode = serializableCode;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm;
    }
}
