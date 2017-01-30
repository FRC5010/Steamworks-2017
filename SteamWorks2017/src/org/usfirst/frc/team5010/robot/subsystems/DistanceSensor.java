package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DistanceSensor extends Subsystem {

	private final Encoder rightEncoder;
	private final Encoder leftEncoder;
	
	public DistanceSensor(){
		rightEncoder = RobotMap.rightEncoder;
		leftEncoder = RobotMap.leftEncoder;
		reset();
		rightEncoder.setDistancePerPulse(SmartDashboard.getNumber("distance per pulse", 10));
		leftEncoder.setDistancePerPulse(SmartDashboard.getNumber("distance per pulse", 10));
	}

	public void reset() {
		rightEncoder.reset();
		leftEncoder.reset();
	}

	public double getDistance() {
		return (rightEncoder.getDistance() + leftEncoder.getDistance()) / 2;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}
}
