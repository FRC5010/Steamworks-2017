package org.usfirst.frc.team5010.robot.subsystems;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jackson Lee
 * @since January 28, 2017
 */
public class GearHolder extends Subsystem {
	// TODO uncomment GearHolderPiston code when Pneumatic Control available.
	//DoubleSolenoid GearHolderPiston = null;
	
	/**
	 * Default constructor.
	 */
	public GearHolder(){
		// TODO uncomment GearHolderPiston code when Pneumatic Control available.
		//GearHolderPiston = new DoubleSolenoid(1, 2);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void extendGearHolder() {
		// TODO uncomment GearHolderPiston code when Pneumatic Control available.
		//GearHolderPiston.set(DoubleSolenoid.Value.kForward);
		//GearHolderPiston.set(DoubleSolenoid.Value.kOff);
		System.out.println("Temporary notification of extending gear holder.");
	}

	public void retractGearHolder() {
		// TODO uncomment GearHolderPiston code when Pneumatic Control available.
		//GearHolderPiston.set(DoubleSolenoid.Value.kReverse);
		//GearHolderPiston.set(DoubleSolenoid.Value.kOff);
		System.out.println("Temporary notification of retracting gear holder.");
	}

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
