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
    
    ImageIcon Logo = new ImageIcon("Images/build/logo.png");//设置连连看字体图标
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
        this.setTitle("连连看");// 设置 标题

        this.setSize(1000, 650);// 设置宽高

        this.setLocationRelativeTo(null);// 自动适配到屏幕中间

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭模式
        this.setVisible(true);// 设置可见

        ImageIcon imageIcon = new ImageIcon("Images/build/app_icon.png");
        Image image = imageIcon.getImage();
        this.setIconImage(image);// 设置连连看窗体图标
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        /*
         * 这个是有关字体设置的，系统的字体太丑了嘤嘤嘤，我换成图片了┭┮﹏┭┮
        g.setColor(Color.white);
        Font font = new Font("黑体", Font.BOLD, 28);
        g.setFont(font); // 设置字体颜色和字体大小
		*/
        
        g.drawImage(imageBackground, 0, 0, this);// 设置背景图片
        g.drawImage(imageLogo,400, 70, this);

        //g.drawString("连连看", 400, 100);

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
