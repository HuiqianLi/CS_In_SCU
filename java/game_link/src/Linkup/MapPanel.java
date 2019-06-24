package Linkup;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Dialog.RecordJDialog;
import tools.Core;
import tools.Param;

/**
 * �������
 * 
 * @author lhq
 * 
 */

public class MapPanel extends JPanel implements MouseListener {
	Chess[][] arr = null;
	// ������
	Stroke stroke = new BasicStroke(3.0f);

	// ���������� ��ŵ���������������
	Point firstPoint;
	Point secondPoint;
	LinkeUpMainFrame mainFrame;

	/**
	 * �Ѵ�����Ϊ�������ݵ������
	 * 
	 * @param mainFrame
	 */

	public MapPanel(LinkeUpMainFrame mainFrame) {
		this.mainFrame = mainFrame;
		initArr();

		this.addMouseListener(this);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	/**
	 * ��ʼ����������
	 */
	public void initArr() {
		arr = new Chess[Param.rows + 2][Param.cols + 2];
		Random random = new Random();
		for (int i = 1; i <= 20; i++) {
			int count = 0;
			while (count < 4) {
				int x = random.nextInt(8) + 1;
				int y = random.nextInt(10) + 1;
				if (arr[x][y] == null) {
					arr[x][y] = new Chess(i);
					count++;
				}
			}
		}

		// ��ΧһȦ �ֶ���ʼ��
		// ������һ����������һ��
		for (int i = 0; i < arr[0].length; i++) {
			arr[0][i] = new Chess(0);
			arr[arr.length - 1][i] = new Chess(0);
		}

		// �����һ�������ұ�һ��
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = new Chess(0);

			arr[i][arr[0].length - 1] = new Chess(0);
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(Param.imageBackground, 0, 0, this);// ���ñ���ͼƬ

		g.setColor(Color.white);
		g.setFont(new Font("����", Font.BOLD, 36));

		if (Param.gameStatus == 0) {
			g.drawString("��Ϸ��δ��ʼ!", 300, 300);
		} else if (Param.gameStatus == 2) {
			g.drawString("��Ϸ��ͣ��!", 300, 300);
		} else if (Param.gameStatus == 3) {
			g.drawString("GameOver!", 300, 300);
		} else {

			for (int i = 1; i < arr.length; i++) {
				for (int j = 1; j < arr[i].length; j++) {
					if (arr[i][j].getStatus() != 0) {
						int x = j * Param.chessWidth + Param.marginWidth;
						int y = i * Param.chessHeight + Param.marginHeight;
						g.drawImage(
								Param.chessImageIcon[arr[i][j].getStatus() - 1], x,
								y, this);
						g.setColor(Color.blue);
						g.drawRect(x, y, Param.chessWidth, Param.chessHeight);
					}
				}
			}
			// �жϵ�һ����firstPoint��Ϊnull
			if (firstPoint != null) {
				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(stroke);
				g2d.setColor(Color.orange);
				int rowX = firstPoint.y * Param.chessWidth + Param.marginWidth;

				int rowY = firstPoint.x * Param.chessHeight
						+ Param.marginHeight;

				g2d.drawRect(rowX + 2, rowY + 2, Param.chessWidth - 4,
						Param.chessHeight - 4);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (Param.gameStatus != 1) {
			return;
		}

		if (e.getModifiers() != InputEvent.BUTTON1_MASK) {
			return;
		}

		int x = e.getX();
		int y = e.getY();

		int j = (x - Param.marginWidth) / Param.chessWidth;
		int rowX = j * Param.chessWidth + Param.marginWidth;
		int i = (y - Param.marginHeight) / Param.chessHeight;
		int rowY = i * Param.chessHeight + Param.marginHeight;

		if (arr[i][j].getStatus() == 0) {
			return;
		}

		if ((x >= Param.marginWidth + Param.chessWidth && x <= Param.marginWidth
				+ Param.cols * Param.chessWidth + Param.chessWidth)
				&& (y >= Param.marginHeight + Param.chessHeight && y <= Param.marginHeight
						+ Param.rows * Param.chessHeight + Param.chessHeight)) {

			// ��һ�ε����firstPoint==null||�ظ�����˵�һ����
			if (firstPoint == null || (firstPoint.x == i && firstPoint.y == j)) {
				firstPoint = new Point(i, j);
				drawMyRect(firstPoint, Color.orange);
				return;
			}
			// �ڶ���
			secondPoint = new Point(i, j);
			drawMyRect(secondPoint, Color.yellow);
			// ͼ���״ֵ̬��ͬ ��ͨ�㷨
			List<Point> list = Core.checkLinked(arr, firstPoint, secondPoint);
			if (list == null) {
				firstPoint = secondPoint;

				mainFrame.repaint();
				return;
			}

			// ������ͨ������ͼ���״ֵ̬Ϊ0���������null�����������ߣ����»��ƽ���
			arr[firstPoint.x][firstPoint.y].setStatus(0);
			arr[secondPoint.x][secondPoint.y].setStatus(0);
			firstPoint = null;
			secondPoint = null;
			Param.ChessCount-=2;
			

			// ����������

			drawLinkedLine(list);

			mainFrame.repaint();
			//��ʾ�÷�
			Param.score+=10;
			mainFrame.setScore(Param.score);
			
			if(Param.ChessCount==0){
			new RecordJDialog(mainFrame);
			
			Param.gameStatus=3;
			mainFrame.restart();
				repaint();
			}
			
			}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	private void drawLinkedLine(List<Point> list) {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		g2d.setColor(Color.orange);
		g2d.setStroke(stroke);
		if (list.size() == 2) {
			Point a = list.get(0);
			Point b = list.get(1);
			int ax = a.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int ay = a.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			int bx = b.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int by = b.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			g2d.drawLine(ax, ay, bx, by);

		}

		if (list.size() == 3) {
			Point a = list.get(0);
			Point c = list.get(1);
			Point b = list.get(2);

			int ax = a.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int ay = a.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;

			int cx = c.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int cy = c.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			int bx = b.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int by = b.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			g2d.drawLine(ax, ay, cx, cy);
			g2d.drawLine(cx, cy, bx, by);
		}

		if (list.size() == 4) {
			Point a = list.get(0);
			Point c = list.get(1);
			Point d = list.get(2);
			Point b = list.get(3);
			int ax = a.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int ay = a.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;

			int cx = c.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int cy = c.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			int dx = d.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int dy = d.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			int bx = b.y * Param.chessWidth + Param.marginWidth
					+ Param.chessWidth / 2;
			int by = b.x * Param.chessHeight + Param.marginHeight
					+ Param.chessHeight / 2;
			g2d.drawLine(ax, ay, cx, cy);
			g2d.drawLine(cx, cy, dx, dy);
			g2d.drawLine(dx, dy, bx, by);
		}

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void drawMyRect(Point p, Color c) {
		Graphics g = getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setStroke(stroke);
		g2d.setColor(c);
		int rowX = p.y * Param.chessWidth + Param.marginWidth;
		int rowY = p.x * Param.chessHeight + Param.marginHeight;
		g2d.drawRect(rowX + 2, rowY + 2, Param.chessWidth - 4,
				Param.chessHeight - 4);
	}

}