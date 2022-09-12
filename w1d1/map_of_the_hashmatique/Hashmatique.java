import java.util.HashMap;
import java.util.Set;
public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Watermelon Sugar","Watermelon sugar high");
        trackList.put("Talking to the Moon","Talking to the moon. Trying to get to you");
        trackList.put("Dynamite", "'Cause I-I-I'm in the stars tonight");
        trackList.put("There's Nothing Holdin' Me Back","Baby, there's nothing holdin' me back");

        //get the keys by using the keyset method
        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + trackList.get(key));
        }
    }
}


