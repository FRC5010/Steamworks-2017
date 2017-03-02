package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TurnToAngle extends PIDCommand {

	
	static Integer numberOfInstances = 0;
	private double tolerance = 0.25;
	private int toleranceBuffer = 10;
	private static double p = 0.06;
	private static double i = 0.04;
	private static double d = 0.04;
	
	
    public TurnToAngle() {
    	super("TurnToAngle", p , i , d);
        requires(RobotMap.drivetrain);
        requires(RobotMap.direction);
        getPIDController().setAbsoluteTolerance(tolerance);
        getPIDController().setToleranceBuffer(toleranceBuffer);
        getPIDController().setOutputRange(-0.225, 0.225);
        getPIDController().setInputRange(-360, 361);   
    }
    
    public void setPoint(double setPoint) {
    	setSetpoint(setPoint);
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.direction.reset();
    	
    	getPIDController().setAbsoluteTolerance(tolerance);
        getPIDController().setToleranceBuffer(toleranceBuffer);
    	getPIDController().setPID(SmartDashboard.getNumber("P", 0.01), SmartDashboard.getNumber("I", 0), SmartDashboard.getNumber("D", 0));

    }
    
   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
