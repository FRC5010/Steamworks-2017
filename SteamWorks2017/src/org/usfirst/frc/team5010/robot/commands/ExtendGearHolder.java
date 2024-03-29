package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.GearHolder;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author Juan 
 * @since January 28, 2016
 */
public class ExtendGearHolder extends Command {

	GearHolder gearHolder = null;
	long startTime = 0;
	/**
	 * Default Constructor.
	 */
	public ExtendGearHolder() {

		super("GearHolder");

		requires(RobotMap.gearHolder);
		this.gearHolder = RobotMap.gearHolder;

	}

	protected void initialize() {
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		gearHolder.extendGearHolder();
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (startTime + 1000 < System.currentTimeMillis());
	}

	// Called once after isFinished returns true
	protected void end() {
		gearHolder.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
