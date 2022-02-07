import java.awt.*;

public abstract class CarTransport extends Car {

    private Ramp ramp;

    /***
     * Constructor for CarTransport.
     * @param nrDoors the number of cars the carTransport will have.
     * @param enginePower the power of the engine.
     * @param color the color of the carTransport.
     * @param modelName the name of the carTransport.
     * @param size the size of the carTransport.
     * @param rampSizeLimit the size limit of the platform.
     */
    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double size, double rampSizeLimit) {
        super(nrDoors, enginePower, color, modelName, size);
        ramp = new Ramp(rampSizeLimit, this);
    }

    //Following methods are solely used to extend the range of the ramp methods.
    public void lowerRamp() {ramp.lowerRamp();}
    public void raiseRamp() {ramp.raiseRamp();}
    public String getCurrentRampState() {return ramp.getCurrentRampState();}

    /***
     * checks if car is in range to be loaded onto the Ramp
     * @param car the car which we want to check the range of
     * @return
     */


    /***
     * loads car onto the Ramp, unless the car is out of range, or the car is another carTransport.
     * @param car the car which is to be loaded
     */
    public void loadItem(Car car) {ramp.loadItem(car);}
    public Car unLoadItem() {return ramp.unLoadItem();}
    public Car peek() {return ramp.peek();}

    /***
     * changes coordinates of the CarTransport and all loaded vehicles, based on angle and currentSpeed.
     */
    public void move() {
        double newX = getX() + getCurrentSpeed() * Math.cos(getAngle());
        double newY = getY() + getCurrentSpeed() * Math.sin(getAngle());
        setX(newX);
        setY(newY);
        ramp.setX(newX);
        ramp.setY(newY);
        for (Car car : ramp.getStack()) {
            car.setX(newX);
            car.setY(newY);
        }
    }


    /***
     * The unique speed factor of all CarTransports
     * @return speedFactor
     */
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }



}
