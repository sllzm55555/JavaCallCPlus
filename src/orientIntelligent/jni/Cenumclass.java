package orientIntelligent.jni;

public class Cenumclass {

    public enum E_rltdat {
        /*#######################################################################################*/
        /*水质*/
        E_RLTDAT_WATERTEMP      ((byte)179),	//water temperature 温度  水质传感器
        E_RLTDAT_TURBIDIMETER   ((byte)180),	//turbidimeter 浊度
        E_RLTDAT_DISSOLVEDOXYGEN((byte)181),	//dissolved oxygen; 溶解氧
        E_RLTDAT_CONDUCTIVITY   ((byte)182),	//conductivity 电导率
        E_RLTDAT_PH             ((byte)183),	//PH值
        E_RLTDAT_BLUEGREENALGA  ((byte)184),	//blue green alga 蓝绿藻
        E_RLTDAT_CHLOROPHYLL    ((byte)185),	//chlorophyll 叶绿素
        E_RLTDAT_PHOSPHORUS     ((byte)186),	//total phosphorus 总磷
        E_RLTDAT_NITROGEN       ((byte)187),	//total nitrogen   总氮
        E_RLTDAT_ANMMONIANITROGEN((byte)188),	//anmmonia nitrogen氨氮
        /*#######################################################################################*/
        /*水文*/
        //FIXME						//temperature 温度   水文传感器
        E_RLTDAT_SALINITY       ((byte)189),	//salinity 盐度
        E_RLTDAT_DENSITY        ((byte)190),	//density 密度
        E_RLTDAT_FLWRATE        ((byte)191),	//flow rate 流速
        E_RLTDAT_FLWTOWARDS     ((byte)192),	//flow towards 流向
        E_RLTDAT_CAPACITY       ((byte)193),	//flow capacity 流量
        E_RLTDAT_WATERLV        ((byte)194),	//water level 水位
        /*#######################################################################################*/
        /*姿态传感器*/
        E_RLTDAT_HEADING        ((byte)195),	//heading 航向
        E_RLTDAT_ROLLING        ((byte)196),	//rolling 横滚
        E_RLTDAT_PITCHING       ((byte)197),	//pitching 俯仰
        E_RLTDAT_ACCELERATION   ((byte)198),	//Acceleration 加速度
        /*#######################################################################################*/
        ///*气象传感器*/
        E_RLTDAT_WINDDIR        ((byte)199),	//wind direction 风向
        E_RLTDAT_WINDSPEED      ((byte)200),	//wind speed 风速
        E_RLTDAT_TEMPERATURE    ((byte)201),	//气温
        E_RLTDAT_HUMIDITY       ((byte)202),	//humidity 湿度
        E_RLTDAT_ATMOSPHERIC    ((byte)203),	//atmospheric 大气压
        E_RLTDAT_RAINFALL       ((byte)204),	//rainfall 降雨量
        /*#######################################################################################*/
        /*测距 超声*/
        E_RLTDAT_ULTRADISTANCE  ((byte)205),	//distance 距离 超声
        /*测距 超声阵列*/
        E_RLTDAT_ARRYULTRADIS   ((byte)206),	//distance 距离 超声阵列
        /*#######################################################################################*/
        ///*测距 毫米波*/
        ///*测距 毫米波阵列*/
        E_RLTDAT_MMWAVEDISTANCE ((byte)207),	//distance 距离 毫米波
        E_RLTDAT_ARRYMILLIDIS   ((byte)208),	//distance 距离 毫米波阵列
        /*#######################################################################################*/
        /*#######################################################################################*/
        ///*经纬度*/
        E_RLTDAT_LONGITUDE      ((byte)209),	//经度 longitude
        E_RLTDAT_LATITUDE       ((byte)210),	//纬度 latitude
        /*#######################################################################################*/
        /*清污机构*/
        E_RLTDAT_RMVCONTAMINATION((byte)211),	//removal of contamination 清污量
        /*#######################################################################################*/
        /*电机*/
        E_RLTDAT_MOTORPOWER     ((byte)212),	//motor power电机功率
        E_RLTDAT_MOTORSPEED     ((byte)213),	//motor speed电机转速
        E_RLTDAT_MOTORVOLTAGE   ((byte)214),	//motor voltage 电机电压
        /*#######################################################################################*/
        /*版本信息*/
        E_RLTDAT_FIRMWAREVERSION((byte)215),	//硬件固件版本
        E_RLTDAT_SOFTWAREVERSION((byte)216),	//软件版本
        E_RLTDAT_RESERVE        ((byte)217);	//

