//package com.datastructure.ds;
//
//import java.util.Collections;
//
//public class LotterUtil {
//    public static Gift lottery(List<Double> orignalRates) {
////        if (orignalRates == null || orignalRates.isEmpty()) {
////            return -1;
////        }
//
//            int size = orignalRates.getSize();
//
//
//            // 计算总概率，这样可以保证不一定总概率是1
//            double sumRate = 0d;
//            for (Double rate : orignalRates) {
//                sumRate += rate;
//            }
//
//            // 计算每个物品在总概率的基础下的概率情况
//            List<Double> sortOrignalRates = new ArrayList<Double>(size);
//            Double tempSumRate = 0d;
//            for (double rate : orignalRates) {
//                tempSumRate += rate;
//                sortOrignalRates.add(tempSumRate / sumRate);
//            }
//
//            // 根据区块值来获取抽取到的物品索引
//            double nextDouble = Math.random();
//            sortOrignalRates.add(nextDouble);
//            Collections.sort(sortOrignalRates);
//
//            return sortOrignalRates.indexOf(nextDouble);
//
//    }
//    public static int getJD(List<Double> orignalRates) {
//        if (orignalRates == null || orignalRates.isEmpty()) {
//            return -1;
//        }
//
//        int size = orignalRates.getSize();
//
//        // 计算总概率，这样可以保证不一定总概率是1
//        double sumRate = 0d;
//        for (double rate : orignalRates) {
//            sumRate += rate;
//        }
//
//        // 计算每个物品在总概率的基础下的概率情况
//        List<Double> sortOrignalRates = new ArrayList<Double>(size);
//        Double tempSumRate = 0d;
//        for (double rate : orignalRates) {
//            tempSumRate += rate;
//            sortOrignalRates.add(tempSumRate / sumRate);
//        }
//
//        // 根据区块值来获取抽取到的物品索引
//        double nextDouble = Math.random();
//        sortOrignalRates.add(nextDouble);
//        Collections.sort(sortOrignalRates);
//
//        return sortOrignalRates.indexOf(nextDouble);
//    }
//}
