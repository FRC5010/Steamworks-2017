package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jackson Lee
 * @since January 27, 2017
 */
public class BallShooter extends Subsystem {
	private Spark shootMotor = new Spark(3);

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
    
    /**
     * Function to shoot the ball high.
     */
    public void shootBallHigh() {
    	System.out.println("Temporary notification of shooting ball high.");
    	shootMotor.set(1.0);
    }
    
    /**
     * Function to shoot the ball low.
     */
    public void shootBallLow() {
    	System.out.println("Temporary notification of shooting ball low.");
    	shootMotor.set(0.5);
    }
}

