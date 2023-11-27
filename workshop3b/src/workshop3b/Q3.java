package workshop3b;

public class Q3 {
	public static void main(String[] args) {
		  Pair<String> fruits = 
		      new Pair<String>("apple", "orange");
		  System.out.println(fruits.getElement1() + " " +
		            fruits.getElement2());
		  System.out.println(fruits);

		  Pair<Integer> acamiableNumbers = 
		         new Pair<Integer>(220, 280);
		  System.out.println(acamiableNumbers.getElement1() + " " +
		        acamiableNumbers.getElement2());
		  System.out.println(acamiableNumbers);
		}
}
