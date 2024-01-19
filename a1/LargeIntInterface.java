// Name: Aditya Shah
// Student number: 218681577
// Email: aditya78@my.yorku.ca
//--------------------------------------------------------

package a1;

public interface LargeIntInterface {

    // adds two large integers and returns a new large integer
    public LargeInt add(LargeInt intLarge);

    // subtracts two large integers and returns a new large integer
    public LargeInt subtract(LargeInt intLarge);

    // sets the integer value from negative to positive if value is negative, or positive to negative otherwise
    public void setNegative();

}