package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveBack extends Command {

	long startTime;
	long currentTime;
	double time = 2000;
	
    public DriveBack() {
        requires(RobotMap.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.drivetrain.drive(.25,.25);
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentTime = System.currentTimeMillis();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return ((startTime + time < currentTime) || Robot.oi.joyDriver.getRawAxis(1) > .2 || Robot.oi.joyDriver.getRawAxis(5) > .2);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
