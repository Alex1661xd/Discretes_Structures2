package com.example.demo.Classes;

import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyHandler {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    private Canvas gc;
    public KeyHandler(Canvas gc) {
        this.gc = gc;
        initializeKeyHandlers();
    }
    /**
     * Initializes the key handlers for the GameController1 instance.
     */
    private void initializeKeyHandlers() {
        gc.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.UP||keyEvent.getCode() == KeyCode.W) {
                upPressed = true;
            }
            if (keyEvent.getCode() == KeyCode.DOWN||keyEvent.getCode() == KeyCode.S) {
                downPressed = true;
            }
            if (keyEvent.getCode() == KeyCode.RIGHT||keyEvent.getCode() == KeyCode.D) {
                rightPressed = true;
            }
            if (keyEvent.getCode() == KeyCode.LEFT||keyEvent.getCode() == KeyCode.A) {
                leftPressed = true;
            }
        });

        gc.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (keyEvent.getCode() == KeyCode.UP||keyEvent.getCode() == KeyCode.W) {
                upPressed = false;
            }
            if (keyEvent.getCode() == KeyCode.DOWN||keyEvent.getCode() == KeyCode.S) {
                downPressed = false;
            }
            if (keyEvent.getCode() == KeyCode.RIGHT||keyEvent.getCode() == KeyCode.D) {
                rightPressed = false;
            }
            if (keyEvent.getCode() == KeyCode.LEFT||keyEvent.getCode() == KeyCode.A) {
                leftPressed = false;
            }
        });
    }
}
