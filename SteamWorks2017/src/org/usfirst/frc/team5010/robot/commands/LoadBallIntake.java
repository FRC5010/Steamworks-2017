package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.BallIntake;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @since Jackson Lee
 * @since January 27, 2017
 */
public class LoadBallIntake extends Command {
	private BallIntake ballIntake;

	/**
	 * Default constructor.
	 */
    public LoadBallIntake() {
    	requires(RobotMap.ballIntake);
    	ballIntake = RobotMap.ballIntake;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	ballIntake.gatherBallToTank();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Robot.oi.joyCoDriver.getRawButton(2))
    	{
    		return false;
    	}
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	ballIntake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
