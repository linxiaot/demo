package com.lin.util.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPacket {

    public static List<BigDecimal> splitRedPacket(BigDecimal totalAmount, int totalNumber) {
        List<BigDecimal> amounts = new ArrayList<>();

        if (totalAmount.compareTo(BigDecimal.ZERO) <= 0 || totalNumber <= 0) {
            return amounts;
        }

        BigDecimal remainAmount = totalAmount;
        int remainNumber = totalNumber;

        Random random = new Random();
        for (int i = 0; i < totalNumber - 1; i++) {
            BigDecimal amount = new BigDecimal(String.valueOf(random.nextDouble())).multiply(remainAmount.divide(new BigDecimal(remainNumber), 2, RoundingMode.HALF_UP).multiply(new BigDecimal(2))).setScale(2, RoundingMode.HALF_UP);
            amounts.add(amount);
            remainAmount = remainAmount.subtract(amount);
            remainNumber--;
        }

        amounts.add(remainAmount);

        return amounts;
    }

    public static void main(String[] args) {
        BigDecimal totalAmount = new BigDecimal(100); // 总金额
        int totalNumber = 10; // 总人数

        List<BigDecimal> amounts = splitRedPacket(totalAmount, totalNumber);

        System.out.println("拆分结果：");
        for (BigDecimal amount : amounts) {
            System.out.println(amount);
        }
        BigDecimal res = new BigDecimal(0);
        for(BigDecimal it : amounts){
            res = res.add(it);
        }
        System.out.println(res);
    }
}
