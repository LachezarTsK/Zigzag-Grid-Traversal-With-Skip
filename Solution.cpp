
#include <vector>
using namespace std;

class Solution {

public:
    vector<int> zigzagTraversal(const vector<vector<int>>& matrix) const {
        int totalRows = matrix.size();
        int totalColumns = matrix[0].size();

        int numberOfVisitedElements = 0;
        vector<int> zigzagTraversal;

        for (int row = 0; row < totalRows; ++row) {

            int start = isEven(row) ? 0 : totalColumns - 1;
            int outOfBoundary = isEven(row) ? totalColumns : -1;
            int step = isEven(row) ? 1 : -1;

            for (int column = start; column != outOfBoundary; column += step) {
                ++numberOfVisitedElements;
                if (!isEven(numberOfVisitedElements)) {
                    zigzagTraversal.push_back(matrix[row][column]);
                }
            }
        }

        return zigzagTraversal;
    }

private:
    bool isEven(int value) const {
        return value % 2 == 0;
    }
};
