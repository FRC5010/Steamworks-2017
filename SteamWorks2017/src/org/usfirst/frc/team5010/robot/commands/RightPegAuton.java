package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RightPegAuton extends CommandGroup {

	public RightPegAuton() {
		double distance = SmartDashboard.getNumber("distance from wall for side autons", 0);
		distance = Math.tan(30 * 180/Math.PI) * (144.0 - distance) + (56.0 - (15.5));
		
		
		DriveForDistance step1 = new DriveForDistance();
		step1.setPoint(distance);
		SmartDashboard.putNumber("setpoint calculated value", distance);
		TurnToAngle step2 = new TurnToAngle();
		step2.setPoint(-60);
		DriveForwardUntilDistance driveForward = new DriveForwardUntilDistance();
		driveForward.setPoint(8);
		DriveForwardUntilDistance driveBack = new DriveForwardUntilDistance();
		driveBack.setPoint(20);

		
		
		addSequential(step1);
		addSequential(step2);
		addSequential(driveForward);
		addSequential(new ExtendGearHolder());
		addSequential(driveBack);
		addSequential(new RetractGearHolder());
	}
}
