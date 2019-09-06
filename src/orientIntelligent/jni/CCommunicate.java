package orientIntelligent.jni;

public class CCommunicate {


    static {
        //C:\Users\Administrator\Desktop\class
        // System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
        //E:\VS\DFSLProDemo\x64\Debug
        // System.load("E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
        System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
    }
    public void parse_msg_server()
    {
        boolean  ret_PW = true;
        boolean ret_Tpv=true;
        boolean ret_EC=true;
        CL1GetOpt tmpL1GetOpt = new CL1GetOpt();
        //step1 注册协议操作集
        int DFSLProID = tmpL1GetOpt.register_DFSLProOptS();
        byte bytes[] = {0x68 ,0x14 ,0x00 ,0x14 ,0x00 ,0x68 ,0x59 ,(byte)0x86 ,(byte)0x80 ,0x03  ,(byte)0x99 ,0x00 ,0x00 ,0x00 ,0x02 ,(byte)0xF0 ,0x00 ,0x00 ,0x01 ,0x00
                ,0x00 ,0x54 ,0x10 ,0x10 ,0x05 ,0x00 ,0x75 ,0x16};
        //step2  检查数据包完整性
        Cenumclass.E_CheckPackage ret = tmpL1GetOpt.check_package(DFSLProID,bytes);
        if(ret != Cenumclass.E_CheckPackage.E_CKPKG_SUCCESS)
        {
            System.out.println("Error to check package");
            return;
        }
        //step3 获取消息验证码
        byte[] pwd = tmpL1GetOpt.get_userData_dataUnit_pwd(DFSLProID);
        if(pwd == null)
        {
            ret_PW = false;
            System.out.println("bytes is null");
        }
        else
        {
            for(byte e:pwd)
            {
                System.out.print("e:"+e+" ");
            }
            System.out.println(" ");
        }

        //step4 读取打包时间
        CS_A16 time = tmpL1GetOpt.get_userData_dataUnit_time(DFSLProID);
        if(null == time)
        {
            ret_Tpv=false;
            System.out.println("未发现时间标签");
        }
        else
        {
            System.out.print(time.day_decade);
            System.out.print(time.day_digit+"日");
            System.out.print(time.hour_decade);
            System.out.print(time.hour_digit+"时");
            System.out.print(time.min_decade);
            System.out.print(time.min_digit+"分");
            System.out.print(time.sec_decade);
            System.out.println(time.sec_digit+"秒");
            System.out.println("ret:"+ret.name());
        }
        //step5 读取事件计数器
        CEvent event = tmpL1GetOpt.get_userData_dataUnit_events(DFSLProID);
        if(null == event)
        {
            ret_EC=false;
            System.out.println("未发现事件计数器");
        }
        else
        {
            System.out.println("important count:"+event.importantCount);
            System.out.println("general count:"+event.generalCount);
        }

        Cenumclass.E_ctlFunCode ctlFunCode = tmpL1GetOpt.get_ctlField_CFFuncCode(DFSLProID);
        System.out.println("ctlFunCode:"+ctlFunCode.name());

        Cenumclass.E_transDir transDir = tmpL1GetOpt.get_ctlField_DIR(DFSLProID);
        CEvent event2 = new CEvent((byte)1,(byte)2);
        System.out.println("event2.generalCount"+event2.generalCount);
        System.out.println("event2.importantCount"+event2.importantCount);

        System.out.println("transDir:"+transDir.name());
        //终端请求
        if(transDir == Cenumclass.E_transDir.E_TD_TML_REQUEST)
        {
            switch(ctlFunCode)
            {
                case E_CFC_M_USERDATA:
                    System.out.println("E_CFC_M_USERDATA");
                    break;
                case E_CFC_M_LINKTEST:
                    System.out.println("E_CFC_M_LINKTEST");
                    Cenumclass.E_appFuncCode appFuncCode = tmpL1GetOpt.get_userData_appFuncCode(DFSLProID);
                    System.out.println("appFuncCode:"+appFuncCode.name());
                    break;
                case E_CFC_M_REQ1STDAT:
                    System.out.println("E_CFC_M_REQ1STDAT");
                    break;
                case E_CFC_M_REQ2NDDAT:
                    System.out.println("E_CFC_M_REQ1STDAT");
                    break;
                    default:
                        System.out.println("Error transDir");
                        break;
            }
        }
        //终端回复
        else if(transDir == Cenumclass.E_transDir.E_TD_TML_ANSWER)
        {
            switch(ctlFunCode)
            {
                case E_CFC_S_RECOGNITION:
                    System.out.println("E_CFC_S_RECOGNITION");
                    break;
                case E_CFC_S_USERDATA:
                    System.out.println("E_CFC_M_LINKTEST");
                    break;
                case E_CFC_S_DENY:
                    System.out.println("E_CFC_M_REQ1STDAT");
                    break;
                case E_CFC_S_LINKSTATE:
                    System.out.println("E_CFC_M_REQ1STDAT");
                    break;
                default:
                    System.out.println("Error transDir");
                    break;
            }
        }
        //错误的帧传输方向
        else
        {
            //TODO Error handling
            System.out.println("Error transDir");
        }


        tmpL1GetOpt.unRegister_DFSLProOptS(DFSLProID);
    }

    public static void main(String[] args) {
        CCommunicate com =  new CCommunicate();
        com.parse_msg_server();
    }
}
