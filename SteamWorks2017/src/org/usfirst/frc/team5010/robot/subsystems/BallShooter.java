package org.usfirst.frc.team5010.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team5010.robot.RobotMap;

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
    
    /**
     * Function to shoot the ball high.
     */
    public void shootBallHigh() {
    	double shootSpeed = SmartDashboard.getNumber("BallShooterHighSpeed", 1.0);
    	RobotMap.shootMotor.set(shootSpeed);
    }
    
    /**
     * Function to shoot the ball low.
     */
    public void shootBallLow() {
    	double shootSpeed = SmartDashboard.getNumber("BallShooterLowSpeed", 0.5);
    	RobotMap.shootMotor.set(shootSpeed);
    }
}

