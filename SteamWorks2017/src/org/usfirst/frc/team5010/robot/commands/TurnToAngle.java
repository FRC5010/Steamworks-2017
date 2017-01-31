package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

	
	static Integer numberOfInstances = 0;
	
    public TurnToAngle() {
    	super("angle",SmartDashboard.getNumber("P", 0.01), SmartDashboard.getNumber("I", 0), SmartDashboard.getNumber("D", 0));
        requires(RobotMap.drivetrain);
        requires(RobotMap.direction);
        getPIDController().setAbsoluteTolerance(SmartDashboard.getNumber("tolerance", 1));
        getPIDController().setToleranceBuffer(Integer.valueOf(SmartDashboard.getString("Tolerance Buffer", "10")));
        getPIDController().setOutputRange(-0.7, 0.7);
        getPIDController().setInputRange(-360, 361);   
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.direction.reset();
    	setSetpoint(SmartDashboard.getNumber("Final Angle", 0));
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	getPIDController().setPID(SmartDashboard.getNumber("P", 0.01), SmartDashboard.getNumber("I", 0), SmartDashboard.getNumber("D", 0));
    	SmartDashboard.putNumber("angle", RobotMap.direction.angle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return getPIDController().onTarget();
       
    }

    // Called once after isFinished returns true
    protected void end() {
        numberOfInstances++;
        SmartDashboard.putString("Number of instances", numberOfInstances.toString());
    	RobotMap.drivetrain.stop();
  
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }

	@Override
	protected double returnPIDInput() {
		return RobotMap.direction.angle();
	}

	@Override
	protected void usePIDOutput(double output) {
		RobotMap.drivetrain.spin(output);
		SmartDashboard.putNumber("output", output);
			
	}
}
