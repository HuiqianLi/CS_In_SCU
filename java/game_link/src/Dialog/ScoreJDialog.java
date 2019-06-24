package Dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import Linkup.LinkeUpMainFrame;
import tools.Student;
import tools.Param;



public class ScoreJDialog extends JDialog {
	//�ı���  �����ı���
	private JTextArea textArea = new JTextArea();
	LinkeUpMainFrame frame;
	TreeSet<Student> treeSet = new TreeSet<Student>();
	public ScoreJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame=frame;
		init();
		this.setTitle("�鿴��Ϸ�ɼ�");
		this.setSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	private void init() {
		//���ı��� ���뵽 ������� ����ʵ�ֹ���Ч��
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.orange));
		this.add(scrollPane);
		//���ò����Ա༭
		textArea.setEditable(false);
		//�Զ�����
		textArea.setLineWrap(true);
		//׷������
		textArea.append("�ɼ�\t����\n");
	
		
		Student student1=new Student(Param.score,Param.name);
		treeSet.add(student1);
		
		
		//��Լ��ϵ�����ŵĵ�����ʽ  forEach����
		for (Student student : treeSet) {
			textArea.append(student+"\n");
		}
		

	}

}
