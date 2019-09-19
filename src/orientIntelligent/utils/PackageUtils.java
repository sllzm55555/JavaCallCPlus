package orientIntelligent.utils;

import orientIntelligent.entity.PackageEntity;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;
import orientIntelligent.jni.DFSLDataType.CS_addrField;
import orientIntelligent.jni.DFSLDataType.CS_userdata_confirmOrDeny;
import orientIntelligent.jni.jni_enum.AdminZoneCode;
import orientIntelligent.jni.jni_enum.CountryCode;

import javax.swing.*;
import java.io.*;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageUtils {
    //E:\Idea\JavaCallCPlus1\src\orientIntelligent\dll\DFSLProDemo.dll
    public static final String BIN_LIB = "E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\";
    static {
        //本地路径
        //System.load("D:\\OrientIntelligent\\svn\\JavaCallCPlus\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
        //VS路径
//        System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
    }


    public static void main(String[] args) {

        PackageEntity packageEntity = new PackageEntity();
        /*地址域
        序列号 行政区划码 机器型号 国家代码
        */
        packageEntity.setAdminZoneCode("成都");//行政区划码
        packageEntity.setCountyCode("中国");//国家代码
        packageEntity.setSerializableCode("123456");//序列号
        packageEntity.setRobotModelCode(99);//机器型号

        /*控制域
        帧传输方向,帧计数位,帧有效位, 链路层功能码
        帧计数位 帧有效位 链路层功能码 暂未设置
        */
        packageEntity.setDirection(Cenumclass.E_transDir.E_TD_SVR_ANSWER.name());//帧传输方向

        /*
        应用层功能码
         */
        packageEntity.setRequestType(Cenumclass.E_appFuncCode.E_AFC_LKDT.name());
        /*
        设置数据单元
         */
        packageEntity.setIsConfirm(Cenumclass.E_ConfirmOrDeny.E_CONDENY_CONFIRMALL.name());

        byte[] bytes = packageData(packageEntity);

    }
    public static byte[] packageData(PackageEntity packageEntity){

//        System.load("E:\\VS\\DFSLProDemo\\x64\\Debug\\DFSLProDemo.dll");
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
        String serializableCode = packageEntity.getSerializableCode();
        byte[] A4_SN = serializableCode.getBytes();
        int adminZoneCode = AdminZoneCode.getValueByName(packageEntity.getAdminZoneCode());
        int robotModelCode = packageEntity.getRobotModelCode();
        byte countyCode = CountryCode.getValueByName(packageEntity.getCountyCode());
        addrField.set_A1_countcode(countyCode);
        addrField.set_A4_SN(A4_SN);
        byte[] modeCode = BytesUtil.int2Bytes(robotModelCode);
        addrField.set_tmladd(modeCode[0],modeCode[1]);
        byte[] zoneCode = BytesUtil.int2Bytes(adminZoneCode);
        addrField.set_adminZoneCode(zoneCode[0],zoneCode[1],zoneCode[2],zoneCode[3]);
        tmpL1SetOpt.set_addrField(DFSLProID,addrField);//设置到内存
        //控制域
        String direction = packageEntity.getDirection();
        Cenumclass.E_transDir tmpDir = null;

        //byte tmpcfc = 0;
        boolean fcvBit = true;
        boolean fcbBit = true;
        Cenumclass.E_ctlFunCode cfc = Cenumclass.E_ctlFunCode.E_CFC_M_LINKTEST;
        tmpDir = Cenumclass.E_transDir.getEnumByName(direction);

        //Cenumclass.E_ctlFunCode tmpcfc = Cenumclass.E_ctlFunCode.getEnumCodeByName(direction);

        tmpL1SetOpt.set_ctlFieldC_all(DFSLProID, tmpDir,fcvBit,fcbBit, cfc);//设置到内存
        //应用层功能码
        Cenumclass.E_appFuncCode tmpafc = Cenumclass.E_appFuncCode.getEnumByName(packageEntity.getRequestType());
        tmpL1SetOpt.set_userData_appFuncCode(DFSLProID,tmpafc);
        //设置数据单元
        String isConfirm = packageEntity.getIsConfirm();

        CS_userdata_confirmOrDeny targetConfirmOrDeny = null;
        Cenumclass.E_ConfirmOrDeny Fn = Cenumclass.E_ConfirmOrDeny.getEnumByName(isConfirm);
        switch (Fn)
        {
            case E_CONDENY_CONFIRMALL://F1 全部确认 数据区为空
                break;
            case E_CONDENY_GENERALDENY://F2 全部否认 数据区为空
                break;
            case E_CONDENY_WRDATAUNITERR://F3 数据区带F3错误码
                //F3
                targetConfirmOrDeny =
                        new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F3(Cenumclass.E_F3ErrNum.E_F3ERR_YES));
                break;
            case E_CONDENY_HARDWAREERR: //F4 硬件错误
                byte[] data = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
                //########################################
                targetConfirmOrDeny =
                        new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F4(Cenumclass.E_F4ErrNum.E_F4ERR_CIPHERTEXTCHECK,data));
                break;
        }
        boolean retSet =  tmpL1SetOpt.set_userData_dataUnit_confirmOrDeny(DFSLProID, Cenumclass.E_Pn.E_PN_TERMAL, Fn,targetConfirmOrDeny);
        if(retSet == false)
        {
            tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
            return null;
        }
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

        if(null!=sendBuf)
        {
            for (byte sb: sendBuf
                 ) {
              System.out.print(" "+(int)sb);
            }
            return sendBuf;
        }
        return null;
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