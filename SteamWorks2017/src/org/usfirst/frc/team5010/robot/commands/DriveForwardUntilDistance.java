package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardUntilDistance extends PIDCommand {
	private boolean firstExecution = true;
	private static Integer numberOfInstances = 0;
	private Gyro gyro = RobotMap.gyro;
	private double currentAngle = 0;
	 //p 0.06 i 0.04 d 0.04
    public DriveForwardUntilDistance() {
        super("angle",SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
        requires(Robot.drivetrain);
        getPIDController().setInputRange(6,200);
        getPIDController().setOutputRange(-0.2, 0.2);
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putNumber("Setpoint", getSetpoint());
    	setSetpoint(SmartDashboard.getNumber("final distance"));   
        numberOfInstances++;
        SmartDashboard.putString("Number of instances", numberOfInstances.toString());
        getPIDController().setAbsoluteTolerance(SmartDashboard.getNumber("tolerance"));
        getPIDController().setToleranceBuffer(Integer.valueOf(SmartDashboard.getString("Tolerance Buffer")));
    	getPIDController().setPID(SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
    	gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = gyro.getAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return getPIDController().onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
        numberOfInstances++;
        SmartDashboard.putString("Number of instances", numberOfInstances.toString());
    	firstExecution = true;
    	Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }

	@Override
	protected double returnPIDInput() {
		double distance = RobotMap.distance.getValue() / 9.8;
    	SmartDashboard.putNumber("distance", distance);
		return distance;
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("output", output);
		// TODO: Check the gyro from a subsystem and adjust the output to the drive system to keep the robot straight
			double leftOutput = output - (currentAngle / 180);
			double rightOutput = output + (currentAngle / 180);
			Robot.drivetrain.drive(leftOutput, rightOutput);
	}
}
