package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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
    	System.out.println("Temporary notification of gathering ball into tank.");
    }
    
    public void reverseBallOut() {
    	System.out.println("Temporary notification of reversing ball out.");
    }

}

