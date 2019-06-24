package tools;

import java.util.TreeSet;

import Linkup.LinkupMenuBar;



public class Student implements Comparable<Student>{
	// ���ʵ���Լ��������� �������:ʵ��Comparable�ӿ�
	public static int scores=Param.score;
	public static String name=Param.name;

	public Student(int id, String name) {
		super();
		this.scores = scores;
		this.name = name;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int score) {
		this.scores = scores;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return scores+"\t"+name;
	}

	@Override
	public int compareTo(Student o) {
		//compareTo()����ö���С�ڡ����ڻ����ָ��������ֱ𷵻ظ������������������
		//����ѧ�ŵ������������....
//		System.out.println("compareTo()......this="+this+" pk  o="+o);
		if(this.scores==o.scores){
			return 1;//��֤�ظ�����Ҳ�ܳɹ�����ӵ�������
		}
		return this.scores-o.scores;
	}
	
	
	public static void main(String[] args) {
		
		TreeSet<Student> treeSet = new TreeSet<Student>();
		for (int i = 1; i <=3; i++) {
			Student student = new Student(i, Param.name+i);
			treeSet.add(student);
		}
		System.out.println(treeSet);
		Student student4 = new Student(1, "ѧ��4");
		treeSet.add(student4);
		System.out.println(treeSet);
		
		
		
	}

}