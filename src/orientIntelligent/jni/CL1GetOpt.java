package orientIntelligent.jni;

public class CL1GetOpt extends CDFSLProOpt {

    public native Cenumclass.E_CheckPackage check_package(int DFSLProID,byte[] bytes);  //帧完整性检查
    public native byte[]  get_userData_dataUnit_pwd(int DFSLProID);                     //获取消息验证码
    public native CS_A16  get_userData_dataUnit_time(int DFSLProID );                   //获取组帧时间
    public native CEvent get_userData_dataUnit_events(int DFSLProID);                   //获取事件计数器
    public native Cenumclass.E_ctlFunCode get_ctlField_CFFuncCode(int DFSLProID);       //获取链路层功能码
    public native boolean get_ctlFieldC_CON(int DFSLProID);                             //获取回复标志位
    public native Cenumclass.E_transDir get_ctlField_DIR(int DFSLProID);                //获取帧传输方向
    public native Cenumclass.E_appFuncCode get_userData_appFuncCode(int DFSLProID);     //获取应用层功能码



}
