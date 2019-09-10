package orientIntelligent.jni;

import orientIntelligent.jni.DFSLDataType.CEvent;
import orientIntelligent.jni.DFSLDataType.CS_A16;
import orientIntelligent.jni.DFSLDataType.CS_userdata_confirmOrDeny;
import orientIntelligent.jni.DFSLDataType.CS_userdata_confirmOrDeny.*;
import orientIntelligent.jni.DFSLDataType.CS_addrField;


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
    public native void set_addrField(int DFSLProID, CS_addrField addrField);

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
    //bool (*set_userData_dataUnit_confirmOrDeny)(POptS THIS,uint16 Pn,E_ConfirmOrDeny Fn,U_userdata_confirmOrDeny target);
    //public native void set_userData_dataUnit_linkDetection_uplink(int DFSLProID,Cenumclass.E_LinkDetection linkDeteNum);
    public native boolean set_userData_dataUnit_confirmOrDeny(int DFSLProID,Cenumclass.E_Pn Pn,Cenumclass.E_ConfirmOrDeny Fn,CS_userdata_confirmOrDeny target);
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
        DFSLProL1SetTest();
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

        //Cenumclass.E_LinkDetection tmpLdt = Cenumclass.E_LinkDetection.E_LKDETEC_LOGIN;
       //创建内部类方法一
       // S_userdata_confirmOrDeny_F3 target= new CS_userdata_confirmOrDeny( ).new  S_userdata_confirmOrDeny_F3(Cenumclass.E_F3ErrNum.E_F3ERR_YES);
       // CS_userdata_confirmOrDeny targetConfirmOrDeny = new CS_userdata_confirmOrDeny( target);
        //创建内部类方法二
        //F3
        CS_userdata_confirmOrDeny targetConfirmOrDenyF3 = new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new  S_userdata_confirmOrDeny_F3(Cenumclass.E_F3ErrNum.E_F3ERR_YES));
        //F4
        byte[] data = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        CS_userdata_confirmOrDeny targetConfirmOrDenyF4 = new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new  S_userdata_confirmOrDeny_F4(Cenumclass.E_F4ErrNum.E_F4ERR_CIPHERTEXTCHECK,data));
        //System.out.println("targetConfirmOrDeny.F3:"+targetConfirmOrDenyF3.getF3().getF3errNum().getValue());
        //System.out.println("targetConfirmOrDeny.F4:"+targetConfirmOrDenyF4.getF4().getF4errNum().getValue());
        boolean retSet =  tmpL1SetOpt.set_userData_dataUnit_confirmOrDeny(DFSLProID,Cenumclass.E_Pn.E_PN_360CAMERA1,Cenumclass.E_ConfirmOrDeny.E_CONDENY_HARDWAREERR,targetConfirmOrDenyF4);
        if(retSet == false)
        {
            tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
            return;
        }
        //(5)set_userData_aux
        byte[] tmpPwd = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        tmpL1SetOpt.set_userData_aux(DFSLProID,(byte)0x6,(byte)0x6,(byte)0x0,tmpPwd);
        tmpL1SetOpt.send_buf_server(DFSLProID);
        tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);

    }


}
