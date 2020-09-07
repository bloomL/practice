package org.example.jvm;

/**
 * @author liguo
 * @Description 引用计数法
 * @date 2020/8/4/004 16:51
 */
public class ReferenceCountingGc {
    Object instance = null;

    public static void main(String[] args) {
        ReferenceCountingGc referenceA = new ReferenceCountingGc();
        ReferenceCountingGc referenceB = new ReferenceCountingGc();
        referenceA.instance = referenceB;
        referenceB.instance = referenceA;
        referenceA = null;
        referenceB = null;
    }
}
