package easy;

import java.util.*;

public class _937_ReorderLogFiles {

    private List<String> letLists = new ArrayList<>();
    private List<String> digLists = new ArrayList<>();

    public String[] reorderLogFiles(String[] logs) {
        for (String log : logs) {
            int i = log.indexOf(' ');
            char ch = log.charAt(i + 1);
            boolean isLet = ch >= 'a' && ch <= 'z';

            if (isLet) {
                letLists.add(log);
            } else {
                digLists.add(log);
            }
        }

        Collections.sort(letLists, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String content1 = o1.substring(o1.indexOf(' ') + 1);
                String content2 = o2.substring(o2.indexOf(' ') + 1);
                return !content1.equals(content2) ? content1.compareTo(content2) :
                        o1.substring(0, o1.indexOf(' ')).compareTo(o2.substring(0, o2.indexOf(' ')));
            }
        });

        letLists.addAll(digLists);
        return letLists.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new _937_ReorderLogFiles().reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
        System.out.println(Arrays.toString(new _937_ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    }
}
