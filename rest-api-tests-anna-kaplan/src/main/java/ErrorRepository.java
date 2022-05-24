import org.testng.Assert;

public class ErrorRepository {
    public static Error invalidLength = new Error("INVL", "Invalid length. Pesel should have exactly 11 digits.");
    public static Error invalidCharacters = new Error("NBRQ", "Invalid characters. Pesel should be a number.");
    public static Error invalidYear = new Error("INVY", "Invalid year.");
    public static Error invalidMonth = new Error("INVM", "Invalid month.");
    public static Error invalidDay = new Error("INVD", "Invalid day.");
    public static Error invalidCheckSum = new Error("INVC", "Check sum is invalid. Check last digit.");
}
