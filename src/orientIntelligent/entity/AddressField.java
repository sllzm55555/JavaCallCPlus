package orientIntelligent.entity;

import java.io.Serializable;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class AddressField implements Serializable {
    /**
     * 国家代码
     */
    private String countryCode;
    /**
     * 新政区划码
     */
    private String zoneCode;
    /**
     * 机器型号
     */
    private String robotCode;
    /**
     * 序列号
     */
    private String serializeCode;

    public AddressField() {
    }

    public AddressField(String countryCode, String zoneCode, String robotCode, String serializeCode) {
        this.countryCode = countryCode;
        this.zoneCode = zoneCode;
        this.robotCode = robotCode;
        this.serializeCode = serializeCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public String getRobotCode() {
        return robotCode;
    }

    public String getSerializeCode() {
        return serializeCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public void setRobotCode(String robotCode) {
        this.robotCode = robotCode;
    }

    public void setSerializeCode(String serializeCode) {
        this.serializeCode = serializeCode;
    }
}
