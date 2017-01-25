package org.usfirst.frc.team5010.robot.subsystems;

//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearHolder extends Subsystem {
	// TODO uncomment GearHolderPiston code when Pneumatic Control available.
	//DoubleSolenoid GearHolderPiston = null;
	
	public GearHolder(){
		//GearHolderPiston = new DoubleSolenoid(1, 2);
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public void extendGearHolder() {
		//GearHolderPiston.set(DoubleSolenoid.Value.kForward);
		//GearHolderPiston.set(DoubleSolenoid.Value.kOff);
	}

	public void retractGearHolder() {
		//GearHolderPiston.set(DoubleSolenoid.Value.kReverse);
		//GearHolderPiston.set(DoubleSolenoid.Value.kOff);
	}

	public void initDefaultCommand() {

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
