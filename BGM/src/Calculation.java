//import java.util.*;

/*
 * Purpose: Produce the best routine( and score) given user response 
 * 
 * Method: 
 * Calculate optimal (a_user_response)
 * 		Make a list of all possible routies (new)  [GETS SENT TO CLASS ROUTINE]
 * 		Have them score themselves and remeber the best so far [ SEND TO SCORE ITSELF]
 * 				net_efficacy = a_routine.score_myself (a user respopnse)
 * 
 *	Return the one with the best score
 */
public class Calculation {
	public Routine[] possibleRoutines(IngredientList a_ingredientList){ 
		int	numIngredients = a_ingredientList.ingredients.length;
		int numRoutines = (int) Math.pow(2,numIngredients);

		Routine Routine_list[] = new Routine [numRoutines];
		

		for (int routineNum = 0; routineNum <numRoutines; routineNum++) {
			boolean[] Routine_ingredients_list = new boolean[numIngredients];
			for(int ing = 0; ing < numIngredients; ing++) {
				
				Routine_ingredients_list[ing]=(routineNum& (1<<ing) )>0;
				//System.out.println(routineNum + " --- " + ing + "---"+Routine_ingredients_list[ing]);
			}
			Routine_list[routineNum] = new Routine(Routine_ingredients_list);
			//System.out.println( routineNum +" ---" + Arrays.toString(Routine_list[routineNum].ingredients) );
		}
		//System.out.println( "35" +" ---" + Arrays.toString(Routine_list[35].ingredients) );
		return Routine_list;
	}

	public Routine calculateOptimal(UserResponse a_userResponse ,IngredientList a_ingredientList) {

		Routine[] routineList =  this.possibleRoutines(a_ingredientList);
		int bestRoutineNum = 0; 
		float bestRoutineScore = 0;
		float temp;

		for(int i = 0; i < routineList.length; i++) {
			//System.out.println( i +" ====" + Arrays.toString(routineList[i].ingredients) );
			temp =	routineList[i].scoreMyself(a_userResponse, a_ingredientList);
			if (temp > bestRoutineScore) {
				bestRoutineNum = i; 
				bestRoutineScore = temp;
			}
			//System.out.println(i + "--" + temp);
		}

			return routineList[bestRoutineNum];
	}



}