package tools;

import java.util.TreeSet;

import Linkup.LinkupMenuBar;



public class Student implements Comparable<Student>{
	// 如何实现自己定义的类的 排序规则:实现Comparable接口
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
		//compareTo()如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
		//按照学号的升序进行排列....
//		System.out.println("compareTo()......this="+this+" pk  o="+o);
		if(this.scores==o.scores){
			return 1;//保证重复数据也能成功被添加到集合中
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
		Student student4 = new Student(1, "学生4");
		treeSet.add(student4);
		System.out.println(treeSet);
		
		
		
	}

}