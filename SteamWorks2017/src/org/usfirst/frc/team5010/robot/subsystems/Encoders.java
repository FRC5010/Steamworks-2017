package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.commands.DriveForDistance;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Encoders extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Encoders encoder = new Encoders();
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveForDistance());
    }
}

