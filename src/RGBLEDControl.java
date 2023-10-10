import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.diozero.util.SleepUtil;
import com.diozero.api.DigitalOutputDevice;
import com.diozero.api.GpioFactory;
import com.diozero.api.PinState;

public class RGBLEDControl {
    private static final Logger logger = LoggerFactory.getLogger(RGBLEDControl.class);
    public static void main(String[] args) {
        // Specify the GPIO pins for the RGB LED (change these to match our setup)
        int redPin = 18;    // GPIO pin for red color
        int greenPin = 22;  // GPIO pin for green color
        int bluePin = 37;   // GPIO pin for blue color

        DigitalOutputDevice red = null;
        DigitalOutputDevice green = null;
        DigitalOutputDevice blue = null;

        try {
            red = GpioFactory.getInstance().provisionDigitalOutputDevice(redPin, PinState.LOW);
            green = GpioFactory.getInstance().provisionDigitalOutputDevice(greenPin, PinState.LOW);
            blue = GpioFactory.getInstance().provisionDigitalOutputDevice(bluePin, PinState.LOW);

            // Change the colors of the RGB LED by setting the states of the individual color pins
            while (true) {
                // Red
                red.on();
                green.off();
                blue.off();
                SleepUtil.sleepMillis(1000);

                // Green
                red.off();
                green.on();
                blue.off();
                SleepUtil.sleepMillis(1000);

                // Blue
                red.off();
                green.off();
                blue.on();
                SleepUtil.sleepMillis(1000);

                // Yellow (Red + Green)
                red.on();
                green.on();
                blue.off();
                SleepUtil.sleepMillis(1000);

                // Purple (Red + Blue)
                red.on();
                green.off();
                blue.on();
                SleepUtil.sleepMillis(1000);

                // Cyan (Green + Blue)
                red.off();
                green.on();
                blue.on();
                SleepUtil.sleepMillis(1000);

                // White (Red + Green + Blue)
                red.on();
                green.on();
                blue.on();
                SleepUtil.sleepMillis(1000);
            }
        }
    }

    // Helper method to sleep for a specified number of milliseconds
        private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            logger.error("An error occurred", e);
        }
    }

}

