package Testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder(){
        order = new Order();
    }
    @AfterEach
    void cleanUp(){
        order.cancel();
    }


    @Test
    void testAssertArrayEquals(){
        //given
        int[] tab1 = {1,2,3};
        int[] tab2 = {1,2,3};

        //then
        assertArrayEquals(tab1,tab2);
    }

    @Test
    void mealListShoulBeEmptyAfterCreationOrder(){
        //given


        //then
        assertThat(order.getMeals(), empty());

        assertThat(order.getMeals().size(), equalTo(0));

        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));

    }

    @Test
    void addingMealSHoulIncreaseOrderSize(){
        //given
        Meal meal = new Meal(15,"Burger");


        //when
        order.addMealToOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(1));
        assertThat(order.getMeals(),contains(meal)) ;
        assertThat(order.getMeals(),hasItem(meal)) ;
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize(){
        //given
        Meal meal = new Meal(15,"Burger");


        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));

    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAdding(){
        //given
        Meal meal = new Meal(15,"Burger");
        Meal meal1 = new Meal(25,"spaghetti");


        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal1);

        //then
        assertThat(order.getMeals(),containsInAnyOrder(meal1,meal));

    }

    @Test
    void testIfMealListsAreTheSame(){
        Meal meal = new Meal(15,"Burger");
        Meal meal1 = new Meal(25,"spaghetti");
        Meal meal2 = new Meal(32,"hummus");

        List<Meal> meals = Arrays.asList(meal,meal1);
        List<Meal> meals1 = Arrays.asList(meal,meal1);

        assertThat(meals1,is(meals));

    }

}