package orientIntelligent.entity;

/**
 * @author wt
 * @version 1.0.0
 * @date 2019-09-11
 */
public class ControlField {

    private UpLink  up;

    public ControlField(UpLink up) {
        this.up = up;
    }

    public ControlField() {
    }

    public UpLink getUp() {
        return up;
    }

    public class UpLink {
        private int dir;
        private int prm;
        private int acd;
        private int reserve;
        private int functionCode;

        public UpLink(int dir, int prm, int acd, int reserve, int functionCode) {
            this.dir = dir;
            this.prm = prm;
            this.acd = acd;
            this.reserve = reserve;
            this.functionCode = functionCode;
        }

        public UpLink() {
        }

        public void SetUp()
        {
            up = this;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        public int getPrm() {
            return prm;
        }

        public void setPrm(int prm) {
            this.prm = prm;
        }

        public int getAcd() {
            return acd;
        }

        public void setAcd(int acd) {
            this.acd = acd;
        }

        public int getReserve() {
            return reserve;
        }

        public void setReserve(int reserve) {
            this.reserve = reserve;
        }

        public int getFunctionCode() {
            return functionCode;
        }

        public void setFunctionCode(int functionCode) {
            this.functionCode = functionCode;
        }
    }

    /**
     * 下行
     */
    public class DownLink {
        private int dir;
        private int prm;
        private int fcb;
        private int reserve;
        private int functionCode;

        public DownLink() {
        }

        public DownLink(int dir, int prm, int fcb, int reserve, int functionCode) {
            this.dir = dir;
            this.prm = prm;
            this.fcb = fcb;
            this.reserve = reserve;
            this.functionCode = functionCode;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        public int getPrm() {
            return prm;
        }

        public void setPrm(int prm) {
            this.prm = prm;
        }

        public int getFcb() {
            return fcb;
        }

        public void setFcb(int fcb) {
            this.fcb = fcb;
        }

        public int getReserve() {
            return reserve;
        }

        public void setReserve(int reserve) {
            this.reserve = reserve;
        }

        public int getFunctionCode() {
            return functionCode;
        }

        public void setFunctionCode(int functionCode) {
            this.functionCode = functionCode;
        }
    }

}
