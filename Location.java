import java.util.HashMap;
/**
 * Class Location - a Location in an adventure game.
 *
 * This class is part of the "SportyZombies" application. 
 * "SportyZombies" is a very simple, text based adventure game.  
 *
 * A "Location" represents one location in the scenery of the game.  It is 
 * connected to other Locations via exits.  The exits are stored in a Map.
 * Each map entry consists of an exit name and the Location the exit leads to.
 * 
 * @author  David Panagiotopulos and Luis Hankel
 * @version 2018.01.15
 */
public class Location 
{
    private HashMap<String, Location> exits;
    private String description;

    /**
     * Create a Location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The Location's description.
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Add an exit to the Location.
     */
    public void addExit(String name, Location exit) 
    {
        exits.put(name, exit);
    }

    /**
     * @return The description of the Location.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Gets the long description of the Location. It consists of the description 
     * plus a list of all exits.
     * @return The long description of the Location.
     */
    public String getLongDescription()
    {
        return "You are " + getDescription() + "\n" + getExits();
    }
    
    /**
     * Gets a list of all exits available for this Location.
     * @return The exits available.
     */
    public String getExits(){
        String allExits = "Exits: ";
        for(String name : exits.keySet()){
            allExits += name + ", ";
        }
        allExits = allExits.replaceAll(", $","");
        
        return allExits;
    }
    
    /**
     * Gets the Location an exit leads to.
     * @return The Location the exit leads to.
     */
    public Location getExit(String exit){
        return exits.get(exit);
    }
}
