package opgave01;

import opgave01.models.IntegerVault;
import opgave01.models.StringVault;

public class Opgave01 {
    public static void main(String[] args) {
        IntegerVault integerVault = new IntegerVault(42, "My password");
        System.out.println(integerVault.getSecret("My password"));

        StringVault stringVault = new StringVault("fortyTwo", "12345");
        System.out.println(stringVault.getSecret("12345"));
    }
}
