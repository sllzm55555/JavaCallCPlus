package orientIntelligent.jni;

public class Cenumclass {
    /*public Cenumclass()
    {

    }*/
    enum E_CheckPackage{
        E_CKPKG_FRAMEERR((byte)1),	//帧错误   ，不能解析数据区
        E_CKPKG_CONTINUE((byte)2),	//有后续帧	，还需要接收完后续帧才能解析数据区
        E_CKPKG_SUCCESS((byte)3),	//可以进行数据区的解析
        E_CKPKG_MALLOCERR((byte)4),	//申请内存错误
        E_CKPKG_INITERR((byte)5),	//函数指针初始化失败
        E_CKPKG_TIMEOUT((byte)6);
        private byte value;
        E_CheckPackage (byte val){
            this.value = val;
        }

        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (Cenumclass.E_CheckPackage e : Cenumclass.E_CheckPackage.values()) {
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

    enum E_transDir {
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

     enum E_ctlFunCode
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
        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (Cenumclass.E_ctlFunCode e : Cenumclass.E_ctlFunCode.values()) {
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

    enum E_appFuncCode{
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
        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (Cenumclass.E_appFuncCode e : Cenumclass.E_appFuncCode.values()) {
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

    enum E_LinkDetection{
        E_LKDETEC_LOGIN((byte)1),    //F1登录
        E_LKDETEC_LOGOUT((byte)2),	//F2登出
        E_LKDETEC_HEARTBEAT((byte)3),//F3心跳
        E_LKDETEC_ERR((byte)4);
        private byte value;
        E_LinkDetection(byte val)
        {
            this.value = val;
        }
        public static String getNameByVal(byte val)
        {
            String retStr = "";
            for (Cenumclass.E_LinkDetection e : Cenumclass.E_LinkDetection.values()) {
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

     enum E_Pn
    {
        E_PN_TERMAL((byte)0x00),			//表示终端本身
        E_PN_WATERQUALITY1((byte)0x01),	//水质感器测量点
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

        /*E_PN_TERMAL((byte)0x00),			//表示终端本身
        E_PN_WATERQUALITY1,	//水质感器测量点
        E_PN_HYDROLOGICAL,		//水文传感器测量点
        E_PN_IMU,				//姿态传感器测量点
        E_PN_METEOROLOGICAL,   	//气象传感器测量点
        E_PN_ULTRASONIC,    	//超声传感器测量点
        E_PN_ULTRASONIC_ARRY,  	//超声波阵列传感器测量点
        E_PN_MMWAVE,    		//毫米波传感器测量点
        E_PN_MMWAVE_ARRY,  		//毫米波阵列传感器测量点

        E_PN_POSITION,  		//位置信息GPS OR 北斗测量点
        E_PN_EXTENSIONARM,		//伸展臂 即清污机构
        E_PN_ELECTRICALMACHINE,	//电机
        E_PN_WAREVERSION,		//固件和软件版本
        E_PN_RGBD,    			//RGB-D测量点
        E_PN_360CAMERA1,//360全景摄像头2测量点
        E_PN_360CAMERA3,    	//360全景摄像头3测量点
        E_PN_360CAMERA4,    	//360全景摄像头4测量点
        E_PN_MAX;*/

        private byte value;
        E_Pn(byte val)
        {
            this.value = val;
        }

         E_Pn()
        {

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
    }
}

