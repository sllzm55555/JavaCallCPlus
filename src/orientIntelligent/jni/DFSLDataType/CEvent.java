package orientIntelligent.jni.DFSLDataType;

public class CEvent
{

    byte importantCount;//重要事件数
    byte generalCount;//一般事件数

    public CEvent(byte importantCount,byte generalCount){
        this.importantCount = importantCount;
        this.generalCount = generalCount;
    }



    public byte getGeneralCount() {
        return generalCount;
    }

    public byte getImportantCount() {
        return importantCount;
    }
}
