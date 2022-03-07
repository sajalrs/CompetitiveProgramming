package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CellsInRange {
    public List<String> cellsInRange(String s) {
        String[] split = s.split(":");
        String topLeft = split[0];
        String bottomRight = split[1];
        char colTopLeft = topLeft.charAt(0);
        int rowTopLeft = Integer.parseInt(String.valueOf(topLeft.charAt(1)));
        char colBottomRight = bottomRight.charAt(0);
        int rowBottomRight = Integer.parseInt(String.valueOf(bottomRight.charAt(1)));

        List<String> listOfCells = new ArrayList<>();
        for (char i = colTopLeft; i <= colBottomRight; i++) {
            for(int j=rowTopLeft; j<=rowBottomRight; j++){
                String cell = i + String.valueOf(j);
                listOfCells.add(cell);
            }
        }
        return listOfCells;
    }
}
