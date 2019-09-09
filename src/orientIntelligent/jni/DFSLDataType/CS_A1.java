package orientIntelligent.jni.DFSLDataType;

public class CS_A1 {
   byte sec_digit  ;	//秒
   byte sec_decade ;
   byte min_digit  ;	//分
   byte min_decade ;
   byte hour_digit ;	//时
   byte hour_decade;
   byte day_digit  ;	//日
   byte day_decade ;
   byte week       ;	   	//星期
   byte mon_decade ;	//月
   byte mon_digit  ;
   byte year_digit ;	//年
   byte year_decade;

   public void SetVal (byte sec_digit  ,
                       byte sec_decade,
                       byte min_digit,
                       byte min_decade,
                       byte hour_digit,
                       byte hour_decade,
                       byte day_digit,
                       byte day_decade,
                       byte week,
                       byte mon_decade,
                       byte mon_digit,
                       byte year_digit,
                       byte year_decade)
   {
       this.sec_digit  = sec_digit  ;
       this.sec_decade = sec_decade ;
       this.min_digit  = min_digit  ;
       this.min_decade = min_decade ;
       this.hour_digit = hour_digit ;
       this.hour_decade= hour_decade;
       this.day_digit  = day_digit  ;
       this.day_decade = day_decade ;
       this.week       = week       ;
       this.mon_decade = mon_decade ;
       this.mon_digit  = mon_digit  ;
       this.year_digit = year_digit ;
       this.year_decade= year_decade;
   }

    public void setSec_digit(byte sec_digit) {
        this.sec_digit = sec_digit;
    }

    public CS_A1()
   {

   }
   public CS_A1(
         byte sec_digit  ,
         byte sec_decade,
         byte min_digit,
         byte min_decade,
         byte hour_digit,
         byte hour_decade,
         byte day_digit,
         byte day_decade,
         byte week,
         byte mon_decade,
         byte mon_digit,
         byte year_digit,
         byte year_decade
   )
   {
       this.sec_digit  = sec_digit  ;
       this.sec_decade = sec_decade ;
       this.min_digit  = min_digit  ;
       this.min_decade = min_decade ;
       this.hour_digit = hour_digit ;
       this.hour_decade= hour_decade;
       this.day_digit  = day_digit  ;
       this.day_decade = day_decade ;
       this.week       = week       ;
       this.mon_decade = mon_decade ;
       this.mon_digit  = mon_digit  ;
       this.year_digit = year_digit ;
       this.year_decade= year_decade;
   }

    public byte getSec_digit() {
        return sec_digit;
    }

    public byte getSec_decade() {
        return sec_decade;
    }

    public byte getMin_digit() {
        return min_digit;
    }

    public byte getMin_decade() {
        return min_decade;
    }

    public byte getHour_digit() {
        return hour_digit;
    }

    public byte getHour_decade() {
        return hour_decade;
    }

    public byte getDay_digit() {
        return day_digit;
    }

    public byte getDay_decade() {
        return day_decade;
    }

    public byte getMon_decade() {
        return mon_decade;
    }

    public byte getMon_digit() {
        return mon_digit;
    }

    public byte getWeek() {
        return week;
    }

    public byte getYear_decade() {
        return year_decade;
    }

    public byte getYear_digit() {
        return year_digit;
    }
}
