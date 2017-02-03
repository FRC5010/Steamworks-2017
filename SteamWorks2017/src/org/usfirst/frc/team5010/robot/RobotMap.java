package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.robot.subsystems.BallIntake;
import org.usfirst.frc.team5010.robot.subsystems.BallShooter;
import org.usfirst.frc.team5010.robot.subsystems.DirectionSensor;
import org.usfirst.frc.team5010.robot.subsystems.DriveTrainMain;
import org.usfirst.frc.team5010.robot.subsystems.GearHolder;
import org.usfirst.frc.team5010.robot.subsystems.RangeSensor;
import org.usfirst.frc.team5010.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static void smartDashboard() {
		SmartDashboard.putNumber("D", 0.1);
		SmartDashboard.putNumber("I", 0.7);
		SmartDashboard.putNumber("P", 1);
		SmartDashboard.putNumber("Final Angle", 90);
		SmartDashboard.putNumber("tolerance", 1);
		SmartDashboard.putString("Tolerance Buffer", "5");
		SmartDashboard.putNumber("final distance", 15);
		SmartDashboard.putNumber("angle", 0);
		SmartDashboard.putNumber("distance per pulse", 1.5 * Math.PI);
		SmartDashboard.putNumber("Distance", ultrasound.getVoltage());
    	
	}

	public static  SpeedController driveMotorLeft;
	public static  SpeedController driveMotorRight;

	public static  Gyro gyro;
	public static  AnalogInput ultrasound;
	public static  DoubleSolenoid solenoid;

	public static  Encoder rightEncoder;
	public static  Encoder leftEncoder;
	public static  CameraServer camera; 

	public static  DriveTrainMain drivetrain;
	public static  GearHolder gearHolder;
	public static  BallIntake ballIntake;
	public static  DirectionSensor direction;
	public static  RangeSensor range;
	public static  Vision vision;
	public static BallShooter ballshooter;
	
	public static void init() {
		driveMotorLeft = new Spark(0);
		driveMotorRight = new Spark(1);

		gyro = new ADXRS450_Gyro();
		ultrasound = new AnalogInput(1);
		solenoid = new DoubleSolenoid(0, 1);

		rightEncoder = new Encoder(0, 1);
		leftEncoder = new Encoder(2, 3);
		camera = CameraServer.getInstance(); 
		drivetrain = new DriveTrainMain();
		gearHolder = new GearHolder();
		ballIntake = new BallIntake();
		direction = new DirectionSensor();
		range = new RangeSensor();
		vision = new Vision();
		ballshooter = new BallShooter(); 

	}
}
