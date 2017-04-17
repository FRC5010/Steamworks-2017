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
    	double motorSpeed=SmartDashboard.getNumber("IntakeSpeed", 1);
    	RobotMap.intakeMotor.set(motorSpeed);
    
    	//uncomment following 2 lines if we use triggers
    	//double axisSpeed = Robot.oi.joyCoDriver.getRawAxis(3);
    	//RobotMap.intakeMotor.set(axisSpeed);
    }
    
    public void reverseBallOut() {
    	double motorSpeed=SmartDashboard.getNumber("IntakeReverseSpeed", -0.5);
    	RobotMap.intakeMotor.set(motorSpeed);
    	
    	//uncomment following 3 lines if we use triggers
    	//double axisSpeed = Robot.oi.joyCoDriver.getRawAxis(2);
    	//axisSpeed=axisSpeed*-1;
    	//RobotMap.intakeMotor.set(axisSpeed);
    }
    
    public void stop() {
    	RobotMap.intakeMotor.set(0);
    }

}

