package orientIntelligent.jni;

import orientIntelligent.jni.DFSLDataType.CEvent;
import orientIntelligent.jni.DFSLDataType.CS_A1;
import orientIntelligent.jni.DFSLDataType.CS_A16;
import orientIntelligent.jni.DFSLDataType.CS_addrField;

import java.io.InputStream;


import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
import javax.swing.JOptionPane;

public class CCommunicate {


    static {

        // System.load("E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
        System.load("E:\\Idea\\JavaCallCPlus1\\src\\orientIntelligent\\dll\\DFSLProDemo.dll");
    }
    public void parse_msg_server(byte bytes[])
    {
        boolean ret_PW  = true;
        boolean ret_Tpv = true;
        boolean ret_EC  = true;
        CL1GetOpt tmpL1GetOpt = new CL1GetOpt();
        //step1 注册协议操作集
        int DFSLProID = tmpL1GetOpt.register_DFSLProOptS();

        //step2  检查数据包完整性
        Cenumclass.E_CheckPackage ret = tmpL1GetOpt.check_package(DFSLProID,bytes);
        if(ret != Cenumclass.E_CheckPackage.E_CKPKG_SUCCESS)
        {
            System.out.println("Error to check package");
            return;
        }
        //step3 获取消息验证码
        byte[] pwd = tmpL1GetOpt.get_userData_dataUnit_pwd(DFSLProID);
        if(pwd == null)
        {
            ret_PW = false;
            System.out.println("bytes is null");
        }
        else
        {
            for(byte e:pwd)
            {
                System.out.print("e:"+e+" ");
            }
            System.out.println(" ");
        }

        //step4 读取打包时间
        CS_A16 time = tmpL1GetOpt.get_userData_dataUnit_time(DFSLProID);
        if(null == time)
        {
            ret_Tpv=false;
            System.out.println("未发现时间标签");
        }
        else
        {
            System.out.print(time.getDay_decade() );
            System.out.print(time.getDay_digit()+"日");
            System.out.print(time.getHour_decade());
            System.out.print(time.getHour_digit()+"时");
            System.out.print(time.getMin_decade());
            System.out.print(time.getMin_digit()+"分");
            System.out.print(time.getSec_decade());
            System.out.println(time.getSec_digit()+"秒");
            System.out.println("ret:"+ret.name());
        }
        //step5 读取事件计数器
        CEvent event = tmpL1GetOpt.get_userData_dataUnit_events(DFSLProID);
        if(null == event)
        {
            ret_EC = false;
            System.out.println("未发现事件计数器");
        }
        else
        {
            System.out.println("important count:"+event.getImportantCount());
            System.out.println("general count:"+event.getGeneralCount());
        }

        Cenumclass.E_ctlFunCode ctlFunCode = tmpL1GetOpt.get_ctlField_CFFuncCode(DFSLProID);
        //System.out.println("ctlFunCode:"+ctlFunCode.name());

        Cenumclass.E_transDir transDir = tmpL1GetOpt.get_ctlField_DIR(DFSLProID);

        System.out.println("transDir:"+transDir.name());
        //终端请求
        if(transDir == Cenumclass.E_transDir.E_TD_TML_REQUEST)
        {
            System.out.println("终端请求");
            switch(ctlFunCode)
            {
                case E_CFC_M_USERDATA:
                    System.out.println("E_CFC_M_USERDATA");
                    break;
                case E_CFC_M_LINKTEST:
                    System.out.println("E_CFC_M_LINKTEST");
                    //Cenumclass.E_appFuncCode appFuncCode = tmpL1GetOpt.get_userData_appFuncCode(DFSLProID);
                    //System.out.println("appFuncCode:"+appFuncCode.name());
                    this.parse_linkdt_dataUnit_server(tmpL1GetOpt,DFSLProID);
                    break;
                case E_CFC_M_REQ1STDAT:
                    System.out.println("E_CFC_M_REQ1STDAT");
                    break;
                case E_CFC_M_REQ2NDDAT:
                    System.out.println("E_CFC_M_REQ2NDDAT");
                    break;
                    default:
                        System.out.println("Error transDir");
                        break;
            }
        }
        //终端回复
        else if(transDir == Cenumclass.E_transDir.E_TD_TML_ANSWER)
        {
            System.out.println("终端回复");
            switch(ctlFunCode)
            {
                case E_CFC_S_RECOGNITION:
                    System.out.println("E_CFC_S_RECOGNITION");

                    break;
                case E_CFC_S_USERDATA:
                    System.out.println("E_CFC_S_USERDATA");
                    break;
                case E_CFC_S_DENY:
                    System.out.println("E_CFC_S_DENY");
                    break;
                case E_CFC_S_LINKSTATE:
                    System.out.println("E_CFC_S_LINKSTATE");
                    break;
                default:
                    System.out.println("Error transDir");
                    break;
            }
        }
        //错误的帧传输方向
        else
        {
            System.out.println("错误的帧传输方向");
            //TODO Error handling
            //System.out.println("Error transDir");
        }

        tmpL1GetOpt.unRegister_DFSLProOptS(DFSLProID);
    }

