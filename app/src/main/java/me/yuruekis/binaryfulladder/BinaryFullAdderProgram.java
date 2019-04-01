package me.yuruekis.binaryfulladder;

/**
 *
 * @author Hall_Haa 夏志宇;
 *
 */

import java.util.Scanner;

public class BinaryFullAdderProgram {

    public static int [] BinaryAdder(int isBD, int inputOne, int inputTwo) {
        int i, j, z;//input1,2为加数和被加数，i，j，z为循环变量
        int p = 0;
        int q = 0;
        int x, y;//循环变量
        int c = 0;
        int s, c1;//s为和，c为当前进位，c1为上次计算的进位
        int[] input1_c = new int[32];
        for (i = 0; i <= 31; i++) {
            input1_c[i] = 0;
        }
        int[] input2_c = new int[32];
        for (i = 0; i <= 31; i++) {
            input2_c[i] = 0;
        }//用整形数组储存二进制的加数和被加数
        int[] result = new int[33];//结果
        //Scanner in1=new Scanner(System.in);
        //System.out.println("请输入1或2来选择：1.输入十进制数    2.输入二进制数");
        int a = isBD;

        if (a == 1) {
            //Scanner in2=new Scanner(System.in);
            //Scanner in3=new Scanner(System.in);
            //System.out.println("请输入两个十进制整数:");
            int input1 = inputOne;
            int input2 = inputTwo;

            if (input1 != 0)//特殊情况
                for (i = 0; input1 != 0; i = i + 1) {
                    input1_c[i] = input1 % 2;//转换为二进制：除2取余
                    input1 = input1 / 2;
                }
            else {
                input1_c[0] = 0;
                i = 1;
            }
            if (input2 != 0)//同加数一般，处理被加数
                for (j = 0; input2 != 0; j = j + 1) {
                    input2_c[j] = input2 % 2;
                    input2 = input2 / 2;
                }
            else {
                input2_c[0] = 0;
                j = 1;
            }
            System.out.println("两个十进制整数转换为二进制数是:");//printf("两个十进制整数转换为二进制数是:\n");
            p = i = i - 1;
            for (; i >= 0; i = i - 1)
                System.out.print(input1_c[i]);
            System.out.println();
            q = j = j - 1;
            for (; j >= 0; j = j - 1)
                System.out.print(input2_c[j]);
            System.out.println();
        }
        if (a == 2) {
            Scanner in2 = new Scanner(System.in);
            Scanner in3 = new Scanner(System.in);
            System.out.println("请输入两个二进制整数:");
            int input1 = in2.nextInt();
            int input2 = in3.nextInt();

            if (input1 != 0)
                for (i = 0; input1 != 0; i = i + 1) {
                    input1_c[i] = input1 % 10;
                    input1 = input1 / 10;
                }
            else {
                input1_c[0] = 0;
                i = 1;
            }
            if (input2 != 0)
                for (j = 0; input2 != 0; j = j + 1) {
                    input2_c[j] = input2 % 10;
                    input2 = input2 / 10;
                }
            else {
                input2_c[0] = 0;
                j = 1;
            }
            System.out.println("二进制数是:");
            p = i = i - 1;
            for (; i >= 0; i = i - 1) {
                System.out.print(input1_c[i]);
            }
            System.out.println();
            q = j = j - 1;
            for (; j >= 0; j = j - 1)
                System.out.print(input2_c[j]);
            System.out.println();
        }
        //检验正确性
        //printf("\n%d\n%d\n",p,q);

        for (c1 = 0, z = 0, i = 0, j = 0; i <= p || j <= q; c1 = c, z = z + 1, i = i + 1, j = j + 1) {
            x = input1_c[i];
            y = input2_c[j];
            result[z] = 0;
            if (c1 == 0 && x == 0 && y == 1) {
                result[z] = 1;
            }
            if (c1 == 0 && x == 1 && y == 0) {
                result[z] = 1;
            }
            if (c1 == 1 && x == 0 && y == 0) {
                result[z] = 1;
            }
            if (c1 == 1 && x == 1 && y == 1) {
                result[z] = 1;
            }
            c = 0;
            if (c1 == 0 && x == 1 && y == 1) {
                c = 1;
            }
            if (c1 == 1 && x == 0 && y == 1) {
                c = 1;
            }
            if (c1 == 1 && x == 1 && y == 0) {
                c = 1;
            }
            if (c1 == 1 && x == 1 && y == 1) {
                c = 1;
            }
            //c=(!c1&&x&&y)||(c1&&!x&&y)||(c1&&x&&!y)||(c1&&x&&y);
        }
        result[z] = c;
        //检验正确性
        //printf("\n%d\n%d\n",p,q);


        /**@ Hall Haa
         * 以下是输出结果，上面的程序已经把所有数据处理完成。
         */
        System.out.println("结果为：");
        if(result[z]==0) {
            z = z - 1;
        }

        int [] returnResult = new int[33];

        for (i = 0; i <= 32; i++) {
            returnResult[i] = 0;
        }

        int j = 0;

        for(;z>=0;z=z-1) {
            //System.out.print(result[z]);
            returnResult[j] = result[z];
            j++;
        }

        return returnResult;

        /**@ Hall Haa
         * 输出模块结束。
         */




    }

}