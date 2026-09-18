import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String $) {
        int __ = $.length();

        int[] ____ = new int[26];  // first occurrence
        int[] $$ = new int[26];    // last occurrence
        Arrays.fill(____, -1);

        for (int $_ = 0; $_ < __; $_++) {
            int $$_ = $.charAt($_) - 'a';
            if (____[$$_] == -1) ____[$$_] = $_;
            $$[$$_] = $_;
        }

        List<String> ________ = new ArrayList<>();
        int _________ = -1;  // right edge of the last interval we kept

        for (int $_ = 0; $_ < __; $_++) {
            if (____[$.charAt($_) - 'a'] != $_) continue;  // only first occurrences can start

            int _____ = $$[$.charAt($_) - 'a'];  // expanding right edge
            boolean ______ = true;               // still self-contained?

            for (int $__ = $_; $__ <= _____; $__++) {
                int _______ = $.charAt($__) - 'a';
                if (____[_______] < $_) { ______ = false; break; }
                if ($$[_______] > _____) _____ = $$[_______];
            }

            if (!______) continue;

            if ($_ > _________) ________.add($.substring($_, _____ + 1));
            else ________.set(________.size() - 1, $.substring($_, _____ + 1));

            _________ = _____;
        }

        return ________;
    }
}