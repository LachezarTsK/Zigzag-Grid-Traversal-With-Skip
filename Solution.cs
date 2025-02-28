
using System;

public class Solution
{
    public IList<int> ZigzagTraversal(int[][] matrix)
    {
        int totalRows = matrix.Length;
        int totalColumns = matrix[0].Length;

        int numberOfVisitedElements = 0;
        IList<int> zigzagTraversal = new List<int>();

        for (int row = 0; row < totalRows; ++row)
        {
            int start = IsEven(row) ? 0 : totalColumns - 1;
            int outOfBoundary = IsEven(row) ? totalColumns : -1;
            int step = IsEven(row) ? 1 : -1;

            for (int column = start; column != outOfBoundary; column += step)
            {
                ++numberOfVisitedElements;
                if (!IsEven(numberOfVisitedElements))
                {
                    zigzagTraversal.Add(matrix[row][column]);
                }
            }
        }

        return zigzagTraversal;
    }

    private bool IsEven(int value)
    {
        return value % 2 == 0;
    }
}
