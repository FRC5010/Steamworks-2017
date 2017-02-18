package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RangeSensor extends Subsystem {
	public final AnalogInput ultrasound;
	
	public RangeSensor() {
		this.ultrasound = RobotMap.ultrasound;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getDistance() {
    	double value = ultrasound.getValue() / 8.14;
    	SmartDashboard.putNumber("value", ultrasound.getValue());
    	return value;
    }
}

