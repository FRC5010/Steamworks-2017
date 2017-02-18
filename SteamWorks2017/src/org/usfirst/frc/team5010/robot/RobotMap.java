package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.robot.subsystems.Agitator;
import org.usfirst.frc.team5010.robot.subsystems.BallIntake;
import org.usfirst.frc.team5010.robot.subsystems.BallShooter;
import org.usfirst.frc.team5010.robot.subsystems.Climber;
import org.usfirst.frc.team5010.robot.subsystems.DirectionSensor;
import org.usfirst.frc.team5010.robot.subsystems.DistanceSensor;
import org.usfirst.frc.team5010.robot.subsystems.DriveTrainMain;
import org.usfirst.frc.team5010.robot.subsystems.GearHolder;
import org.usfirst.frc.team5010.robot.subsystems.RangeSensor;
import org.usfirst.frc.team5010.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
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
		SmartDashboard.putNumber("D", 0.04);
		SmartDashboard.putNumber("I", 0.04);
		SmartDashboard.putNumber("P", 0.06);
		SmartDashboard.putNumber("Final Angle", 90);
		SmartDashboard.putNumber("tolerance", 1);
		SmartDashboard.putString("Tolerance Buffer", "5");
		SmartDashboard.putNumber("final distance", 15);
		SmartDashboard.putNumber("angle", 0);
		SmartDashboard.putNumber("distance per pulse", 4.7);
		SmartDashboard.putNumber("Distance", ultrasound.getVoltage());
    	SmartDashboard.putNumber("ballShooterHighSpeed", 1.0);
    	SmartDashboard.putNumber("ballShooterLowSpeed", 0.5);
    	SmartDashboard.putNumber("IntakeSpeed", 0.5);
    	SmartDashboard.putNumber("IntakeReverseSpeed", -0.5);
    	SmartDashboard.putNumber("climbingSpeed", 0.3);
    	SmartDashboard.putNumber("agitator time", 500);
    	SmartDashboard.putNumber("distance from wall for side autons", 0);
	}

	public static  SpeedController driveMotorLeft;
	public static  SpeedController driveMotorRight;
	public static  SpeedController shootMotor;
	public static SpeedController intakeMotor;
	public static SpeedController climbMotor;

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
	public static DistanceSensor distanceSensor;
	
	public static Climber climber;
	
	public static Spark agitatorMotor;
	public static Agitator agitator;
	
	public static void init() {
		driveMotorLeft = new Spark(0);
		driveMotorRight = new Spark(1);
		intakeMotor = new Spark(4);
		shootMotor = new Spark(3);
		climbMotor=new Spark(2);
		
		gyro = new ADXRS450_Gyro();
		ultrasound = new AnalogInput(0);
		solenoid = new DoubleSolenoid(0, 1);
		agitatorMotor = new Spark(5);

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
		climber= new Climber();
		distanceSensor = new DistanceSensor();
		agitator = new Agitator();
		
		
	}
}
