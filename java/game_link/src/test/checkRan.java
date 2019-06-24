package test;


import java.util.Random;

public class checkRan {

    public static void main(String[] args) {
        
        int arr[][] = new int[8][10];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int count = 0;
            while (count < 4) {
                int x = random.nextInt(8);//产生0~8（不包括8）的随机整数
                int y = random.nextInt(10);//产生0~10（不包括10）的随机整数
                if (arr[x][y] == 0) {//该坐标还没有被数占有
                    arr[x][y] = i;//用i标识该坐标，表示该坐标已经有数了
                    count++;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

}