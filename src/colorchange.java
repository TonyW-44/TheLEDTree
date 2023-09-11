import com.pi4j.io.gpio.*; // imports the Pi4j that needs to be installed on the raspberry pi
import java.util.concurrent.TimeUnit; // this is a time related operation for sleeping threads

public class LEDColorController { // self explanatory
    public static void main(String[] args) throws InterruptedException { // throws InterruptedException for color change
        GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Color", PinState.LOW);
        GpioPinDigitalOutput greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Color", PinState.LOW);
        GpioPinDigitalOutput bluePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Color", PinState.LOW);

        try {
            // Change LED colors in a loop, we can change this to fit.
            while (true) {
                colorPin.toggle();
                TimeUnit.SECONDS.sleep(1); // all three of these are pausing for 1 second before changing
                colorPin.toggle();
                TimeUnit.SECONDS.sleep(1); // change second to fit whatever we want
                colorPin.toggle();
                TimeUnit.SECONDS.sleep(1);
            }
        } finally {
            gpio.shutdown();
        }
    }
}
