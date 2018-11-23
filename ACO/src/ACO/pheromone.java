package ACO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class pheromone {
	private double initialPLvl;
	private double rateOfEvap;
	private double rateOfDepos;
	private double relativeImpP;
	private double relativeImpE;
	
	public pheromone(double initialPLvl, double rateOfEvap, double rateOfDepos, double relativeImpP, double relativeImpE) {
		initialPLvl = 0.0;
		rateOfEvap = 0.5;
		rateOfDepos = 100.0;
		relativeImpP = 1.0;
		relativeImpE = 5.0;
		
		this.initialPLvl = initialPLvl;
		this.rateOfEvap = rateOfEvap;
		this.rateOfDepos = rateOfDepos;
		this.relativeImpP = relativeImpP;
		this.relativeImpE = relativeImpE;
		
		
		
	}
	
	public void run() {
	
		
	}
	
	
	
	private void setPlvl(ArrayList<float[]> route, int length,double newlvl) {
		length = route.size();
		newlvl = getrateOfDepos()/length;
		
		initialPLvl = newlvl;
	}
	
	public double getPlvl() {
		return initialPLvl;
	}
	
	private void setrateOfEvap(double newRateEvap) {
		//P * Ti,j *t
		//Ti,j(t)  =pheremone on edge
		// p = rateofEvap
		
		rateOfEvap =  newRateEvap;
	}
	
	public double getrateOfEvap(){
		return rateOfEvap;
	}
	
	
	public double getrateOfDepos(){
		return rateOfDepos;
	}
	
	
	private void setrateOfDepos(double newRateOfDepos) {
		
		rateOfDepos =  newRateOfDepos;
	}
	
	
	
	private void setrelativeImpP(double newrelativeImpP) {
		relativeImpP = newrelativeImpP;
	}
	
	public double getrelativeImpP() {
		return relativeImpP;
	}
	
	
	private void setrelativeImpE(double newrelativeImpE) {
		relativeImpE = newrelativeImpE;
	}
	
	public double getrelativeImpE() {
		return relativeImpE;
	}
	
	
}
