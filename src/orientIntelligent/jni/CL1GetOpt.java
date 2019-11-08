package orientIntelligent.jni;

import orientIntelligent.entity.CommunicationProtocol;

public class CL1GetOpt {

    public   native CommunicationProtocol parse_message(byte[] bytes);



    public static void main(String[] args) {
        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");
//        System.load("E:\\Idea\\JavaCallCPlus\\src\\orientIntelligent\\dll\\DFSLProJni.dll");
        byte hearbeat[] = {
                (byte)0x68 ,(byte)0x18 ,(byte)0x00 ,(byte)0x18 ,(byte)0x00 ,(byte)0x68 ,(byte)0x5B ,(byte)0x86 ,(byte)0x08 ,(byte)0x30,
                (byte)0xA1 ,(byte)0x12 ,(byte)0x34 ,(byte)0x56 ,(byte)0x0A ,(byte)0xF0 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x03,
                (byte)0x03 ,(byte)0x03 ,(byte)0x03 ,(byte)0x03 ,(byte)0x00 ,(byte)0x25 ,(byte)0x58 ,(byte)0x13 ,(byte)0x07 ,(byte)0x00,
                (byte)0xFC ,(byte)0x16
        };

        byte query[] = {
                     (byte)0x68 ,(byte)0x33 ,(byte)0x00 ,(byte)0x33 ,(byte)0x00 ,(byte)0x68 ,(byte)0xB8 ,(byte)0x86 ,(byte)0x30 ,(byte)0x08
                    ,(byte)0x1A ,(byte)0x56 ,(byte)0x34 ,(byte)0x12 ,(byte)0x0A ,(byte)0xE0 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x03
                    ,(byte)0x01 ,(byte)0xC0 ,(byte)0xA8 ,(byte)0x01 ,(byte)0x04 ,(byte)0xB8 ,(byte)0x22 ,(byte)0xFF ,(byte)0xFF ,(byte)0xFF
                    ,(byte)0xFF ,(byte)0x0A ,(byte)0x1A ,(byte)0x43 ,(byte)0x4D ,(byte)0x4E ,(byte)0x45 ,(byte)0x54 ,(byte)0x00 ,(byte)0x00
                    ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00 ,(byte)0x00
                    ,(byte)0x07 ,(byte)0x58 ,(byte)0x13 ,(byte)0x07 ,(byte)0x00 ,(byte)0x06 ,(byte)0x06 ,(byte)0x93 ,(byte)0x16
        };
        //登录帧
        byte login[] = {0x68,0x0E ,0x00 ,0x0E ,0x00 ,0x68 ,(byte)0xD9 ,(byte)0x86 ,0x30 ,0x08  ,0x00 ,0x56 ,0x34 ,0x12 ,0x02 ,0x70 ,0x00 ,0x00 ,0x01 ,0x00
                ,0x34 ,0x16};

        byte logout[] = {0x68 ,0x0E ,0x00 ,0x0E ,0x00 ,0x68 ,(byte)0xD9 ,(byte)0x86 ,0x30 ,0x08  ,0x00 ,0x56 ,0x34 ,0x12 ,0x02 ,0x70 ,0x00 ,0x00 ,0x02 ,0x00
                ,0x35 ,0x16};
        /**
         * 水质
         */
        byte realTimeData[] = {0x68 ,0x54 ,0x00 ,0x54 ,0x00 ,0x68 ,(byte)0xB8 ,(byte)0x86 ,0x30 ,0x08  ,(byte)0x1A ,0x56 ,0x34 ,0x12 ,(byte)0x0C ,(byte)0xE0 ,0x01 ,0x01 ,0x04 ,0x16
                ,0x21 ,0x43 ,0x01 ,0x01 ,0x08 ,0x16 ,0x23 ,0x11 ,0x32 ,0x54  ,0x01 ,0x01 ,0x10 ,0x16 ,0x23 ,0x01 ,0x01 ,0x01 ,0x20 ,0x16
                ,0x12 ,0x21 ,0x43 ,0x01 ,0x01 ,0x40 ,0x16 ,0x21 ,0x43 ,0x01  ,0x01 ,(byte)0x80 ,0x16 ,0x12 ,0x21 ,0x43 ,0x01 ,0x01 ,0x01 ,0x17
                ,0x12 ,0x21 ,0x43 ,0x01 ,0x01 ,0x02 ,0x17 ,0x21 ,0x43 ,0x65  ,0x01 ,0x01 ,0x04 ,0x17 ,0x23 ,0x01 ,0x01 ,0x01 ,0x08 ,0x17
                ,0x23 ,0x01 ,0x08 ,0x54 ,0x50 ,0x16 ,0x26 ,0x00 ,0x06 ,0x06  ,0x38 ,0x16};
        /**
         * IMU
         */
        byte imu[] = {   0x68 ,0x2E ,0x00 ,0x2E ,0x00 ,0x68 ,(byte)0xB8 ,(byte)0x86 ,0x30 ,0x08
                        ,0x1A ,0x56 ,0x34 ,0x12 ,0x0C ,(byte)0xE0 ,0x04 ,0x01 ,0x04 ,0x18
                        ,0x12 ,0x21 ,0x43 ,0x04 ,0x01 ,0x08 ,0x18 ,0x12 ,0x21 ,0x43
                        ,0x04 ,0x01 ,0x10 ,0x18 ,0x12 ,0x21 ,0x43 ,0x04 ,0x01 ,0x20
                        ,0x18 ,0x21 ,0x43 ,(byte)0xA1 ,0x08 ,0x18 ,0x31 ,0x09 ,0x29 ,0x00
                        ,0x06 ,0x06 ,(byte)0xD2 ,0x16};

        byte[] recvFram = null;
        int lenRecvFram;
        int port = 9998;

/*        try {
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
                inputStream.close();
                socket.close();
                serversocket.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        CL1GetOpt com =  new CL1GetOpt();
        if(hearbeat!=null) {

            //com.parse_msg_server(recvFram);
            System.out.println("->DEBUG:");
            CommunicationProtocol parseMessage = com.parse_message(hearbeat);
            int as;
            System.out.println(parseMessage.getMessage());
        }
        else
        {
            System.out.println("parseMessage is empty");
        }
    }

}
