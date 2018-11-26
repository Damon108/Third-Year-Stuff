package ACO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Aco {
	private ArrayList<float[]> PtRoute;
	private double[][] pt;
	private ArrayList<float[]> cities;
private pheromone pheromone;
	public Aco() {
		//Collumn 1 is first city, collumn 2 is second city, collumn 3 is PT
	PtRoute = new ArrayList<float[]>();
	
	//pheromone = new pheromone(pheromone.getPlvl(), pheromone.getrateOfEvap(), pheromone.getrateOfDepos(), pheromone.getrelativeImpP(), pheromone.getrelativeImpE());
	
	}
	
	private void run(){
		readFile();
		cities = generateRandomRoute(cities);
		
	}

	public ArrayList<float[]> readFile() {
		
		cities = new ArrayList<float[]>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("D:\\3rd year\\ACO\\src\\ulysses16.csv"));
			String line = "";
			while ((line = reader.readLine()) != null) {
				try {

					String[] words = line.split(",");
					float[] index0 = { Float.parseFloat(words[0]), Float.parseFloat(words[1]),
							Float.parseFloat(words[2]) };

					cities.add(index0);
					// cities2.add(index0);
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
	
	private void ACOAlgo() {
		int numOfAnts = 10;
		
		//pheromone pheromone = new pheromone(0, 0, 0, 0, 0);
		pheromone[] pheremones = new pheromone[cities.size()];
		for(int i = 0 ; i < pheremones.length;i++) {
			pheremones[i] = new pheromone(pheromone.getPlvl(), pheromone.getrateOfEvap(), pheromone.getrateOfDepos(), pheromone.getrelativeImpP(), pheromone.getrelativeImpE());
		}
		
		for(float[] element : cities){
			int counter = 0;
			cities.get
		}
	}
}
