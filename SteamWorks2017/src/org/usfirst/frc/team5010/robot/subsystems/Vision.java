package org.usfirst.frc.team5010.robot.subsystems;

import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Vision() {
		RobotMap.camera = CameraServer.getInstance();
	}

	public void startFrontVision() {
		RobotMap.camera.addServer("FrontCamera", 0);
		RobotMap.camera.startAutomaticCapture("FrontCamera", 0);
	}

	public void startRearVision() {
		RobotMap.camera.addServer("RearCamera", 1);
		RobotMap.camera.startAutomaticCapture("RearCamera", 1);
	}

	public void stopFrontVision() {
		if (null != RobotMap.camera) {
			RobotMap.camera.removeCamera("FrontCamera");
			RobotMap.camera.removeServer("FrontCamera");
		}
	}

	public void stopRearVision() {
		if (null != RobotMap.camera) {
			RobotMap.camera.removeCamera("RearCamera");
			RobotMap.camera.removeServer("RearCamera");
		}
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

