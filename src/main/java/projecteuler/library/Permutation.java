package projecteuler.library;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    private final List<Character> characters;

    public Permutation(List<Character> characters) {
        this.characters = new ArrayList<>(characters);
        Collections.sort(this.characters);
    }

    public List<Character> getPermutation() {
        return characters;
    }

    public void permute() {

    }

    private int findCeiling(char first, int l, int h) {
        int ceilingIndex = l;

        for(int i = l+1; i <= h; i++) {
            if(characters.get(i) > first && characters.get(i) < characters.get(ceilingIndex)) {
                ceilingIndex = i;
            }
        }
        return ceilingIndex;
    }

    public void reset() {
        Collections.sort(characters);
    }
}
