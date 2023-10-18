package com.eventHive.utils;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.http.Part;

public class eventUtils {
	
	public static String saveImageToFolder(Part part, String fileName) throws IOException {
		
        String path = "E:/Projects/Java Web Applications/EventHive_Project/src/main/webapp/assets/eventBanners/" + fileName;
        File file = new File(path);
        
        try {
            part.write(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return path;
    }
	
	

}
