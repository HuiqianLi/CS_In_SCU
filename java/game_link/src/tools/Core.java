package tools;

import java.util.List;
import java.util.Random;
import java.awt.Point;
import java.util.ArrayList;

import Linkup.Chess;
/**
 * �����������㷨��  ʵ����ͨ
 * @author lhq
 *
 */
public class Core {
	//���� ��̬����
	private static List<Point> list = new ArrayList<Point>();

	/**
	 * ��ͨ�����жϷ���
	 * @param arr
	 * @param a
	 * @param b
	 * @return ��ͨ��ļ���;null��ʾ�޷���ͨ
	 */
	public static List<Point> checkLinked(Chess[][] arr, Point a, Point b) {
		if(arr[a.x][a.y].getStatus()!=arr[b.x][b.y].getStatus()){
			return null;
		}
		
		list.clear();
		if (noCorner(arr, a, b) != null) {
			return list;
		}
		if (oneCorner(arr, a, b) != null) {
			return list;
		}

		if (twoCorner(arr, a, b) != null) {
			return list;
		}
		return null;
	}

	/**
	 * ֱ����ͨ�㷨
	 * @param arr
	 * @param a
	 * @param b
	 * @return ��ͨ��ļ��ϣ�null��������ͨ
	 */
	public static List<Point> noCorner(Chess[][] arr, Point a, Point b) {
		if (canArrived(arr, a, b)) {
			list.add(a);
			list.add(b);
			return list;
		}
		return null;
	}

	/**
	 * һ�ս���ͨ�㷨
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 * @return ��ͨ��ļ��ϣ�null��������ͨ
	 */
	public static List<Point> oneCorner(Chess[][] arr, Point a, Point b) {
		Point c = new Point(a.x, b.y);

		if (arr[c.x][c.y].getStatus() == 0 && canArrived(arr, a, c)
				&& canArrived(arr, c, b)) {
			list.add(a);
			list.add(c);
			list.add(b);
			return list;
		}

		Point d = new Point(b.x, a.y);
		if (arr[d.x][d.y].getStatus() == 0 && canArrived(arr, a, d)
				&& canArrived(arr, d, b)) {
			list.add(a);
			list.add(d);
			list.add(b);
			return list;
		}
		return null;
	}

	/**
	 * ���ս���ͨ�㷨
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 * @return ��ͨ��ļ��ϣ�null��������ͨ
	 */
	public static List<Point> twoCorner(Chess[][] arr, Point a, Point b) {
		for (int i = 0; i < arr[0].length; i++) {
			Point c = new Point(a.x, i);

			if (arr[c.x][c.y].getStatus() == 0 && canArrived(arr, a, c)
					&& oneCorner(arr, c, b) != null) {
				list.add(0, a);
				return list;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			Point c = new Point(i, a.y);
			if (arr[c.x][c.y].getStatus() == 0 && canArrived(arr, a, c)
					&& oneCorner(arr, c, b) != null) {

				list.add(0, a);
				return list;
			}
		}
		return null;
	}

	/**
	 * �ж�ֱ���Ƿ������ͨ
	 * 
	 * @param arr
	 * @param a
	 * @param b
	 * @return true��ʾ������ͨ��false��ʾ��������ͨ
	 */
	public static boolean canArrived(Chess[][] arr, Point a, Point b) {
		// ���� a.x == b.x
		if (a.x == b.x) {
			
			
			for (int i = Math.min(a.y, b.y) + 1; i < Math.max(a.y, b.y); i++) {
				if (arr[a.x][i].getStatus() != 0) {
					return false;
				}
			}
			// ������ͨ
			return true;
		}

		// ����: a.y == b.y
		if (a.y == b.y) {
			for (int i = Math.min(a.x, b.x) + 1; i < Math.max(a.x, b.x); i++) {
				if (arr[i][a.y].getStatus() != 0) {
					return false;
				}
			}
			// ������ͨ
			return true;
		}

		return false;
	}
	
	public static void refreshArr(Chess[][] arr){
		
		List<Chess> list = new ArrayList<Chess>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j].getStatus()!=0){
					list.add(arr[i][j]);
				}
			}
		}
		
		
		Random random=new Random();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j].getStatus()!=0){
					int index = random.nextInt(list.size());
					arr[i][j] = list.get(index);
					list.remove(index);
				}
			}
		}
	}
	
	/**
	 * ��ʾ �㷨ʵ�֣�Ѱ�ҿ�����ͨ�������� 
	 * @param arr
	 * @return
	 */
	public static List<Point> remarkArr(Chess[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if(arr[i][j].getStatus()==0){
					continue;
				}
				for (int x = 0; x < arr.length; x++) {
					for (int y = 0; y < arr.length; y++) {
						if(arr[x][y].getStatus()==0){
							continue;
						}
						if(i==x&&j==y){
							continue;
						}
						Point a=new Point(i,j);
						Point b=new Point(x,y);
						if(checkLinked(arr, a, b)!=null){
							List<Point> list =new ArrayList<Point>();
							list.add(a);
							list.add(b);
							return list;
						}
					}
				}
			}
		}
		return null;
	}

}