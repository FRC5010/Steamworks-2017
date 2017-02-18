package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LeftPegAuton extends CommandGroup {

	public LeftPegAuton() {
		double Distance = SmartDashboard.getNumber("distance from wall for side autons", 0);
		
		
		
		DriveForDistance step1 = new DriveForDistance();
		step1.setPoint(Math.tan(30 * 180/Math.PI) * (151 - Distance) + (56 - (15.5)));
		TurnToAngle step2 = new TurnToAngle();
		step2.setPoint(60);
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
