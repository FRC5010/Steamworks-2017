package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.subsystems.BallShooter;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class ShootHighGoalBall extends Command {
	private BallShooter shooter;
	/**
	 * Default constructor.
	 */
    public ShootHighGoalBall() {
    	requires(RobotMap.ballshooter);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	shooter.shootBallHigh();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ( Robot.oi.joyCoDriver.getRawButton(4) == true )
     	   return false; 
        else 
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
