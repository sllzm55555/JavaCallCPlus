package orientIntelligent.utils;

import orientIntelligent.entity.PackageEntity;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;
import orientIntelligent.jni.DFSLDataType.CS_addrField;
import orientIntelligent.jni.jni_enum.AdminZoneCode;
import orientIntelligent.jni.jni_enum.CountryCode;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageUtils {


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

        tmpDir = Cenumclass.E_transDir.getTransDirCodeByName(direction);
//        if(direction.equals(Cenumclass.E_transDir.E_TD_SVR_REQUEST.name())){
//            tmpDir = Cenumclass.E_transDir.E_TD_SVR_REQUEST;
//        }
//        if(direction.equals(Cenumclass.E_transDir.E_TD_SVR_ANSWER.name())){
//            tmpDir = Cenumclass.E_transDir.E_TD_SVR_ANSWER;
//        }

        Cenumclass.E_ctlFunCode tmpcfc = Cenumclass.E_ctlFunCode.getCtlFunCodeCodeByName(direction);
//        if(direction.equals(Cenumclass.E_ctlFunCode..name())){
//            tmpDir = Cenumclass.E_transDir.E_TD_SVR_REQUEST;
//        }
        tmpL1SetOpt.set_ctlFieldC_all(DFSLProID, tmpDir,fcvBit,fcbBit, tmpcfc);//设置到内存
        //应用层功能码
        Cenumclass.E_appFuncCode tmpafc = Cenumclass.E_appFuncCode.getAppFuncCodeByName(packageEntity.getRequestType());
        tmpL1SetOpt.set_userData_appFuncCode(DFSLProID,tmpafc);
        //设置数据单元

        //设置附加信息
        byte[] tmpPwd = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        byte importantEventCount = (byte)0x6;//重要事件

        byte generalEventCount = (byte)0x6;//一般事件

        byte pfc = (byte)0x0;//启动帧计数器
        tmpL1SetOpt.set_userData_aux(DFSLProID,importantEventCount,generalEventCount,pfc,tmpPwd);
        //获取帧数据
        byte[] sendBuf = tmpL1SetOpt.serializeToBuf(DFSLProID);
        //注销
        tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);

        return null;
    }


}
