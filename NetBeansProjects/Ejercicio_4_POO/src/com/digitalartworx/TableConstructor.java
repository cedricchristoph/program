package com.digitalartworx;
public class TableConstructor {

    // CONSTRUCTION ELEMENTS //
    private byte[] columnSizes;
    private String[] orientations;

    // DESIGN ELEMENTS //
    private String lineSeparator;
    private String lineMarker;
    private String sectionSeparator;
    private String standardOrientation;

    private boolean allSameSizes;
    private boolean showLineMarker;
    private boolean showLineSeparator;
    private boolean showSectionSeparator;

    // CONSTRUCTORS //
    public TableConstructor() {
        columnSizes = new byte[0];
        orientations = new String[0];
        lineMarker = "-";
        lineSeparator = "+";
        sectionSeparator = "|";
        standardOrientation = "center";
        allSameSizes = false;
        showLineMarker = true;
        showLineSeparator = true;
        showSectionSeparator = true;
    }

    public TableConstructor(byte... columnSizes) {
        orientations = new String[0];
        this.columnSizes = columnSizes;
        lineMarker = "-";
        lineSeparator = "+";
        sectionSeparator = "|";
        standardOrientation = "center";
        allSameSizes = false;
        showLineMarker = true;
        showLineSeparator = true;
        showSectionSeparator = true;
    }

    // PUBLIC METHODS
    public void printRow(String... fieldContents) {
        print(fieldContents, false);
    }

    public void printHeader(String... headers) {
        print(headers, true);
    }

    public void setCustomSizes(int... sizes) {
        allSameSizes = false;
        columnSizes = new byte[sizes.length];
        for (int i = 0; i < sizes.length; i++) {
            columnSizes[i] = (byte) sizes[i];
        }
    }

    public void showSectionSeparator(boolean show) {
        showSectionSeparator = show;
    }

    public void showLineSeparator(boolean show) {
        showLineSeparator = show;
    }

    public void showLineMarker(boolean show) {
        showLineMarker = show;
    }

    public void setLineMarker(String marker) {
        lineMarker = marker;
    }

    public void setLineSeparator(String separator) {
        lineSeparator = separator;
    }

    public void setSectionSeparator(String separator) {
        sectionSeparator = separator;
    }

    public void setStandardOrientation(String orientation) {
        if (orientation.equals("left") || orientation.equals("center") || orientation.equals("right"))
            standardOrientation = orientation;
    }

    public void setCustomOrientations(String... orientations) {
        this.orientations = new String[orientations.length];
        System.arraycopy(orientations, 0, this.orientations, 0, orientations.length);
    }

    public void setAllSizes(int sizesForAllColumns) {
        columnSizes = new byte[1];
        columnSizes[0] = (byte) sizesForAllColumns;
        allSameSizes = true;
    }

    // PRIVATE METHODS
    private void print(String[] contents, boolean isHeader) {
        // CHECK&CORRECT COLUMN SIZES & ORIENTATIONS BEFORE PROCEEDING
        if (!(checkRealSizes(contents)))
            sizeCorrector(contents);
        checkAndCorrectOrientations(contents);

        // PRINT UPPER SEPARATOR LINE FOR HEADER
        if (isHeader) {
            printSeparatorLine();
        }
        for (int i = 0; i < contents.length; i++) {
            printField(contents[i], columnSizes[i], orientations[i]);
        }
        printSectionSeparator();
        lineBreak();
        printSeparatorLine();
    }

    private void printField(String content, int colSize, String orientation) {
        printSectionSeparator();
        int spacesOnEachSide = (colSize - content.length()) / 2;
        content = contentFitter(content, colSize);
        boolean even = checkEven(content.length());
        switch (orientation) {
            case "left":
                printSpaces(1);
                System.out.print(content);
                if (!(even)) {
                    printSpaces(spacesOnEachSide + (spacesOnEachSide));
                    break;
                }
                printSpaces(spacesOnEachSide + (spacesOnEachSide - 1));
                break;
            case "center":
                printSpaces(spacesOnEachSide);
                System.out.print(content);
                if (!(even)) {
                    printSpaces(spacesOnEachSide + 1);
                    break;
                }
                printSpaces(spacesOnEachSide);
                break;
            case "right":
                if (!(even)) {
                    printSpaces(spacesOnEachSide * 2);
                } else {
                    printSpaces((spacesOnEachSide * 2) - 1);
                }
                System.out.print(content);
                printSpaces(1);
                break;
        }
    }

    private String contentFitter(String content, int colSize) {
        if (content.length() >= colSize) {
            content = content.substring(0, colSize - 4);
            content = content + "...";

        }
        return content;
    }

    private void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print(" ");
        }
    }

    private void printSectionSeparator() {
        if (showSectionSeparator) {
            System.out.print(sectionSeparator);
        } else {
            System.out.print(" ");
        }
    }

    private void printSeparatorLine() {
        for (int i = 0; i < columnSizes.length; i++) {
            printLineSeparator();
            for (int j = 0; j < columnSizes[i]; j++) {
                printLineMarker();
            }
        }
        printLineSeparator();
        lineBreak();
    }

    private void lineBreak() {
        System.out.println("");
    }

    private void printLineMarker() {
        if (showLineMarker) {
            System.out.print(lineMarker);
        } else {
            System.out.print(" ");
        }
    }

    private void printLineSeparator() {
        if (showLineSeparator) {
            System.out.print(lineSeparator);
        } else {
            System.out.print(" ");
        }
    }

    private boolean checkRealSizes(String[] contents) {
        return contents.length == columnSizes.length;
    }

    private void checkAndCorrectOrientations(String[] contents) {
        int positionCounter;
        String[] newOrientations = new String[contents.length];
        for (positionCounter = 0; positionCounter < newOrientations.length; positionCounter++) {
            newOrientations[positionCounter] = newOrientation(positionCounter);
        }
        orientations = new String[newOrientations.length];
        System.arraycopy(newOrientations, 0, orientations, 0, newOrientations.length);
    }

    private String newOrientation(int orientationIndex) {
        try {
            String indicatedOrientation = orientations[orientationIndex];
            switch (indicatedOrientation) {
                case "left":
                    return indicatedOrientation;
                case "center":
                    return indicatedOrientation;
                case "right":
                    return indicatedOrientation;
                default:
                    return standardOrientation;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return standardOrientation;
        }
    }

    private void sizeCorrector(String[] contents) {
        int positionCounter;
        byte[] newSizes = new byte[contents.length];

        // CHECK AND IF NECESSARY CORRECT GIVEN SIZES
        for (positionCounter = 0; positionCounter < newSizes.length; positionCounter++) {
            newSizes[positionCounter] = newSize((byte) contents[positionCounter].length(), (byte) positionCounter);
        }
        columnSizes = new byte[contents.length];
        System.arraycopy(newSizes, 0, columnSizes, 0, newSizes.length);
    }

    private byte newSize(byte contentLength, byte colSizeIndex) {
        if (allSameSizes) {
            return columnSizes[0];
        }
        try {
            byte indicatedSize = columnSizes[colSizeIndex];
            if (contentLength > (indicatedSize - 4) || indicatedSize < 4) {
                int newSize = contentLength + 4;
                if (!(checkEven(newSize)))
                    newSize += 1;
                return (byte) newSize;
            } else {
                if (!(checkEven(indicatedSize)))
                    indicatedSize += 1;
                return indicatedSize;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            int newSize = contentLength + 4;
            if (!(checkEven(newSize)))
                newSize += 1;
            return (byte) newSize;
        }
    }

    private boolean checkEven(int number) {
        return (number % 2) == 0;
    }
}
