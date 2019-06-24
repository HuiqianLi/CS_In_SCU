package Linkup;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tools.Core;
import tools.Param;
import Linkup.SoundThread;
public class LinkeUpMainFrame extends JFrame {
	MapPanel mapPanel = new MapPanel(this);
	
	int remarkCount = Param.remarkCountConstant, refreshCount = Param.refreshCountConstant;
	JLabel labelStart = new LinkedJLable("开始");
	JLabel labelRemark = new LinkedJLable("提示(" + remarkCount + ")");
	JLabel labelRefresh = new LinkedJLable("洗牌(" + refreshCount + ")");
	JLabel labelScore = new LinkedJLable("当前成绩：");
	JLabel labelRestart = new LinkedJLable("重新开始");
TimerJProgressbar timerJProgressbar=new TimerJProgressbar(this);

LinkupMenuBar menuBar = new LinkupMenuBar(this);
	public LinkeUpMainFrame() {
		init();
		this.setJMenuBar(menuBar);
		//
		this.setTitle("连连看");// 设置 标题

		this.setSize(1000, 650);// 设置宽高

		this.setLocationRelativeTo(null);// 自动适配到屏幕中间

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置关闭模式
		this.setResizable(false);

		this.setVisible(true);// 设置可见

		ImageIcon imageIcon = new ImageIcon("Images/Photos/app_icon.png");
		Image image = imageIcon.getImage();
		this.setIconImage(image);// 设置连连看窗体图标
	}

