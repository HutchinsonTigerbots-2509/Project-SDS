package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * in future could optimize by instead of having 
 * the wheel turn 180 degrees instead by inversing 
 * the wheel power
 * @author Nate Christensen
 */
public class Swerve {
    //Drive Encoder Ratio: 52:54
    //Rotary Encoder Ratio: 34:72
    //Forward = Joystick.getY
    //Strafe = Joystick.getX
	//Rotate = Joystick.getZ
	private static SpeedController DriveMotor,
		RotateMotor;
	private static Encoder DriveEncoder,
		RotateEncoder;
	protected Swerve(){

	}
	public Swerve(SpeedController drvMtr, SpeedController rotMtr, Encoder drvEnc, Encoder rotEnc){
		DriveMotor = drvMtr;
		DriveEncoder = drvEnc;
		RotateMotor = rotMtr;
		RotateEncoder = rotEnc;
	}

    /**
     * <p>Converts a joystick (x,y) corridinate 
     * to a usable degree angle</p>
     * <p>This returns an int for simplicity</p>
     * @param stick
     * @return degrees
     */
    public static int RotateAngle(double x, double y){
        //(x,y) or (cos,sin)
        double  rads = 0,
                degs = 0;
        rads = Math.atan2(x, y);
		degs = Math.toDegrees(rads);
		//This has been removed because the encoder will read negative values
			//Makes sure that degree are between 0 & 360
			// if(degs<0){
			//     degs+=360;
			// }
        return (int)degs;
    }
    /**
     * <p>Uses the Joystick values and returns a value for power</p>
     * <p><i>This method uses a scaling vs average</i></p>
     * 
     * @param xSpeed
	 * @param ySpeed
	 * @param zRotation
     */
    protected double WheelPower(double xSpeed, double ySpeed){
        double pwr;
        double  x = xSpeed,
				y = ySpeed;
        pwr = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
        pwr /= Math.sqrt(2);
        return pwr;
	}
	public void Rotate(int targetAngle){
		int target = targetAngle,
			tollerance = 5,//± degrees 
			angle = RotateEncoder.get();
		if(angle<(target-tollerance)){
			RotateMotor.set(-0.5);
		}else if(angle>(target+tollerance)){
			RotateMotor.set(0.5);
		}else{
			RotateMotor.set(0);
		}
	}
	public void Drive(double power){
		DriveMotor.set(power);
	}
	public double getDistance(){
		return DriveEncoder.getDistance();
	}


	/**
   	 * Limit motor values to the -1.0 to +1.0 range.
   	 */
	protected static double limit(double value){
		if(value>1){
			return 1.0;
		}else if(value<-1){
			return -1.0;
		}else{
			return value;
		}
	}
	/**
	 * Normalize all wheel speeds if the magnitude of any wheel is greater than 1.0.
	 */
	protected void normalize(double[] wheelSpeeds) {
		double maxMagnitude = Math.abs(wheelSpeeds[0]);
		for (int i = 1; i < wheelSpeeds.length; i++) {
		  double temp = Math.abs(wheelSpeeds[i]);
		  if (maxMagnitude < temp) {
			maxMagnitude = temp;
		  }
		}
		if (maxMagnitude > 1.0) {
		  for (int i = 0; i < wheelSpeeds.length; i++) {
			wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
		  }
		}
	}
}