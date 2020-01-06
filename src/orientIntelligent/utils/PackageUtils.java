package orientIntelligent.utils;

import orientIntelligent.entity.*;
import orientIntelligent.entity.AddressField;
import orientIntelligent.entity.LinkData;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-16
 */

class myT extends Thread {
   // PackageUtils util;
    int id;
    myT(int input){
        this.id = input;
    }
    public void run (){
        PackageUtils packageUtils = new PackageUtils();
//        for (int i = 0; i < 100000; i++) {
        for (int i = 0; i < 10000; i++) {
            packageUtils.qureHistory
                    (Cenumclass.E_hisdat.E_HISDAT_WATERTEMP.getValue(),Cenumclass.E_hisdat.E_HISDAT_ANMMONIANITROGEN.getValue(),Cenumclass.E_Pn.E_PN_WATERQUALITY.getValue());
            packageUtils.qureHistory
                    (Cenumclass.E_hisdat.E_HISDAT_SALINITY.getValue(),Cenumclass.E_hisdat.E_HISDAT_WATERLV.getValue(),Cenumclass.E_Pn.E_PN_HYDROLOGICAL.getValue());
            packageUtils.qureHistory
                    (Cenumclass.E_hisdat.E_HISDAT_WINDDIR.getValue(),Cenumclass.E_hisdat.E_HISDAT_RAINFALL.getValue(),Cenumclass.E_Pn.E_PN_METEOROLOGICAL.getValue());
            packageUtils.qureHistory
                    (Cenumclass.E_hisdat.E_RLTDAT_LONGANDLAT.getValue(),Cenumclass.E_hisdat.E_RLTDAT_LONGANDLAT.getValue(),Cenumclass.E_Pn.E_PN_POSITION.getValue());
 //           System.out.println(i);
          //  Cenumclass.E_Pn.E_PN_WATERQUALITY
        }

     //   packageUtils.oldmain();

        System.out.println("|--------------->id:"+this.id);
    }
}
public class PackageUtils {
    private static String masterIpFormat = "IP:%s port:%s IP:%s port:%s,APN:%s";
    private static String historyString = "{\"density\":15,\"points\":1,\"timeFlag\":{\"day\":31,\"hour\":12,\"min\":0,\"month\":12,\"year\":19}}";
    public static final String BIN_LIB = "E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\";

    public static String getMasterIpFormat() {
        return masterIpFormat;
    }



    public static void main(String[] args) {

        System.load("E:\\Idea\\JavaCallCPlus\\src\\orientIntelligent\\dll\\pthreadVC2.dll");
        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");

//        PackageUtils packageUtils = new PackageUtils();
//        for (int i = 0; i < 10000000; i++) {
//            packageUtils.qureHistory();
//            System.out.println(i);
//        }
//
//        packageUtils.oldmain();
        myT myt1=new myT(1);
        myT myt2=new myT(2);
        myT myt3=new myT(3);
        myT myt4=new myT(4);
        myT myt5=new myT(5);
        myT myt6=new myT(6);
        myT myt7=new myT(7);
        myT myt8=new myT(8);
        myT myt9=new myT(9);
        myt1.run();
        myt2.run();
        myt3.run();
        myt4.run();
        myt5.run();
        myt6.run();
        myt7.run();
        myt8.run();
        myt9.run();

//        packageUtils.queryParameter();
    }

    public  void qureHistory(byte fnstart,byte fnend,byte pn)
    {
        ProtocolContent protocolContent = new ProtocolContent();
        //private ControlField controlField;
        ControlField controlField = new ControlField();
        //  1 private Cenumclass.E_transDir direction;
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
        //  2 private Cenumclass.E_ctlFunCode cfc;
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ2NDDAT);
        protocolContent.setControlField(controlField);
        //private AddressField addressField;
        AddressField addressField = new AddressField();
        // 1 private String countryCode;
        addressField.setCountryCode("86");
        // 2 private String zoneCode;
        addressField.setZoneCode("5106");
        // 3 private String robotCode;
        addressField.setRobotCode("01");
        // 4 private String serializeCode;
        addressField.setSerializeCode("100009");
        protocolContent.setAddressField(addressField);
        //private LinkData linkData;
        LinkData linkData = new LinkData();
        // 1 private Cenumclass.E_appFuncCode applicationFunctionCode;
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_HISDATA);
        // 2 private List<DataUnit> dataUnitList;

        List<DataUnit> unitList = new ArrayList<>();
        for (int i = fnstart; i <= fnend; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setFn((byte)(i));
            dataUnit.setPn(pn);
            dataUnit.setData(historyString);
            unitList.add(dataUnit);
        }
      //  dataUnit.setFn(Cenumclass.E_hisdat.E_HISDAT_WATERTEMP.getValue());

       // dataUnit.setPn(Cenumclass.E_Pn.E_PN_WATERQUALITY.getValue());
        // String tmpStr = "zxcvbnm";
        //"IP:192.168.0.1 port:8888: IP:188.188.114.114 port:6666,APN:CMNET";
//        String tmpStr = "IP:192.168.0.1 port:8888: IP:188.188.114.114 port:6666,APN:CMNET";
//        String temp = "IP:%s port:%s IP:%s port:%s,APN:%s";
       // masterIpFormat = String.format(masterIpFormat, "192.168.0.1", "8888", "188.188.114.114", "6666", "CMNET");

