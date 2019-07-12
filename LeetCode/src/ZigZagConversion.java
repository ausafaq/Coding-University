import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == numRows - 1 || curRow == 0) {
                goingDown = !goingDown;
            }
            if(goingDown) {
                curRow += 1;
            } else {
                curRow += -1;
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}