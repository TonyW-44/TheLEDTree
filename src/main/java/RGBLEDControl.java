import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.diozero.api.DigitalOutputDevice;
import com.diozero.api.GpioPullUpDown;
import com.diozero.api.GpioFactory;
import com.diozero.api.PinState;

import java.util.Objects;

// LEDColorController.java
public interface LEDColorController implements RGBLEDControl {
    void setColor(int red, int green, int blue);
    void turnOff();
}

// RGBLEDController.java
public class RGBLEDController implements LEDColorController {
    private final DigitalOutputDevice red;
    private final DigitalOutputDevice green;
    private final DigitalOutputDevice blue;

    public RGBLEDController(int redPin, int greenPin, int bluePin, GpioPullUpDown pullUpDown) {
        red = GpioFactory.getInstance().provisionDigitalOutputDevice(redPin, PinState.LOW, pullUpDown);
        green = GpioFactory.getInstance().provisionDigitalOutputDevice(greenPin, PinState.LOW, pullUpDown);
        blue = GpioFactory.getInstance().provisionDigitalOutputDevice(bluePin, PinState.LOW, pullUpDown);
    }

    @Override
    public void setColor(int red, int green, int blue) {
        // Implement the logic to set the LED color
        // You might want to use the provided parameters or modify this method as needed
        // For example, setting the intensity of each color based on the parameters
    }

    @Override
    public void turnOff() {
        // Implement the logic to turn off the LED
        red.off();
        green.off();
        blue.off();
    }

    // You can add more methods or functionality as needed

    public void close() {
        // Close GPIO resources when done
        red.close();
        green.close();
        blue.close();
    }
}

// RGBLEDControl.java
public class RGBLEDControl {
    private static final Logger logger = LoggerFactory.getLogger(RGBLEDControl.class);

    public static void main(String[] args) {
        // Specify the BCM GPIO pins for the RGB LED
        int redPin = 17;    // GPIO pin for red color (BCM 17)
        int greenPin = 18;  // GPIO pin for green color (BCM 18)
        int bluePin = 22;   // GPIO pin for blue color (BCM 22)

        GpioPullUpDown pullUpDown = GpioPullUpDown.PULL_DOWN;
        RGBLEDController rgbLEDController = new RGBLEDController(redPin, greenPin, bluePin, pullUpDown);

        try {
            // Change the colors of the RGB LED by setting the states of the individual color pins
            while (true) {
                // Red
                rgbLEDController.setColor(255, 0, 0);
                Thread.sleep(1000);

                // Green
                rgbLEDController.setColor(0, 255, 0);
                Thread.sleep(1000);

                // Blue
                rgbLEDController.setColor(0, 0, 255);
                Thread.sleep(1000);

                // Yellow (Red + Green)
                rgbLEDController.setColor(255, 255, 0);
                Thread.sleep(1000);

                // Purple (Red + Blue)
                rgbLEDController.setColor(255, 0, 255);
                Thread.sleep(1000);

                // Cyan (Green + Blue)
                rgbLEDController.setColor(0, 255, 255);
                Thread.sleep(1000);

                // White (Red + Green + Blue)
                rgbLEDController.setColor(255, 255, 255);
                Thread.sleep(1000);

                // Turn off
                rgbLEDController.turnOff();
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            logger.error("An error occurred", e);
        } finally {
            // Make sure to close the GPIO resources when done
            rgbLEDController.close();
        }
    }
}


