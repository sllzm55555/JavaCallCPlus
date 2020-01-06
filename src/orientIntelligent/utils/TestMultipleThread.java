package orientIntelligent.utils;

import orientIntelligent.entity.*;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wt
 * @version 1.0.0
 * @date 2020-01-06
 */
public class TestMultipleThread implements Runnable{

    private String serialNum;

    public TestMultipleThread(String serialNumber) {
        this.serialNum = serialNumber;
    }

    @Override
    public void run() {
        test(Cenumclass.E_Pn.E_PN_WATERQUALITY);
        test(Cenumclass.E_Pn.E_PN_HYDROLOGICAL);
        test(Cenumclass.E_Pn.E_PN_METEOROLOGICAL);
        test(Cenumclass.E_Pn.E_PN_POSITION);
    }

    public void test(Cenumclass.E_Pn pn) {
        ProtocolContent protocolContent = new ProtocolContent();
        
        //控制域
        ControlField controlField = new ControlField();
        controlField.setDirection(Cenumclass.E_transDir.E_TD_SVR_REQUEST);
        controlField.setCfc(Cenumclass.E_ctlFunCode.E_CFC_M_REQ2NDDAT);
        protocolContent.setControlField(controlField);
        
        //地址域
        AddressField addressField = new AddressField();
        addressField.setCountryCode("86");
        addressField.setZoneCode("5106");
        addressField.setRobotCode("01");
        addressField.setSerializeCode(serialNum);
        protocolContent.setAddressField(addressField);
        
        //链路数据
        LinkData linkData = new LinkData();
        linkData.setApplicationFunctionCode(Cenumclass.E_appFuncCode.E_AFC_HISDATA);
        List<DataUnit> unitList = new ArrayList<>();

        int fnCount = 0;
        int startIndex = 0;
        switch (pn){
            case E_PN_WATERQUALITY:
                fnCount = 10;
                startIndex = 179;
                break;
            case E_PN_HYDROLOGICAL:
                fnCount = 6;
                startIndex = 189;
                break;
            case E_PN_METEOROLOGICAL:
                fnCount = 6;
                startIndex = 199;
                break;
            case E_PN_POSITION:
                fnCount = 1;
                startIndex = 209;
                break;
            default:
                break;
        }
        for (int i = 0; i < fnCount; i++) {
            DataUnit dataUnit = new DataUnit();
            dataUnit.setPn(pn.getValue());
            dataUnit.setFn(startIndex + i);
            dataUnit.setData("{\"min\":0, \"hour\":12, \"day\":6, \"month\":1, \"year\":20}");
            unitList.add(dataUnit);
        }
        linkData.setDataUnitList(unitList);
        protocolContent.setLinkData(linkData);

        //附加信息
        ExtraMessage extraMessage = new ExtraMessage();
        byte[] authorization = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        extraMessage.setAuthorization(authorization);
        protocolContent.setExtraMessage(extraMessage);

        //打包
        CL1SetOpt cl1SetOpt = new CL1SetOpt();
        byte[] message = cl1SetOpt.packageMessage(protocolContent);
//        cl1SetOpt.packageMessage(protocolContent);
        if (message == null)
            return;
    }

}
