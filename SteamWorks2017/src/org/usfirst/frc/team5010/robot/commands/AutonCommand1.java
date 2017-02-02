package org.usfirst.frc.team5010.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonCommand1 extends CommandGroup {

    public AutonCommand1() {
    	
    	//can't have same command repeated.
    	DriveForwardUntilDistance step1 = new DriveForwardUntilDistance();
    	step1.setPoint(6);
    	TurnToAngle step2 = new TurnToAngle();
    	step2.setPoint(-90);
    	TurnToAngle step3 = new TurnToAngle();
    	step3.setPoint(90);
    	addSequential(step1);
    	addSequential(step2);
//    	addSequential(step1);
//    	addSequential(step3);
//    	addSequential(step1);
//    	addSequential(step3);
//    	addSequential(step1);
//    	addSequential(step3);
//    	addSequential(step1);
//    	addSequential(step3);
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
