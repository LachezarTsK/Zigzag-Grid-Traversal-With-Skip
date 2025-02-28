
class Solution {

    fun zigzagTraversal(matrix: Array<IntArray>): List<Int> {
        val totalRows = matrix.size
        val totalColumns = matrix[0].size

        var numberOfVisitedElements = 0
        val zigzagTraversal = ArrayList<Int>()

        for (row in 0..<totalRows) {

            val start = if (isEven(row)) 0 else totalColumns - 1
            val outOfBoundary = if (isEven(row)) totalColumns else -1
            val step = if (isEven(row)) 1 else -1

            var column = start
            while (column != outOfBoundary) {
                ++numberOfVisitedElements
                if (!isEven(numberOfVisitedElements)) {
                    zigzagTraversal.add(matrix[row][column])
                }
                column += step
            }
        }

        return zigzagTraversal
    }

    private fun isEven(value: Int): Boolean {
        return value % 2 == 0
    }
}
