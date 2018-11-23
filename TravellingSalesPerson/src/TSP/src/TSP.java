
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TSP {

	private String[][] weights;
	private String[][] csvWeights;
	private Random rnd;
	private ArrayList<ArrayList<float[]>> HolderOfSolutions = new ArrayList<ArrayList<float[]>>();

	private ArrayList<float[]> cities2 = new ArrayList<float[]>();
	private ArrayList<float[]> cities = new ArrayList<float[]>();
	private ArrayList<float[]> randomRoute = new ArrayList<float[]>();

	// private float[] newRoute = new float[pop];
	private float[] tempCities;
	private float[] tempCities1;

	public TSP() {
		// TSP tsp = new TSP();
		// readFile();
		weights = new String[12][3];
		rnd = new Random();
		ArrayList<float[]> cities = new ArrayList<float[]>();
		int pop = cities.size();
		// ArrayList<float[]> cities2 = new ArrayList<float[]>();
		float[] tempCities = new float[cities.size()];
		float[] tempCities1 = new float[cities.size()];
		ArrayList<ArrayList<float[]>> HolderOfSolutions = new ArrayList<ArrayList<float[]>>();
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

	public void run() {
	//for(int  i =  0 ; i<5; i++) {	
	//readFile();
		randomSearch();
//	cities = cities2;
	//cities2 = cities;
//randomRoute = generateRandomRoute(cities);
	//HolderOfSolutions = TwoOptSwap(randomRoute);
		//BestNeighbour(HolderOfSolutions);
	// generateRandomRoute(cities);
		//localSearch();
		//twoOptSwap(route, i, j)
		//ArrayList<float[]> r = new ArrayList<float[]>();
		//r = generateRandomRoute(cities);
		//makingNeighborhood(r);
		
		//for(ArrayList<float[]> routes : HolderOfSolutions) {
		//	System.out.println("cost of each route " + getCostOfRoute2(routes));
		//}
	}
	// }
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

	public ArrayList<float[]> readFile() {
		// String path = "";
		// int counter = 0;
		cities = new ArrayList<float[]>();
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
					cities2.add(index0);
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
		return cities;

	}

	public float getCostOfRoute2(ArrayList<float[]> cities) {
		float[] tElement = new float[cities.size()];
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
			System.out.println("cities size is " + cities.size());
			if (index == cities.size() - 1) {
				System.out.println("poo");
				tElement = cities.get(index);
				element = cities.get(0);

				Xa = element[1];
				Ya = element[2];

				System.out.println("Xa + " + Xa);
				System.out.println("Ya + " + Ya);

				Xb = tElement[1];
				Yb = tElement[2];

				System.out.println("Xb + " + Xb);
				System.out.println("Yb + " + Yb);

				xDifference = Xa - Xb;
				yDifference = Ya - Yb;

				cost += Math.sqrt((xDifference * xDifference) + (yDifference * yDifference));
				return cost;
			}
			tElement = cities.get(index + 1);
			// System.out.println("city size is : " + cities.size());

			System.out.println("city 1: " + element[0]);
			System.out.print(" " + " X :" + element[1]);
			System.out.println(" " + " Y :" + element[2]);

			Xa = element[1];
			Ya = element[2];

			Xb = tElement[1];
			Yb = tElement[2];

			System.out.println("city 2" + tElement[0]);
			System.out.println("Xb " + Xb);

			System.out.println("Yb " + Yb);

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

	private double randomSearch() {
		cities = generateRandomRoute(cities);
		double solution = getCostOfRoute2(cities);
		ArrayList<float[]> tempRoute = new ArrayList<float[]>();
		ArrayList<float[]> newRoute = new ArrayList<float[]>();
		tempCities = new float[cities.size()];

		// float[] Troute = new float[tempRoute.size()];

		for (int i = 0; i < 100; i++) {
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

	private ArrayList<float[]> generateRandomRoute(ArrayList<float[]> route) {
		// randomRoute = new ArrayList<float[]>();
		route = readFile();
		Collections.shuffle(route);

		// randomRoute = route;
		for (float[] e : route) {
			System.out.println(e[0]);
		}

		return route;
	}

	private ArrayList<ArrayList<float[]>> generate2Opt(ArrayList<float[]> cities) {
		// ArrayList<ArrayList<float[]>> OptSwapped = new
		// ArrayList<ArrayList<float[]>>();

		int first = 0;
		int second = 0;
		int maxVal = cities.size();
		for (int i = 0; i < 5; i++) {
			first = rnd.nextInt(maxVal);
			second = rnd.nextInt(maxVal);
			System.out.println("first is " + first);
			System.out.println("second is " + second);
			if (first == second) {
				do {
					first = rnd.nextInt(maxVal);
					second = rnd.nextInt(maxVal);
					System.out.println("first is " + first);
					System.out.println("second is " + second);
				} while (first != second);
				// }
				// first = rnd.nextInt(cities.size());
				// second = rnd.nextInt(cities.size());
			}
			cities.set(first, cities.get(second));
			cities.set(second, cities.get(first));
			HolderOfSolutions.add(cities);
			System.out.println("I value " + i);

			// System.out.println("neigbhourhood "
			// +HolderOfSolutions.get(counter));
			// cities = cities2;
		}
		for (ArrayList<float[]> routes : HolderOfSolutions) {
			System.out.println("Cost of each routeREA1 " + getCostOfRoute2(routes));
			// System.out.println("neigbhourhood "
			// +HolderOfSolutions.get(counter));

		}

		// OptSwapped = HolderOfSolutions;
		return HolderOfSolutions;
	}

	private ArrayList<float[]> BestNeighbourFunction(ArrayList<ArrayList<float[]>> neighbours) {
		// neighbours = new ArrayList<ArrayList<float[]>>();
		neighbours = generate2Opt(cities);

		ArrayList<float[]> thebestRoute = new ArrayList<float[]>();
		float bestVal = getCostOfRoute2(neighbours.get(0));
		System.out.println("Cost first route " + (getCostOfRoute2(neighbours.get(0))));
		int counter = 0;
		int tCounter = 0;

		for (ArrayList<float[]> routes : neighbours) {
			System.out.println("Cost of each route " + getCostOfRoute2(routes));
			if (bestVal > getCostOfRoute2(routes)) {
				tCounter = counter;
				bestVal = getCostOfRoute2(neighbours.get(counter));
				thebestRoute = neighbours.get(counter);

			}
			counter++;

		}
		System.out.println("best value is " + bestVal);
		return thebestRoute;

	}

	private ArrayList<float[]> localSearch() {
		ArrayList<float[]> newRoute = new ArrayList<float[]>();
		ArrayList<float[]> initialRoute = new ArrayList<float[]>();
		initialRoute = generateRandomRoute(cities);
		for (int i = 0; i < 10; i++) {
			HolderOfSolutions = makingNeighborhood(initialRoute);
			newRoute = BestNeighbour(HolderOfSolutions);
			initialRoute = newRoute;
		}
		return newRoute;
	}

	private ArrayList<ArrayList<float[]>> TwoOptSwap(ArrayList<float[]> r) {
		ArrayList<float[]> r1 = new ArrayList<float[]>();


	 
		
		int firstIndex = 0;
		int secondIndex = 0;
		// cities2 = cities;
		
		for (int i = 0; i < 10; i++) {
			//randomRoute = setRandomRoute();
			
			//r = readFile();
			r = setRandomRoute();
			float[] tempCities = new float[r.size()];
			float[] tempCities1 = new float[r.size()];
			// readFile();
			//cities = cities2;
			// ArrayList<float[]> cities2 = new ArrayList<float[]>();
//ArrayList<float[]> cities = new ArrayList<float[]>();

			for (float[] element : r) {
				int j = 0;
				tempCities[j] = element[0];
				System.out.println("ORRINGAL");
				System.out.print(tempCities[j] + " ");
				j++;

			}
			
			firstIndex = rnd.nextInt(r.size());
			secondIndex = rnd.nextInt(r.size());
			if (firstIndex == secondIndex) {
				do {
					firstIndex = rnd.nextInt(r.size());
					secondIndex = rnd.nextInt(r.size());
					System.out.println("first is " + firstIndex);
					System.out.println("second is " + secondIndex);
				} while (firstIndex == secondIndex);
			}
			float[] secondVal = r.get(secondIndex);
			float[] firstVal = r.get(firstIndex);
			System.out.println("first index " + firstIndex);
			System.out.println("second index " + secondIndex);
			r.set(firstIndex, secondVal);
			r.set(secondIndex, firstVal);

		
			HolderOfSolutions.add(r);

			for (float[] element : r) {
				int j = 0;
				tempCities[j] = element[0];
				System.out.println("After");

				System.out.print(tempCities[j] + " ");
				System.out.println("");

				j++;

			}
//cities = cities2;
			// cities = cities2;
			for (float[] element : cities2) {
				int j = 0;
				tempCities1[j] = element[0];
				System.out.println("route2 ");
				System.out.print(tempCities1[j] + " ");
				j++;

			}
			//cities = cities2;
		}
		int counter = 0;
		for (ArrayList<float[]> routes : HolderOfSolutions) {
			System.out.println("Cost of each routeREAL " + counter + " " + getCostOfRoute2(routes));
			// System.out.println("Cost of each routeREAL2 " + getCostOfRoute2(routes));
			// System.out.println("Cost of each routeREAL4 " +
			// getCostOfRoute2(HolderOfSolutions.get(1)));
			counter++;
			
		}
		return HolderOfSolutions;

	}

	private ArrayList<float[]> BestNeighbour(ArrayList<ArrayList<float[]>> neighbourhood) {
		ArrayList<float[]> bestNeighbour = new ArrayList<float[]>();
		// neighbourhood = TwoOptSwap(cities);
		float bestVal = 0;
		float[] tempCities1 = new float[cities.size()];
		int counter = 0;
		bestVal = getCostOfRoute2(neighbourhood.get(0));
		bestNeighbour = neighbourhood.get(0);
		System.out.println("best val at the start " + bestVal);
		for (ArrayList<float[]> neighbours : neighbourhood) {
			float aVal = getCostOfRoute2(neighbours);
			System.out.println("aval " + aVal);
			System.out.println("counter value " + counter);
			System.out.println("NEIGHBOURS IN NEIGBHOURHOOD " + neighbours);

			if (bestVal > getCostOfRoute2(neighbours)) {
				bestVal = getCostOfRoute2(neighbours);
				bestNeighbour = neighbours;
			}
			counter++;
		}
		for (float[] element : bestNeighbour) {
			int j = 0;
			tempCities1[j] = element[0];
			System.out.print("England : " + tempCities1[j] + " ");

			System.out.println("best Neighbour is " + tempCities1[j]);
			j++;
		}
		System.out.println("best Neighbour cost is " + bestVal);
		return bestNeighbour;
	}

	private ArrayList<float[]> setRandomRoute() {
		randomRoute = new ArrayList<float[]>();
		randomRoute = generateRandomRoute(cities);

		return randomRoute;
	}

	private boolean isTourNew(ArrayList<float[]> r) {
		boolean isThere = false;
		for (ArrayList<float[]> tours : HolderOfSolutions) {
			int lCounter = 0;
			if (tours == r) {
				isThere = true;
			}
			lCounter++;
		}
		return isThere;
	}

	private ArrayList<float[]> twoOptSwap(ArrayList<float[]> route, int i, int j) {
		float[] tempRoute = route.get(i);

		route.set(i, route.get(j));
		route.set(j, tempRoute);

		HolderOfSolutions.add(route);
		return route;

	}

	private ArrayList<ArrayList<float[]>> makingNeighborhood(ArrayList<float[]> r) {
		//generate randome route to create neighbourhood around
		//r = generateRandomRoute(cities);
		//Swap index i with i +1 and carry on
		for (int i = 0; i < r.size() - 1; i++) {
			for (int j = i+1; j < r.size(); j++) {
				
				ArrayList<float[]> swappedT = twoOptSwap(new ArrayList<>(r), i, j);
				HolderOfSolutions.add(swappedT);
			}
		}

		return HolderOfSolutions;
	}
}