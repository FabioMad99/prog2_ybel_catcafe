package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class CatCafeTest {

    @Test
    void shouldBeEmptyWhenCreated() {
        CatCafe cafe = new CatCafe();
        assertEquals(0, cafe.getCatCount());
    }

    @Test
    void shouldIncreaseCountWhenCatIsAdded() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Mimi", 2));
        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void shouldFindCatByExactName() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord result = cafe.getCatByName("Morticia");

        assertNotNull(result);
        assertEquals("Morticia", result.name());
    }

    @Test
    void shouldReturnNullForUnknownCatName() {
        CatCafe cafe = new CatCafe();
        assertNull(cafe.getCatByName("Ghost"));
    }

    @Test
    void shouldFindCatInWeightRange() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("A", 1));
        cafe.addCat(new FelineOverLord("B", 3));

        assertNotNull(cafe.getCatByWeight(2, 4));
    }

    @Test
    void shouldReturnNullWhenNoCatInWeightRange() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("A", 1));

        assertNull(cafe.getCatByWeight(5, 10));
    }

    @Test
    void shouldStoreMultipleCatsCorrectly() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("A", 1));
        cafe.addCat(new FelineOverLord("B", 2));
        cafe.addCat(new FelineOverLord("C", 3));

        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void shouldReturnFirstMatchingCatByName() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Sam", 2));
        cafe.addCat(new FelineOverLord("Sam", 5));

        FelineOverLord result = cafe.getCatByName("Sam");

        assertNotNull(result);
        assertEquals("Sam", result.name());
    }

    @Test
    void shouldNotAffectExistingCatsWhenAddingNewOne() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("A", 1));
        cafe.addCat(new FelineOverLord("B", 2));

        assertEquals(2, cafe.getCatCount());
    }

    @Test
    void shouldReturnCorrectCatForWeightBoundary() {
        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Edge", 3));

        assertNotNull(cafe.getCatByWeight(2, 4));
    }

    @Test
    void shouldMatchCorrectWeightValue() {
        FelineOverLord cat = new FelineOverLord("TestCat", 7);
        assertEquals(7, cat.weight());
    }
}
