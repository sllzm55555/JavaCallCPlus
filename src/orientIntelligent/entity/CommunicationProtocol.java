package orientIntelligent.entity;

import orientIntelligent.jni.Cenumclass;

import java.io.Serializable;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class CommunicationProtocol implements Serializable {

    /**
     * 状态码
     */
    private Cenumclass.E_CheckPackage status;
    /**
     * 提示消息
     */
    private String message;
    /**
     * 协议内容
     */
    private ProtocolContent protocolContent;

    public Cenumclass.E_CheckPackage getStatus() {
        return status;
    }

    public void setStatus(Cenumclass.E_CheckPackage status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ProtocolContent getProtocolContent() {
        return protocolContent;
    }

    public void setProtocolContent(ProtocolContent protocolContent) {
        this.protocolContent = protocolContent;
    }

    public CommunicationProtocol() {
    }

    public CommunicationProtocol(Cenumclass.E_CheckPackage status, String message, ProtocolContent protocolContent) {
        this.status = status;
        this.message = message;
        this.protocolContent = protocolContent;
    }
}
