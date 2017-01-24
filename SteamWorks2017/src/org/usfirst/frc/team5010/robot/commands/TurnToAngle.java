package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

	
	static Integer numberOfInstances = 0;
	
    public TurnToAngle() {
    	
    	super("angle",SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
        requires(Robot.drivetrain);
        getPIDController().setAbsoluteTolerance(SmartDashboard.getNumber("tolerance"));
        getPIDController().setToleranceBuffer(Integer.valueOf(SmartDashboard.getString("Tolerance Buffer")));
        getPIDController().setOutputRange(-0.7, 0.7);
        getPIDController().setInputRange(-360, 361);   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setSetpoint(SmartDashboard.getNumber("Final Angle"));
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	getPIDController().setPID(SmartDashboard.getNumber("P"), SmartDashboard.getNumber("I"), SmartDashboard.getNumber("D"));
    	SmartDashboard.putNumber("angle", RobotMap.gyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return getPIDController().onTarget();
       
    }

    // Called once after isFinished returns true
    protected void end() {
        numberOfInstances++;
        SmartDashboard.putString("Number of instances", numberOfInstances.toString());
    	Robot.drivetrain.stop();
  
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.gyro.getAngle();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drivetrain.spin(output);
		SmartDashboard.putNumber("output", output);
			
	}
}
