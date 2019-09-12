package Testing;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void AccountShouldNotBeActivateAfterACreation(){
        Account account = new Account();

  


    }

    @Test
    void accountShouldBeActivateAfterActivation(){
        Account account = new Account();
        assertFalse(account.isActive());
        account.activate();
        assertTrue(account.isActive());



    }

    @Test
    void newlyCreatedAccountShouldNotHaveDeliveryAdress(){
        //given
        Account account = new Account();

        //when
        Adress adress = account.getDeliveryAdress();

        //then
        //assertThat(adress).isNull();

    }

    @Test
    void deliveryAdressShoulNotBeNullAfterSetting(){
        //given
        Adress adress = new Adress("Krakowska", 10);
        Account account = new Account();
        account.setDeliveryAdress(adress);

        //when
        Adress defaultAdress = account.getDeliveryAdress();

        //then
        //assertThat(defaultAdress).isNotNull();
    }

    @Test
    void newAccounrWithNotNullAdessShoulBeActive(){
        //given
        Adress adress = new Adress("zeromskiego", 1);

        //when
        Account account = new Account(adress);

        //then
         assumingThat(adress!= null, ()-> {
             assertTrue(account.isActive());
         });
    }

}
