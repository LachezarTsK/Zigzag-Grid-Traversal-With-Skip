
/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var zigzagTraversal = function (matrix) {
    const totalRows = matrix.length;
    const totalColumns = matrix[0].length;

    let numberOfVisitedElements = 0;
    const zigzagTraversal = new Array();

    for (let row = 0; row < totalRows; ++row) {

        const start = isEven(row) ? 0 : totalColumns - 1;
        const outOfBoundary = isEven(row) ? totalColumns : -1;
        const step = isEven(row) ? 1 : -1;

        for (let column = start; column !== outOfBoundary; column += step) {
            ++numberOfVisitedElements;
            if (!isEven(numberOfVisitedElements)) {
                zigzagTraversal.push(matrix[row][column]);
            }
        }
    }

    return zigzagTraversal;
};

/**
 * @param {number} value
 * @return {boolean}
 */
function isEven(value) {
    return value % 2 === 0;
}
