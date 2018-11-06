package frc.robot;


/**
 * 
 * @author Nate Christensen
 */
public class SwerveDrive extends Swerve {
    Swerve fLeft,fRight,rLeft,rRight;
    public SwerveDrive(Swerve fls, Swerve frs, Swerve rls, Swerve rrs){
        fLeft=fls;
        fRight=frs;
        rLeft=rls;
        rRight=rrs;
    }
    /**
     * Drive method for Swerve Drive platform.
     *
     * <p>Angles are measured clockwise from the positive X axis. The robot's speed is independent
     * from its angle or rotation rate.
     *
     * @param ySpeed    The robot's speed along the Y axis [-1.0..1.0]. Right is positive.
     * @param xSpeed    The robot's speed along the X axis [-1.0..1.0]. Forward is positive.
     * @param zRotation The robot's rotation rate around the Z axis [-1.0..1.0]. Clockwise is
     *                  positive.
     */
    public void Drive(double xSpeed, double ySpeed, double zRotation){
        double x=limit(xSpeed),
            y=limit(ySpeed),
            z=limit(zRotation);
        int rotateAngle = RotateAngle(x, y);
        double flSpeed,
            frSpeed,
            rlSpeed,
            rrSpeed;
        
        //Rotate each Swerve to correct angle
        fLeft.Rotate(rotateAngle);
        fRight.Rotate(rotateAngle);
        rLeft.Rotate(rotateAngle);
        rRight.Rotate(rotateAngle);

        //Determines the power for each wheel
        flSpeed = WheelPower(x,y)+z;
        frSpeed = WheelPower(x,y)-z;
        rlSpeed = WheelPower(x,y)+z;
        rrSpeed = WheelPower(x,y)-z;

        //Makes sure that speed is bewteen -1 and 1
        double[] speed = {flSpeed,frSpeed,rlSpeed,rrSpeed};
        normalize(speed);
        flSpeed = speed[0];
        frSpeed = speed[1];
        rlSpeed = speed[2];
        rrSpeed = speed[3];

        //Sets the SwerveDrive power
        fLeft.Drive(flSpeed);
        fRight.Drive(frSpeed);
        rLeft.Drive(rlSpeed);
        rRight.Drive(rrSpeed);
    }

}