import DIOZero
public class LEDColorController { // Public or private?
    public static void main(String[] args) throws InterruptedException { // throws InterruptedException for color change
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Red", PinState.LOW);
        GpioPinDigitalOutput bluePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Blue", PinState.LOW);
        GpioPinDigitalOutput greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Green", PinState.LOW);

        try {
            // Change LED colors in a loop, we can change this to fit.
            while (true) {
                redPin.toggle();
                TimeUnit.SECONDS.sleep(1); // all three of these are pausing for 1 second before changing
                bluePin.toggle(); // Have to choose colors or repeat this for more color options
                TimeUnit.SECONDS.sleep(1); // change second to fit whatever we want
                greenPin.toggle();
                TimeUnit.SECONDS.sleep(1);
            }
        } finally {
            gpio.shutdown();
        }
    }
}