//        System.out.println(masterIpFormat);


      //  dataUnit.setData(masterIpFormat);


        linkData.setDataUnitList(unitList);
        protocolContent.setLinkData(linkData);
        System.out.println(protocolContent.getLinkData().getDataUnitList().get(0).getData());
        //private ExtraMessage extraMessage;
        // 1 private byte[] authorization;
        ExtraMessage extraMessage = new ExtraMessage();
        byte[] authorization = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        extraMessage.setAuthorization(authorization);
        protocolContent.setExtraMessage(extraMessage);
        CL1SetOpt cl1SetOpt = new CL1SetOpt();
        byte[] message = cl1SetOpt.packageMessage(protocolContent);
//        cl1SetOpt.packageMessage(protocolContent);
        if(message==null)
            return;
//        System.out.println("message.length: "+message.length);
    }

    public  void queryParameter()
    {
        ProtocolContent protocolContent = new ProtocolContent();
        //private ControlField controlField;
        ControlField controlField = new ControlField();
        //  1 private Cenumclass.E_transDir direction;
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
        //  2 private Cenumclass.E_ctlFunCode cfc;
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ2NDDAT);
        protocolContent.setControlField(controlField);
        //private AddressField addressField;
        AddressField addressField = new AddressField();
        // 1 private String countryCode;
        addressField.setCountryCode("86");
        // 2 private String zoneCode;
        addressField.setZoneCode("0830");
        // 3 private String robotCode;
        addressField.setRobotCode("a1");
        // 4 private String serializeCode;
        addressField.setSerializeCode("123456");
        protocolContent.setAddressField(addressField);
        //private LinkData linkData;
        LinkData linkData = new LinkData();
        // 1 private Cenumclass.E_appFuncCode applicationFunctionCode;
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_QUERYPARA);
        // 2 private List<DataUnit> dataUnitList;
        DataUnit dataUnit = new DataUnit();

        dataUnit.setFn(Cenumclass.E_setParameter.E_SETPAR_MASIPPORT.getValue());
        dataUnit.setPn(Cenumclass.E_Pn.E_PN_TERMAL.getValue());
        // String tmpStr = "zxcvbnm";
        String tmpStr = "2 3 3";
        dataUnit.setData(tmpStr);
        List<DataUnit> unitList = new ArrayList<>();
        unitList.add(dataUnit);
        linkData.setDataUnitList(unitList);
        protocolContent.setLinkData(linkData);
        //private ExtraMessage extraMessage;
        // 1 private byte[] authorization;
        ExtraMessage extraMessage = new ExtraMessage();
        byte[] authorization = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        extraMessage.setAuthorization(authorization);
        protocolContent.setExtraMessage(extraMessage);
        CL1SetOpt cl1SetOpt = new CL1SetOpt();
        byte[] message = cl1SetOpt.packageMessage(protocolContent);
//        cl1SetOpt.packageMessage(protocolContent);
        if(message==null)
            return;
        System.out.println("message.length: "+message.length);
    }

    public  void newmain()
    {
        ProtocolContent protocolContent = new ProtocolContent();
        //private ControlField controlField;
        ControlField controlField = new ControlField();
        //  1 private Cenumclass.E_transDir direction;
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_ANSWER);
        //  2 private Cenumclass.E_ctlFunCode cfc;
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_S_LINKSTATE);
        protocolContent.setControlField(controlField);
        //private AddressField addressField;
        AddressField addressField = new AddressField();
        // 1 private String countryCode;
        addressField.setCountryCode("86");
        // 2 private String zoneCode;
        addressField.setZoneCode("0830");
        // 3 private String robotCode;
        addressField.setRobotCode("a1");
        // 4 private String serializeCode;
        addressField.setSerializeCode("123456");
        protocolContent.setAddressField(addressField);
        //private LinkData linkData;
        LinkData linkData = new LinkData();
        // 1 private Cenumclass.E_appFuncCode applicationFunctionCode;
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_CONDENY);
        // 2 private List<DataUnit> dataUnitList;
        DataUnit dataUnit = new DataUnit();

        dataUnit.setFn(Cenumclass.E_ConfirmOrDeny.E_CONDENY_CONFIRMALL.getValue());
        dataUnit.setPn(Cenumclass.E_Pn.E_PN_TERMAL.getValue());
       // String tmpStr = "zxcvbnm";
        String tmpStr = "1";
        dataUnit.setData(tmpStr);
        List<DataUnit> unitList = new ArrayList<>();
        unitList.add(dataUnit);
        linkData.setDataUnitList(unitList);
        protocolContent.setLinkData(linkData);
        //private ExtraMessage extraMessage;
        // 1 private byte[] authorization;
        ExtraMessage extraMessage = new ExtraMessage();
        byte[] authorization = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        extraMessage.setAuthorization(authorization);
        protocolContent.setExtraMessage(extraMessage);
        CL1SetOpt cl1SetOpt = new CL1SetOpt();
        byte[] message = cl1SetOpt.packageMessage(protocolContent);
//        cl1SetOpt.packageMessage(protocolContent);
        if(message==null)
            return;
        System.out.println("message.length: "+message.length);
    }

    public static void oldmain()
    {
        ProtocolContent protocolContent = new ProtocolContent();
        //地址域
        //序列号 行政区划码 机器型号 国家代码
        protocolContent.setAddressField(new AddressField("86", "5106", "01", "123456"));
        //控制域
        //帧传输方向,帧计数位,帧有效位, 链路层功能码
        //帧计数位 帧有效位 链路层功能码 暂未设置
        ControlField controlField = new ControlField();
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_ANSWER);
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ2NDDAT);
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
       // byte[] bytes = packageMessage(protocolContent);
        CL1SetOpt cl1SetOpt = new CL1SetOpt();
        byte[] message = cl1SetOpt.packageMessage(protocolContent);
        if(message == null)
        {
            System.out.println("message == null XXXXXXXXXXXXXXXXXx");
        }
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
