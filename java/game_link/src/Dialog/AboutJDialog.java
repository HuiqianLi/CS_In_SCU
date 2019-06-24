package Dialog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import tools.Param;
import tools.Student;
import Linkup.LinkeUpMainFrame;

public class AboutJDialog extends JDialog {
	
	LinkeUpMainFrame frame;
	public AboutJDialog(LinkeUpMainFrame frame) {
		super(frame);
		this.frame=frame;
		setTitle("游戏版权");
		this.setSize(new Dimension(550,400));
		this.setLocationRelativeTo(frame);
		
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(Param.About, 0, 0, this);
	}
	
}