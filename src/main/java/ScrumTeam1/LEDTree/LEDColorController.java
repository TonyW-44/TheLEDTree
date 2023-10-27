package ScrumTeam1.LEDTree;


//import com.pi4j.io.gpio.*; // imports the Pi4j that needs to be installed on the raspberry pi
//import java.util.concurrent.TimeUnit; // this is a time related operation for sleeping threads

public class LEDColorController { // Public or private?
    /*
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

 */
}