        private byte value;

        E_rltdat(byte value) {
            this.value = value;
        }

        public static E_rltdat getEnumByName(String name){
            E_rltdat[] values = E_rltdat.values();
            for (E_rltdat code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_rltdat e : E_rltdat.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue() {
            return value;
        }
    }

    public enum E_hisdat {
        /*#######################################################################################*/
        /*水质*/
        E_HISDAT_WATERTEMP      ((byte)179),	//water temperature 温度  水质传感器
        E_HISDAT_TURBIDIMETER   ((byte)180),	//turbidimeter 浊度
        E_HISDAT_DISSOLVEDOXYGEN((byte)181),	//dissolved oxygen; 溶解氧
        E_HISDAT_CONDUCTIVITY   ((byte)182),	//conductivity 电导率
        E_HISDAT_PH             ((byte)183),	//PH值
        E_HISDAT_BLUEGREENALGA  ((byte)184),	//blue green alga 蓝绿藻
        E_HISDAT_CHLOROPHYLL    ((byte)185),	//chlorophyll 叶绿素
        E_HISDAT_PHOSPHORUS     ((byte)186),	//total phosphorus 总磷
        E_HISDAT_NITROGEN       ((byte)187),	//total nitrogen   总氮
        E_HISDAT_ANMMONIANITROGEN((byte)188),	//anmmonia nitrogen氨氮
        /*#######################################################################################*/
        /*水文*/
        //FIXME						//temperature 温度   水文传感器
        E_HISDAT_SALINITY       ((byte)189),	//salinity 盐度
        E_HISDAT_DENSITY        ((byte)190),	//density 密度
        E_HISDAT_FLWRATE        ((byte)191),	//flow rate 流速
        E_HISDAT_FLWTOWARDS     ((byte)192),	//flow towards 流向
        E_HISDAT_CAPACITY       ((byte)193),	//flow capacity 流量
        E_HISDAT_WATERLV        ((byte)194),	//water level 水位
        /*#######################################################################################*/
        /*姿态传感器*/
        E_HISDAT_HEADING        ((byte)195),	//heading 航向
        E_HISDAT_ROLLING        ((byte)196),	//rolling 横滚
        E_HISDAT_PITCHING       ((byte)197),	//pitching 俯仰
        E_HISDAT_ACCELERATION   ((byte)198),	//Acceleration 加速度
        /*#######################################################################################*/
        ///*气象传感器*/
        E_HISDAT_WINDDIR        ((byte)199),	//wind direction 风向
        E_HISDAT_WINDSPEED      ((byte)200),	//wind speed 风速
        E_HISDAT_TEMPERATURE    ((byte)201),	//气温
        E_HISDAT_HUMIDITY       ((byte)202),	//humidity 湿度
        E_HISDAT_ATMOSPHERIC    ((byte)203),	//atmospheric 大气压
        E_HISDAT_RAINFALL       ((byte)204),	//rainfall 降雨量
        /*#######################################################################################*/
        /*测距 超声*/
        E_HISDAT_ULTRADISTANCE  ((byte)205),	//distance 距离 超声
        /*测距 超声阵列*/
        E_HISDAT_ARRYULTRADIS   ((byte)206),	//distance 距离 超声阵列
        /*#######################################################################################*/
        ///*测距 毫米波*/
        ///*测距 毫米波阵列*/
        E_HISDAT_MMWAVEDISTANCE ((byte)207),	//distance 距离 毫米波
        E_HISDAT_ARRYMILLIDIS   ((byte)208),	//distance 距离 毫米波阵列
        /*#######################################################################################*/
        /*#######################################################################################*/
        ///*经纬度*/
        E_HISDAT_LONGITUDE      ((byte)209),	//经度 longitude
        E_HISDAT_LATITUDE       ((byte)210),	//纬度 latitude
        /*#######################################################################################*/
        /*清污机构*/
        E_HISDAT_RMVCONTAMINATION((byte)211),	//removal of contamination 清污量
        /*#######################################################################################*/
        /*电机*/
        E_HISDAT_MOTORPOWER     ((byte)212),	//motor power电机功率
        E_HISDAT_MOTORSPEED     ((byte)213),	//motor speed电机转速
        E_HISDAT_MOTORVOLTAGE   ((byte)214),	//motor voltage 电机电压
        /*#######################################################################################*/
        /*版本信息*/
        E_HISDAT_FIRMWAREVERSION((byte)215),	//硬件固件版本
        E_HISDAT_SOFTWAREVERSION((byte)216),	//软件版本
        E_HISDAT_RESERVE        ((byte)217);	//

        private byte value;

        E_hisdat(byte value) {
            this.value = value;
        }

        public static E_hisdat getEnumByName(String name){
            E_hisdat[] values = E_hisdat.values();
            for (E_hisdat code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_hisdat e : E_hisdat.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue() {
            return value;
        }
    }

    public enum E_CheckPackage{

        E_CKPKG_CONTINUE    ((byte)1),	//有后续帧	，还需要接收完后续帧才能解析数据区
        E_CKPKG_SUCCESS     ((byte)2 ),	//可以进行数据区的解析
        E_CKPKG_INITERR     ((byte)3 ),	//函数指针初始化失败
        E_CKPKG_TIMEOUT     ((byte)4 ), //超时
        E_CKPKG_ERRSTAFLAG  ((byte)5 ), //错误的起始字符
        E_CKPKG_ERRLENBIT   ((byte)6 ),	//长度位不一致
        E_CKPKG_ERRFRAMELEN ((byte)7 ), //帧长度错误
        E_CKPKG_ERRMALLOC   ((byte)8 ), //内存申请失败
        E_CKPKG_ERRCHECKSUM ((byte)9 ), //校验和校验失败
        E_CKPKG_ERRENDFLAG  ((byte)10), //错误的结束字符
        E_CKPKG_ERRFRAMESEQ ((byte)11); //帧位置（序列）错误
        private byte value;
        E_CheckPackage (byte val){
            this.value = val;
        }

        public static E_CheckPackage getEnumByName(String name){
            E_CheckPackage[] values = E_CheckPackage.values();
            for (E_CheckPackage code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_CheckPackage e : E_CheckPackage.values()) {
               // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue() {
            return value;
        }
    }

    public enum E_transDir {
        //E_downlink_QT2ROBOT=0,
        //E_uplink_ROBOT2QT  =1,
        //[DIR:PRM]
        E_TD_SVR_ANSWER((byte)0),	//1服务器回复	00
        E_TD_SVR_REQUEST((byte)1),	//2服务器请求 01
        E_TD_TML_ANSWER((byte)2),	//3终端回复       10
        E_TD_TML_REQUEST((byte)3),	//4终端请求		  11
        E_TD_TML_RESERVE((byte)4);
        private byte value;
        E_transDir(byte val)
        {
            this.value = val;
        }

        public static E_transDir getEnumByName(String name){
            E_transDir[] values = E_transDir.values();
            for (E_transDir code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (Cenumclass.E_transDir e : Cenumclass.E_transDir.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue()
        {
            return this.value;
        }
    }

    public enum E_ctlFunCode
    {
        //slave 回复
        E_CFC_S_RECOGNITION((byte)0x0), //用于确认回复
        E_CFC_S_USERDATA((byte)0x08),   //用于用户数据
        E_CFC_S_DENY((byte)0x09),       //用于否认回复
        E_CFC_S_LINKSTATE((byte)0x0b),  //用于回应链路状态
        //master 请求
        E_CFC_M_RESET((byte)0x11),      //用于复位命令
        E_CFC_M_USERDATA((byte)0x14),   //用于接收用户数据
        E_CFC_M_LINKTEST((byte)0x19),   //用于链路检测
        E_CFC_M_REQ1STDAT((byte)0x1a),  //用于1级数据 【设置参数、控制命令】
        E_CFC_M_REQ2NDDAT((byte)0x1b);  //用于2级数据

        private byte value;
         E_ctlFunCode(byte val)
        {
            this.value = val;
        }

        public static E_ctlFunCode getEnumCodeByName(String name){
            E_ctlFunCode[] values = E_ctlFunCode.values();
            for (E_ctlFunCode code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_ctlFunCode e : E_ctlFunCode.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue()
        {
            return this.value;
        }
    }

    public enum E_appFuncCode{
        E_AFC_CONDENY		((byte)0x00),	//1 确认∕否认 Confirm or deny
        E_AFC_RESET			((byte)0x01),	//2 复位命令 reset
        E_AFC_LKDT			((byte)0x02),	//3 链路接口检测 Link interface detection
        E_AFC_RPTSTATION	((byte)0x03),	//4 中继站
        E_AFC_SETPARAM		((byte)0x04),	//5 设置参数
        E_AFC_CTLCMD		((byte)0x05),	//6 控制命令
        E_AFC_IDENTITY		((byte)0x06),	//7 身份认证及密钥协商
        E_AFC_RESERVE		((byte)0x07),  //8 预留
        E_AFC_TMLRPT		((byte)0x08),	//9 请求被级联终端主动上报 Terminal active report
        E_AFC_TMLCFGINFO	((byte)0x09),	//10请求终端配置及信息
        E_AFC_QUERYPARA		((byte)0x0A),	//11查询参数
        E_AFC_TASKDATA		((byte)0x0B),  //12请求任务数据
        E_AFC_RLTDATA		((byte)0x0C),	//13请求1类数据(实时数据,采集的数据)
        E_AFC_HISDATA		((byte)0x0D),	//14请求2类数据(历史数据,采集的数据)
        E_AFC_ALARMEVENT	((byte)0x0E),	//15请求3类数据(告警事件)
        E_AFC_FILETRANSF	((byte)0x0F),	//16文件传输
        E_AFC_FORWARDATA	((byte)0x10),	//17透明转发
        E_AFC_MAX			((byte)0xFF);			//
        private byte value;
        E_appFuncCode(byte val)
        {
            this.value = val;
        }

        public static E_appFuncCode getEnumByName(String name){
            E_appFuncCode[] values = E_appFuncCode.values();
            for (E_appFuncCode code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_appFuncCode e : E_appFuncCode.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue()
        {
            return this.value;
        }
    }

    public enum E_LinkDetection{
        E_LKDETEC_LOGIN((byte)1),    //F1登录
        E_LKDETEC_LOGOUT((byte)2),	//F2登出
        E_LKDETEC_HEARTBEAT((byte)3),//F3心跳
        E_LKDETEC_ERR((byte)4);
        private byte value;
        E_LinkDetection(byte val)
        {
            this.value = val;
        }

        public static E_LinkDetection getEnumByName(String name){
            E_LinkDetection[] values = E_LinkDetection.values();
            for (E_LinkDetection code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_LinkDetection e : E_LinkDetection.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public byte getValue() {
            return value;
        }
    }

     public enum E_Pn
    {
        E_PN_TERMAL((byte)0x00),			//表示终端本身
        E_PN_WATERQUALITY((byte)0x01),	    //水质感器测量点
        E_PN_HYDROLOGICAL((byte)0x02),		//水文传感器测量点
        E_PN_IMU((byte)0x03),				//姿态传感器测量点
        E_PN_METEOROLOGICAL((byte)0x04),   	//气象传感器测量点
        E_PN_ULTRASONIC((byte)0x05),    	//超声传感器测量点
        E_PN_ULTRASONIC_ARRY((byte)0x06),  	//超声波阵列传感器测量点
        E_PN_MMWAVE((byte)0x07),    		//毫米波传感器测量点
        E_PN_MMWAVE_ARRY((byte)0x08),  		//毫米波阵列传感器测量点

        E_PN_POSITION((byte)0x09),  		//位置信息GPS OR 北斗测量点
        E_PN_EXTENSIONARM((byte)0x0a),		//伸展臂 即清污机构
        E_PN_ELECTRICALMACHINE((byte)0x0b),	//电机
        E_PN_WAREVERSION((byte)0x0c),		//固件和软件版本
        E_PN_RGBD((byte)0x0d),    			//RGB-D测量点
        E_PN_360CAMERA1((byte)0x0e),//360全景摄像头2测量点
        E_PN_360CAMERA3((byte)0x0f),    	//360全景摄像头3测量点
        E_PN_360CAMERA4((byte)0x11),    	//360全景摄像头4测量点
        E_PN_MAX((byte)0x12);


        private byte value;
        E_Pn(byte val)
        {
            this.value = val;
        }

         E_Pn()
        {

        }

        public static E_Pn getEnumByName(String name){
            E_Pn[] values = E_Pn.values();
            for (E_Pn code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_Pn e : E_Pn.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public static E_Pn getEnumByIntValue(int value){
            String name = getNameByVal((byte) value);
            return getEnumByName(name);
        }

        public byte getValue() {
            return value;
        }
    }

    public enum E_ConfirmOrDeny
    {
        E_CONDENY_CONFIRMALL((byte)1),	//F1 全部确认
        E_CONDENY_GENERALDENY((byte)2),	//F2 全部否认
        E_CONDENY_WRDATAUNITERR((byte)3),//F3 写ERRO码到数据单元
        E_CONDENY_HARDWAREERR((byte)4),	//F4 硬件错误
        E_CONDENY_RESERVE((byte)5);
        private byte value;
        E_ConfirmOrDeny ()
        {}
        E_ConfirmOrDeny(byte val)
        {
            this.value = val;
        }

        public byte getValue() {
            return value;
        }

        public static E_ConfirmOrDeny getEnumByName(String name){
            E_ConfirmOrDeny[] values = E_ConfirmOrDeny.values();
            for (E_ConfirmOrDeny code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_ConfirmOrDeny e : E_ConfirmOrDeny.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
        public static E_ConfirmOrDeny getEnumByIntValue(int value){
            String name = getNameByVal((byte) value);
            return getEnumByName(name);
        }
    }

    public enum E_F3ErrNum
    {
        E_F3ERR_YES((byte)1),		//正确
        E_F3ERR_OTHERERR((byte)2),	//其他错误
        E_F3ERR_TABADDRDUP((byte)3),	//Table address duplication表地址重复
        E_F3ERR_RESERVE((byte)4);		//3-255备用
        private byte value;
        E_F3ErrNum()
        {}
        E_F3ErrNum(byte val)
        {
            this.value = val;
        }

        public byte getValue() {
            return value;
        }

        public static E_F3ErrNum getEnumByName(String name){
            E_F3ErrNum[] values = E_F3ErrNum.values();
            for (E_F3ErrNum code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_F3ErrNum e : E_F3ErrNum.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
    }

    public enum E_F4ErrNum
    {
        E_F4ERR_SIGN((byte)1),				//1表示签名校验错误
        E_F4ERR_CIPHERTEXTCHECK((byte)2),	//2表示密文校验错误 ciphertext checking 密文校验
        E_F4ERR_MACCHECK((byte)3),			//3表示对称MAC验证失败
        E_F4ERR_HARDWAREEXCEPTION((byte)4),	//4表示硬件工作异常
        E_F4ERR_MAX((byte)5);
        private byte value;
        E_F4ErrNum()
        {}
        E_F4ErrNum(byte val)
        {
            this.value = val;
        }

        public byte getValue() {
            return value;
        }

        public static E_F4ErrNum getEnumByName(String name){
            E_F4ErrNum[] values = E_F4ErrNum.values();
            for (E_F4ErrNum code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (E_F4ErrNum e : E_F4ErrNum.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
    }

    public enum CurrentFramePosition {
        /**
         * 多帧：中间帧
         */
        mutiple_middle((byte)0),
        /**
         * 多帧：结束帧
         */
        mutiple_start((byte)1),
        /**
         * 多帧：第1帧，有后续帧。
         */
        mutiple_end((byte)2),
        /**
         * 单帧
         */
        single((byte)3);

        private byte value;
        CurrentFramePosition(){}
        CurrentFramePosition(byte val){
            this.value = val;
        }

        public byte getValue() {
            return value;
        }

        public static CurrentFramePosition getEnumByName(String name){
            CurrentFramePosition[] values = CurrentFramePosition.values();
            for (CurrentFramePosition code : values) {
                if(name.equals(code.name())){
                    return code;
                }
            }
            return null;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (CurrentFramePosition e : CurrentFramePosition.values()) {
                // System.out.println(e.toString());
                if(val == e.getValue())
                {
                    //System.out.println("name:"+e.name());
                    retStr = e.name();
                }
            }
            return retStr;
        }
    }
}

