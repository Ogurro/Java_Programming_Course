package learning.java;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Song {

    private String tittle;
    private String duration; // minutes:seconds

    public Song(String tittle, String duration) {
        this.tittle = tittle.toLowerCase();
        setDuration(duration);
    }

    public String getTittle() {
        return this.tittle;
    }

    public String getDuration() {
        return this.duration;
    }

    private void setDuration(String duration) {
        String regex = "^([\\d]{0,2}:[\\d]{0,2})$";
        if (Pattern.matches(regex, duration)){
            if (duration.length() < 5){
                String[] durationArray = duration.split(":");
                if (durationArray.length == 1) {
                    durationArray = Arrays.copyOf(durationArray, 2);
                    durationArray[1] = "00";
                } else if (durationArray.length == 0) {
                    durationArray = new String[] {"00", "00"};
                }
                for (int i = 0; i < durationArray.length; i++) {
                    if ((durationArray[0].length() == 2) && (durationArray[1].length() == 2)){
                        break;
                    }
                    int valueLength = 2 - durationArray[i].length();
                    durationArray[i] = (valueLength == 1) ? ("0" + durationArray[i]) : ((valueLength == 2) ? ("00") : (durationArray[i]));
                }
                duration = String.format("%s:%s", durationArray[0], durationArray[1]);
            }
        } else {
            duration = "00:00";
        }
        this.duration = duration;
    }

    public String getInfo(){
        return String.format("Tittle: %s, duration: %s", this.getTittle(), this.getDuration());
    }
}
