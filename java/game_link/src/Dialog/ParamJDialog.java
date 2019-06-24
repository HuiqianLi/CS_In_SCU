package Dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Linkup.LinkeUpMainFrame;
import tools.Param;

public class ParamJDialog extends JDialog {
	private JTextField textFieldTime = new JTextField(Param.timeCount + "");
	private JTextField textFieldRefreshCount = new JTextField(
			Param.refreshCountConstant + "");
	private JTextField textFieldRemarkCount = new JTextField(
			Param.remarkCountConstant + "");
	private JButton buttonSure = new JButton("确认");
	private JButton buttonCancel = new JButton("取消");
	LinkeUpMainFrame frame;

	public ParamJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame = frame;
		init();
		setTitle("游戏参数设置 ");
		this.setSize(new Dimension(300, 200));
		this.setLocationRelativeTo(frame);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);

	}

	private void init() {
		this.setLayout(null);
		JLabel labelTime = new JLabel("游戏时间：");
		JLabel labelRefresh = new JLabel("刷新次数：");
		JLabel labelRemark = new JLabel("提示次数：");
		JLabel labelTimeMessage = new JLabel("秒(整数)");
		JLabel labelRefreshMessage = new JLabel("*整数");
		JLabel labelRemarkMessage = new JLabel("*整数");
		labelTimeMessage.setForeground(Color.black);
		labelRefreshMessage.setForeground(Color.black);
		labelRemarkMessage.setForeground(Color.black);
		labelTime.setBounds(60, 20, 80, 25);
		textFieldTime.setBounds(121, 20, 60, 25);
		labelTimeMessage.setBounds(182, 20, 80, 25);
		
		labelRefresh.setBounds(60, 60, 80, 25);
		textFieldRefreshCount.setBounds(121, 60, 60, 25);
		labelRefreshMessage.setBounds(182, 60, 80, 25);

		labelRemark.setBounds(60, 100, 80, 25);
		textFieldRemarkCount.setBounds(121, 100, 60, 25);
		labelRemarkMessage.setBounds(182, 100, 80, 25);

		buttonSure.setBounds(60, 140, 80, 25);
		buttonCancel.setBounds(150, 140, 80, 25);

		this.add(labelTime);
		this.add(textFieldTime);
		this.add(labelTimeMessage);

		this.add(labelRefresh);
		this.add(textFieldRefreshCount);
		this.add(labelRefreshMessage);

		this.add(labelRemark);
		this.add(textFieldRemarkCount);
		this.add(labelRemarkMessage);

		this.add(buttonSure);
		this.add(buttonCancel);
		initEvent();
	
	}
	private void initEvent() {
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//获得时间
				String timeText = textFieldTime.getText();
				int time=0;
				try{
					time = Integer.parseInt(timeText);
					if (!(10 <= time && time <= 600)) {
						JOptionPane.showMessageDialog(frame,
								"时间范围不合法,范围[10~600]!");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "时间必须为数字,范围[10~600]!");
					return;
				}
				//获得洗牌次数
				String refreshText=textFieldRefreshCount.getText();
				int refreshCount=0;
				try {
					refreshCount = Integer.parseInt(refreshText);// 8984398
					if (!(3 <= refreshCount && refreshCount <= 20)) {
						JOptionPane.showMessageDialog(frame,
								"洗牌次数范围不合法,范围[3~20]!");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "洗牌次数必须为数字,范围[3~20]!");
					return;
				}
				//提示次数
				String remarkText=textFieldRemarkCount.getText();
				int remarkCount=0;
				try {
					remarkCount = Integer.parseInt(remarkText);// 8984398
					if (!(3 <= remarkCount && remarkCount <= 20)) {
						JOptionPane.showMessageDialog(frame,
								"洗牌次数范围不合法,范围[3~20]!");
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(frame, "洗牌次数必须为数字,范围[3~20]!");
					return;
				}
				//销毁对话框
				dispose();
				//合法
				Param.timeCount=time;
				Param.refreshCountConstant=refreshCount;
				Param.remarkCountConstant=remarkCount;
				frame.restartGame();
			}
		});
		
		//销毁对话框
		buttonCancel.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}

}