package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Chip
 * @since February 6, 2017
 */
public class Climb extends Command {

	private Climber littleClimber;
	
    public Climb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(RobotMap.climber);
    	littleClimber=RobotMap.climber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	littleClimber.startClimbing();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.oi.joyDriver.getRawButton(5)) {
        	return false;
        }
        else {
        	return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	littleClimber.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
