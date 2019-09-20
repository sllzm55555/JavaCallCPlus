package orientIntelligent.entity.root;

import orientIntelligent.jni.Cenumclass;

import java.util.List;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 * 链路用户数据
 */
public class LinkData {

    /**
     * 应用层功能码
     */
    private Cenumclass.E_appFuncCode applicationFunctionCode;
    /**
     * 序列域
     */
    private SerializableField serializableField;
    /**
     * 数据单元
     */
    private List<DataUnit> dataUnitList;

    public LinkData() {
    }

    public LinkData(Cenumclass.E_appFuncCode applicationFunctionCode, SerializableField serializableField, List<DataUnit> dataUnitList) {

        this.applicationFunctionCode = applicationFunctionCode;
        this.serializableField = serializableField;
        this.dataUnitList = dataUnitList;
    }

    public Cenumclass.E_appFuncCode getApplicationFunctionCode() {
        return applicationFunctionCode;
    }

    public void setApplicationFunctionCode(Cenumclass.E_appFuncCode applicationFunctionCode) {
        this.applicationFunctionCode = applicationFunctionCode;
    }

    public SerializableField getSerializableField() {
        return serializableField;
    }

    public void setSerializableField(SerializableField serializableField) {
        this.serializableField = serializableField;
    }

    public List<DataUnit> getDataUnitList() {
        return dataUnitList;
    }

    public void setDataUnitList(List<DataUnit> dataUnitList) {
        this.dataUnitList = dataUnitList;
    }
}
