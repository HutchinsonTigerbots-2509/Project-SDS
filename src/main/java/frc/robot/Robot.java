/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends IterativeRobot {
  private Talon fldMotor, frdMotor, rldMotor, rrdMotor, flrMotor, frrMotor, rlrMotor, rrrMotor;
  private Encoder fldEnc, frdEnc, rldEnc, rrdEnc, flrEnc, frrEnc, rlrEnc, rrrEnc;
  private Swerve flSwerve, frSwerve, rlSwerve, rrSwerve;
  private SwerveDrive drivetrain;
  private Joystick stick;
  public Swerve test;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    VictorSP testRMotor = new VictorSP(0);
    VictorSP testDMotor = new VictorSP(1);
    Encoder testREncoder = new Encoder(0, 1);
    Encoder testDEncoder = new Encoder(2, 3);
    test = new Swerve(testDMotor, testRMotor, testDEncoder, testREncoder);
    // //Motors for Swerve Drive
    // fldMotor = new Talon(0);
    // frdMotor = new Talon(1);
    // rldMotor = new Talon(2);
    // rrdMotor = new Talon(3);
    // flrMotor = new Talon(4);
    // frrMotor = new Talon(5);
    // rlrMotor = new Talon(6);
    // rrrMotor = new Talon(7);
    // //Encoders for Sweve Drive
    // fldEnc = new Encoder(0,1);
    // frdEnc = new Encoder(2,3);
    // rldEnc = new Encoder(4,5);
    // rrdEnc = new Encoder(6,7);
    // flrEnc = new Encoder(8,9);
    // frrEnc = new Encoder(10,11);
    // rlrEnc = new Encoder(12,13);
    // rrrEnc = new Encoder(14,15);
    // //Swerve Drive
    // flSwerve = new Swerve(fldMotor, flrMotor, fldEnc, flrEnc);
    // frSwerve = new Swerve(frdMotor,frrMotor,frdEnc,frrEnc);
    // rlSwerve = new Swerve(rldMotor,rlrMotor,rldEnc,rlrEnc);
    // rrSwerve = new Swerve(rrdMotor,rrrMotor,rrdEnc,rrrEnc);
    // //Drivetrain
    // drivetrain = new SwerveDrive(flSwerve,frSwerve,rlSwerve,rrSwerve);
    // Joysticks
    stick = new Joystick(0);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString line to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure below with additional strings. If using the SendableChooser
   * make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    test.SingleDrive(stick.getX(), stick.getY(), stick.getZ());
    // drivetrain.Drive(stick.getX(), stick.getY(), stick.getZ());
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
