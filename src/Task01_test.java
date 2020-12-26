import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class Task01_test
{
    @Test(expected = NumberFormatException.class)
    public void decode_empty_str_exception()
    {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_positive_sign_in_wrong_pos_exception()
    {
        Integer.decode("0x+4");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_negative_sign_in_wrong_pos_exception()
    {
        Integer.decode("0-4");
    }

    @Test(expected = NumberFormatException.class)
    public void decode_not_number_exception()
    {
        Integer.decode("ab12cd");
    }

    @Test()
    public void decode_in_10_radix()
    {
        Assert.assertEquals( "Method should decode positive 10-radix", 120, (int) Integer.decode("120"));
        Assert.assertEquals( "Method should decode negative 10-radix", -40, (int) Integer.decode("-40"));
    }

    @Test()
    public void decode_in_8_radix()
    {
        Assert.assertEquals( "Method should decode positive 8-radix", 052, (int) Integer.decode("052"));
        Assert.assertEquals( "Method should decode negative 8-radix", -073, (int) Integer.decode("-073"));
    }

    @Test()
    public void decode_in_16_radix_0x()
    {
        Assert.assertEquals( "Method should decode positive 16-radix", 0x52, (int) Integer.decode("0x52"));
        Assert.assertEquals( "Method should decode negative 16-radix", -0x200, (int) Integer.decode("-0x200"));
    }

    @Test()
    public void decode_in_16_radix()
    {
        Assert.assertEquals( "Method should decode positive 16-radix", 0x52, (int) Integer.decode("#52"));
        Assert.assertEquals( "Method should decode negative 16-radix", -0x200, (int) Integer.decode("-#200"));
    }
}
