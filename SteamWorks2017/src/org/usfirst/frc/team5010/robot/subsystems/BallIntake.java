package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class BallIntake extends Subsystem {

	Spark intakeMotor = RobotMap.intakeMotor;
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
    	System.out.println("Temporary notification of gathering ball into tank.");
    	intakeMotor.setSpeed(.5);
    	
    }
    
    public void reverseBallOut() {
    	System.out.println("Temporary notification of reversing ball out.");
    	intakeMotor.setSpeed(-.5);
    }
    
    public void stop() {
    	intakeMotor.setSpeed(0);
    }

}

