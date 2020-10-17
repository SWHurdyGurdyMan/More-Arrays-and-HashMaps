import java.util.*;
import acm.program.*;

public class NameCounts {
	public static void main(String[] args) {
		HashMap<String, Integer> names = new HashMap<String, Integer>();
		readNames(names);
		printNames(names);
	}
	
	private static void readNames(HashMap<String, Integer> names) {
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.println(("Enter name : "));
			String name = input.nextLine();
			if (name.equals("")) break;
			Integer occurences = names.get(name);
			if(occurences == null) {
				occurences = new Integer(1);			
			}else {
				occurences = new Integer(occurences + 1);
			}
			
			names.put(name, occurences);
		}
	}
	private static void printNames(HashMap<String, Integer> names) {
		Iterator<String> it = names.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			int count = names.get(key);
			System.out.println("Entry [" + key + "] occurs " + count);
		}
	}
}