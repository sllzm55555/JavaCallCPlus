package orientIntelligent.jni;

public class CL1SetOpt extends CDFSLProOpt{

    static {
        //C:\Users\Administrator\Desktop\class
      // System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
        //E:\VS\DFSLProDemo\x64\Debug
      // System.load("E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
       System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
    }
   // public native
    /**
     *
     * @param DFSLProID 协议对象ID
     * @param addrField 传入地址域参数
     */
    public native void set_addrField(int DFSLProID,CS_addrField addrField);

    /**
     *
     * @param DFSLProID 协议对象ID
     * @param dir   数据传输方向
     * @param reserveOrFCV
     * @param ACDorFCB
     * @param cfc 控制域功能码
     */
    public native void set_ctlFieldC_all(int DFSLProID,Cenumclass.E_transDir dir, boolean reserveOrFCV, boolean ACDorFCB, Cenumclass.E_ctlFunCode cfc);
    public native void set_userData_appFuncCode(int DFSLProID,Cenumclass.E_appFuncCode afc);
    public native void set_userData_dataUnit_linkDetection_uplink(int DFSLProID,Cenumclass.E_LinkDetection linkDeteNum);
    public native void set_userData_aux(int DFSLProID,byte ec1num_important ,byte ec2num_general,byte current_pfc,byte []password);
    public native void send_buf_server(int DFSLProID);
    void callbackWrite(byte[] bytes){
        /*
        try {
            //dos.write(bytes);
            System.out.println("[java send] length = " + bytes.length + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i < bytes.length; i++) {
            System.out.print("bytes:"+bytes[i]);
        }


        System.out.println("bytes.length:"+bytes.length);

       // System.out.println("It`s OK:");
        return ;
    };
    void test()
    {
        System.out.println("hello test in");
    }
    public static void main(String[] args) {
        DFSLProL1GetTest();
    }

    public static void DFSLProL1SetTest()
    {
        CL1SetOpt tmpL1SetOpt = new CL1SetOpt();
        int DFSLProID = tmpL1SetOpt.register_DFSLProOptS();
        //tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
        //int DFSLProID2 = tmpL1SetOpt.register_DFSLProOptS();
        System.out.println("DFSLProID:"+DFSLProID);
        byte[] A4_SN = {(byte)0x56,(byte)0x34,(byte)0x12};
        CS_addrField addrField = new CS_addrField();
        CS_addrField.CS_adminZoneCode adminZoneCode = addrField.get_adminZoneCode();
        CS_addrField.CS_tmladd tmladd = addrField.get_tmladd();
        addrField.set_A4_SN(A4_SN);
        addrField.set_adminZoneCode((byte)0,(byte)8,(byte)3,(byte)0);
        addrField.set_tmladd((byte)9,(byte)9);
        addrField.set_A1_countcode((byte)0x86);
        //new CL1SetOpt().set_addrField(addrField);
        tmpL1SetOpt.set_addrField(DFSLProID,addrField);
        //(2)set_ctlFieldC_all
        //step1 set E_transDir
        Cenumclass.E_transDir tmpDir = Cenumclass.E_transDir.E_TD_SVR_ANSWER;
        //step2 set E_ctlFunCode
        Cenumclass.E_ctlFunCode tmpcfc= Cenumclass.E_ctlFunCode.E_CFC_M_LINKTEST;
        //step3 set FCV FCB
        boolean fcvBit = true;
        boolean fcbBit = true;
        //step4 call set_ctlFieldC_all
        tmpL1SetOpt.set_ctlFieldC_all(DFSLProID,Cenumclass.E_transDir.E_TD_SVR_REQUEST,
                fcvBit,fcbBit, Cenumclass.E_ctlFunCode.E_CFC_M_LINKTEST);
        //(3)set_userData_appFuncCode
        Cenumclass.E_appFuncCode tmpafc = Cenumclass.E_appFuncCode.E_AFC_LKDT;
        tmpL1SetOpt.set_userData_appFuncCode(DFSLProID,tmpafc);
        //(4)set_userData_dataUnit_linkDetection_uplink
        Cenumclass.E_LinkDetection tmpLdt = Cenumclass.E_LinkDetection.E_LKDETEC_LOGIN;
        tmpL1SetOpt.set_userData_dataUnit_linkDetection_uplink(DFSLProID,tmpLdt);
        //(5)set_userData_aux
        byte[] tmpPwd = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        tmpL1SetOpt.set_userData_aux(DFSLProID,(byte)0x6,(byte)0x6,(byte)0x0,tmpPwd);
        tmpL1SetOpt.send_buf_server(DFSLProID);
        tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
        System.out.println(111);
    }

    public static void DFSLProL1GetTest(){
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


        CEvent event = tmpL1GetOpt.get_userData_dataUnit_events(DFSLProID);
        if(null == event)
        {
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
        System.out.println("transDir:"+transDir.name());

        Cenumclass.E_appFuncCode appFuncCode = tmpL1GetOpt.get_userData_appFuncCode(DFSLProID);
        System.out.println("appFuncCode:"+appFuncCode.name());
        tmpL1GetOpt.unRegister_DFSLProOptS(DFSLProID);
    }

}
