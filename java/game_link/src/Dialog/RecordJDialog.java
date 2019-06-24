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
	private JButton buttonSure =new JButton("ȷ��");
	private JButton buttonCancel = new JButton("ȡ��");
	LinkeUpMainFrame frame;
	public RecordJDialog(LinkeUpMainFrame frame){
		super(frame);
		this.frame=frame;
		
		init();
		setTitle("��¼�ɼ�");
		this.setSize(250, 200);
		this.setLocationRelativeTo(frame);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
		
		
	}
	private void init() {
		this.setLayout(null);
		JLabel labelmessage = new JLabel("��Ϸ�������������������֣���");
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
	 * ����ť��Ӽ��� 
	 */
	private void initEvent() {
		buttonSure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//������� 
				String nameText =textFieldName.getText();
				//���ٶԻ���
				dispose();
				Student.name=nameText;
				
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