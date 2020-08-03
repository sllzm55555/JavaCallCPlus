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
            packageUtils.hisdata
                    (Cenumclass.E_hisdat.E_HISDAT_WATERTEMP.getValue(),Cenumclass.E_hisdat.E_HISDAT_ANMMONIANITROGEN.getValue(),Cenumclass.E_Pn.E_PN_WATERQUALITY.getValue());
            packageUtils.hisdata
                    (Cenumclass.E_hisdat.E_HISDAT_SALINITY.getValue(),Cenumclass.E_hisdat.E_HISDAT_WATERLV.getValue(),Cenumclass.E_Pn.E_PN_HYDROLOGICAL.getValue());
            packageUtils.hisdata
                    (Cenumclass.E_hisdat.E_HISDAT_WINDDIR.getValue(),Cenumclass.E_hisdat.E_HISDAT_RAINFALL.getValue(),Cenumclass.E_Pn.E_PN_METEOROLOGICAL.getValue());
            packageUtils.hisdata
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

//        E:\VS\DFSLPro\x64\Debug
//        System.load("E:\\Idea\\JavaCallCPlus\\src\\orientIntelligent\\dll\\pthreadVC2.dll");
        System.load("E:\\VS\\DFSLPro\\pthread\\Pre-built.2\\dll\\x64\\pthreadVC2.dll");
        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");

        PackageUtils packageUtils = new PackageUtils();
//        for (int i = 0; i < 10000000; i++) {
//            packageUtils.qureHistory();
//            System.out.println(i);
//        }
//
//        packageUtils.confirmOrdeny();
//        packageUtils.controlCommand((byte)31,(byte)31,(byte)0);
//        packageUtils.setParameter((byte)3,(byte)3,(byte)0);
//        packageUtils.queryParameter_data1();
        packageUtils.queryParameter_ip();
//        packageUtils.hisdata(Cenumclass.E_hisdat.E_RLTDAT_LONGANDLAT.getValue(),Cenumclass.E_hisdat.E_RLTDAT_LONGANDLAT.getValue(),(byte)0);
//        packageUtils.rltdata(Cenumclass.E_rltdat.E_RLTDAT_LONGANDLAT.getValue(),Cenumclass.E_hisdat.E_RLTDAT_LONGANDLAT.getValue(),(byte)0);
//        packageUtils.alrmevent((byte)1);
//        myT myt1=new myT(1);
//        myT myt2=new myT(2);
//        myT myt3=new myT(3);
//        myT myt4=new myT(4);
//        myT myt5=new myT(5);
//        myT myt6=new myT(6);
//        myT myt7=new myT(7);
//        myT myt8=new myT(8);
//        myT myt9=new myT(9);
//        myt1.run();
//        myt2.run();
//        myt3.run();
//        myt4.run();
//        myt5.run();
//        myt6.run();
//        myt7.run();
//        myt8.run();
//        myt9.run();

//        packageUtils.queryParameter();
    }

    public void setParameter(byte fnstart,byte fnend,byte pn){

        ProtocolContent protocolContent = new ProtocolContent();
        //private ControlField controlField;
        ControlField controlField = new ControlField();
        //  1 private Cenumclass.E_transDir direction;
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
        //  2 private Cenumclass.E_ctlFunCode cfc;
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ1STDAT);
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
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_SETPARAM);
        // 2 private List<DataUnit> dataUnitList;

        List<DataUnit> unitList = new ArrayList<>();
        for (int i = fnstart; i <= fnend; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setFn((byte)(i));
            dataUnit.setPn(pn);
//            String tmpStr = "IP:192.168.0.123 port:9888: IP:192.168.0.101 port:6666,APN:CMNET";
            String ipp = "{\"ipS1\":192,\"ipS2\":168,\"ipS3\":0,\"ipS4\":123,\"port\":8888,\"ipS1_resrve\":192,\"ipS2_resrve\":168,\"ipS3_resrve\":0,\"ipS4_resrve\":101,\"port_resrve\":6666,\"APN\":\"CMNET\"}";

            dataUnit.setData(ipp);
            unitList.add(dataUnit);
        }

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
        if(message==null)
            return;
    }

    public void controlCommand(byte fnstart,byte fnend,byte pn){

        ProtocolContent protocolContent = new ProtocolContent();
        //private ControlField controlField;
        ControlField controlField = new ControlField();
        //  1 private Cenumclass.E_transDir direction;
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
        //  2 private Cenumclass.E_ctlFunCode cfc;
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ1STDAT);
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
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_CTLCMD);
        // 2 private List<DataUnit> dataUnitList;

        List<DataUnit> unitList = new ArrayList<>();
        for (int i = fnstart; i <= fnend; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setFn((byte)(i));
            dataUnit.setPn(pn);
            String a1 = "{\"sec_decade\":3,\"sec_digit\":8,\"min_decade\":4,\"min_digit\":1,\"hour_decade\":0,\"hour_digit\":9,\"day_decade\":0,\"day_digit\":1,\"week\":6,\"mon_decade\":0,\"mon_digit\":8,\"year_decade\":1,\"year_digit\":0}";
//            String a1 = "";
            dataUnit.setData(a1);
            unitList.add(dataUnit);
        }


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
        if(message==null)
            return;
    }

    public  void hisdata(byte fnstart,byte fnend,byte pn)
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
//            String historyString = "{\"density\":15,\"points\":1,\"timeFlag\":{\"day\":31,\"hour\":12,\"min\":0,\"month\":12,\"year\":19}}";
//            String tmpstr = "{\"density\":15,\"points\":1,\"timeFlag\":{\"day\":31,\"hour\":12,\"min\":0,\"month\":12,\"year\":19}}";
//            String tmpstr = "{\"min_decade\":2,\"min_digit\":5,\"hour_decade\":1,\"hour_digit\":1,\"day_decade\":0,\"day_digit\":1,\"mon_decade\":0,\"mon_digit\":8,\"year_decade\":2,\"year_digit\":0}";
            dataUnit.setData(historyString);
            unitList.add(dataUnit);
        }

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

    public  void queryParameter_ip()
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

