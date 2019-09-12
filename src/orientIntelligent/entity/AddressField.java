package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class AddressField {
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
}
