package orientIntelligent.utils;

import orientIntelligent.jni.Cenumclass;

/**
 * @author wt
 * @version 1.0.0
 * @date 2020-01-06
 */
public class TestThread {

    public static void main(String[] args) {
//        System.load("E:\\Idea\\JavaCallCPlus\\src\\orientIntelligent\\dll\\pthreadVC2.dll");
//        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");

        System.load("E:\\VS\\DFSLPro\\pthread\\Pre-built.2\\dll\\x64\\pthreadVC2.dll");
        System.load("E:\\VS\\DFSLPro\\x64\\Debug\\DFSLProJni.dll");
//        System.load("E:\\Idea\\JavaCallCPlus\\src\\orientIntelligent\\dll\\DFSLProJni.dll");
        //模拟次数
        for (int i = 0; i < 100; i++) {
            //模拟客户端
            for (int j = 0; j < 10; j++) {
                String temp = "10000" + j;
                new Thread(new TestMultipleThread(temp)).start();
            }
        }
    }
}
