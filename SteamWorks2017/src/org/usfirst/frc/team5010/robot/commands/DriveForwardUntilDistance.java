package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardUntilDistance extends PIDCommand {
	
	private double currentAngle = 0;
	private static double p = 0.06;
	private static double i = 0.04;
	private static double d = 0.04;
	private static double tolerance = 0.25;
	private static int toleranceBuffer = 10;
	 //p 0.06 i 0.04 d 0.04
    public DriveForwardUntilDistance() {
        super("DriveForwardUntilDistance", p, i, d);
        requires(RobotMap.drivetrain);
        requires(RobotMap.direction);
        requires(RobotMap.range);
        getPIDController().setInputRange(6,200);
        getPIDController().setOutputRange(-0.2, 0.2);
       
    }
    public void setPoint(double setPoint) {
    	setSetpoint(setPoint);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putNumber("Setpoint", getSetpoint());   
        getPIDController().setAbsoluteTolerance(tolerance);
        getPIDController().setToleranceBuffer(toleranceBuffer);
    	RobotMap.direction.reset();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = RobotMap.direction.angle();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {    
        return getPIDController().onTarget();
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

	@Override
	protected double returnPIDInput() {
		double distance = RobotMap.range.getDistance();
    	SmartDashboard.putNumber("distance", distance);
		return distance;
	}

	@Override
	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("output", output);
		// TODO: Check the gyro from a subsystem and adjust the output to the drive system to keep the robot straight
			double leftOutput = .5 * output; //- (currentAngle / 180);
			double rightOutput = .5 * output; //+ (currentAngle / 180);
			RobotMap.drivetrain.drive(leftOutput, rightOutput);
	}
}
