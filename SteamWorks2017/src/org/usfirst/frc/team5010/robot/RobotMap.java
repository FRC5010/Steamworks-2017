package org.usfirst.frc.team5010.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
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

		SmartDashboard.putNumber("distance per pulse", 1.5 * Math.PI);
	}

	public static SpeedController driveMotorLeft = new Spark(0);
	public static SpeedController driveMotorRight = new Spark(1);

	public static Gyro gyro = new ADXRS450_Gyro();
	public static AnalogInput distance = new AnalogInput(0);
	public static DoubleSolenoid solenoid = new DoubleSolenoid(1, 2);

	public static Encoder rightEncoder = new Encoder(0, 1);
	public static Encoder leftEncoder = new Encoder(2, 3);

}
