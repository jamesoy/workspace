package my.test;

public class Tower {

	public static void main(String[] args) {
		Tower.move(3, 'A', 'C', 'B');
	}
	
	public static void move(int n, char from, char to, char via) {
		if (n == 0) return;
		move(n - 1, from, via, to);
		System.out.println("Move " + n + " from " + from + " to " + to);
		move(n - 1, via, to, from);
	}

}
