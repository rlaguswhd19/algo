import java.util.PriorityQueue;
import java.util.TreeSet;

public class Test {
	static PriorityQueue<String> q;	
	static TreeSet<String> set;
	public static void main(String[] args) {
		q = new PriorityQueue<String>();
		set = new TreeSet<String>();
		q.add("d");
		q.add("a");
		set.add("D");
		set.add("A");
		System.out.println(set.first());
		System.out.println(q);
	}
}
