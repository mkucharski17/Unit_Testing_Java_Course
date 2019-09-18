package Testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void ShouldRetuenDiscountedPrice() {
        //given
        Meal meal = new Meal(35);

        //when
        int discountesPrice = meal.getDiscountPrice(7);

        //then
        // assertThat(discountesPrice).isEqualTo(28);


    }

    @Test
    void referenceToTheSameObjectShouldBeEqual(){
        //given
        Meal meal1 = new Meal(30);
        Meal meal2 = meal1;

        //then
        //assertThat(meal1).isSameAs(meal2);
    }

    @Test
    void referenceToDifferentObjectsShouldNotBe(){
        //given
        Meal meal1 = new Meal(30);
        Meal meal2 = new Meal(20);

        //then
        assertNotSame(meal1,meal2);

    }

    @Test
    void twoMealsShouldBeEqualsWhemNameAndPriceAreTheSame(){

        //given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(80, "Pizza");

        //then
        assertEquals(meal1,meal2, "check if two meals are equal");

    }

    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanPrice(){
        //given
        Meal meal = new Meal(8,"soup");

        //when
        //then
        assertThrows(IllegalArgumentException.class, ()->meal.getDiscountPrice(3));
    }

    @ParameterizedTest
    @ValueSource(ints = {5,10,15,19})
    void mealricesShouldBeLowerThan20(int price){
        assertThat(price,lessThan(20));

    }

    @ParameterizedTest
    @MethodSource("createMealsWithNamesAndPrice")
    void mealsShouldHaveCorrectNamesAndPrices(String name, int price){
        assertThat(name, containsString("burger"));
        assertThat(price, lessThan(20));
    }


    private static Stream<Arguments> createMealsWithNamesAndPrice(){
        return Stream.of(
                Arguments.of("Hamburger", 12),
                Arguments.of("cheeseburger", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("createCakeNames")
    void cakeNameShouldEndWithCake(String name){
        assertThat(name, notNullValue());
        assertThat(name, endsWith("cake"));

    }

    private static Stream<String> createCakeNames(){
        List<String> cakeNames = Arrays.asList("Cheesecake", "cupcake");

        return cakeNames.stream();
    }

    @ExtendWith(IAExceptionIgnoreExtension.class)
    @ParameterizedTest
    @ValueSource(ints = {5,3,7,4})
    void  mealPricesShouldBeLowerThan10(int price){
        if(price > 5)
            throw new IllegalArgumentException();
        assertThat(price,lessThan(10));

    }
}