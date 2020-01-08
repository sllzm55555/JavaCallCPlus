package orientIntelligent.jni;

import orientIntelligent.entity.ProtocolContent;

public class CL1SetOpt extends CDFSLProOpt{
    public synchronized static native byte[] packageMessage(ProtocolContent protocolContent);
}
