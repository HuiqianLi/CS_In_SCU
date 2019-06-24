package tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Param {

	// 游戏总行数与总列数
	public static int rows = 8;
	public static int cols = 10;

	// 棋子图标 宽与高
	public static int chessWidth = 60;
	public static int chessHeight = 60;

	// 棋盘到边界的距离
	public static int marginWidth = 200 - chessWidth;
	public static int marginHeight = 100 - chessHeight;

	// 游戏的背景图片
	
	public static Image imageBackground1 = new ImageIcon("Images/Back/BackGround1.jpg").getImage();
	public static Image imageBackground2 = new ImageIcon("Images/Back/BackGround2.jpg").getImage();
	public static Image imageBackground3 = new ImageIcon("Images/Back/BackGround3.jpg").getImage();
	public static Image imageBackground4 = new ImageIcon("Images/Back/BackGround4.jpg").getImage();
	public static Image imageBackground5 = new ImageIcon("Images/Back/BackGround5.jpg").getImage();
	public static Image imageBackground6 = new ImageIcon("Images/Back/BackGround6.jpg").getImage();
	public static Image imageBackground = new ImageIcon("Images/Back/BackGround1.jpg").getImage();
	
	public  static  Image RulePicture=new ImageIcon("Images/build/LinkupRule.png").getImage();
	public static Image[][] chessImage = new Image[4][20];
	public static Image[] chessImageIcon=new Image[20];
	
	static {
		for (int i = 0; i < chessImageIcon.length; i++) {
			chessImage[0][i] = new ImageIcon("Images/build/jpg/1." + (i + 1) + ".jpg")
					.getImage();
			chessImageIcon[i] = new ImageIcon("Images/build/jpg/1." + (i + 1) + ".jpg")
			.getImage();
			chessImage[1][i] = new ImageIcon("Images/build/jpg/2." + (i + 1) + ".jpg")
			.getImage();
			chessImage[2][i]=new ImageIcon("Images/build/jpg/3."+(i+1)+".jpg").getImage();
			chessImage[3][i]=new ImageIcon("Images/build/jpg/4."+(i+1)+".jpg").getImage();
			
		}
	}
	
	public static int gameStatus = 0;
	
	public static int timeCount = 100;
	public static int refreshCountConstant=3;
	public static int remarkCountConstant=3;
	
	public static  int score=0;
	public static  int ChessCount=80;
	public static  int refreshcount=0;
	public static  int remarkcount=0;
	public static String name;
	public static Image About=new ImageIcon("Images/build/About.jpg").getImage();
	public static Image Rule=new ImageIcon("Images/build/LinkupRule.png").getImage();
}