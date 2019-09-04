package orientIntelligent.jni;


public class CL1SetOpt {

    static {
        //C:\Users\Administrator\Desktop\class
      // System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
       System.load("E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
    }
   // public native
    /*
    * 注册一个协议对象
    * */
    public native int register_DFSLProOptS();
    /*
     * 注销一个协议对象
     * */
    public native void unRegister_DFSLProOptS(int DFSLProID);

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
        DFSLProtest();
    }

    public static void DFSLProtest()
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
        System.out.println(111);

    }

}
