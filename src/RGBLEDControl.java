import com.diozero.api.*;
import com.diozero.api.function.*;

public class RGBLEDControl {
    public static void main(String[] args) {
        // Specify the GPIO pins for the RGB LED (change these to match our setup)
        int redPin = 17;    // GPIO pin for red color
        int greenPin = 18;  // GPIO pin for green color
        int bluePin = 22;   // GPIO pin for blue color

        try (DigitalOutputDevice red = GpioFactory.getInstance().provisionDigitalOutputDevice(redPin, PinState.LOW);
             DigitalOutputDevice green = GpioFactory.getInstance().provisionDigitalOutputDevice(greenPin, PinState.LOW);
             DigitalOutputDevice blue = GpioFactory.getInstance().provisionDigitalOutputDevice(bluePin, PinState.LOW)) {

            // Change the colors of the RGB LED by setting the states of the individual color pins
            while (true) {
                // Red
                red.on();
                green.off();
                blue.off();
                sleep(1000);

                // Green
                red.off();
                green.on();
                blue.off();
                sleep(1000);

                // Blue
                red.off();
                green.off();
                blue.on();
                sleep(1000);

                // Yellow (Red + Green)
                red.on();
                green.on();
                blue.off();
                sleep(1000);

                // Purple (Red + Blue)
                red.on();
                green.off();
                blue.on();
                sleep(1000);

                // Cyan (Green + Blue)
                red.off();
                green.on();
                blue.on();
                sleep(1000);

                // White (Red + Green + Blue)
                red.on();
                green.on();
                blue.on();
                sleep(1000);
            }
        }
    }

    // Helper method to sleep for a specified number of milliseconds
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
