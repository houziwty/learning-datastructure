package com.datastructure;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author : tianyu.wang
 * create at:  2021/5/14  5:42 下午
 * @description:一致性Hash
 *
 */

public class ConsistentHashingWithVirtuaNode {
    static String[]servers={"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111",
            "192.168.0.3:111", "192.168.0.4:111"};


    /**
     * 真实结点列表,考虑到服务器上线、下线的场景，即添加、删除的场景会比较频繁，这里使用LinkedList会更好
     */



    /**
     * 虚拟节点，key表示虚拟节点的hash值，value表示虚拟节点的名称
     */
    static SortedMap<Integer,String>virtualNodes=new TreeMap<>();
}
