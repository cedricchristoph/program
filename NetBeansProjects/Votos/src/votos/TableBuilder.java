/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package votos;

import java.util.Arrays;

/**
 *
 * @author Inf2
 */
public class TableBuilder {
    
    private int colSize = 0;
    private boolean userSetSize;
    
    public TableBuilder(){
        userSetSize = false;
    }
    public TableBuilder(int size){
        colSize = size;
        userSetSize = true;
    }
    
    public void setSize(int size){
        colSize = size;
        userSetSize = true;
    }
    
    public void setSizeToAutomatic(){
        colSize = 0;
        userSetSize = false;
    }
    
    public void printHeaders(String... headers){
        int maxSize = 0;
        
        if (!(userSetSize)){
            for (String header : headers){
            if (header.length()>maxSize)
                maxSize = header.length();
            }
            if (!(checkEven(maxSize)))
                maxSize+=1;
        
            colSize = maxSize + 4;   
        }
        print(headers, colSize, true);
    }
    
    public void printHeaders(String[] headers, String... orientations){
        int maxSize = 0;
        
        if (!(userSetSize)){
            for (String header : headers){
            if (header.length()>maxSize)
                maxSize = header.length();
            }
            if (!(checkEven(maxSize)))
                maxSize+=1;
        
            colSize = maxSize + 4;   
        }
        
        print(headers, colSize, true, orientations);
    }
    
    public void printRow(String... data){
        if (colSize == 0){
            System.out.println("ERROR: No headers found! Please print some headers first.");
        }else{
            print(data, colSize, false);
        }
    }
    
    public void printRow(String[] data, String... orientations){
        if (colSize == 0){
            System.out.println("ERROR: No headers found! Please print some headers first.");
        }else{
            if (orientations.length!=data.length){
                orientations = new String[1];
                orientations[0] = "center";
            }
            print(data, colSize, false, orientations);
        }
    }
    
    
    public void printMultiLineElement(String text){
       // THIS FUNCTION IS MEANT TO BE USED AS TO PRINT A MULTI-LINE TEXT
       // INSIDE A BOX WITH A TITLE ON TOP
       
        String[] lines;
        String tmpText = text;
        int lineCount = 0;
        int maxLineLength = colSize-2;
        // COUNT HOW MANY LINES THERE WILL BE
        
        lineCount = (text.length()/(maxLineLength))+1;
        lines = new String[lineCount];
        
        for (int i=0; i<lineCount; i++){
            int startIndex = i*maxLineLength;
            int endIndex = startIndex + maxLineLength;
            try{
                lines[i] = text.substring(startIndex, endIndex);
            }catch(Exception ex){
                lines[i] = text.substring(startIndex);
            }
        }
        for (int i=0; i<lines.length; i++){
            printRowElement(lines[i], colSize, "left", 0);
            System.out.print("|\n");
        }
        
        // PRINT LOWER LINES
            for (int i=0; i<1; i++){
                System.out.print("+");
                for(int j=1; j<=colSize; j++){
                    System.out.print("-");
                }
                if(i==(1-1))
                    System.out.print("+\n\n");
            }
    
    }
    
    
    private void print(String[] headers, int size, boolean isHeader, String... orientations){
        int colCount = headers.length;
        
        // CHECK IF ALL HEADERS ARE OKEY IN LENGTH
        boolean headersOk = true;
        //for (String header : headers){
        //    if (header.length()>size)
        //        headersOk = false;
        //}
        
        if (headersOk){
            
            //PRINT UPPER LINES
            if (isHeader){
                for (int i=0; i<colCount; i++){
                    System.out.print("+");
                    for(int j=1; j<=size; j++){
                        System.out.print("-");
                    }
                    if(i==(colCount-1))
                    System.out.print("+\n");
                }
            }
            
            for (int i=0; i<headers.length; i++){
                try{
                    printRowElement(headers[i], colSize, orientations[i], headers.length);
                }catch (Exception ex){
                    if (orientations.length == 1){
                        printRowElement(headers[i], colSize, orientations[0], headers.length);
                    }else{
                        printRowElement(headers[i], colSize, "center", headers.length);
                    }
                }
            }
            
            System.out.print("|\n");
            
            
            // PRINT LOWER LINES
            for (int i=0; i<colCount; i++){
                System.out.print("+");
                for(int j=1; j<=size; j++){
                    System.out.print("-");
                }
                if(i==(colCount-1))
                    System.out.print("+\n");
            }
            
        }else{
            System.out.println("The headers are too long");
        }
    }
    
    private void printRowElement(String element, int size, String orientation, int totalElements){
        // ELEMENT WILL BE PRINTED AS DATA ON SCREEN
        // SIZE IS THE MAX WIDTH OF THE COLUMN
        // ORIENTATION MUST BE "left", "center" or "right"
        int charCount = element.length();
        int spacesOnEachSide = (((size)-charCount)/2);
        boolean isEven = checkEven(charCount);
        
        if (element.length()>=size){
            element = element.substring(0, size-4);
            element = element + "...";
        }
        
        switch(orientation){
            case "left":
                charCount = element.length();
                spacesOnEachSide = (((size)-charCount)/2);
                System.out.print("|");
                isEven = checkEven(charCount);
                if (isEven){
                    System.out.print(" ");
                    System.out.print(element);
                    for (int k=0; k<(spacesOnEachSide+(spacesOnEachSide - 1)); k++){
                        System.out.print(" ");
                    }
                }else{

                    System.out.print(" ");

                    System.out.print(element);
                    for (int k=0; k<spacesOnEachSide+spacesOnEachSide; k++){
                        System.out.print(" ");
                    }
                }
                break;
            case "center":
                charCount = element.length();
                spacesOnEachSide = (((size)-charCount)/2);
                System.out.print("|");
                isEven = checkEven(charCount);
                if (isEven){
                    for (int j=0; j<spacesOnEachSide; j++){
                        System.out.print(" ");
                    }
                    System.out.print(element);
                    for (int k=0; k<spacesOnEachSide; k++){
                        System.out.print(" ");
                    }
                }else{
                    for (int j=0; j<spacesOnEachSide; j++){
                        System.out.print(" ");
                    }
                    System.out.print(element);
                    for (int k=0; k<spacesOnEachSide+1; k++){
                        System.out.print(" ");
                    }
                }
                break;
            case "right":
                charCount = element.length();
                spacesOnEachSide = (((size)-charCount)/2);
                System.out.print("|");
                isEven = checkEven(charCount);
                if (isEven){
                    for (int j=0; j<spacesOnEachSide+(spacesOnEachSide-1); j++){
                        System.out.print(" ");
                    }
                    System.out.print(element);
                    System.out.print(" ");
                }else{
                    for (int j=0; j<spacesOnEachSide+spacesOnEachSide; j++){
                        System.out.print(" ");
                    }
                    System.out.print(element);
                    System.out.print(" ");
                }
                break;
            default:
                System.out.println("ERROR: orientation variable is not correct\n");
        }
    }
    

    public static boolean checkEven(int input){
        if ((input % 2)==0){
            return true;
        }else{
            return false;
        }
    }
}
