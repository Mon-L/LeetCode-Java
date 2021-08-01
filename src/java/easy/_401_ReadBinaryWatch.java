package easy;

import java.util.ArrayList;
import java.util.List;

public class _401_ReadBinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            int hBitCount = Integer.bitCount(h);

            if (hBitCount > turnedOn) {
                break;
            }

            for (int m = 0; m < 60; m++) {
                if (hBitCount + Integer.bitCount(m) == turnedOn) {
                    ret.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return ret;
    }
}
