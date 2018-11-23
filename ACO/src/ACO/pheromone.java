package ACO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class pheromone {
	private double initialPLvl;
	private double rateOfEvap;
	private double rateOfDepos;
	private double relativeImpP;
	private double relativeImpE;
private ArrayList<float[]> cities;
	public pheromone(double initialPLvl, double rateOfEvap, double rateOfDepos, double relativeImpP, double relativeImpE) {
		this.initialPLvl = initialPLvl;
		this.rateOfEvap = rateOfEvap;
		this.rateOfDepos = rateOfDepos;
		this.relativeImpP = relativeImpP;
		this.relativeImpE = relativeImpE;
		
	}
	
	private void run() {
		readFile();
	}
	
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
					//cities2.add(index0);
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
	
	private void setPlvl(double newlvl) {
		initialPLvl = newlvl;
	}
	
	private double getPlvl() {
		return initialPLvl;
	}
	
	private void setrateOfEvap(double newRateEvap) {
		rateOfEvap =  newRateEvap;
	}
	
	private double getrateOfEvap(){
		return rateOfEvap;
	}
	
	
	private double getrateOfDepos(){
		return rateOfDepos;
	}
	
	
	private void setrateOfDepos(double newRateOfDepos) {
		rateOfDepos =  newRateOfDepos;
	}
	
	
	
	private void setrelativeImpP(double newrelativeImpP) {
		relativeImpP = newrelativeImpP;
	}
	
	private double getrelativeImpP() {
		return relativeImpP;
	}
	
	
	private void setrelativeImpE(double newrelativeImpE) {
		relativeImpE = newrelativeImpE;
	}
	
	private double getrelativeImpE() {
		return relativeImpE;
	}
}
