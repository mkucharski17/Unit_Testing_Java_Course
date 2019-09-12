package Testing;

public class Account {

    private boolean active;
    private Adress deliveryAdress;

    public Account(){
        this.active = false;
    }

    public void activate(){
        this.active = true;
    }

    public boolean isActive(){
        return this.active;
    }

    public Adress getDeliveryAdress() {
        return deliveryAdress;
    }

    public void setDeliveryAdress(Adress deliveryAdress) {
        this.deliveryAdress = deliveryAdress;
    }

    public Account(Adress deliveryAdress) {
        if(deliveryAdress!= null)
            activate();
        else
            this.active = false;

        this.deliveryAdress = deliveryAdress;
    }
}
