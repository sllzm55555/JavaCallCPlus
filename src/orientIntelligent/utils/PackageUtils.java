package orientIntelligent.utils;

import orientIntelligent.entity.PackageEntity;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;
import orientIntelligent.jni.DFSLDataType.CS_addrField;
import orientIntelligent.jni.DFSLDataType.CS_userdata_confirmOrDeny;
import orientIntelligent.jni.jni_enum.AdminZoneCode;
import orientIntelligent.jni.jni_enum.CountryCode;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageUtils {


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

        PackageUtils packageUtils = new PackageUtils();
        packageUtils.packageData(packageEntity);
    }
    public byte[] packageData(PackageEntity packageEntity){

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
        tmpDir = Cenumclass.E_transDir.getTransDirCodeByName(direction);

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
        重要事件计数器 一般事件计数器  启动帧计数器 消息认证码
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


}
