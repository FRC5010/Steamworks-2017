package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class BallShooter extends Subsystem {

	/**
	 * Default constructor.
	 */
    public BallShooter()
    {
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shootBallHigh() {
    	System.out.println("Temporary notification of shooting ball high.");
    }
    
    public void shootBallLow() {
    	System.out.println("Temporary notification of shooting ball low.");
    }
}

