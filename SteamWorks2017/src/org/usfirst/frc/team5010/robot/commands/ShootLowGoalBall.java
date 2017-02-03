package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.BallShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @since January 28, 2017
 */
public class ShootLowGoalBall extends Command {
	private BallShooter shooter;
	
	/**
	 * Default constructor.
	 */
    public ShootLowGoalBall() {
    	requires(RobotMap.ballshooter);
    	shooter = RobotMap.ballshooter;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.shootBallLow();
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
