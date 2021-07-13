import java.util.*;
public class SkinMain {
	//NOTE -- Add a cancel button!!
	static Scanner sc = new Scanner(System.in);
	//static boolean[] testRoutine = {true, true, true, true, true, true};
	public static void main(String[] args) {
		//UserResponse a_userResponse = new UserResponse(ratingArray, constraint);
		IngredientList a_ingredientList = new IngredientList();
		
	//System.out.print("Here are your list of possible skin concerns:\n\tAcne-1\t\t\tHyperpigmentation-2\n\tAnti-Aging-3\tDryness-4\n\tFine Lines/Winkles-5 \tDullness-6");
		
		int[] ratingArray = new int[a_ingredientList.concerns.length]; // create array for the ratings
//		int[] set = new int[5]; 
		for (int i=0;i<a_ingredientList.concerns.length;i++) { // for loop asking the user to rate each skin concern
			System.out.println("\nHow concerned are you with "  + a_ingredientList.concerns[i] + " (0 = Not a concern - 5 = High Concern) : \n\t");
			ratingArray[i] = sc.nextInt();
			//int ratingInput = ratingArray[i];
		}
		System.out.println("How much time are you willing to spend on your routine daily (in minutes)? : \n\t");
		int timeInput = sc.nextInt();
		
		System.out.println("What is the max you are willing to pay for a product? (round to the nearest dollar): \n\t");
		int budgetInput = sc.nextInt();
		
		/*
		 * CHANGE FOR STEPS
		 */
		System.out.println("What is the max number of steps you would like in your routine (1 - 5)? : \n\t");
		int stepsInput = sc.nextInt();
		
		
		
		int[] constraint = new int[3];
		constraint[0] = budgetInput;
		constraint[1] = timeInput;
		constraint[2] = stepsInput;
		
		//int[] constraint = {10,9,3};
	//	int[] ratingArray = {3,5,3,1,2,1};
		
		
	UserResponse a_userResponse = new UserResponse(ratingArray, constraint);
//		IngredientList a_ingredientList = new IngredientList();
		
		//Routine a_routine = new Routine(testRoutine);
		Calculation compute = new Calculation();
		Routine optimalRoutine = compute.calculateOptimal(a_userResponse, a_ingredientList);
		
		
		
		//System.out.println("Here are your list of possible skin concerns:\n\tAcne-1\t\t\tHyperpigmentation-2\n\tAnti-Aging-3\tDryness-4\n\tFine Lines/Winkles-5 \tDullness-6");
		//System.out.println( "\nThe net efficacy is: " + optimalRoutine.netEfficacy);
		//System.out.println( "The ingredient(s)  is: " +  Arrays.toString(optimalRoutine.ingredients) );
		
		System.out.println("The ingredients you should incorporate into your routine are: ");
		for(int j = 0; j<optimalRoutine.ingredients.length; j++) {
			if (optimalRoutine.ingredients[j] == true) {
				System.out.println("\n\t-" + a_ingredientList.ingredients[j]);
			}
		}
		//System.out.println( "The efficacy of routine is: " + Arrays.toString(optimalRoutine.efficacies) );
		//System.out.println( "totalcost is:  " +   optimalRoutine.totalCost);
		System.out.println( "This routine will only take about " + (int)optimalRoutine.totalTime + " minutes.");
		//System.out.println( "totalsteps is:  " + optimalRoutine.totalSteps);
		//System.out.println( "totalsteps is:  " + optimalRoutine.noConstraints);
	}
	}

