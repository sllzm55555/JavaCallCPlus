package orientIntelligent.jni;

public class CDFSLDataType {


}

class CEvent
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

class CS_A16// second_XX_XX_XX_XX
{

    byte sec_digit  ;	//秒
    byte sec_decade ;
    byte min_digit  ;	//分
    byte min_decade ;
    byte hour_digit ;	//时
    byte hour_decade;
    byte day_digit  ;	//日
    byte day_decade ;

    public CS_A16(byte sec_digit,byte sec_decade,byte min_digit,byte min_decade,byte hour_digit,byte hour_decade,byte day_digit,byte day_decade)
    {
        this.sec_digit   = sec_digit  ;
        this.sec_decade  = sec_decade ;
        this.min_digit   = min_digit  ;
        this.min_decade  = min_decade ;
        this.hour_digit  = hour_digit ;
        this.hour_decade = hour_decade;
        this.day_digit   = day_digit  ;
        this.day_decade  = day_decade ;
    }


    public byte getSec_decade() {
        return sec_decade;
    }

    public byte getSec_digit() {
        return sec_digit;
    }

    public byte getMin_decade() {
        return min_decade;
    }

    public byte getMin_digit() {
        return min_digit;
    }

    public byte getHour_decade() {
        return hour_decade;
    }

    public byte getHour_digit() {
        return hour_digit;
    }

    public byte getDay_decade() {
        return day_decade;
    }

    public byte getDay_digit() {
        return day_digit;
    }
};