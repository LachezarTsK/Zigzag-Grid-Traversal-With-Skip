
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> zigzagTraversal(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        int numberOfVisitedElements = 0;
        List<Integer> zigzagTraversal = new ArrayList<>();

        for (int row = 0; row < totalRows; ++row) {

            int start = isEven(row) ? 0 : totalColumns - 1;
            int outOfBoundary = isEven(row) ? totalColumns : -1;
            int step = isEven(row) ? 1 : -1;

            for (int column = start; column != outOfBoundary; column += step) {
                ++numberOfVisitedElements;
                if (!isEven(numberOfVisitedElements)) {
                    zigzagTraversal.add(matrix[row][column]);
                }
            }
        }

        return zigzagTraversal;
    }

    private boolean isEven(int value) {
        return value % 2 == 0;
    }
}
