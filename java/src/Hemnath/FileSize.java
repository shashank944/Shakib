package Hemnath;

import java.io.File;

public class FileSize {
	



	    public static void main(String[] args) {
	        String filePath = "C:/Users/user/Downloads/feb_16th_2024_-_l3_tickets_release_note__ver_2.9.21.10_.pdf"; 
	        File file = new File(filePath);
            String fileType="kb";
            long bytes;
            double kb;
            double mb;
            String fileSize;
            
	        if (file.exists() && file.isFile() &&(fileType.contains("bytes")||fileType.contains("Bytes")||fileType.contains("BYTES"))) {
	          
	            bytes=getFileSizeInBytes(file);
	            fileSize=Long.toString(bytes)+" Bytes";
	            }
	        
	        else if (file.exists() && file.isFile() &&(fileType.contains("kb")||fileType.contains("Kb")||fileType.contains("KB"))) {
         kb= getFileSizeInKB(file);
         fileSize=Double.toString(kb)+" Kb";
               }
	        
	        else if (file.exists() && file.isFile() &&(fileType.contains("mb")||fileType.contains("Mb")||fileType.contains("MB"))) {
	           mb=getFileSizeInMB(file);
	           fileSize=Double.toString(mb)+" Mb";
	        } 
	        else {
	        	fileSize="File does not exist or is not a regular file.";
	        }
	        
	        System.out.println(fileSize);
	    }
	    

	    
	    public static long getFileSizeInBytes(File file) {
	        return file.length();
	    }

	   
	    public static double getFileSizeInKB(File file) {
	    return getFileSizeInBytes(file) / 1024.0;
	    }

	    
	    public static double getFileSizeInMB(File file) {
	        return getFileSizeInKB(file) / 1024.0;
	    }
	}

	

	
