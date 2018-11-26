package ACO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class pheromone {
	private double PlvlPLvl;
	private double rateOfEvap;
	private double rateOfDepos;
	private double relativeImpP;
	private double relativeImpE;
	private double initPlvl;
	
	public pheromone(double PlvlPLvl, double rateOfEvap, double rateOfDepos, double relativeImpP, double relativeImpE) {
		initPlvl = 0.0;
		rateOfEvap = 0.5;
		rateOfDepos = 100.0;
		relativeImpP = 1.0;
		relativeImpE = 5.0;
		PlvlPLvl = initPlvl;
		
		this.PlvlPLvl = PlvlPLvl;
		this.rateOfEvap = rateOfEvap;
		this.rateOfDepos = rateOfDepos;
		this.relativeImpP = relativeImpP;
		this.relativeImpE = relativeImpE;
		
		
		
	}
	
	public void run() {
	
		
	}
	
	
	
	public void setPlvl(ArrayList<float[]> route, int length,double newlvl) {
		length = route.size();
		newlvl = getrateOfDepos()/length;
		
		PlvlPLvl = newlvl;
	}
	
	public double getPlvl() {
		return PlvlPLvl;
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
