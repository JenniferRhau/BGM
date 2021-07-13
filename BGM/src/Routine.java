//import java.util.*;

public class Routine {
	boolean[] ingredients;
	float[] efficacies;
	float netEfficacy;
	float totalCost;
	float totalTime;
	int totalSteps;
	// int noConstraints;



	public Routine(	boolean[] ingredients){
		this.ingredients = ingredients;
		//System.out.println( Arrays.toString(this.ingredients) );
		this.netEfficacy = 0; 
		this.totalCost = 0; 
		//this.efficacies = new float[this.ingredients.length];
		this.efficacies = new float[7];
		for (int s = 0; s < this.efficacies.length; s++) {
			this.efficacies[s] = 0; 
		}

	}

	public float scoreMyself(UserResponse a_userResponse, IngredientList a_ingredientList) {
		//System.out.println( Arrays.toString(this.ingredients) );
		/*
		 * Calculate efficacy
		 */
		for(int i=0; i < this.ingredients.length;i++) {//ingredients
			if (this.ingredients[i] == true) {
				for(int j=0; j < a_userResponse.scores.length;j++) {//skin
					this.efficacies[j] += (float) Math.pow(a_ingredientList.ingredientEfficacy[j][i],3); // add efficacy of skin routine at skin concern
					//this.efficacies[j] += Math.pow(a_ingredientList.ingredientEfficacy[i][j],2);
				}
				this.totalCost = this.totalCost + a_ingredientList.cost[i];
				this.totalTime = this.totalTime + a_ingredientList.time[i];
				this.totalSteps = this.totalSteps + a_ingredientList.steps[i];
			}

		} 
		int sumOfScores = 0;
		for(int j=0; j < a_userResponse.scores.length;j++) {
		this.efficacies[j] = (float) Math.pow(this.efficacies[j],0.3333); //cubed root
			//this.efficacies[j] = (float) Math.pow(this.efficacies[j],0.5);
			this.netEfficacy = this.netEfficacy + (this.efficacies[j]* a_userResponse.scores[j]);
			sumOfScores = sumOfScores + a_userResponse.scores[j];
			//noConstraints = this.efficacies[j];
		}
		this.netEfficacy = this.netEfficacy / sumOfScores;
		
		if (this.totalTime> a_userResponse.constraints[1]) { 
			this.netEfficacy = 0;
		}
		if (this.totalSteps> a_userResponse.constraints[2]) { 
			this.netEfficacy = 0;
		}
		/*
		 * Each ingredient is being budgeted as 1 product
		 * IF total cost is greater than the users budget multiplied by the total steps (# of products)
		 * then efficacy = 0
		 */
		if (this.totalCost > (a_userResponse.constraints[0] * this.totalSteps) ) { 
			this.netEfficacy = 0;
		}

		return this.netEfficacy;
	}
}


