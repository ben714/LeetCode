
/* LeetCode Question 6: ZigZag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * */

import java.util.*;

public class Question006 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int row = sc.nextInt();
        Question006 obj = new Question006();
        System.out.println("Output: " + obj.convert2(s,row));
    }

    public String convert(String s, int numRows)
    {
        if(s==null) return "";
        if(numRows<2) return s;
        StringBuilder re= new StringBuilder();
        int length = s.length();
        int set = (int)Math.ceil((length-numRows)/(2.0*numRows-2));
        int width = 2*numRows-2;
        for(int i=0;i<numRows;i++)
        {
            for(int j=0;j<=set;j++)
            {
                int po = i+width*j;
                if(i>0 && i<numRows-1)
                {
                    if(po-2*i>0 && po-2*i<length){re.append(s.charAt(po-2*i));}
                }
                if(po<length) {re.append(s.charAt(po));}

            }
        }
        return re.toString();
    }


        public String convert1(String s, int numRows) {

            if (numRows == 1) return s;

            List<StringBuilder> rows = new ArrayList<>();
            for (int i = 0; i < Math.min(numRows, s.length()); i++)
                rows.add(new StringBuilder());

            int curRow = 0;
            boolean goingDown = false;

            for (char c : s.toCharArray()) {
                rows.get(curRow).append(c);
                if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
                curRow += goingDown ? 1 : -1;
            }

            StringBuilder ret = new StringBuilder();
            for (StringBuilder row : rows) ret.append(row);
            return ret.toString();
        }


        public String convert2(String s, int numRows) {

            if (numRows == 1) return s;

            StringBuilder ret = new StringBuilder();
            int n = s.length();
            int cycleLen = 2 * numRows - 2;

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j + i < n; j += cycleLen) {
                    ret.append(s.charAt(j + i));
                    if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                        ret.append(s.charAt(j + cycleLen - i));
                }
            }
            return ret.toString();
        }

}
