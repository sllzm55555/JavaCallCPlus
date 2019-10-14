package orientIntelligent.utils;

import orientIntelligent.entity.CommunicationProtocol;
import orientIntelligent.entity.ProtocolContent;
import orientIntelligent.jni.CCommunicate;
import orientIntelligent.jni.CL1SetOpt;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-10-14
 */
public class ProtocolUtils {

    private ProtocolUtils(){}

    public static byte[] packMessage(ProtocolContent protocolContent){
        return new CL1SetOpt().packageMessage(protocolContent);
    }

    public static CommunicationProtocol unpackMessage(byte[] message){
        return new CCommunicate().parse_message(message);
    }

}
