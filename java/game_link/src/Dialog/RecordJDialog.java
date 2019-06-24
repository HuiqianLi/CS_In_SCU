package Dialog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tools.Student;
import Linkup.LinkeUpMainFrame;

public class RecordJDialog extends JDialog {
	private JTextField textFieldName = new JTextField();
	private JButton buttonSure =new JButton("确定");
	private JButton buttonCancel = new JButton("取消");
	LinkeUpMainFrame frame;
	public RecordJDialog(LinkeUpMainFrame frame){
		super(frame);
		this.frame=frame;
		
		init();
		setTitle("记录成绩");
		this.setSize(250, 200);
		this.setLocationRelativeTo(frame);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
		
		
	}
	private void init() {
		this.setLayout(null);
		JLabel labelmessage = new JLabel("游戏结束，大侠请输入名字！！");
		labelmessage.setForeground(Color.black);
		labelmessage.setBounds(30,30,300,25);
		textFieldName.setBounds(75,70,100,25);
		buttonSure.setBounds(50, 110, 80, 25);
		buttonCancel.setBounds(140,110,80,25);
		
		this.add(labelmessage);
		this.add(textFieldName);
		this.add(buttonSure);
		this.add(buttonCancel);
		initEvent();
	}
	/**
	 * 给按钮添加监听 
	 */
	private void initEvent() {
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得名字 
				String nameText =textFieldName.getText();
				//销毁对话框
				dispose();
				Student.name=nameText;
				
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