package orientIntelligent.utils;

import orientIntelligent.entity.PackageEntity;
import orientIntelligent.jni.CL1SetOpt;
import orientIntelligent.jni.Cenumclass;
import orientIntelligent.jni.DFSLDataType.CS_addrField;

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



        String direction = packageEntity.getDirection();

        if(direction.equals(Cenumclass.E_transDir.E_TD_SVR_REQUEST.name())){

        }



        return null;
    }


}
