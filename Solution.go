
package main

func zigzagTraversal(matrix [][]int) []int {
    totalRows := len(matrix)
    totalColumns := len(matrix[0])

    numberOfVisitedElements := 0
    zigzagTraversal := []int{}

    for row := range totalRows {

        start := Ternary(isEven(row), 0, totalColumns - 1)
        outOfBoundary := Ternary(isEven(row), totalColumns, -1)
        step := Ternary(isEven(row), 1, -1)

        var column = start
        for column != outOfBoundary {
            numberOfVisitedElements++
            if !isEven(numberOfVisitedElements) {
                zigzagTraversal = append(zigzagTraversal, matrix[row][column])
            }
            column += step
        }
    }

    return zigzagTraversal
}

func isEven(value int) bool {
    return value % 2 == 0
}

func Ternary[T any](condition bool, first T, second T) T {
    if condition {
        return first
    }
    return second
}
