package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.subsystems.GearHolder;

public class ExtendGearHolder extends Command {

	GearHolder gearHolder = null;

	public ExtendGearHolder() {

		super("GearHolder");

		//requires(Robot.gearHolder);
	}

	protected void initialize() {
		//this.gearHolder = Robot.gearHolder;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		gearHolder.extendGearHolder();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
