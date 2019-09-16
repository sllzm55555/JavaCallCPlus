package orientIntelligent.jni.jni_enum;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public enum AdminZoneCode {

    /**
     *
     */
    chengdu("成都", 1186),
    guizhou("贵州", 1287);

    private String zoneName;
    private int value;

    AdminZoneCode(String name, int value) {
        this.zoneName = name;
        this.value = value;
    }

    public AdminZoneCode getAdminZoneCodeByName(String name){
        AdminZoneCode[] values = AdminZoneCode.values();
        for (AdminZoneCode code : values) {
            if(name.equals(code.key())){
                return code;
            }
        }
        return null;
    }

    public String key(){
        return this.zoneName;
    }

    private int value(){
        return this.value;
    }

    public static int getValueByName(String name){
        AdminZoneCode[] values = AdminZoneCode.values();
        for (AdminZoneCode code : values) {
            if(name.equals(code.key())){
                return code.value;
            }
        }
        //如果循环完都没有找到对应的值
        return 0;
    }

}
