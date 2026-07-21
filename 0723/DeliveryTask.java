public class DeliveryTask {
    private String code;
    private String address;

    public DeliveryTask(String code, String address) {
        this.code    = code;
        this.address = address;
    }

    public String getCode()    { return code;    }
    public String getAddress() { return address; }

    @Override
    public String toString() {
        return "[" + code + "] " + address;
    }
}