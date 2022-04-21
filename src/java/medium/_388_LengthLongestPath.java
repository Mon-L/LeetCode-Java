package medium;

public class _388_LengthLongestPath {

    /**
     * dir
     * ⟶ subdir1
     * ⟶ ⟶ file1.ext
     * ⟶ ⟶ subsubdir1
     * ⟶ ⟶ ⟶ file2.ext
     * ⟶ file2.ext
     * ⟶ subdir2
     * ⟶ ⟶ subsubdir2
     * ⟶ ⟶ ⟶ file2.ext
     */
    public int lengthLongestPath(String input) {
        char[] chars = input.toCharArray();
        int i = 0, n = chars.length, max = 0;
        int[] lens = new int[n + 1];
        while (i < n) {
            int depth = 1;
            while (i < n && chars[i] == '\t') {
                depth++;
                i++;
            }

            boolean isFile = false;
            int len = 0;
            while (i < n && chars[i] != '\n') {
                if (chars[i] == '.') {
                    isFile = true;
                }
                len++;
                i++;
            }
            i++;

            len += lens[depth - 1];

            if (isFile) {
                max = Math.max(max, len + depth - 1);
            } else {
                lens[depth] = len;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new _388_LengthLongestPath().lengthLongestPath("a"));
        System.out.println(new _388_LengthLongestPath().lengthLongestPath("a\n\taa\naaaaaaaaaaaaaaaaaaaaa\n\tsth.png"));
        System.out.println(new _388_LengthLongestPath().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new _388_LengthLongestPath().lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
