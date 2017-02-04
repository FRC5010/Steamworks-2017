package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class EmptyBallIntake extends Command {

	/**
	 * Default constructor.
	 */
    public EmptyBallIntake() {
    	requires(RobotMap.ballIntake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.ballIntake.reverseBallOut();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("InEmptyBallIntake");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//better way to do this?
        return Robot.oi.joyDriver.getRawButton(3);
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.ballIntake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
