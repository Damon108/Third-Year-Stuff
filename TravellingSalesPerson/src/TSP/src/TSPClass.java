
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TSPClass {
	private String[][] weights;
	private String[][] csvWeights;
	private Random rnd;
	private ArrayList<ArrayList<float[]>> HolderOfSolutions = new ArrayList<ArrayList<float[]>>(); // private
																									// ArrayList<String>
																									// route = new
																									// ArrayList<>();
	static ArrayList<float[]> cities = new ArrayList<float[]>();
	int pop = cities.size();
	private float[] newRoute = new float[pop];
	private static float[] tempCities = new float[cities.size()];

	public TSPClass() {
		weights = new String[12][3];

		weights[0][0] = "A";
		weights[0][1] = "B";
		weights[0][2] = "20";

		weights[1][0] = "A";
		weights[1][1] = "C";
		weights[1][2] = "42";

		weights[2][0] = "A";
		weights[2][1] = "D";
		weights[2][2] = "35";
		///////////////////////////////////////////////////
		weights[3][0] = "B";
		weights[3][1] = "A";
		weights[3][2] = "20";

		weights[4][0] = "B";
		weights[4][1] = "C";
		weights[4][2] = "30";

		weights[5][0] = "B";
		weights[5][1] = "D";
		weights[5][2] = "34";
		////////////////////////////////////////////////////
		weights[6][0] = "C";
		weights[6][1] = "A";
		weights[6][2] = "42";

		weights[7][0] = "C";
		weights[7][1] = "B";
		weights[7][2] = "30";

		weights[8][0] = "C";
		weights[8][1] = "D";
		weights[8][2] = "12";
		/////////////////////////////////////////////////////
		weights[9][0] = "D";
		weights[9][1] = "A";
		weights[9][2] = "35";

		weights[10][0] = "D";
		weights[10][1] = "B";
		weights[10][2] = "34";

		weights[11][0] = "D";
		weights[11][1] = "C";
		weights[11][2] = "12";

		// route.add("ABCD");
	}

	public static void main(String[] args) {
		
		TSPClass tsp = new TSPClass();
		
		//reading file
		tsp.readFile();
		tempCities = new float[cities.size()];
		//random search
		tsp.randomSearch(cities);
		
		//Generating a single random route
		//tsp.generateRandomRoute(cities);
		
		/*tsp.getCostOfRoute2(cities);
		for (float[] element : cities) {
			int j = 0;
			tempCities[j] = element[0];
			System.out.print(tempCities[j] + " ");
			j++;

		}*/
	}

	/*
	 * public int getCostOfRoute(String path) { // String[] cit1 = new String[12];
	 * String[] city = path.split("(?!^)"); String sCost = ""; int cost = 0;
	 * System.out.print(city[0]); System.out.print(city[1]);
	 * System.out.print(city[2]); System.out.println(city[3]);
	 * 
	 * for (int c = 0; c < city.length; c++) {
	 * 
	 * for (int i = 0; i < weights.length; i++) {
	 * 
	 * for (int j = 0; j < weights[i].length; j++) {
	 * System.out.println("NUMBER C : " + c);
	 * 
	 * if (c == 3) { System.out.println("path : " + city[0] + city[1] + city[2] +
	 * city[3]); System.out.print("current city : " + city[c]); //
	 * System.out.print(); System.out.print(" index : " + i + " ");
	 * System.out.println(weights[i][0]); for (int counter = 0; counter <
	 * weights.length; counter++) { if (city[c].equals(weights[counter][0])) {
	 * System.out.println("current city : " + city[c]);
	 * System.out.println("first city : " + city[0]);
	 * System.out.println("NUMBER C : " + c); System.out.println("Current City : " +
	 * city[c]); System.out.println("counter : " + weights[counter][0]);
	 * System.out.println("BALLOOGA WAHEL"); System.out.println("path : " + city[0]
	 * + city[1] + city[2] + city[3]);
	 * 
	 * if (city[0].equals(weights[counter][1])) {
	 * System.out.println("current city : " + city[c]);
	 * System.out.println("first city : " + city[0]);
	 * 
	 * System.out.println(sCost); System.out.println(i);
	 * 
	 * sCost = weights[counter][2]; System.out.println(i);
	 * 
	 * System.out.println(sCost);
	 * 
	 * cost += Integer.parseInt(sCost);
	 * 
	 * } /* else if (city[0].equals(weights[counter][1])) {
	 * System.out.println("current city : " + city[c]);
	 * System.out.println("first city : " + city[0]);
	 * 
	 * System.out.println(sCost); System.out.println(i);
	 * 
	 * sCost = weights[i + 1][2]; System.out.println(i);
	 * 
	 * System.out.println(sCost);
	 * 
	 * cost += Integer.parseInt(sCost);
	 * 
	 * } else if (city[0].equals(weights[counter][1])) {
	 * System.out.println("current city : " + city[c]);
	 * System.out.println("first city : " + city[0]);
	 * 
	 * System.out.println(sCost); System.out.println(i);
	 * 
	 * sCost = weights[i + 2][2]; System.out.println(i);
	 * 
	 * System.out.println(sCost);
	 * 
	 * cost += Integer.parseInt(sCost); }
	 * 
	 * } }
	 * 
	 * System.out.println("final cost :" + cost); return cost; }
	 * System.out.println(i); if (city[c].equals(weights[i][0])) {
	 * 
	 * System.out.println("current city : " + city[c]); System.out.println("cost:" +
	 * sCost); System.out.println("index C :" + c);
	 * 
	 * 
	 * if (c == 3) { System.out.println("final total: " + sCost); }
	 * 
	 * if (city[c + 1].equals(weights[i][j]) && c + 1 <= city.length) {
	 * 
	 * System.out.println("current City : " + city[c]);
	 * System.out.println("city to go to :" + weights[i][j]);
	 * System.out.println("cost from and to " + weights[i][2]); sCost =
	 * weights[i][2]; cost += Integer.parseInt(sCost); } }
	 * 
	 * } }
	 * 
	 * }
	 * 
	 * System.out.println(cost); return cost;
	 * 
	 * }
	 */

	/*
	 * public String generateRandomRoutes() { String Sroute = ""; Random rnd = new
	 * Random(); int index = rnd.nextInt(16);
	 * 
	 * System.out.println(rnd);
	 * 
	 * int size = cities.size();
	 * 
	 * int counter = 0; float[] rroute = new float[cities.size()];
	 * 
	 * for (float[] route : cities) { // Initialise array to arraylist Size float[]
	 * troute = new float[size]; // Store all 16 cities in temp Array
	 * troute[counter] = route[0];
	 * 
	 * System.out.println("Cities inside troute : " + troute[counter]); Sroute +=
	 * String.valueOf(route[0]);
	 * 
	 * counter++; }
	 * 
	 * String route = "";
	 * 
	 * boolean AChosen = false; boolean BChosen = false; boolean CChosen = false;
	 * boolean DChosen = false; // Random rnd = new Random();
	 * 
	 * for (int i = 0; i < 100; i++) { int num = rnd.nextInt(4);
	 * 
	 * if (num == 0 && AChosen == false) { AChosen = true; route += "A"; } else { if
	 * (num == 1 && BChosen == false) { BChosen = true; route += "B"; } else { if
	 * (num == 2 && CChosen == false) { CChosen = true; route += "C"; } else { if
	 * (num == 3 && DChosen == false) { DChosen = true; route += "D"; } } } } }
	 * System.out.println(AChosen);
	 * 
	 * System.out.println(BChosen);
	 * 
	 * System.out.println(CChosen);
	 * 
	 * System.out.println(DChosen); System.out.println("Random Route : " + route);
	 * return route; }
	 */

	public void readFile() {
		// String path = "";
		// int counter = 0;

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("ulysses16.csv"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				try {

					String[] words = line.split(",");
					float[] index0 = { Float.parseFloat(words[0]), Float.parseFloat(words[1]),
							Float.parseFloat(words[2]) };

					cities.add(index0);

					System.out.println("index 0 : " + index0[0] + "   " + "index 1 : " + index0[1] + "  " + "index 2 : "
							+ index0[2]);
				} catch (NumberFormatException e) {
					continue;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public float getCostOfRoute2(ArrayList<float[]> cities) {

		// Collections.shuffle(cities);

		// Xb-Xa^2 + yb-ya^2
		float cost = 0;
		// Loop thhrough cities arraylist
		// get index and the x and y values
		// get index2 and x values
		float Xb = 0;
		float Xa = 0;

		float Yb = 0;
		float Ya = 0;

		float xDifference = 0;
		float yDifference = 0;

		int index = 0;

		for (float[] element : cities) {
			if (index == cities.size() - 1) {
				System.out.println("poo");

				return cost;
			}
			float[] tElement = cities.get(index + 1);
			//System.out.println("city size is : " + cities.size());

			System.out.println("city 1: " + element[0]);
			System.out.print(" " + " X :" + element[1]);
			System.out.println(" " + " Y :" + element[2]);

			
			Xa = element[1];
			Ya = element[2];

			Xb = tElement[1];
			Yb = tElement[2];
			
			System.out.println("city 2" + tElement[0]);
			System.out.println("Xb " + Xb);
			
			System.out.println("Yb " +Yb);

			System.out.println("Temp elements city : " + tElement[0]);

			System.out.println("Temp elements x : " + tElement[1]);

			System.out.println("Temp elements y : " + tElement[2]);

			xDifference = Xa - Xb;
			yDifference = Ya - Yb;

			cost += Math.sqrt((xDifference * xDifference) + (yDifference * yDifference));
			System.out.println("index : " + index);

			System.out.println(cost);
			index++;

		}

		System.out.println("Xa:  " + Xa + "	Xb :" + Xb);

		return cost;
	}

	private double randomSearch(ArrayList<float[]> cities) {
		generateRandomRoute(cities);
		double solution = getCostOfRoute2(cities);
		ArrayList<float[]> tempRoute = new ArrayList<float[]>();
		ArrayList<float[]> newRoute = new ArrayList<float[]>();
		tempCities = new float[cities.size()];

		// float[] Troute = new float[tempRoute.size()];

		for (int i = 0; i < 100000; i++) {
			newRoute = generateRandomRoute(cities);

			if (solution > getCostOfRoute2(cities)) {
				tempRoute = newRoute;
				solution = getCostOfRoute2(tempRoute);

				// System.out.println(cities.get(i));
			}
			for (float[] element : tempRoute) {
				int j = 0;
				tempCities[j] = element[0];
				System.out.print(tempCities[j] + " ");
				j++;

			}
		}
		System.out.println("Best solution is " + solution);
		return solution;
	}
	
	

	private ArrayList<float[]> generateRandomRoute(ArrayList<float[]> cities) {
	
		Collections.shuffle(cities);
		
		return cities;
	}

	private ArrayList<ArrayList<float[]>> generate2Opt(ArrayList<float[]> cities) {
		// ArrayList<float[]> OptSwapped = new ArrayList<float[]>();

		int first = rnd.nextInt();
		int second = rnd.nextInt();

		cities.set(first, cities.get(second));
		cities.set(second, cities.get(first));
		HolderOfSolutions.add(cities);

		return HolderOfSolutions;
	}

	private ArrayList<float[]> BestNeighbourFunction(ArrayList<ArrayList<float[]>> neighbours) {
		 neighbours = HolderOfSolutions;
		float bestVal = getCostOfRoute2(neighbours.get(0));

		int counter = 0;

		for (ArrayList<float[]> routes : neighbours) {
			if (getCostOfRoute2(routes) < bestVal) {
				bestVal = getCostOfRoute2(neighbours.get(counter));
			}
			counter++;
		}
		System.out.println(bestVal);
		return neighbours.get(counter);

	}

	private void localSearch() {
		ArrayList<float[]> newRoute = new ArrayList<float[]>();
		newRoute = generateRandomRoute(cities);
		for (int termination = 0; termination < 100; termination++) {
			for (int i = 0; i < 5; i++) {
				generate2Opt(newRoute);


			}
			newRoute = BestNeighbourFunction(HolderOfSolutions);
			generate2Opt(newRoute);
		}
	}
}