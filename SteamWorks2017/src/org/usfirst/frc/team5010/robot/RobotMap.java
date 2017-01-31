package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.robot.subsystems.BallIntake;
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
		SmartDashboard.putNumber("angle", RobotMap.direction.angle());
		SmartDashboard.putNumber("distance per pulse", 1.5 * Math.PI);
	}

	public static final SpeedController driveMotorLeft = new Spark(0);
	public static final SpeedController driveMotorRight = new Spark(1);

	public static final Gyro gyro = new ADXRS450_Gyro();
	public static final AnalogInput ultrasound = new AnalogInput(0);
	public static final DoubleSolenoid solenoid = new DoubleSolenoid(1, 2);

	public static final Encoder rightEncoder = new Encoder(0, 1);
	public static final Encoder leftEncoder = new Encoder(2, 3);
	public static final CameraServer camera = CameraServer.getInstance(); 

	public static final DriveTrainMain drivetrain = new DriveTrainMain();
	public static final GearHolder gearHolder = new GearHolder();
	public static final BallIntake ballIntake = new BallIntake();
	public static final DirectionSensor direction = new DirectionSensor();
	public static final RangeSensor range = new RangeSensor();
	public static final DistanceSensor distance = new DistanceSensor();
	public static final Vision vision = new Vision();
}
