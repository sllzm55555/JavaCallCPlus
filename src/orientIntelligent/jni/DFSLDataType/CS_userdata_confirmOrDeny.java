package orientIntelligent.jni.DFSLDataType;
import orientIntelligent.jni.Cenumclass.*;

//package orientIntelligent.jni;

public class CS_userdata_confirmOrDeny {
    private S_userdata_confirmOrDeny_F4 F4;
    private S_userdata_confirmOrDeny_F3 F3;
    //private byte[] bytes;//byte[17];
    public class S_userdata_confirmOrDeny_F4
    {
        E_F4ErrNum f4errNum;
        byte[]		data;//data[16];
        public S_userdata_confirmOrDeny_F4 (E_F4ErrNum f4errNum,byte[]		data)
        {
            this.data = data;
            this.f4errNum = f4errNum;
        }
        public void setData(byte[] data) {
            this.data = data;
        }

        public void setF4errNum(E_F4ErrNum f4errNum) {
            this.f4errNum = f4errNum;
        }

        public byte[] getData() {
            return data;
        }

        public E_F4ErrNum getF4errNum() {
            return f4errNum;
        }
    }

    public class S_userdata_confirmOrDeny_F3
    {
        E_F3ErrNum f3errNum;

        public S_userdata_confirmOrDeny_F3 (E_F3ErrNum f3errNum)
        {
            this.f3errNum = f3errNum;
        }

        public void setF3errNum(E_F3ErrNum f3errNum) {
            this.f3errNum = f3errNum;
        }

        public E_F3ErrNum getF3errNum() {
            return f3errNum;
        }
    }

    public CS_userdata_confirmOrDeny()
    {}

    public CS_userdata_confirmOrDeny(S_userdata_confirmOrDeny_F4 F4)
    {
        this.F3 = null;
        this.F4 = F4;
        //this.bytes = null;
    }

    CS_userdata_confirmOrDeny(byte[] bytes)
    {
        this.F3 = null;
        this.F4 = null;
        //this.bytes = bytes;
    }

   public CS_userdata_confirmOrDeny(S_userdata_confirmOrDeny_F3 F3)
    {
        this.F3 = F3;
        this.F4 = null;
        //this.bytes = null;
    }

    /*public byte[] getBytes() {
        return bytes;
    }*/

    public S_userdata_confirmOrDeny_F3 getF3() {
        return F3;
    }

    public S_userdata_confirmOrDeny_F4 getF4() {
        return F4;
    }
}