//        String tmpStr = "2 3 3";
//        String tmpStr = "{\"ntimes\":2,\"array\":[3,7]}";
        String tmpStr = "{\"ntimes\":3,\"array\":[1,2,3]}";

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


    public  void queryParameter_data1()
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

        dataUnit.setFn(38);
        dataUnit.setPn(Cenumclass.E_Pn.E_PN_TERMAL.getValue());

//        String tmpStr = "2 3 3";
        String tmpStr = "{\"id\":3,\"ntimes\":2,\"array\":[99,101]}";

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

    public  void confirmOrdeny()
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

        dataUnit.setFn(Cenumclass.E_ConfirmOrDeny.E_CONDENY_WRDATAUNITERR.getValue());
        dataUnit.setPn(Cenumclass.E_Pn.E_PN_TERMAL.getValue());

        /**
         * dataflag + afc + innerDataflag + ERRNum
         * example: reset() afc=0x1  Pn=0 Fn=1 ERRNum=0
         */
        String tmpStr = "1 0 1 0";

//        String json = "{\"data\":{\"afc\":11,\"list\":[{\"innerPn\":0,\"innerFn\":3,\"ERRNum\":1}]}}";
        String json = "{\"afc\":11,\"list\":[{\"innerPn\":0,\"innerFn\":3,\"ERRNum\":1}]}";

//        dataUnit.setData(tmpStr);
        dataUnit.setData(json);
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

    public  void rltdata(byte fnstart,byte fnend,byte pn)
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
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_RLTDATA);
        // 2 private List<DataUnit> dataUnitList;

        List<DataUnit> unitList = new ArrayList<>();
        for (int i = fnstart; i <= fnend; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setFn((byte)(i));
            dataUnit.setPn(pn);
 //           String a1 = "{\"sec_decade\":3,\"sec_digit\":8,\"min_decade\":4,\"min_digit\":1,\"hour_decade\":0,\"hour_digit\":9,\"day_decade\":0,\"day_digit\":1,\"week\":6,\"mon_decade\":0,\"mon_digit\":8,\"year_decade\":1,\"year_digit\":0}";
            String a1 = null;
            dataUnit.setData(a1);
            unitList.add(dataUnit);
        }


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

    public  void alrmevent(byte Fn)
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
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_ALARMEVENT);
        // 2 private List<DataUnit> dataUnitList;

        List<DataUnit> unitList = new ArrayList<>();
        for (int i = 1; i <= 1; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setFn(Fn);
            dataUnit.setPn(0);
            //           String a1 = "{\"sec_decade\":3,\"sec_digit\":8,\"min_decade\":4,\"min_digit\":1,\"hour_decade\":0,\"hour_digit\":9,\"day_decade\":0,\"day_digit\":1,\"week\":6,\"mon_decade\":0,\"mon_digit\":8,\"year_decade\":1,\"year_digit\":0}";
            String tmpstr = "{\"PM\":7,\"PN\":2}";
            dataUnit.setData(tmpstr);
            unitList.add(dataUnit);
        }

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

    public static void rltdata2()
    {
        ProtocolContent protocolContent = new ProtocolContent();
        //地址域
        //序列号 行政区划码 机器型号 国家代码
        protocolContent.setAddressField(new AddressField("86", "5106", "01", "123456"));
        //控制域
        //帧传输方向,帧计数位,帧有效位, 链路层功能码
        //帧计数位 帧有效位 链路层功能码 暂未设置
        ControlField controlField = new ControlField();
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
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
