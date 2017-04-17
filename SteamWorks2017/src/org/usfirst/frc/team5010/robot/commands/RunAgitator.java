package org.usfirst.frc.team5010.robot.commands;

import org.usfirst.frc.team5010.robot.Robot;
import org.usfirst.frc.team5010.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunAgitator extends Command {

//	long startTime;
//	long currentTime;
//	double agitatorTime;
	
//	boolean agitatorDirection;
	
    public RunAgitator() {
        // Use requires() here to declare subsystem dependencies
        requires(RobotMap.agitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//TODO ball agitator is new subsytem. w/ new snow blower motor. only one direction needed
//    	agitatorTime = SmartDashboard.getNumber("agitator time", 200);
//    	agitatorDirection = true;
    	
    	
    	//startTime = System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	currentTime = System.currentTimeMillis();
//    	if(currentTime > startTime + agitatorTime){
//    		if(agitatorDirection){
//    			agitatorDirection = false;
//    			RobotMap.agitator.moveToDegree(0);
//    		}else{
//    			agitatorDirection = true;
//    			RobotMap.agitator.moveToDegree(170);
//    		}
//    		startTime = currentTime;
//    	}
    	
    	RobotMap.agitator.setSpeed(1);
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	 if(Robot.oi.joyDriver.getRawButton(2)) {
         	return false;
         }
         else {
         	return true;
         }
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.agitator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
