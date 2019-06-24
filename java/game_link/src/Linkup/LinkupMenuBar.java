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
	JMenuItem menuItemParam = new JMenuItem("��Ϸ����");
	JMenu menuItemBackground = new JMenu("���ñ���");
	JMenu menuItemChessIcon = new JMenu("��������");
	JMenuItem menuItemScore = new JMenuItem("�鿴�ɼ�");
	JMenuItem menuItemExit = new JMenuItem("�˳���Ϸ");
	JMenuItem menuItemRule = new JMenuItem("��Ϸ����");
	
	JMenuItem menuItemAbout = new JMenuItem("��Ϸ��Ȩ");

	LinkeUpMainFrame mainFrame;
	public LinkupMenuBar(LinkeUpMainFrame mainFrame) {
		this.mainFrame=mainFrame;
		
		this.init();
	}
	private void init() {
		
		JMenu menuSet = new JMenu("����");
		menuSet.add(menuItemParam);
		menuSet.addSeparator();
		menuSet.add(menuItemBackground);
		menuSet.addSeparator();
		menuSet.add(menuItemChessIcon);
		menuSet.addSeparator();
		menuSet.add(menuItemScore);
		menuSet.addSeparator();
		menuSet.add(menuItemExit);
		String[] arrIcon=new String[]{"Ӣ��1","Ӣ��2","Ӣ��3","Ӣ��4"};
		for (int i = 0; i < arrIcon.length; i++) {
			final JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(arrIcon[i]);
			menuItemChessIcon.add(jCheckBoxMenuItem);
			menuItemChessIcon.addSeparator();
			jCheckBoxMenuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String text = jCheckBoxMenuItem.getText();
					if("Ӣ��1".equals(text)){
						Param.chessImageIcon=Param.chessImage[0];
					}else if("Ӣ��2".equals(text)){
						Param.chessImageIcon=Param.chessImage[1];
					}else if("Ӣ��3".equals(text)){
						Param.chessImageIcon=Param.chessImage[2];
					}else if("Ӣ��4".equals(text)){
						Param.chessImageIcon=Param.chessImage[3];
					}
					mainFrame.repaint();
				}
			});
		}
		
		String[] arr = new String[]{"����","����֮��","ս������","����̨��","���������","���ž�������"};
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
					if("����".equals(text)){
						Param.imageBackground=Param.imageBackground1;
					}else if("����֮��".equals(text)){
						Param.imageBackground=Param.imageBackground2;
					}else if("ս������".equals(text)){
						Param.imageBackground=Param.imageBackground3;
					}else if("����̨��".equals(text)){
						Param.imageBackground=Param.imageBackground4;
					}else if("���������".equals(text)){
						Param.imageBackground=Param.imageBackground5;
					}else if("���ž�������".equals(text)){
						Param.imageBackground=Param.imageBackground6;
					}
					mainFrame.repaint();
					
					
					
				}
			});
		}
		
		JMenu menuHelp = new JMenu("����");
		
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