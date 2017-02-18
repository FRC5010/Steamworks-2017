package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {
	Spark agitatorMotor = null;
	
	public Agitator() {
		agitatorMotor = RobotMap.agitatorMotor;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void setSpeed(double speed){
		agitatorMotor.set(speed);
	}
	
	public void stop(){
		agitatorMotor.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

