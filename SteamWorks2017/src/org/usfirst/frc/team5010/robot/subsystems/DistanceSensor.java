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
	
	public DistanceSensor(){
		rightEncoder = RobotMap.rightEncoder;
		reset();
		rightEncoder.setDistancePerPulse(SmartDashboard.getNumber("distance per pulse", .02));
	}

	public void reset() {
		rightEncoder.reset();
	}

	public double getDistance() {
		//TODO uncomment when both encoders have
		SmartDashboard.putNumber("raw encoder", rightEncoder.getRaw());
		return (rightEncoder.getRaw() / -46);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());

	}
}
