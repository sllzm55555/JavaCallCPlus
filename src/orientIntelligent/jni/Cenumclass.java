package orientIntelligent.jni;

public class Cenumclass {

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

        public byte getValue() {
            return value;
        }
    }
}

/*
* //数据链路检测Fn定义
typedef enum linkdetection
{
	E_LKDETEC_LOGIN=1,	//F1登录
	E_LKDETEC_LOGOUT,	//F2登出
	E_LKDETEC_HEARTBEAT,//F3心跳
	E_LKDETEC_ERR,
}E_LinkDetection;
* */

/*
* typedef enum Application_function_code
{
	E_AFC_CONDENY		=0x00,	//1 确认∕否认 Confirm or deny
	E_AFC_RESET			=0x01,	//2 复位命令 reset
	E_AFC_LKDT			=0x02,	//3 链路接口检测 Link interface detection
	E_AFC_RPTSTATION	=0x03,	//4 中继站
	E_AFC_SETPARAM		=0x04,	//5 设置参数
	E_AFC_CTLCMD		=0x05,	//6 控制命令
	E_AFC_IDENTITY		=0x06,	//7 身份认证及密钥协商
	E_AFC_RESERVE		=0x07,  //8 预留
	E_AFC_TMLRPT		=0x08,	//9 请求被级联终端主动上报 Terminal active report
	E_AFC_TMLCFGINFO	=0x09,	//10请求终端配置及信息
	E_AFC_QUERYPARA		=0x0A,	//11查询参数
	E_AFC_TASKDATA		=0x0B,  //12请求任务数据
	E_AFC_RLTDATA		=0x0C,	//13请求1类数据(实时数据,采集的数据)
	E_AFC_HISDATA		=0x0D,	//14请求2类数据(历史数据,采集的数据)
	E_AFC_ALARMEVENT	=0x0E,	//15请求3类数据(告警事件)
	E_AFC_FILETRANSF	=0x0F,	//16文件传输
	E_AFC_FORWARDATA	=0x10,	//17透明转发
	E_AFC_MAX			=0xFF,			//
}E_appFuncCode;
* */

/*
* typedef enum  Controlfield_Function_Code
{
//slave
	E_CFC_S_RECOGNITION = 0x00, 	 //0  认可
	E_CFC_S_USERDATA = 0x08,		 //8  响应帧 用户数据
	E_CFC_S_DENY = 0x09,			 //9  响应帧 否认：无所召唤的数据
	E_CFC_S_LINKSTATE = 0x0b,	 //11 响应帧 链路状态
//master
	E_CFC_M_RESET = 0x11,				//1  发送∕确认 复位命令
	E_CFC_M_USERDATA = 0x14, 			//4  发送∕无回答 用户数据
	E_CFC_M_LINKTEST = 0x19, 			//9  请求∕响应帧 链路测试
	E_CFC_M_REQ1STDAT = 0x1a, 	//10 请求∕响应帧 请求1级数据
	E_CFC_M_REQ2NDDAT = 0x1b,	//11 请求∕响应帧 请求2级数据
}E_ctlFunCode;
* */