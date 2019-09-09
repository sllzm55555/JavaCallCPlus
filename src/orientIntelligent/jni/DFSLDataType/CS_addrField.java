package orientIntelligent.jni.DFSLDataType;




public class CS_addrField {

    private byte A1_countcode;//国家代码
    private CS_adminZoneCode adminZoneCode;//行政区划码
    private CS_tmladd tmladd;//机器型号
    private byte[] A4_SN;//序列号

    public CS_addrField(byte A1_countcode,CS_adminZoneCode adminZoneCode,CS_tmladd tmladd,byte[] A4_SN)
    {
        this.A1_countcode = A1_countcode;
        this.adminZoneCode = adminZoneCode;
        this.tmladd = tmladd;
        this.A4_SN = A4_SN;
    }
    public CS_addrField()
    {
        adminZoneCode = new CS_adminZoneCode();
        tmladd = new CS_tmladd();
    }
    public CS_adminZoneCode get_adminZoneCode()
    {
        return adminZoneCode;
    }

    public CS_tmladd get_tmladd()
    {
        return tmladd;
    }

    public void set_adminZoneCode(byte azc_digit,byte azc_decade,byte azc_hundred,byte azc_kilobit)
    {
        adminZoneCode.azc_digit = azc_digit;
        adminZoneCode.azc_decade = azc_decade;
        adminZoneCode.azc_hundred = azc_hundred;
        adminZoneCode.azc_kilobit = azc_kilobit;
    }
    public void set_A1_countcode(byte val)
    {
        A1_countcode = val;
    }

    public void set_tmladd(byte addr_digit,byte addr_decade)
    {
        tmladd.addr_decade = addr_decade;
        tmladd.addr_digit = addr_digit;
    }

    public void set_A4_SN(byte[] SN)
    {
        A4_SN = SN;
    }


    /**
     * 行政区划码
     */
    public class CS_adminZoneCode
    {
        /*

        uint8 azc_digit:4;
        uint8 azc_decade:4;
        uint8 azc_hundred:4;
        uint8 azc_kilobit:4;
         */
        public CS_adminZoneCode(byte azc_digit,byte azc_decade,byte azc_hundred,byte azc_kilobit)
        {
            this.azc_digit = azc_digit;
            this.azc_decade = azc_decade;
            this.azc_hundred = azc_hundred;
            this.azc_kilobit = azc_kilobit;
        }
        public CS_adminZoneCode()
        {

        }


        private byte azc_digit;
        private byte azc_decade;
        private byte azc_hundred;
        private byte azc_kilobit;
    }

    /**
     * 机器型号
     */
    public class CS_tmladd
    {
        public CS_tmladd(byte addr_digit,byte addr_decade)
        {
            this.addr_decade = addr_decade;
            this.addr_digit = addr_digit;
        }
        public CS_tmladd()
        {

        }
        private byte addr_digit;
        private byte addr_decade;
    }


}


