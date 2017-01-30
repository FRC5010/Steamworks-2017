package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	private final CameraServer camera; 

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Vision() {
		this.camera = RobotMap.camera;
	}

	public void startVision() {
		camera.startAutomaticCapture(1);
		camera.startAutomaticCapture(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

