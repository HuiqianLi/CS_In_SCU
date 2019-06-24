package Linkup;

import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.TreeSet;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.plaf.OptionPaneUI;

import Dialog.AboutJDialog;
import Dialog.ExitJDialog;
import Dialog.ParamJDialog;
import Dialog.RuleJDialog;
import Dialog.ScoreJDialog;
import tools.Param;
import tools.Student;

public class LinkupMenuBar extends JMenuBar {
	JMenuItem menuItemParam = new JMenuItem("游戏参数");
	JMenu menuItemBackground = new JMenu("设置背景");
	JMenu menuItemChessIcon = new JMenu("设置棋子");
	JMenuItem menuItemScore = new JMenuItem("查看成绩");
	JMenuItem menuItemExit = new JMenuItem("退出游戏");
	JMenuItem menuItemRule = new JMenuItem("游戏规则");
	
	JMenuItem menuItemAbout = new JMenuItem("游戏版权");

	LinkeUpMainFrame mainFrame;
	public LinkupMenuBar(LinkeUpMainFrame mainFrame) {
		this.mainFrame=mainFrame;
		
		this.init();
	}
	private void init() {
		
		JMenu menuSet = new JMenu("设置");
		menuSet.add(menuItemParam);
		menuSet.addSeparator();
		menuSet.add(menuItemBackground);
		menuSet.addSeparator();
		menuSet.add(menuItemChessIcon);
		menuSet.addSeparator();
		menuSet.add(menuItemScore);
		menuSet.addSeparator();
		menuSet.add(menuItemExit);
		String[] arrIcon=new String[]{"英雄1","英雄2","英雄3","英雄4"};
		for (int i = 0; i < arrIcon.length; i++) {
			final JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(arrIcon[i]);
			menuItemChessIcon.add(jCheckBoxMenuItem);
			menuItemChessIcon.addSeparator();
			jCheckBoxMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String text = jCheckBoxMenuItem.getText();
					if("英雄1".equals(text)){
						Param.chessImageIcon=Param.chessImage[0];
					}else if("英雄2".equals(text)){
						Param.chessImageIcon=Param.chessImage[1];
					}else if("英雄3".equals(text)){
						Param.chessImageIcon=Param.chessImage[2];
					}else if("英雄4".equals(text)){
						Param.chessImageIcon=Param.chessImage[3];
					}
					mainFrame.repaint();
				}
			});
		}
		
		String[] arr = new String[]{"海都","三分之地","战国争鸣","上阳台帖","有你才有团","有团聚有王者"};
		ButtonGroup buttonGroup = new ButtonGroup();
		for (int i = 0; i < arr.length; i++) {
			final JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(arr[i]);
			
			menuItemBackground.add(jCheckBoxMenuItem);
			menuItemBackground.addSeparator();
			buttonGroup.add(jCheckBoxMenuItem);
			jCheckBoxMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String text = jCheckBoxMenuItem.getText();
					if("海都".equals(text)){
						Param.imageBackground=Param.imageBackground1;
					}else if("三分之地".equals(text)){
						Param.imageBackground=Param.imageBackground2;
					}else if("战国争鸣".equals(text)){
						Param.imageBackground=Param.imageBackground3;
					}else if("上阳台帖".equals(text)){
						Param.imageBackground=Param.imageBackground4;
					}else if("有你才有团".equals(text)){
						Param.imageBackground=Param.imageBackground5;
					}else if("有团聚有王者".equals(text)){
						Param.imageBackground=Param.imageBackground6;
					}
					mainFrame.repaint();
					
					
					
				}
			});
		}
		
		JMenu menuHelp = new JMenu("帮助");
		
		menuHelp.add(menuItemRule);
		menuHelp.addSeparator();
		menuHelp.add(menuItemAbout);
		this.add(menuSet);
		this.add(menuHelp);
		
		menuItemParam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ParamJDialog(mainFrame);
				
			}
		});
		
		menuItemExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ExitJDialog(mainFrame);
				
			
			}
			
		});
		
		menuItemScore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				new ScoreJDialog(mainFrame);
				
			}
		});
		
		menuItemRule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new RuleJDialog(mainFrame);			}
		
		
			
		});
	
		
		menuItemAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutJDialog(mainFrame);
				
			}
		});
	}
	
	
	
}