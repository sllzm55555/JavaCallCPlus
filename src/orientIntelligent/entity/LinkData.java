package orientIntelligent.entity;

import orientIntelligent.jni.Cenumclass;

import java.io.Serializable;
import java.util.List;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 * 链路用户数据
 */
public class LinkData implements Serializable {

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
    private List<Data> dataList;

    public LinkData() {
    }

    public LinkData(Cenumclass.E_appFuncCode applicationFunctionCode, SerializableField serializableField, List<Data> data) {

        this.applicationFunctionCode = applicationFunctionCode;
        this.serializableField = serializableField;
        this.dataList = data;
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

    public List<Data> getDataList() {
        return dataList;
    }

    public void setDataList(List<Data> dataList) {
        this.dataList = dataList;
    }
}
