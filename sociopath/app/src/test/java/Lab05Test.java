import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Lab05Test {

    Sociopath finder = new Sociopath();

    // Helper method to make creating lists easier for tests (Manual version)
    private List<int[]> createList(int[]... pairs) {
        List<int[]> list = new ArrayList<>();
        for (int[] pair : pairs) {
            list.add(pair);
        }
        return list;
    }

    @Test
    void sociopathExists1() {
        //Case: Size 2, [1, 2]. Expect: 2
        List<int[]> likes = createList(new int[]{1, 2});
        assertEquals(2, finder.findTheSociopath(2, likes));
    }

    @Test
    void incompleteInfo() {
        // Case: Size 3, [1, 2]. Expect: -1
        List<int[]> likes = createList(new int[]{1, 2});
        assertEquals(-1, finder.findTheSociopath(3, likes));
    }

    @Test
    void sSociopathExists2() {
        // Case: Size 3, [1, 2], [1, 3], [2, 3]. Expect: 3
        List<int[]> likes = createList(
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 3}
        );
        assertEquals(3, finder.findTheSociopath(3, likes));
    }

    @Test
    void everyoneLikesSomeone() {
        // Case: Size 3, [1, 3], [2, 3], [3, 1]. Expect: -1
        List<int[]> likes = createList(
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 1}
        );
        assertEquals(-1, finder.findTheSociopath(3, likes));
    }

    @Test
    void invalidGroup() {
        // Case: Size 0, [1, 2]. Expect: -1
        List<int[]> likes = createList(new int[]{1, 2});
        assertEquals(-1, finder.findTheSociopath(0, likes));
    }

    @Test
    void invalidPerson0() {
        // Case: Size 3, [1, 0]. Expect: -1
        List<int[]> likes = createList(new int[]{1, 0});
        assertEquals(-1, finder.findTheSociopath(3, likes));
    }

    @Test
    //Case: Size 6, [2, 1], [3,1], [4,1], [5,1], [6, 1]. Expect: 1
    void largeGroup() {
        List<int[]> likes = createList(
                new int[]{2, 1},
                new int[]{3, 1},
                new int[]{4, 1},
                new int[]{5, 1},
                new int[]{6, 1}
        );
        //Sociopath is the first person)
        assertEquals(1, finder.findTheSociopath(6, likes));
    }

    @Test
    void almostASociopath1() {
        //Case: Size 4, [1,4], [2,4], [3,2]. Expect: -1
        List<int[]> likes = createList(
                new int[]{1, 4},
                new int[]{2, 4},
                new int[]{3, 2}
        );
        //Person 4 only has 2 votes, needs 3 to be sociopath
        assertEquals(-1, finder.findTheSociopath(4, likes));
    }

    @Test
    void sociopathLikesThemself() {
        //Case: Size 3, [1,3], [2,3], [3,3]. Expect: -1
        List<int[]> likes = createList(
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 3}
        );
        assertEquals(-1, finder.findTheSociopath(3, likes));
    }

    @Test
    void almostASociopath2() {
        //Case: Size 3, [1,2], [3,2], [2,3]. Expect: -1
        List<int[]> likes = createList(
                new int[]{1, 2},
                new int[]{3, 2},
                new int[]{2, 3}
        );
        assertEquals(-1, finder.findTheSociopath(3, likes));
    }
}