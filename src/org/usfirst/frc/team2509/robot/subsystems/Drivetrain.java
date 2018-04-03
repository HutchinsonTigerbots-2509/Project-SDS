package org.usfirst.frc.team2509.robot.subsystems;

import org.usfirst.frc.team2509.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	private VictorSP LeftFrontDrive = RobotMap.DriveTrain_LeftFrontDrive;
	private VictorSP RightFrontDrive = RobotMap.DriveTrain_RightFrontDrive;
	private VictorSP LeftRearDrive = RobotMap.DriveTrain_LeftRearDrive;
	private VictorSP RightRearDrive = RobotMap.DriveTrain_RightRearDrive;
	private VictorSP LeftFrontRotate = RobotMap.DriveTrain_LeftFrontRotate;
	private VictorSP RightFrontRotate = RobotMap.DriveTrain_RightFrontRotate;
	private VictorSP LeftRearRotate = RobotMap.DriveTrain_LeftRearRotate;
	private VictorSP RightRearRotate = RobotMap.DriveTrain_RightRearRotate;
	private Encoder LeftFrontEnc = RobotMap.DriveTrain_LeftFrontEncoder;
	private Encoder RightFrontEnc = RobotMap.DriveTrain_RightFrontEncoder;
	private Encoder LeftRearEnc = RobotMap.DriveTrain_LeftRearEncoder;
	private Encoder RightRearEnc = RobotMap.DriveTrain_RightRearEncoder;
	private double rangeOfError = 2.5;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public double calculateRotateAngle(double x, double y) {
    	double a = x;
    	double b = y;
    	double c = Math.sqrt((a*a)+(b*b));
    	double angle = Math.atan2(y, x)*(180/Math.PI);
		return angle;
    }
    public void rotateToAngle(double angle) {
    	rotateMotor(LeftFrontRotate,LeftFrontEnc,angle);
    	rotateMotor(RightFrontRotate,RightFrontEnc,angle);
    	rotateMotor(LeftRearRotate,LeftRearEnc,angle);
    	rotateMotor(RightRearRotate,RightRearEnc,angle);
    }
    public void rotateMotor(SpeedController motor, Encoder enc, double angle) {
    	if(angle<(enc.get()-rangeOfError)){
    		motor.set(-0.5);
    	}else if(angle>(enc.get()+rangeOfError)) {
    		motor.set(0.5);
    	}else {
    		motor.set(0);
    	}
    }
    /**
     * Left Front Drive Motor
     * @return VictorSP LeftFront
     */
    public VictorSP getLeftFront() {
    	return LeftFrontDrive;
    }
    /**
     * Right Front Drive Motor
     * @return VictorSP RightFront
     */
    public VictorSP getRightFront() {
    	return RightFrontDrive;
    }
    /**
     * Left Rear Drive Motor
     * @return VictorSP LeftRear
     */
    public VictorSP getLeftRear() {
    	return LeftRearDrive;
    }
    /**
     * Right Rear Drive Motor
     * @return VictorSP RightRear
     */
    public VictorSP getRightRear() {
    	return RightRearDrive;
    }
    /**
     * Left Front Rotate Motor
     * @return VictorSP LeftFront
     */
    public VictorSP getLeftFrontRotate() {
    	return LeftFrontRotate;
    }
    /**
     * Right Front Rotate Motor
     * @return VictorSP RightFront
     */
    public VictorSP getRightFrontRotate() {
    	return RightFrontRotate;
    }
    /**
     * Left Rear Rotate Motor
     * @return VictorSP LeftRear
     */
    public VictorSP getLeftRearRotate() {
    	return LeftRearRotate;
    }
    /**
     * Right Rear Rotate Motor
     * @return VictorSP RightRear
     */
    public VictorSP getRightRearRotate() {
    	return RightRearRotate;
    }
}

