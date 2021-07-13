/*
 * each ingredient and efficacy of each ingredient on the skin concerns
 */
public class IngredientList {
	public String[] ingredients;
	public String[] concerns;
	public int[][] ingredientEfficacy;
	public float[] time;
	public int[] steps;
	public float[] cost;

	public IngredientList(){
		this.concerns =  new String[] {"Acne","dark spots / uneven tone","Aging skin","Dryness / eczema","rough / textured skin"};
		this.ingredients =  new String[] {"Vitamin C", "Retinols", "SPF", "alpha hydroxy acid", "Hyaluronic Acid", "Benxoyl Peroxide", "Ceramides"};

		this.ingredientEfficacy = new int[this.concerns.length] [this.ingredients.length];

		this.ingredientEfficacy[0][0] = 4; 
		this.ingredientEfficacy[1][0] = 6; 
		this.ingredientEfficacy[2][0] = 4; 
		this.ingredientEfficacy[3][0] = 0; 
		this.ingredientEfficacy[4][0] = 2; 


		this.ingredientEfficacy[0][1] = 7;
		this.ingredientEfficacy[1][1] = 8; 
		this.ingredientEfficacy[2][1] = 10; 
		this.ingredientEfficacy[3][1] = -6; 
		this.ingredientEfficacy[4][1] = 7; 

		this.ingredientEfficacy[0][2] = 8; 
		this.ingredientEfficacy[1][2] = 8; 
		this.ingredientEfficacy[2][2] = 8; 
		this.ingredientEfficacy[3][2] = 0; 
		this.ingredientEfficacy[4][2] = 8;  

		this.ingredientEfficacy[0][3] = 8; 
		this.ingredientEfficacy[1][3] = 7; 
		this.ingredientEfficacy[2][3] = 0; 
		this.ingredientEfficacy[3][3] = 2; 
		this.ingredientEfficacy[4][3] = 8; 


		this.ingredientEfficacy[0][4] = 0; 
		this.ingredientEfficacy[1][4] = 0; 
		this.ingredientEfficacy[2][4] = 2; 
		this.ingredientEfficacy[3][4] = 10; 
		this.ingredientEfficacy[4][4] = 2; 
 

		this.ingredientEfficacy[0][5] = 10; 
		this.ingredientEfficacy[1][5] = 0; 
		this.ingredientEfficacy[2][5] = 0; 
		this.ingredientEfficacy[3][5] = -4; 
		this.ingredientEfficacy[4][5] = 2; 
	
		this.ingredientEfficacy[0][6] = -2; 
		this.ingredientEfficacy[1][6] = 0; 
		this.ingredientEfficacy[2][6] = 6; 
		this.ingredientEfficacy[3][6] = 10; 
		this.ingredientEfficacy[4][6] = 4; 
	
		
		
		this.cost = new float[this.ingredients.length];
		this.cost[0] = 40; 
		this.cost[1] = 40; 
		this.cost[2] = 25; 
		this.cost[3] = 30; 
		this.cost[4] = 20; 
		this.cost[5] = 15; 
		this.cost[6] = 25;

		this.time = new float[this.ingredients.length];
		this.time[0] = 2; 
		this.time[1] = 1; 
		this.time[2] = 5; 
		this.time[3] = 2; 
		this.time[4] = 1; 
		this.time[5] = 1; 
		this.time[6] = 1; 

		this.steps = new int [this.ingredients.length];
		this.steps[0] = 1; 
		this.steps[1] = 1; 
		this.steps[2] = 1; 
		this.steps[3] = 1; 
		this.steps[4] = 1; 
		this.steps[5] = 1; 
		this.steps[6] = 1; 


	}




}

