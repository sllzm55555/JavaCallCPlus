package orientIntelligent.entity;

import java.io.Serializable;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-20
 */
public class PackProtocolContent extends ProtocolContent implements Serializable {

    private String direction;
    private String isConfirm;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm;
    }
}
