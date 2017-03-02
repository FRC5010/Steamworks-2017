package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterPegAuton extends CommandGroup {

    public CenterPegAuton() {
    	RobotMap.direction.reset();
    	//can't have same command repeated.
    	DriveForwardUntilDistance step1 = new DriveForwardUntilDistance();
    	step1.setPoint(8);
    	DriveForwardUntilDistance driveBack = new DriveForwardUntilDistance();
    	driveBack.setPoint(20);
    	
    	
    	addSequential(step1);
    	addSequential(new ExtendGearHolder());
    	addSequential(driveBack);
    	addSequential(new RetractGearHolder());
    	
    }
}
