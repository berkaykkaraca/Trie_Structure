import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inputs = sc.nextInt();
		TrieST t = new TrieST<>();
		for(int i = 0;i<inputs;i++) {
			String s = sc.next();
			t.put(s, i);
			
		}
		
		while(true) {
			
			System.out.println("Enter Operation Code:");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				String key = sc.next();
				t.Search(key);
				break;
			case 2:
				
				t.countPrefix();
				break;
			case 3:
				String s = sc.next();
				t.reverseFind(s);
				break;
			case 4:
				t.ShortestUniquePrefix(t);
				break;
			case 5:
				t.LongestCommonPrefix();
				break;
			case 6:
				System.exit(0);
			}
		}
	}

}
