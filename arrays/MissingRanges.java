package arrays;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public static String getRange(int l, int r){
        StringBuilder sb = new StringBuilder();
        if (r - l > 1) {
            if ( r - l == 2)
                return sb.append(l + 1).toString();
            else {
                sb.append(l+1).append("->").append(r-1);
                return sb.toString();
            }
        } 
        return "";
    }

    public static List<String> findMissingRanges(int[] ranges, int l, int r){
        List<String> rgs = new ArrayList<String>();
        r += 1;
        l -= 1;
        int last = l;

        // get last value and compute last range
        if (ranges.length > 0) 
            last = ranges[ranges.length -1];
        
        for(int i = 0; i < ranges.length; i++) {
            String currRange = "";
            // get from lower up to first range value
            if (i == 0) 
                currRange = MissingRanges.getRange(l, ranges[0]);
            else {
                currRange = MissingRanges.getRange(ranges[i-1], ranges[i]);
            }
            if (!currRange.equals("")) {
                rgs.add(currRange);
            }
        }

        String lastRange = MissingRanges.getRange(last, r);
        if (!lastRange.equals("")) {
            rgs.add(lastRange);
        }
        return rgs;
    }

    public static void main (String args[]) {
        int[] ranges = {0,1,3,50,75};
        int left = 0;
        int right = 100;

        System.out.println( MissingRanges.findMissingRanges(ranges, left, right).toString());
    }
    
}
