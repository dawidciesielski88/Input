package com.dawidciesielski;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void main(String[] args) throws IOException {

        try (FileWriter locFile = new FileWriter("locations.txt");
             FileWriter dirFile = new FileWriter("directions.txt")) {
            for (Location location : locations.values()) {
                locFile.write(location.getLOCATION_ID() + "," + location.getDESCRIPTION() + "\n");
                for (String direction : location.getEXITS().keySet()) {
                    dirFile.write(location.getLOCATION_ID() + "," + direction + "," + location.getEXITS().get(direction) + "\n");
                }
            }
        }

//        FileWriter localFile = null;
//
//        try {
//            localFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                localFile.write(location.getLOCATION_ID() + "," + location.getDESCRIPTION() + "\n");
//            }
//
//        } finally {
//            System.out.println("In finally block");
//
//            if (localFile != null) {
//                localFile.close();
//            }
//        }
    }

    static {
        Map<String, Integer> tempExit = new HashMap<>();
        tempExit.put("W", 2);
        locations.put(0, new Location(0, "You are waking up in a strange dark place. There are door and you can see light in key hole", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are inside the tunnel", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are inside the mine", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside the cave", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are inside the lair with some kind of monster watching in the dark", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are on the fresh air inside a forest", tempExit));

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
