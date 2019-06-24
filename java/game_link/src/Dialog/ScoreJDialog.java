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
	//文本域  多行文本框
	private JTextArea textArea = new JTextArea();
	LinkeUpMainFrame frame;
	TreeSet<Student> treeSet = new TreeSet<Student>();
	public ScoreJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame=frame;
		init();
		this.setTitle("查看游戏成绩");
		this.setSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	private void init() {
		//把文本域 加入到 滚动面板 才能实现滚动效果
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.orange));
		this.add(scrollPane);
		//设置不可以编辑
		textArea.setEditable(false);
		//自动换行
		textArea.setLineWrap(true);
		//追加内容
		textArea.append("成绩\t名字\n");
	
		
		Student student1=new Student(Param.score,Param.name);
		treeSet.add(student1);
		
		
		//针对集合的最酷炫的迭代方式  forEach迭代
		for (Student student : treeSet) {
			textArea.append(student+"\n");
		}
		

	}

}
