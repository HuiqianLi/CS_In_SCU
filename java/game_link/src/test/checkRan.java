package test;


import java.util.Random;

public class checkRan {

    public static void main(String[] args) {
        
        int arr[][] = new int[8][10];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int count = 0;
            while (count < 4) {
                int x = random.nextInt(8);//����0~8��������8�����������
                int y = random.nextInt(10);//����0~10��������10�����������
                if (arr[x][y] == 0) {//�����껹û�б���ռ��
                    arr[x][y] = i;//��i��ʶ�����꣬��ʾ�������Ѿ�������
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