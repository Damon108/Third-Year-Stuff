import java.util.Random;

public class Particle {
	private double velocity;
	private double cPos;
	private double pbPos;

	private Random rnd;

	public Particle(double velocity, double cPos, double pbPos) {

		this.velocity = velocity;
		this.cPos = cPos;
		this.pbPos = pbPos;

	}

	public double getPB() {
		System.out.println("pb is : " +pbPos);
		return pbPos;
	}

	public void savePB(double cPos) {
		pbPos = cPos;
	}
}
