package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;
import org.usfirst.frc.team5010.robot.commands.TankDrive;

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
	Gyro gyro = RobotMap.gyro;
	AnalogInput distance = RobotMap.distance;

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void driveStraightandSafe(double power) {
    	rightMotor.set(power);
    	leftMotor.set(-power);
    	
    }
    
    public void drive(double leftPower, double rightPower) {
    	rightMotor.set(rightPower);
    	leftMotor.set(-leftPower);
    }
}

