package Testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class AdressTest {

    @ParameterizedTest
    @CsvSource({"fabryczna,10", "Zeromksiego, 1" , "solec,113"})
    void givenAdressesSHouldNotBeEmptyAndHaveProperNames(String street, int number){
        assertThat(street,notNullValue());
        assertThat(street.length(),greaterThan(4));
        assertThat(number, lessThan(200));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void givenAdressesFromFIleSHouldNotBeEmptyAndHaveProperNames(String street, int number){
        assertThat(street,notNullValue());
        assertThat(street.length(),greaterThan(4));
        assertThat(number, lessThan(200));
    }





}