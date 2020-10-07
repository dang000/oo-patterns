/**
 *  -> Builder Pattern
 *
 *  1. Create builder interface with setters
 *  2. Create classes for products
 *  3. Implement builder interface for each type of
 *     the same product, which can return the product
 *  4. Build manually and return product
 *     OR
 *  4. Create Director to make products using builders
 *  5. Create new director and create related builders,
 *     and return builder result for related product.
 *
 */


package BuilderPattern;

public interface PhoneBuilder {
    void setCamera(String camera);
    void setProcessor(String processor);
    void setBattery(int battery);
}

class AbcPhoneBuilder implements PhoneBuilder {
    private int battery;
    private String processor;
    private String camera;

    @Override
    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Phone getPhone() {
        return new Phone(battery, processor, camera);
    }
}

class AbcSmartphoneBuilder implements PhoneBuilder {
    private int battery;
    private String processor;
    private String camera;

    @Override
    public void setBattery(int battery) {
        this.battery = battery + 100;
    }

    @Override
    public void setCamera(String camera) {
        this.camera = camera;
    }

    @Override
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Smartphone getSmartphone() {
        return new Smartphone(battery, processor, camera);
    }
}

class Phone {
    private int battery;
    private String processor;
    private String camera;

    public Phone(int battery, String processor, String camera) {
        this.battery = battery;
        this.processor = processor;
        this.camera = camera;
    }
}

class Smartphone {
    private int battery;
    private String processor;
    private String camera;

    public Smartphone(int battery, String processor, String camera) {
        this.battery = battery;
        this.processor = processor;
        this.camera = camera;
    }
}


class Director {
    private PhoneBuilder phoneBuilder;

    public void MakeAndroidPhone(PhoneBuilder phoneBuilder) {
        phoneBuilder.setBattery(500);
        phoneBuilder.setCamera("shitbox camera");
        phoneBuilder.setProcessor("bitcoin miner");
    }

    public void MakeApplePhone(PhoneBuilder phoneBuilder) {
        phoneBuilder.setBattery(200);
        phoneBuilder.setCamera("decent camera");
        phoneBuilder.setProcessor("mac");
    }
}

class Test {

    public static void main(String[] args) {
        Director director = new Director();
        AbcPhoneBuilder phoneBuilder = new AbcPhoneBuilder();
        AbcSmartphoneBuilder smartphoneBuilder = new AbcSmartphoneBuilder();

        director.MakeAndroidPhone(phoneBuilder);
        director.MakeApplePhone(smartphoneBuilder);

        Smartphone smartphone = smartphoneBuilder.getSmartphone();
    }
}