	private void init() {
	
		this.setLayout(null);
		labelStart.setFont(new Font("宋体", Font.BOLD, 16));
		labelRemark.setFont(new Font("宋体", Font.BOLD, 16));
		labelRefresh.setFont(new Font("宋体", Font.BOLD, 16));
		labelScore.setFont(new Font("宋体", Font.BOLD, 16));
		labelRestart.setFont(new Font("宋体", Font.BOLD, 16));

		labelStart.setBounds(20, 20, 80, 25);
		labelStart.setForeground(Color.white);
		labelRestart.setBounds(90, 20, 100, 25);
		labelRestart.setForeground(Color.white);
		labelRemark.setBounds(200, 20, 80, 25);
		labelRemark.setForeground(Color.white);
		labelRefresh.setBounds(300, 20, 80, 25);
		labelRefresh.setForeground(Color.white);
		labelScore.setBounds(400, 20, 150, 25);
		labelScore.setForeground(Color.white);
		timerJProgressbar.setBounds(650,20,200,23);
		this.add(labelStart);
		this.add(labelRestart);
		this.add(labelRemark);
		this.add(labelRefresh);
		this.add(labelScore);
		this.add(timerJProgressbar);
		mapPanel.setBounds(0, 0, 1000, 650);

		this.add(mapPanel);
		
		labelStart.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				new SoundThread("Music/easymap.mid").start();
				String text = labelStart.getText();
				if ("开始".equals(text)) {
					
					Param.gameStatus = 1;
					labelStart.setText("暂停");
					
					timerJProgressbar.start();
					repaint();
				} else if ("暂停".equals(text)) {
					 
					Param.gameStatus = 2;
					labelStart.setText("继续");
					
					timerJProgressbar.stop();
					repaint();
				} else if ("继续".equals(text)) {
					
					Param.gameStatus = 1;
					labelStart.setText("暂停");

					timerJProgressbar.start();
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				String text = labelStart.getText();
				if ("开始".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 20));
					labelStart.setText("开始");
				} else if ("暂停".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 20));
					labelStart.setText("暂停");
				} else if ("继续".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 20));
					labelStart.setText("继续");
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				String text = labelStart.getText();
				if ("开始".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 16));
					labelStart.setText("开始");
				} else if ("暂停".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 16));
					labelStart.setText("暂停");
				} else if ("继续".equals(text)) {
					labelStart.setFont(new Font("宋体", Font.BOLD, 16));
					labelStart.setText("继续");
				}
			}

		});

		// 洗牌

		labelRefresh.addMouseListener(new MouseAdapter() {
			//int count = 0;
		
			@Override
			public void mousePressed(MouseEvent e) {
				new SoundThread("Music/easymap.mid").start();
				if (Param.gameStatus != 1) {
					JOptionPane.showMessageDialog(LinkeUpMainFrame.this,
							"游戏还未开始，请先开始游戏！");
					return;
				}

				if (e.getModifiers() != InputEvent.BUTTON1_MASK) {
					return;
				}

				if (Param.refreshcount < 3) {
					Core.refreshArr(mapPanel.arr);
					repaint();
					Param.refreshcount++;
					refreshCount--;
					labelRefresh.setText("洗牌(" + refreshCount + ")");
				}else{
					JOptionPane.showMessageDialog(LinkeUpMainFrame.this, "洗牌次数已用完！");
					return;
				}

			}

		});

		// 提示 监听

		labelRemark.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mousePressed(MouseEvent e) {
				if (Param.gameStatus != 1) {
					JOptionPane.showMessageDialog(LinkeUpMainFrame.this,
							"游戏还未开始，请先开始游戏！");
					return;
				}

				if (e.getModifiers() != InputEvent.BUTTON1_MASK) {
					return;
				}
			
					List<Point> list = Core.remarkArr(mapPanel.arr);
					if (list != null) {
						if (Param.remarkcount < 3) {
						Param.remarkcount++;
						remarkCount--;
						labelRemark.setText("提示(" + remarkCount + ")");
					}else{
						JOptionPane.showMessageDialog(LinkeUpMainFrame.this, "提示次数已用完！");
						return;
					}
					remarkDeal(list);
				}

			}

		});
		
		labelRestart.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getModifiers()!=InputEvent.BUTTON1_MASK){
					return;
				}
				restartGame();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				labelRestart.setFont(new Font("宋体",Font.BOLD,20));
				labelRestart.setText("重新开始");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				labelRestart.setFont(new Font("宋体",Font.BOLD,16));
				labelRestart.setText("重新开始");
			}
		});
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new LinkeUpMainFrame();

	}

	public void remarkDeal(final List<Point> list) {
		
		new Thread() {
			public void run() {
				int count=0;
				while ( count< 3) {
					mapPanel.drawMyRect(list.get(0), Color.orange);
					mapPanel.drawMyRect(list.get(1), Color.orange);
					count++;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}
		}.start();
	}

	public int setScore(int score) {
		labelScore.setText("当前成绩:" + score);
		return score;
	}
	
	public  void  restartGame(){
		Param.gameStatus=1;
		timerJProgressbar.reset();
		refreshCount=Param.refreshCountConstant;
		remarkCount=Param.remarkCountConstant;
		labelRefresh.setText("洗牌("+refreshCount+")");
		labelRemark.setText("提示(" + remarkCount + ")");
		
		Param.score=0;
		setScore(0);
		mapPanel.initArr();
		labelStart.setText("暂停");
		timerJProgressbar.start();
		repaint();
		
	}
	
	public void restart(){
		Param.gameStatus=0;
		timerJProgressbar.reset();
		refreshCount=Param.refreshCountConstant;
		remarkCount=Param.remarkCountConstant;
		labelRefresh.setText("洗牌("+refreshCount+")");
		labelRemark.setText("提示(" + remarkCount + ")");
		
		Param.score=0;
		setScore(0);
//		mapPanel.initArr();
		labelStart.setText("开始");
//		timerJProgressbar.start();
		repaint();
	}
	
	public void GameOver(){
		Param.gameStatus=3;
		labelRefresh.setText("洗牌("+(Param.refreshCountConstant-Param.refreshcount)+")");
		labelRemark.setText("提示(" + (Param.remarkCountConstant-Param.remarkcount) + ")");
		timerJProgressbar.setValue(0);
		timerJProgressbar.setString("0秒");
		timerJProgressbar.setStringPainted(true);
		repaint();
	}
}