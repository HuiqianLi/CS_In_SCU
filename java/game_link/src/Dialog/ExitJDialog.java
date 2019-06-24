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
	private JButton buttonSure =new JButton("ȷ��");
	private JButton buttonCancel = new JButton("ȡ��");
	public ExitJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame=frame;
		init();
		setTitle("�˳���Ϸ");
		this.setSize(new Dimension(300,200));
		this.setLocationRelativeTo(frame);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
		
	}	
	private void init() {
		this.setLayout(null);
		JLabel labelmessage = new JLabel("�ף�ȷ��Ҫ�뿪��Ϸ�𣿩ѩҩn�ѩ�");
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
				//���ٶԻ���
				System.exit(0);
				dispose();
				
			}
		});

		//���ٶԻ���
		buttonCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();//���ٶԻ���
				
			}
		});
	}
}