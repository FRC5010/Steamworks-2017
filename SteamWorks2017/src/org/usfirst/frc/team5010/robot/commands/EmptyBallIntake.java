package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.BallIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class EmptyBallIntake extends Command {
	private BallIntake ballIntake;

	/**
	 * Default constructor.
	 */
    public EmptyBallIntake() {
    	requires(RobotMap.ballIntake);
    	ballIntake = RobotMap.ballIntake;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ballIntake.reverseBallOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.oi.joyCoDriver.getRawAxis(2) == 0.0)
    	{
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballIntake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
