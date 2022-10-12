
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;

public class validation {

    @Test
    public void fourForeignPlayers() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("team/team.json");
        Object obj = jsonParser.parse(reader);
        JSONObject o = (JSONObject) obj;
        JSONArray array = (JSONArray)o.get("player");


        int count=0;
        for (int i = 0 ; i < array.size() ; i++){
            JSONObject player = (JSONObject) array.get(i);
            String country = (String) player.get("country");
            if (country.equals("India")){
                count = count + 1;
            }
        }
        Assert.assertEquals(count , 7);
    }

    @Test
    public void oneWicketKeeper() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("team/team.json");
        Object obj = jsonParser.parse(reader);
        JSONObject o = (JSONObject) obj;
        JSONArray array = (JSONArray)o.get("player");
        int count = 0;
        for (int i = 0; i < array.size(); i++){
            JSONObject player = (JSONObject) array.get(i);
            String role = (String) player.get("role");
            if (role.equals("Wicket-keeper")){
                count = count + 1;
            }
        }
        Assert.assertNotEquals(count, 0);
    }
}