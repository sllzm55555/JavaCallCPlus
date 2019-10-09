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
import java.util.List;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */
public class PackageUtils {

    public static final String BIN_LIB = "E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\";


    public static void main(String[] args) {

        ProtocolContent protocolContent = new ProtocolContent();
        //地址域
            //序列号 行政区划码 机器型号 国家代码
            protocolContent.setAddressField(new AddressField("中国", "成都", "99", "123456"));
        //控制域
            //帧传输方向,帧计数位,帧有效位, 链路层功能码
            //帧计数位 帧有效位 链路层功能码 暂未设置
            ControlField controlField = new ControlField();
            controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_ANSWER);
            protocolContent.setControlField(controlField);
        //应用层功能码
            //链路检测
            //packProtocol.setLinkData(new LinkData(Cenumclass.E_appFuncCode.E_AFC_LKDT, null, null));
            //实时数据
            protocolContent.setLinkData(new LinkData(Cenumclass.E_appFuncCode.E_AFC_RLTDATA, null, null));
        //附加信息
            ExtraMessage extraMessage = new ExtraMessage();
            extraMessage.setAuthorization(new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
            protocolContent.setExtraMessage(extraMessage);
        //打包
        packageData(protocolContent);

    }
    public static byte[] packageData(ProtocolContent protocolContent){

        CL1SetOpt tmpL1SetOpt = new CL1SetOpt();

        //注册
        int DFSLProID = tmpL1SetOpt.register_DFSLProOptS();

        //设置地址域
        CS_addrField addrField = new CS_addrField();

        AddressField addressField = protocolContent.getAddressField();

        if (addressField != null) {
            String serializableCode = addressField.getSerializeCode();
            byte[] A4_SN = serializableCode.getBytes();
            int adminZoneCode = AdminZoneCode.getValueByName(addressField.getZoneCode());
            int robotModelCode = Integer.parseInt(addressField.getRobotCode(), 16);
            byte countryCode = CountryCode.getValueByName(addressField.getCountryCode());
            addrField.set_A1_countcode(countryCode);
            addrField.set_A4_SN(A4_SN);
            byte[] modeCode = BytesUtil.int2Bytes(robotModelCode);
            addrField.set_tmladd(modeCode[0],modeCode[1]);
            byte[] zoneCode = BytesUtil.int2Bytes(adminZoneCode);
            addrField.set_adminZoneCode(zoneCode[0],zoneCode[1],zoneCode[2],zoneCode[3]);
            //设置到内存
            tmpL1SetOpt.set_addrField(DFSLProID,addrField);
        }
        //控制域
        boolean fcvBit = true;
        boolean fcbBit = true;
        //实时数据
        ControlField controlField = protocolContent.getControlField();

        Cenumclass.E_ctlFunCode cfc = null;
        Cenumclass.E_transDir tmpDir = null;
        if (controlField != null) {
            cfc = controlField.getCfc();
            tmpDir = controlField.getDirection();
        }

        //设置到内存
        tmpL1SetOpt.set_ctlFieldC_all(DFSLProID, tmpDir, fcvBit, fcbBit, cfc);

        //应用层功能码
        LinkData linkData = protocolContent.getLinkData();
        List<DataUnit> dataUnitList = linkData.getDataUnitList();
        DataUnit dataUnit = null;
        if (dataUnitList != null) {
            dataUnit = dataUnitList.get(0);
            Cenumclass.E_appFuncCode tmpafc = linkData.getApplicationFunctionCode();
            tmpL1SetOpt.set_userData_appFuncCode(DFSLProID,tmpafc);
            //设置数据单元[数据单元标识Pn+Fn 数据单元数据data]
            tmpL1SetOpt.set_userData_dataUnit_realTimeData_downlink(DFSLProID, Cenumclass.E_Pn.getEnumByIntValue(dataUnit.getPn()));
        }

        if (dataUnit != null) {
            CS_userdata_confirmOrDeny targetConfirmOrDeny = null;
            Cenumclass.E_ConfirmOrDeny fn = Cenumclass.E_ConfirmOrDeny.getEnumByIntValue(dataUnit.getFn());
            switch (fn) {
                //F1 全部确认 数据区为空
                case E_CONDENY_CONFIRMALL:
                    break;
                //F2 全部否认 数据区为空
                case E_CONDENY_GENERALDENY:
                    break;
                //F3 数据区带F3错误码
                case E_CONDENY_WRDATAUNITERR:
                    //F3
                    targetConfirmOrDeny =
                            new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F3(Cenumclass.E_F3ErrNum.E_F3ERR_YES));
                    break;
                //F4 硬件错误
                case E_CONDENY_HARDWAREERR:
                    byte[] data = dataUnit.getData().getBytes();
                    targetConfirmOrDeny =
                            new CS_userdata_confirmOrDeny( new CS_userdata_confirmOrDeny( ).new S_userdata_confirmOrDeny_F4(Cenumclass.E_F4ErrNum.E_F4ERR_CIPHERTEXTCHECK,data));
                    break;
                default:
                    break;
            }
            boolean retSet =  tmpL1SetOpt.set_userData_dataUnit_confirmOrDeny(DFSLProID, Cenumclass.E_Pn.E_PN_TERMAL, fn,targetConfirmOrDeny);
            if(retSet == false)
            {
                tmpL1SetOpt.unRegister_DFSLProOptS(DFSLProID);
                return null;
            }
        }
        //设置附加信息
        //重要事件计数器 一般事件计数器 启动帧计数器 消息认证码
        ExtraMessage extraMessage = protocolContent.getExtraMessage();
        byte[] tmpPwd = new byte[0];
        byte importantEventCount = 0;
        byte generalEventCount = 0;
        if (extraMessage != null) {
            //消息认证码
            tmpPwd = extraMessage.getAuthorization();
            //重要事件计数器
            importantEventCount = (byte) extraMessage.getEventWarnningCount().getImportantEventCount();
            //一般事件计数器
            generalEventCount = (byte) extraMessage.getEventWarnningCount().getOrdinaryEventCount();
        }

        //启动帧计数器
        byte pfc = (byte)0x0;
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
