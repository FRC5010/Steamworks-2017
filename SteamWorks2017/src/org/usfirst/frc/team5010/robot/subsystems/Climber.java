package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Chip
 * @since February 6, 2017
 */
public class Climber extends Subsystem {

	/**
	 * Default constructor.
	 */
	public Climber()
	{
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void startClimbing(double speed) {
		//double motorSpeed=SmartDashboard.getNumber("climbingSpeed", 0.2);
		RobotMap.climbMotor.set(speed);
	}
	
	public void stop() {
		RobotMap.climbMotor.set(0.0);
	}
	
}
