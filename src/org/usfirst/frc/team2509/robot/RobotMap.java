/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2509.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static VictorSP DriveTrain_LeftFrontDrive;
	public static VictorSP DriveTrain_RightFrontDrive;
	public static VictorSP DriveTrain_LeftRearDrive;
	public static VictorSP DriveTrain_RightRearDrive;
	public static VictorSP DriveTrain_LeftFrontRotate;
	public static VictorSP DriveTrain_RightFrontRotate;
	public static VictorSP DriveTrain_LeftRearRotate;
	public static VictorSP DriveTrain_RightRearRotate;
	public static Encoder DriveTrain_LeftFrontEncoder;
	public static Encoder DriveTrain_RightFrontEncoder;
	public static Encoder DriveTrain_LeftRearEncoder;
	public static Encoder DriveTrain_RightRearEncoder;
	
	public static void init() {
		DriveTrain_LeftFrontDrive = new VictorSP(0);
		DriveTrain_LeftFrontRotate = new VictorSP(1);
		DriveTrain_RightFrontDrive = new VictorSP(2);
		DriveTrain_RightFrontRotate = new VictorSP(3);
		DriveTrain_LeftRearDrive = new VictorSP(4);
		DriveTrain_LeftRearRotate = new VictorSP(5);
		DriveTrain_RightRearDrive = new VictorSP(6);
		DriveTrain_RightRearRotate = new VictorSP(7);
		DriveTrain_LeftFrontEncoder = new Encoder(0,1);
		DriveTrain_RightFrontEncoder = new Encoder(2,3);
		DriveTrain_LeftRearEncoder = new Encoder(4,5);
		DriveTrain_RightRearEncoder = new Encoder(6,7);
	}
}
