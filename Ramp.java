public class Ramp extends Platform<Car> {


    private enum RampState {
        UP, DOWN
    }

    private RampState currentRampState;
    private final CarTransport carTransport;

    /***
     * Constructor for Ramp.
     * @param sizeLimit The maximum capacity in terms of size.
     * @param car The car object which has this ramp implemented.
     */
    public Ramp(double sizeLimit, CarTransport car) {
        super(30);
        currentRampState = RampState.UP;
        this.sizeLimit = sizeLimit;
        this.carTransport = car;
    }

    /***
     *Tells us if Ramp is currently up or down.
     */
    public String getCurrentRampState() {
        return "Ramp is " + currentRampState;
    }

    /***
     * Sets rampState to UP.
     */
    public void raiseRamp() {
        currentRampState = RampState.UP;
    }

    /***
     * Sets rampState to DOWN only if car is not moving.
     */
    public void lowerRamp() {
        if (carTransport.getCurrentSpeed() == 0) {
            currentRampState = RampState.DOWN;
        }
    }

    /***
     * Pushes the specified car object to stack, only if t
     * @param car specified to be loaded
     */
    public void loadItem(Car car) {
        if (currentRampState == RampState.DOWN){
            super.loadItem(car);
        }
    }

    /***
     * removes (pops) the last loaded car (the car at the top of the stack)
     */
    public Car unLoadItem() {
        if (currentRampState == RampState.DOWN) {
            double newX =  -1 * Math.cos(carTransport.getAngle());
            double newY =  -1 *  Math.cos(carTransport.getAngle());
           return super.unLoadItem(newX, newY);
        }
        else {
            throw new RuntimeException("Ramp is UP!");
        }}


}
