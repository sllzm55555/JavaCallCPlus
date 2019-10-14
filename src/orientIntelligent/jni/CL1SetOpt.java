package orientIntelligent.jni;

import orientIntelligent.entity.ProtocolContent;

public class CL1SetOpt extends CDFSLProOpt{
    public native byte[] packageMessage(ProtocolContent protocolContent);
}
