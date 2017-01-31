package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainMain extends Subsystem {

	SpeedController rightMotor = RobotMap.driveMotorRight;
	SpeedController leftMotor = RobotMap.driveMotorLeft;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new TankDrive());
    }

    public void driveStraightandSafe(double power) {
    	rightMotor.set(power);
    	leftMotor.set(-power);
    	
    }
    
    public void drive(double leftPower, double rightPower) {
    	rightMotor.set(-rightPower);
    	leftMotor.set(leftPower);
    }
    
    public void spin(double power){
    	rightMotor.set(power);
    	leftMotor.set(power);
    }
    
    public void stop() {
    	rightMotor.set(0);
    	leftMotor.set(0);
    }
}


