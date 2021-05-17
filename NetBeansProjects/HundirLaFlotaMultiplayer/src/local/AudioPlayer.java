package local;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Responsible for playing sounds
 * @author Cedric Christoph
 * @since 1.1.0
 * @version 1.0.0
 */
public class AudioPlayer {
    
    /**
     * File variables for each audio file
     */
    private File explosion, water, victory;
    
    /**
     * Boolean variables if sound should be playing and if audio is playing
     */
    private boolean activate, playing;
    
    /**
     * Clip variable
     */
    Clip clip;
    
    /**
     * AudioInputStream
     */
    AudioInputStream inputStream;
    
    /**
     * Constructor initializes the File variables and the activate boolean
     */
    public AudioPlayer() {
        explosion = new File("explosion.wav");
        water = new File("water.wav");
        victory = new File("himno.wav");
        activate = false;
    }
    
    /**
     * Method for playing the explosion sound.
     */
    public void explosion() {
        if (activate){
            try {
                clip = AudioSystem.getClip();
                inputStream = AudioSystem.getAudioInputStream(explosion);
                clip.open(inputStream);
                clip.start();
                playing = true;
            } catch (Exception ex) {
                System.out.println(ex.getLocalizedMessage());
            }
        }
    }
    
    /**
     * Method for playing the water blop sound.
     */
    public void water() {
        if (activate){
            try {
                clip = AudioSystem.getClip();
                inputStream = AudioSystem.getAudioInputStream(water);
                clip.open(inputStream);
                clip.start();
                playing = true;
            } catch (Exception ex) {
            
            }
        }
    }

    /**
     * Method for playing the winner hymn.
     */
    public void victory() {
        try {
            clip = AudioSystem.getClip();
            inputStream = AudioSystem.getAudioInputStream(victory);
            clip.open(inputStream);
            clip.start();
            playing = true;
        } catch (Exception ex) {
            
        }
    }
    
    /**
     * Stops the current audio
     */
    public void stop() {
        playing = false;
        clip.stop();
    }

    /**
     * Returns the explosion audio File
     * @return File explosion
     */
    public File getExplosion() {
        return explosion;
    }

    /**
     * Returns the water audio File
     * @return File water
     */
    public File getWater() {
        return water;
    }

    /**
     * Returns if audio is playing or not
     * @return Boolean true if playing
     */
    public boolean isPlaying() {
        return playing;
    }
    
    /**
     * Returns if audio is activated or not
     * @return Boolean is active
     */
    public boolean isActivate() {
        return activate;
    }

    /**
     * Returns clip object
     * @return Clip
     */
    public Clip getClip() {
        return clip;
    }

    /**
     * Returns AudioInputStream
     * @return 
     */
    public AudioInputStream getInputStream() {
        return inputStream;
    }

    /**
     * Method for changing the explosion file
     * @param explosion File explosion
     */
    public void setExplosion(File explosion) {
        this.explosion = explosion;
    }

    /**
     * Method for changing the water blop file
     * @param water File water
     */
    public void setWater(File water) {
        this.water = water;
    }

    /**
     * Method for changing active variables value
     * @param activate Boolean activate
     */
    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public void setInputStream(AudioInputStream inputStream) {
        this.inputStream = inputStream;
    }
    
    /**
     * Method for enabling audio.
     */
    public void enable() {
        activate = true;
    }
    
    /**
     * Method for disabling audio.
     */
    public void disable() {
        activate = false;
    }
}
