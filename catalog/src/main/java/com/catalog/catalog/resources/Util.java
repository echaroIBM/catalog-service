package com.catalog.catalog.resources;

import java.util.HashMap;
import java.util.List;

import com.catalog.catalog.model.Task;

public class Util {

    private static final HashMap<String, List<Task>> map = new HashMap<>();
    private static Util instance;


    public static synchronized Util getInstance() {
    	if(instance == null) {
    		instance = new Util();
    	}
    	return instance;
    } 
    


    public List<Task> getValue(String key) {
        return map.get(key);
    }

    public void add(String key, List<Task> tasks) {
        map.put(key, tasks);
        
    }

}

