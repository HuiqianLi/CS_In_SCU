package Dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import tools.Param;
import tools.Student;
import Linkup.LinkeUpMainFrame;

public class ExitJDialog extends JDialog {

	LinkeUpMainFrame frame;
	private JButton buttonSure =new JButton("确定");
	private JButton buttonCancel = new JButton("取消");
	public ExitJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame=frame;
		init();
		setTitle("退出游戏");
		this.setSize(new Dimension(300,200));
		this.setLocationRelativeTo(frame);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
		
	}	
	private void init() {
		this.setLayout(null);
		JLabel labelmessage = new JLabel("亲！确定要离开游戏吗？┭┮﹏┭┮");
		labelmessage.setForeground(Color.black);
		labelmessage.setBounds(30,30,300,25);
		buttonSure.setBounds(50, 110, 80, 25);
		buttonCancel.setBounds(140,110,80,25);
		this.add(labelmessage);
		this.add(buttonSure);
		this.add(buttonCancel);
		initEvent();
	}
	private void initEvent() {
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				//销毁对话框
				System.exit(0);
				dispose();
				
			}
		});

		//销毁对话框
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();//销毁对话框
				
			}
		});
	}
}