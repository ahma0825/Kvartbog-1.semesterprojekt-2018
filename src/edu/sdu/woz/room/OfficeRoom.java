/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sdu.woz.room;

import edu.sdu.woz.Game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;

/**
 *
 * @author jesperisgaard
 */
public class OfficeRoom extends Room {

    private static final String SCREECH1 = "/screech.wav";
    private static final String SCREECH2 = "/screech2.wav";
    private boolean answered = false;
    
    public OfficeRoom(Game game, Point pos) {
        super(game, pos);
    }

    public String answer() {
        if (!answered){
            answered = true;
            playSound(SCREECH1);
            return "You pick up the phone, put it to your ear and a spooky sound comes from the phone.";
        } else{
            playSound(SCREECH2);
            return "You pick up the phone again and you hear another spooky sound.";
        }
    }
    
    @Override
    public String examine() {
        if (!answered){
        return "You are in an office. In one side of the room there's a large desk with a revolving chair turned away."
                +"\nOn the desk is an old rotary phone, ringing endlessly";
        } else{
            return "You're in the office.";
        }
    }

    private void playSound(final String name) {
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                        OfficeRoom.class.getResourceAsStream(name));
                clip.open(inputStream);
                clip.start();
            } catch (Exception e) {
                // It seems not all JVMs likes the first screech
                if (toString().equals(SCREECH1)) {
                    playSound(SCREECH2);
                }
            }
        }).start();
    }
    
}
