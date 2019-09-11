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
    private int countryCode;
    /**
     * 新政区划码
     */
    private int zoneCode;
    /**
     * 机器型号
     */
    private int robotCode;
    /**
     * 序列号
     */
    private byte[] serializeCode;

    public AddressField() {
    }

    public AddressField(int countryCode, int zoneCode, int robotCode, byte[] serializeCode) {
        this.countryCode = countryCode;
        this.zoneCode = zoneCode;
        this.robotCode = robotCode;
        this.serializeCode = serializeCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(int zoneCode) {
        this.zoneCode = zoneCode;
    }

    public int getRobotCode() {
        return robotCode;
    }

    public void setRobotCode(int robotCode) {
        this.robotCode = robotCode;
    }

    public byte[] getSerializeCode() {
        return serializeCode;
    }

    public void setSerializeCode(byte[] serializeCode) {
        this.serializeCode = serializeCode;
    }
}
