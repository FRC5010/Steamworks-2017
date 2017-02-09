
package org.usfirst.frc.team5010.robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5010.robot.GripPipelinepeg;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class Vision extends Subsystem {
	private static final String REAR_CAMERA = "RearCamera";

	private static final String FRONT_CAMERA = "FrontCamera";

	private UsbCamera camera0 = null;
	private UsbCamera camera1 = null;
	
	private VisionThread visionThread;
	private final Object imgLock = new Object();
	private double centerX = 0.0;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Vision() {
		//RobotMap.camera = CameraServer.getInstance();
	}

	public void startFrontVision() {
		if (null == camera0) {
			camera0 = RobotMap.camera.startAutomaticCapture(FRONT_CAMERA, 0);
			camera0.setResolution(320, 240);
			camera0.setFPS(15);
		}
		RobotMap.camera.getVideo(FRONT_CAMERA).setEnabled(true);
	}

	public void startRearVision() {
		if (null == camera1) {
			camera1 = RobotMap.camera.startAutomaticCapture(REAR_CAMERA, 1);
			camera1.setResolution(160, 120);
			camera1.setFPS(10);
		}
		RobotMap.camera.getVideo(REAR_CAMERA).setEnabled(true);
	}

	public void stopFrontVision() {
		if (null != RobotMap.camera) {
			RobotMap.camera.getVideo(FRONT_CAMERA).setEnabled(false);
		}
	}

	public void stopRearVision() {
		if (null != RobotMap.camera) {
			RobotMap.camera.getVideo(REAR_CAMERA).setEnabled(false);
		}
	}

	public double getX() {
		double x;
		synchronized (imgLock) {
			x = centerX;
		}
		return x;
	}
	
	public void startTargeting() {
		SmartDashboard.putNumber("centerX", 0);
		System.out.println("Why isn't this working!");
		// GripPipelinepeg needs to implement VisionPipeline (GripPipelinepeg implements VisionPipeline)
		visionThread = new VisionThread(camera0, new GripPipelinepeg(), pipeline -> {
			if (!pipeline.filterContoursOutput().isEmpty()) {
				// Write a function that takes an ArrayList<MatOfPoint> and processes the screen objects
				processScreenContours(pipeline.filterContoursOutput());
			}
		});
		visionThread.start();
	}

	private void processScreenContours(ArrayList<MatOfPoint> contourList) {
		double localX;
		
		// This function will loop over the list and pick out the 2 target contours
		// It will then store information for a vision targeting command which can be used to drive the robot
		// That information should also be output to the smart dashboard for operator targeting
		Rect r = Imgproc.boundingRect(contourList.get(0));
		synchronized (imgLock) {
			centerX = r.x + (r.width / 2);
			localX = centerX;
		}
		
		SmartDashboard.putNumber("centerX", localX);
	}
	
	public void stop() {
		visionThread.stop();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
