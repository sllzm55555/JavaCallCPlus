package orientIntelligent.utils;

import orientIntelligent.entity.*;
import orientIntelligent.entity.AddressField;
import orientIntelligent.entity.LinkData;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;
import orientIntelligent.jni.DFSLDataType.CS_addrField;
import orientIntelligent.jni.DFSLDataType.CS_userdata_confirmOrDeny;
import orientIntelligent.jni.jni_enum.AdminZoneCode;
import orientIntelligent.jni.jni_enum.CountryCode;

import java.io.*;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageUtils {

    public static final String BIN_LIB = "E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\";

    public static void main(String[] args) {

        PackProtocolContent packProtocol = new PackProtocolContent();
        /*地址域
        序列号 行政区划码 机器型号 国家代码
        */
        packProtocol.setAddressField(new AddressField("中国", "成都", "99", "123456"));

        /*控制域
        帧传输方向,帧计数位,帧有效位, 链路层功能码
        帧计数位 帧有效位 链路层功能码 暂未设置
        */
        packProtocol.setDirection(Cenumclass.E_transDir.E_TD_SVR_ANSWER.name());

        /*
        应用层功能码
         */
        //链路检测
//        packProtocol.setLinkData(new LinkData(Cenumclass.E_appFuncCode.E_AFC_LKDT, null, null));
        //实时数据
        packProtocol.setLinkData(new LinkData(Cenumclass.E_appFuncCode.E_AFC_RLTDATA, null, null));
        /*
        设置数据单元
         */
//        packProtocol.setIsConfirm(Cenumclass.E_ConfirmOrDeny.E_CONDENY_CONFIRMALL.name());

        packageData(packProtocol);

    }
    public static byte[] packageData(PackProtocolContent packProtocol){


//        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");
//        try {
//            //loadLib("MyMathLibForJava.dll");C:\Users\Administrator\AppData\Local\Temp\MyMathLibForJava.dll.dll
//            loadLib("DFSLProDemo");
//            //JOptionPane.showMessageDialog(null, "1234");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex.getStackTrace());
//        }

        CL1SetOpt tmpL1SetOpt = new CL1SetOpt();

        //注册
        int DFSLProID = tmpL1SetOpt.register_DFSLProOptS();

        //设置地址域
        CS_addrField addrField = new CS_addrField();
        String serializableCode = packProtocol.getAddressField().getSerializeCode();
        byte[] A4_SN = serializableCode.getBytes();
        int adminZoneCode = AdminZoneCode.getValueByName(packProtocol.getAddressField().getZoneCode());
        int robotModelCode = Integer.valueOf(packProtocol.getAddressField().getRobotCode());
        byte countryCode = CountryCode.getValueByName(packProtocol.getAddressField().getCountryCode());
        addrField.set_A1_countcode(countryCode);
        addrField.set_A4_SN(A4_SN);
        byte[] modeCode = BytesUtil.int2Bytes(robotModelCode);
        addrField.set_tmladd(modeCode[0],modeCode[1]);
        byte[] zoneCode = BytesUtil.int2Bytes(adminZoneCode);
        addrField.set_adminZoneCode(zoneCode[0],zoneCode[1],zoneCode[2],zoneCode[3]);
        tmpL1SetOpt.set_addrField(DFSLProID,addrField);//设置到内存
        //控制域
        boolean fcvBit = true;
        boolean fcbBit = true;
        //链路测试
//        Cenumclass.E_ctlFunCode cfc = Cenumclass.E_ctlFunCode.E_CFC_M_LINKTEST;
        //实时数据
        Cenumclass.E_ctlFunCode cfc = packProtocol.getControlField().getCfc();
        Cenumclass.E_transDir tmpDir = packProtocol.getControlField().getDirection();

        tmpL1SetOpt.set_ctlFieldC_all(DFSLProID, tmpDir,fcvBit,fcbBit, cfc);//设置到内存
        //应用层功能码
        Cenumclass.E_appFuncCode tmpafc = packProtocol.getLinkData().getApplicationFunctionCode();
        tmpL1SetOpt.set_userData_appFuncCode(DFSLProID,tmpafc);
        //设置数据单元
        tmpL1SetOpt.set_userData_dataUnit_realTimeData_downlink(DFSLProID, Cenumclass.E_Pn.getEnumByName(Cenumclass.E_Pn.getNameByVal((byte)(packProtocol.getLinkData().getDataUnitList().get(0).getPn()))));


//        String isConfirm = packProtocol.getIsConfirm();
//
//        CS_userdata_confirmOrDeny targetConfirmOrDeny = null;
//        Cenumclass.E_ConfirmOrDeny Fn = Cenumclass.E_ConfirmOrDeny.getEnumByName(isConfirm);
//        switch (Fn)
//        {
//            case E_CONDENY_CONFIRMALL://F1 全部确认 数据区为空
//                break;
//            case E_CONDENY_GENERALDENY://F2 全部否认 数据区为空
//                break;
//            case E_CONDENY_WRDATAUNITERR://F3 数据区带F3错误码
//                //F3
//                targetConfirmOrDeny =
//                        new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F3(Cenumclass.E_F3ErrNum.E_F3ERR_YES));
//                break;
//            case E_CONDENY_HARDWAREERR: //F4 硬件错误
//                byte[] data = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
//                //########################################
//                targetConfirmOrDeny =
//                        new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F4(Cenumclass.E_F4ErrNum.E_F4ERR_CIPHERTEXTCHECK,data));
//                break;
//        }
//        boolean retSet =  tmpL1SetOpt.set_userData_dataUnit_confirmOrDeny(DFSLProID, Cenumclass.E_Pn.E_PN_TERMAL, Fn,targetConfirmOrDeny);
//        if(retSet == false)
//        {
//            tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
//            return null;
//        }
        /*设置附加信息
        重要事件计数器 一般事件计数器 启动帧计数器 消息认证码
         */
        byte[] tmpPwd = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};//消息认证码
        byte importantEventCount = (byte)0x6;//重要事件计数器
        byte generalEventCount = (byte)0x6;//一般事件计数器
        byte pfc = (byte)0x0;//启动帧计数器
        tmpL1SetOpt.set_userData_aux(DFSLProID,importantEventCount,generalEventCount,pfc,tmpPwd);
        //获取帧数据
        byte[] sendBuf = tmpL1SetOpt.serializeToBuf(DFSLProID);
        //注销
        tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);

        return sendBuf;
    }


    public synchronized static void loadLib(String libName) throws IOException {
        String systemType = System.getProperty("os.name");
        String libExtension = (systemType.toLowerCase().indexOf("win")!=-1) ? ".dll" : ".so";
        System.out.println("libExtension:"+libExtension);
        String libFullName = libName + libExtension;
        System.out.println("libFullName:"+libFullName);
        String nativeTempDir = System.getProperty("java.io.tmpdir");
        System.out.println("nativeTempDir:"+nativeTempDir);
        InputStream in = null;
        BufferedInputStream reader = null;
        FileOutputStream writer = null;
        String fullFileNameOut = nativeTempDir+ File.separator+libFullName;
        System.out.println("fullFileNameOut:"+fullFileNameOut);

        String fullFileNameIn = PackageUtils.BIN_LIB + libFullName;
        System.out.println("fullFileNameIn:"+fullFileNameIn);
        File extractedLibFile = new File(nativeTempDir+File.separator+libFullName);
        System.out.println("extractedLibFile.exists():"+extractedLibFile.exists());

        try {
            //FileInputStream fis = new FileInputStream("f:\\files\\1.txt");
            FileInputStream fis = new FileInputStream(fullFileNameIn);
            //FileOutputStream fos = new FileOutputStream("f:\\files\\copy.txt");
            FileOutputStream fos = new FileOutputStream(fullFileNameOut);
            int n = 0;
            while ((n = fis.read()) != -1) {
                fos.write(n);
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.load(extractedLibFile.toString());
    }

}
