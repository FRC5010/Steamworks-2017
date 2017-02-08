package org.usfirst.frc.team5010.robot;

import org.usfirst.frc.team5010.oi.JoystickAnalogButton;
import org.usfirst.frc.team5010.robot.commands.EmptyBallIntake;
import org.usfirst.frc.team5010.robot.commands.ExtendGearHolder;
import org.usfirst.frc.team5010.robot.commands.LoadBallIntake;
import org.usfirst.frc.team5010.robot.commands.RetractGearHolder;
import org.usfirst.frc.team5010.robot.commands.ShootHighGoalBall;
import org.usfirst.frc.team5010.robot.commands.ShootLowGoalBall;
import org.usfirst.frc.team5010.robot.commands.SwitchDriveMode;
import org.usfirst.frc.team5010.robot.commands.VisionStart;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick joyDriver = new Joystick(0);
	public Joystick joyCoDriver = new Joystick(1);
	
	private Button buttonB = new JoystickButton(joyDriver, 2);
	private Button buttonA = new JoystickButton(joyDriver, 1);
	private Button buttonCoDX = new JoystickButton(joyCoDriver, 3);
	private Button buttonCoDY = new JoystickButton(joyCoDriver, 4);
	private Button buttonBack = new JoystickButton(joyDriver, 7);
	private Button buttonStart = new JoystickButton(joyDriver, 8);
	private JoystickAnalogButton leftCoDTrigger = new JoystickAnalogButton(joyCoDriver, 2);
	private JoystickAnalogButton rightCoDTrigger = new JoystickAnalogButton(joyCoDriver, 3);
	private Button buttonY = new JoystickButton(joyDriver, 4);
	
	/**
	 * Default constructor.
	 */
	public OI () {
		buttonB.whenReleased(new SwitchDriveMode());
	
		buttonStart.whenPressed(new ExtendGearHolder());
		buttonBack.whenPressed(new RetractGearHolder());
		
		buttonY.whenPressed(new VisionStart());

		buttonCoDX.whenPressed(new ShootLowGoalBall());
		buttonCoDY.whenPressed(new ShootHighGoalBall());

		rightCoDTrigger.whenPressed(new LoadBallIntake());
		leftCoDTrigger.whenPressed(new EmptyBallIntake());
		
		
	}
	
}
