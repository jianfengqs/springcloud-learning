package com.qs.demo.memory;

/**
 * gc测试类
 * 大对象直接进入老年代，对象优先分配Eden区
 * -XX:+PrintGCDetails
 * -XX:PretenureSizeThreshold=1000000 (单位是字节)  -XX:+UseSerialGC
 *
 * @author feishi
 * @date 2021/06/07
 */
public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6;
        allocation1 = new byte[60000 * 1024];

        allocation2 = new byte[8000 * 1024];

//        allocation3 = new byte[1000 * 1024];
//        allocation4 = new byte[1000 * 1024];
//        allocation5 = new byte[1000 * 1024];
//        allocation6 = new byte[1000 * 1024];
    }
}