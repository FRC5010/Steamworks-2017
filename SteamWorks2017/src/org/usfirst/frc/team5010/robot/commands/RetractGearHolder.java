package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.subsystems.GearHolder;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Juan 
 * @since January 28, 2016
 */
public class RetractGearHolder extends Command {
	GearHolder gearHolder = null;

	/**
	 * Default constructor.
	 */
	public RetractGearHolder() {
    	requires(Robot.gearHolder);
    }
	
    // Called just before this Command runs the first time
    protected void initialize() {
    	this.gearHolder = Robot.gearHolder;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gearHolder.retractGearHolder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
