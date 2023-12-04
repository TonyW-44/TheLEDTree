package ScrumTeam1.LEDTree;

import com.pi4j.io.gpio.*;
import java.util.concurrent.TimeUnit;

/*
Ok so here is how this rewritten class works. toggleAndSleep governs
the on/off state of each pin. toggleAndSleep is used in the colorChange
method to switch between colors. runColorSequence then uses the colorChange method
in a loop to flip between colors making a sequence. There is a sequence shutdown method
that I've been meaning to write
 */


public class LEDColorController {
    // Light sequence class

    // variable where Gpio can store pin values

    private GpioController gpio;
    private GpioPinDigitalOutput redPin;
    private GpioPinDigitalOutput bluePin;
    private GpioPinDigitalOutput greenPin;



    // Constructor that initializes each color pin with the variables. Because I had trouble understanding how
    // Gpio works, and I was lazy I asked chatGPT to help me set this up
    public LEDColorController() {
        gpio = GpioFactory.getInstance();
        redPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "Red", PinState.LOW);
        bluePin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "Blue", PinState.LOW);
        greenPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "Green", PinState.LOW);
    }

    // This method uses a switch to switch each color. It is used in the loop to create
    // a x-mas light type light sequence.
    public void changeColor(LEDColor color) throws InterruptedException {
        switch (color) {
            case RED:
                toggleAndSleep(redPin);
                break;
            case BLUE:
                toggleAndSleep(bluePin);
                break;
            case GREEN:
                toggleAndSleep(greenPin);
                break;
        }
    }

    // This is the actual sequence!!! This can be used with the switch above to create other light
    // sequences. I'll add two more after we know this works.
    public void runColorSequence(int sequenceCount, int colorDuration, int breakDuration) throws InterruptedException {
        //int sequenceCount = 20; // The break condition for the loop
        //int colorDuration = 2; // In seconds
        //int breakDuration = 1; // In seconds - This is the time between colors.

        for (int i = 0; i < sequenceCount; i++) {
            changeColor(LEDColor.RED);
            changeColor(LEDColor.BLUE);
            changeColor(LEDColor.GREEN);

            // Condition set to ensure that a break is not added after the last iteration of the loop
            if (i < sequenceCount - 1) {
                // If not the last iteration, add a break
                TimeUnit.SECONDS.sleep(breakDuration);
                // ^ This means that the loop will pause/sleep for the time amount
                // specified in breakDuration
            }
        }
    }

    // This method toggles the pins for the changeColor method
    private void toggleAndSleep(GpioPinDigitalOutput pin) throws InterruptedException {
        pin.toggle();
        TimeUnit.SECONDS.sleep(1);
    }

    // This is the shutdown method I've been meaning to write
    public void shutdown() {
        gpio.shutdown();
    }

    // This is an enumeration method. I had to add this in order to make the code a little more
    //human-readable. This method also apparently makes the color "types" type safe.
    // This was a suggested addition when I asked the ai to look over my code.
    // I need to learn more about this so don't ask me to explain outside of the narrow use here.
    public enum LEDColor {
        RED,
        BLUE,
        GREEN
    }
}





