package com.method;

import java.util.Arrays;

/**
 * ClassName:ArraysDemo05
 * Package:com.method
 * Description:每一个牛B的人物都有一段苦B的岁月，只要像傻B一样坚持，终将会牛B！
 *
 * @date:2021/2/20 17:37
 * @author:VX438364246
 */
public class ArraysDemo05 {
    public static void main(String[] args) {
        //冒泡排序
        int[]arrays={5,8,3,4,1};

        int max=0;
        //轮数
        for (int i = 0; i < arrays.length; i++) {
            //次数比较
            for (int j = 0; j <arrays.length-1-i ; j++) {
                if (arrays[j+1]>arrays[j]){
                    max=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=max;

                }

            }
        }
        //System.out.println(Arrays.toString(arrays));
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.println(arrays[i]);
//        }
        for (int array : arrays) {
            System.out.println(array);
        }



        int[]arrays2={5,8,3,4,1};
        int[] s=paiXun(arrays2);
        System.out.println(Arrays.toString(s));
    }
//2
    public static int[] paiXun(int[]arr){
        int max=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    max=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=max;
                }
            }

        }

        return arr;
    }

}
