package com.method;

/**
 * ClassName:ArrayDemo
 * Package:com.method
 * Description:每一个牛B的人物都有一段苦B的岁月，只要像傻B一样坚持，终将会牛B！
 *
 * @date:2021/2/22 10:24
 * @author:VX438364246
 */
public class ArrayDemo {
    public static void main(String[] args) {
        //创建二维数组
        //1 白棋
        //2 黑棋
        int[][]array1=new int[11][11];
        array1[1][2]=1;
        array1[2][3]=2;
        array1[2][2]=1;
        array1[3][3]=2;
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        int sum=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if (array1[i][j]!=0){
                    sum++;
                }
            }
        }
        //System.out.println("有效值："+sum);
        int[][] array2=new int[sum+1][3];
        array2[0][0]=11;
        array2[0][1]=11;
        array2[0][2]=sum;
        //遍历二维数组，非0存进稀疏数组
        int count=0;
        for (int i = 0; i <array1.length ; i++) {
            for (int j = 0; j <array1[i].length ; j++) {
                if(array1[i][j]!=0){
                    count++;
                    array2[count][0]=i;
                    array2[count][1]=j;
                    array2[count][2]=array1[i][j];
                }

            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int i = 0; i <array2.length ; i++) {
            System.out.println(array2[i][0]+"\t"+
                    array2[i][1]+"\t"+
                    array2[i][2]+"\t");
        }
        System.out.println("**************************还原***********************");
        //读取数组
        int[][]array3=new int[array2[0][0]][array2[0][1]];
        //还原值
        for (int i = 1; i <array2.length ; i++) {
            array3[array2[i][0]][array2[i][1]]=array2[i][2];
        }
        //打印还原后的
        System.out.println("还原的数组：");
        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println("");
        }

    }
}
