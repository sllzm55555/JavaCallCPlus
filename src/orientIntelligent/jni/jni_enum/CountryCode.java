package orientIntelligent.jni.jni_enum;

import java.util.Arrays;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public enum CountryCode {
    /**
     *
     */
    China("中国", (byte)0x86),
    America("美国", (byte)0x87);

    private String countryName;
    private byte value;

    CountryCode(String name, byte value) {
        this.countryName = name;
        this.value = value;
    }
    public String key(){
        return this.countryName;
    }

    public byte value(){
        return this.value;
    }

    public byte getValueByName(String name){
        CountryCode[] values = CountryCode.values();
        for (CountryCode countryCode : values) {
            if(name.equals(countryCode.key())){
                return countryCode.value;
            }
        }
        //如果循环完都没有找到对应的值
        return 0;
    }

}
