package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.commands.TankDrive;

import com.ni.vision.NIVision.LegFeature;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

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
    	rightMotor.set(rightPower);
    	leftMotor.set(-leftPower);
    }
    
    public void spin(double power){
    	rightMotor.set(-power);
    	leftMotor.set(-power);
    }
    
    public void stop() {
    	rightMotor.set(0);
    	leftMotor.set(0);
    }
}