    public static void main(String[] args) {

        byte hearbeat[] = {0x68 ,0x14 ,0x00 ,0x14 ,0x00 ,0x68 ,(byte)0xD9 ,(byte)0x86 ,0x30 ,0x08  ,0x00 ,0x56 ,0x34 ,0x12 ,0x02 ,0x70 ,0x00 ,0x00 ,0x04 ,0x00
                ,0x39 ,0x30 ,0x10 ,0x09 ,(byte)0x91 ,0x19 ,0x63 ,0x16};
        //登录帧
        byte login[] = {0x68 ,0x0E ,0x00 ,0x0E ,0x00 ,0x68 ,(byte)0xD9 ,(byte)0x86 ,0x30 ,0x08  ,0x00 ,0x56 ,0x34 ,0x12 ,0x02 ,0x70 ,0x00 ,0x00 ,0x01 ,0x00
                ,0x34 ,0x16};

        byte logout[] = {0x68 ,0x0E ,0x00 ,0x0E ,0x00 ,0x68 ,(byte)0xD9 ,(byte)0x86 ,0x30 ,0x08  ,0x00 ,0x56 ,0x34 ,0x12 ,0x02 ,0x70 ,0x00 ,0x00 ,0x02 ,0x00
                ,0x35 ,0x16};
        //socket通信
        //step1 创建服务器套接字
        //step2 等待连接accept
        //step3 从socket读取数据
        //step4 关闭socket
        //step5 关闭服务器套接字
        byte[] recvFram = null;
        int lenRecvFram;
        int port = 9998;
        //ServerSocket server = new ServerSocket(port);
        try {
            //创建绑定到特定端口的服务器套接字  1-65535
            ServerSocket serversocket = new ServerSocket(port);
            while(true) {
                //建立连接，获取socket对象
                System.out.println("server将一直等待连接的到来");
                Socket socket=serversocket.accept();

                //消息提示框
                JOptionPane.showMessageDialog(null, "有客户端连接到了本机9998端口哦");
                //与客户端通信

                // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len;
                if((len = inputStream.read(bytes)) > 0)
                {
                    recvFram = new byte[len];
                    for (int i = 0; i < len; i++) {
                        recvFram[i]=bytes[i];
                    }
                }
//                StringBuilder sb = new StringBuilder();
//                while ((len = inputStream.read(bytes)) != -1) {
//                    //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
//                    sb.append(new String(bytes, 0, len,"UTF-8"));
//
//                    System.out.println("len:"+len);
//                }
//                System.out.println("get message from client: " + sb);
                inputStream.close();
                socket.close();
                serversocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



        CCommunicate com =  new CCommunicate();
        if(recvFram!=null)
        com.parse_msg_server(recvFram);
    }

    public int parse_linkdt_dataUnit_server(CL1GetOpt tmpL1GetOpt,int DFSLProID)
    {
       // CS_A1 tmp_A1 = new CS_A1();
        CS_A1 tmp_A1 = new CS_A1();
        Cenumclass.E_appFuncCode appFuncCode = tmpL1GetOpt.get_userData_appFuncCode(DFSLProID);
        System.out.println("appFuncCode:"+appFuncCode.name());
        Cenumclass.E_LinkDetection linkdt = tmpL1GetOpt.get_userData_dataUnit_linkDetection_uplink(DFSLProID,tmp_A1);
        switch(linkdt)
        {
            case E_LKDETEC_LOGIN:
                System.out.println("登录帧");
                break;
            case E_LKDETEC_LOGOUT:
                System.out.println("登出帧");
                break;
            case E_LKDETEC_HEARTBEAT:
                System.out.println("心跳帧");
                System.out.println("心跳包"+
                        tmp_A1.getYear_decade()+""+tmp_A1.getYear_digit()+"年"+
                        tmp_A1.getMon_decade()+""+ tmp_A1.getMon_digit() +"月"+
                        tmp_A1.getDay_decade()+""+ tmp_A1.getDay_digit() +"日"+
                        tmp_A1.getHour_decade()+""+tmp_A1.getHour_digit()+"时"+
                        tmp_A1.getMin_decade()+""+ tmp_A1.getMin_digit() +"分"+
                        tmp_A1.getSec_decade()+""+ tmp_A1.getSec_digit() +"秒"+
                        "周"+tmp_A1.getWeek()
                );
                break;
        }
        return 0;
    }
}
