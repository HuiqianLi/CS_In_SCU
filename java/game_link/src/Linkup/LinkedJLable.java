package Linkup;


import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LinkedJLable extends JLabel {
	
	public LinkedJLable(String text) {
		super(text);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
}