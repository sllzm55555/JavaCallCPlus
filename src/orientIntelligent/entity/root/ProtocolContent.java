package orientIntelligent.entity.root;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class ProtocolContent {

    /**
     * 长度
     */
    private int length;
    /**
     * 控制域
     */
    private ControlField controlField;
    /**
     * 地址域
     */
    private AddressField addressField;
    /**
     * 链路数据
     */
    private LinkData linkData;
    /**
     * 校验和
     */
    private int checkSum;
    /**
     * 附加信息 (时间标签, 事件数, 消息认证码)
     */
    private ExtraMessage extraMessage;

    public ExtraMessage getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(ExtraMessage extraMessage) {
        this.extraMessage = extraMessage;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ControlField getControlField() {
        return controlField;
    }

    public void setControlField(ControlField controlField) {
        this.controlField = controlField;
    }

    public AddressField getAddressField() {
        return addressField;
    }

    public void setAddressField(AddressField addressField) {
        this.addressField = addressField;
    }

    public LinkData getLinkData() {
        return linkData;
    }

    public void setLinkData(LinkData linkData) {
        this.linkData = linkData;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }
}
