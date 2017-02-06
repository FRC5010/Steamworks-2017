package org.usfirst.frc.team5010.robot.subsystems;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team5010.robot.GripPipelinepeg;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class Vision extends Subsystem {
	private final UsbCamera camera0;

	private VisionThread visionThread;
	private final Object imgLock = new Object();
	private double centerX = 0.0;

	// Put methods for controlling this subsystem
	// here. Call these from Commands
	public Vision() {
		camera0 = RobotMap.camera.startAutomaticCapture();
	}

	public void startVision() {
		// camera.startAutomaticCapture(1);
		camera0.setResolution(320, 240);
		// GripPipelinepeg needs to implement VisionPipeline (GripPipelinepeg implements VisionPipeline)
		visionThread = new VisionThread(camera0, new GripPipelinepeg(), pipeline -> {
			if (!pipeline.filterContoursOutput().isEmpty()) {
				// Write a function that takes an ArrayList<MatOfPoint> and processes the screen objects
				processScreenContours(pipeline.filterContoursOutput());
			}
		});

	}
	public void readX() {
		double centerX;
		synchronized (imgLock){
			centerX = this.centerX;
		}
	}

	private void processScreenContours(ArrayList<MatOfPoint> contourList) {
		// This function will loop over the list and pick out the 2 target contours
		// It will then store information for a vision targeting command which can be used to drive the robot
		// That information should also be output to the smart dashboard for operator targeting
		Rect r = Imgproc.boundingRect(contourList.get(0));
		synchronized (imgLock) {
			centerX = r.x + (r.width / 2);
		}
	}
	
	public void stop() {
		visionThread.stop();
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
