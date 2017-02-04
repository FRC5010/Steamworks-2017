package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class BallIntake extends Subsystem {

	/**
	 * Default constructor.
	 */
	public BallIntake()
	{
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void gatherBallToTank() {
    	double motorSpeed=SmartDashboard.getNumber("IntakeSpeed", 0.5);
    	RobotMap.intakeMotor.set(motorSpeed);
    
    }
    
    public void reverseBallOut() {
    	double motorSpeed=SmartDashboard.getNumber("IntakeReverseSpeed", -0.5);
    	RobotMap.intakeMotor.set(motorSpeed);
    }
    
    public void stop() {
    	RobotMap.intakeMotor.set(0);
    }

}

