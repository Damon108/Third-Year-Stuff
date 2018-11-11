import java.util.Random;

public class Particle {
	private double velocity;
	private double cPos;
	private double tempPos;
	private double pbPos;
	private double SSLValue;

	private Random rnd;

<<<<<<< HEAD
	public Particle(double velocity, double cPos, double pbPos, double SSLValue) {
=======
	public Particle(double velocity, double cPos, double pbPos) {
>>>>>>> 79665ad197d0f83d24fc2e68f1ae37a2ff544107
		this.velocity = velocity;
		this.cPos = cPos;
		this.pbPos = pbPos;
		this.SSLValue = SSLValue;

		

	
	}

	public double getPB() {

		System.out.println("pb is : " + pbPos);

		// System.out.println("pb is : " +pbPos);

		return pbPos;
	}

	public void savePB(double cPos) {
		pbPos = cPos;
	}

<<<<<<< HEAD
	public void savecPos(double Pos) {
		this.cPos = Pos;
=======
	public void savecPos(double cPos) {
		this.cPos = cPos;
>>>>>>> 79665ad197d0f83d24fc2e68f1ae37a2ff544107
	}

	public double getcPos() {
		// System.out.println("pb is : " +pbPos);
		return cPos;
	}

	public void saveSSLValue(double SSLValue) {
		this.SSLValue = SSLValue;
	}

	public double getSSLValue() {
		// System.out.println("SSL is : " + SSLValue);
		return SSLValue;
	}

	public double getVelocity() {
		return velocity;
	}
<<<<<<< HEAD

	public void setVelocity(double newVelocity) {

=======
	
	public void setVelocity(double newVelocity) {
		
>>>>>>> 79665ad197d0f83d24fc2e68f1ae37a2ff544107
		velocity = newVelocity;
	}
}
