package com.datastructure;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author : tianyu.wang
 * create at:  2021/5/6  11:23 上午
 * @description:
 */
public class SuanFa {

    static Map<String, Integer> all = new HashMap<>();


    static Map<String, Integer> allKey = new HashMap<>();


    public static void main(String[] args) {


        Map<String, String> ali = new HashMap<>();

        Map<String, String> meituan = new HashMap<>();
        Map<String, String> didi = new HashMap<>();
        Map<String, String> kuaishou = new HashMap<>();
        Map<String, String> zijie = new HashMap<>();


        ali = text("/Users/tianyu.wang/Downloads/al.txt");
        didi = text("/Users/tianyu.wang/Downloads/didi.txt");
        meituan = text("/Users/tianyu.wang/Downloads/meituan.txt");
        kuaishou = text("/Users/tianyu.wang/Downloads/kuaishou.txt");
        zijie = text("/Users/tianyu.wang/Downloads/zijie.txt");

        itera(ali);
//        System.out.println("ali size:"+ali.size());

        itera(didi);
//        System.out.println("didi size:"+didi.size());

        itera(meituan);

//        System.out.println("meituan size:"+meituan.size());
        itera(kuaishou);

//        System.out.println("kuaishou size:"+kuaishou.size());
        itera(zijie);

//        System.out.println("zijie size:"+zijie.size());



        remove(ali);
        System.out.println("ali size:"+ali.size());
        remove(didi);
        System.out.println("didi size:"+didi.size());
        remove(meituan);
        System.out.println("meituan size:"+meituan.size());
        remove(kuaishou);
        System.out.println("kuaishou size:"+kuaishou.size());
        remove(zijie);
        System.out.println("zijie size:"+zijie.size());




//        System.out.println("ALL Size:"+all.size());
//        for (Map.Entry<String, Integer> entry : all.entrySet()) {
//            String mapKey = entry.getKey();
//            Integer mapValue = entry.getValue();
//            if(mapValue>1){
//                System.out.println(mapKey);
//            }
//        }


//        iteare(ali);
//        iteare(didi);
//        iteare(meituan);
//        iteare(kuaishou);
        iteare(zijie);






    }

    static void iteare(Map<String, String> map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }
    }

    static void remove(Map<String, String> map){
        for (Map.Entry<String, Integer> entry : all.entrySet()) {
            String mapKey = entry.getKey();
            Integer mapValue = entry.getValue();
            if(mapValue>1){
                map.remove(mapKey);
            }
        }
    }

    static void itera(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            if (all.get(mapKey) == null) {
                all.put(mapKey, 1);
            }else {
                Integer val=all.get(mapKey)+1;
                all.put(mapKey, val);
            }
//            System.out.println(mapKey + ":" + mapValue);
        }


    }


    static Map<String, String> text(String path) {
        Map<String, String> map = new HashMap<>();
        try {
            String encoding = "utf-8";    //设定自己需要的字符编码集
            File file = new File(path);
            if (file.exists() && file.isFile()) {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                //FileReader read = new FileReader(file); //不考虑转码，可使用FileReader;
                BufferedReader br = new BufferedReader(read);//使用缓冲流按行读取
                String lineText = null;
                StringBuffer sb = new StringBuffer();
                while ((lineText = br.readLine()) != null) {

                    boolean isMatch = Pattern.matches(".*%", lineText);
                    if (!isMatch && !lineText.trim().equals("plus") && !lineText.trim().equals("困难") && !lineText.trim().equals("中等") && !lineText.trim().equals("简单")) {
//                        System.out.println(lineText);
                        map.put(lineText, lineText);
                        sb.append(lineText + "\n");
                    }
                }
                br.close();
                read.close();
//                FileWriter fw = new FileWriter("c:/t.txt");
//                BufferedWriter bw = new BufferedWriter(fw);
//                bw.write(sb.toString());
//                bw.close();
//                fw.close();
            } else {
                System.out.println("找不到指定的文件");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
}
