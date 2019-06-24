package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings({ "serial", "unused" })
public class TestGUI extends JFrame {
    ImageIcon imageIcon = new ImageIcon("Images/build/BackGround.jpg");
    Image imageBackground = imageIcon.getImage();
    
    ImageIcon Logo = new ImageIcon("Images/build/logo.png");//��������������ͼ��
    Image imageLogo = Logo.getImage();

    static int arr[][] = new int[8][10];
    
    static{
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int count = 0;
            while (count < 4) {
                int x = random.nextInt(8);
                int y = random.nextInt(10);
                if (arr[x][y] == 0) {
                    arr[x][y] = i;
                    count++;
                }
            }
        }
    }

    static Image[] chessImage = new Image[20];
    static {
        for (int i = 0; i < chessImage.length; i++) {
            chessImage[i] = new ImageIcon("Images/build/jpg/" + (i + 1) + ".jpg").getImage();
        }
    }

    public TestGUI() {
        this.setTitle("������");// ���� ����

        this.setSize(1000, 650);// ���ÿ��

        this.setLocationRelativeTo(null);// �Զ����䵽��Ļ�м�

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ùر�ģʽ
        this.setVisible(true);// ���ÿɼ�

        ImageIcon imageIcon = new ImageIcon("Images/build/app_icon.png");
        Image image = imageIcon.getImage();
        this.setIconImage(image);// ��������������ͼ��
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        /*
         * ������й��������õģ�ϵͳ������̫���������ӣ��һ���ͼƬ�˩ѩҩn�ѩ�
        g.setColor(Color.white);
        Font font = new Font("����", Font.BOLD, 28);
        g.setFont(font); // ����������ɫ�������С
		*/
        
        g.drawImage(imageBackground, 0, 0, this);// ���ñ���ͼƬ
        g.drawImage(imageLogo,400, 70, this);

        //g.drawString("������", 400, 100);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 10; j++) {
                g.drawImage(chessImage[arr[i][j]], 200 + (j * 55), 150 + (i * 55), this);
            }
        }

    }

    public static void main(String[] args) {
        
        new TestGUI();

    }
}
