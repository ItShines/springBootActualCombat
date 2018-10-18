package com.springboot.ecs;

import java.util.Scanner;

/**
 * @author zhangsanfeng
 */
public class ForClass {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("每年存多少钱？");
        double payment = in.nextDouble();

        System.out.println("每年的利率的百分比？");
        double interestRate = in.nextDouble();

        double balance =0;
        int year=0;
        String input;

        do{
            balance +=payment;
            double interest = balance * interestRate / 100;
            balance += interest;

            year ++;

            System.out.printf("第%d 年，你的收入是：%,.2f%n",year,balance);

            System.out.println("是否满足退休？(Y/N)");
            input = in.next();

        }while (input.equals("N"));
    }
}
