package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DirectionSensor extends Subsystem {
	public final Gyro gyro;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DirectionSensor() {
		this.gyro = RobotMap.gyro;
	}
	
	public double angle() {
		return gyro.getAngle();
	}
	
	public void reset() {
		gyro.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

