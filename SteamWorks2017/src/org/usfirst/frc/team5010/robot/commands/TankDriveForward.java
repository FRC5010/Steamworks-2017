package org.usfirst.frc.team5010.robot.commands;


import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDriveForward extends Command {
	private double leftInputPower;
	private double rightInputPower;
    
	public TankDriveForward() {
    	requires(RobotMap.drivetrain);
    	requires(RobotMap.distanceSensor);
    	requires(RobotMap.range);

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.forwardOrReverse = true;
//    	RobotMap.vision.stopRearVision();
//    	RobotMap.vision.startFrontVision();
    	RobotMap.distanceSensor.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftInputPower = Robot.oi.joyDriver.getRawAxis(1);
    	rightInputPower = Robot.oi.joyDriver.getRawAxis(5);
    	
    	RobotMap.drivetrain.drive(leftInputPower, rightInputPower);
    	SmartDashboard.putNumber("distance", RobotMap.range.getDistance());
    	SmartDashboard.putNumber("encoder", RobotMap.distanceSensor.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.drivetrain.drive(0,0);
    	RobotMap.vision.stopFrontVision();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
