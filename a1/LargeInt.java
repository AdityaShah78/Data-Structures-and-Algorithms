// Name: Aditya Shah
// Student number: 218681577
// Email: aditya78@my.yorku.ca
//--------------------------------------------------------

package a1;

public class LargeInt implements LargeIntInterface {

    // boolean isNegative to check if the LargeInt is negative
    private boolean isNegative;
    // SpecializedList DLL to store the large int
    private SpecializedList DLL;
    // LargeInt result to store the result of the methods
    private LargeInt result;

    // Public constructor LargeInt to convert a string into a Specialized List
    public LargeInt(String input){
        // checks if the input is negative or not
        isNegative = input.contains("-");

        // new string to store the large integer as a string
        String mInput = " ";

        // only extracts integers and converts them to a string
        for(int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                mInput = mInput + input.charAt(i);
            }
        }

        // removes any spaces in the beginning or the end of the string
        mInput = mInput.trim();

        // removes any leading zeros
        mInput = mInput.replaceFirst("^0+(?!$)", "");

        // creating a new empty specialized list
        DLL = new SpecializedList();

        // converts the string into a specialized list
        for(int i = 0; i < mInput.length(); i++){
            DLL.insertEnd((byte)Character.getNumericValue(mInput.charAt(i)));
        }

    }

    // the method adds two large integers and returns the result as a new largeInt object
    @Override
    public LargeInt add(LargeInt operation) {
        int maxLength;
        SpecializedList top = null;
        SpecializedList bottom = null;

        if(this.DLL == operation.DLL){
            operation = new LargeInt(operation.toString());
        }

        if(operation.DLL.lengthIs() > DLL.lengthIs()){
            maxLength = operation.DLL.lengthIs();
            top = operation.DLL;
            bottom = DLL;
        } else if (DLL.lengthIs() > operation.DLL.lengthIs()) {
            maxLength = DLL.lengthIs();
            top = DLL;
            bottom = operation.DLL;
        }
        else{
            maxLength = DLL.lengthIs();
            byte current;
            byte input;
            DLL.resetForward();operation.DLL.resetForward();
            for(int i = 0; i < maxLength; i++) {
                current = DLL.getNextItem();
                input = operation.DLL.getNextItem();
                if (current > input) {
                    top = DLL;
                    bottom = operation.DLL;
                    break;
                } else if (current < input) {
                    top = operation.DLL;
                    bottom = DLL;
                    break;
                } else {
                    if(i == maxLength - 1){
                        top = operation.DLL;
                        bottom = DLL;
                        break;
                    }
                }
            }
        }

        String r = " ";

        DLL.resetBackward();DLL.resetForward();
        operation.DLL.resetForward();operation.DLL.resetBackward();

        boolean extra = false;
        int carry = 0;

        if((isNegative && !operation.isNegative) || (!isNegative && operation.isNegative)){
            for(int i = 0; i < maxLength; i++){
                byte topItem = 0;
                byte bottomItem = 0;

                if (bottom.lengthIs() <= i) {
                    bottomItem = 0;
                } else {
                    bottomItem = bottom.getPriorItem();
                }

                topItem = top.getPriorItem();

                int num;

                if (extra == true) {
                    topItem = (byte) (topItem - 1);
                    extra = false;
                }

                if (bottomItem > topItem) {
                    topItem += 10;
                    extra = true;
                }

                num = (topItem - bottomItem);

                r = num + r;

            }

            r = r.trim();

            r = r.replaceFirst("^0+(?!$)", "");

            if(r.equals(null)){
                r = "0";
            }

            if(((top == operation.DLL && operation.isNegative) || (top == DLL && isNegative)) && !r.equals("0")) {
                r = "-" + r;
            }
        }
        else {
            for (int i = 0; i < maxLength; i++) {
                byte currentDLL;
                byte inputDLL;

                if (DLL.lengthIs() <= i) {
                    currentDLL = 0;
                } else {
                    currentDLL = DLL.getPriorItem();
                }
                if (operation.DLL.lengthIs() <= i) {
                    inputDLL = 0;
                } else {
                    inputDLL = operation.DLL.getPriorItem();
                }

                int num = (currentDLL + inputDLL);

                if (extra) {
                    num = num + carry;
                    extra = false;
                }

                if (num / 10 != 0) {
                    carry = (byte) (num / 10);
                    num = (num) % 10;
                    extra = true;
                }

                r = num + r;

                if (i == maxLength - 1 && extra) {
                    r = carry + r;
                }

            }

            r = r.trim();

            if (isNegative && operation.isNegative && !r.equals("0")) {
                r = "-" + r;
            }
        }

        result = new LargeInt(r);

        return result;
    }

    // method subtracts two large integers and returns the result as a new largeInt object
    @Override
    public LargeInt subtract(LargeInt operation) {
        int maxLength;
        SpecializedList top = null;
        SpecializedList bottom = null;

        if(this.DLL == operation.DLL){
            operation = new LargeInt(operation.toString());
        }

        if(operation.DLL.lengthIs() > DLL.lengthIs()){
            maxLength = operation.DLL.lengthIs();
            top = operation.DLL;
            bottom = DLL;
        } else if (DLL.lengthIs() > operation.DLL.lengthIs()) {
            maxLength = DLL.lengthIs();
            top = DLL;
            bottom = operation.DLL;
        }
        else{
            maxLength = DLL.lengthIs();
            byte current;
            byte input;
            DLL.resetForward();operation.DLL.resetForward();
            for(int i = 0; i < maxLength; i++) {
                current = DLL.getNextItem();
                input = operation.DLL.getNextItem();
                if (current > input) {
                    top = DLL;
                    bottom = operation.DLL;
                    break;
                } else if (current < input) {
                    top = operation.DLL;
                    bottom = DLL;
                    break;
                } else {
                    if(i == maxLength - 1){
                        top = operation.DLL;
                        bottom = DLL;
                        break;
                    }
                }
            }
        }

        String r = " ";

        DLL.resetBackward();DLL.resetForward();
        operation.DLL.resetForward();operation.DLL.resetBackward();

        boolean extra = false;
        int carry = 0;

        if(isNegative && operation.isNegative){
            for(int i = 0; i < maxLength; i++){
                byte topItem = 0;
                byte bottomItem = 0;

                if (bottom.lengthIs() <= i) {
                    bottomItem = 0;
                } else {
                   bottomItem = bottom.getPriorItem();
                }

                topItem = top.getPriorItem();

                int num;

                if (extra == true) {
                    topItem = (byte) (topItem - 1);
                    extra = false;
                }

                if (bottomItem > topItem) {
                    topItem += 10;
                    extra = true;
                }

                num = (topItem - bottomItem);

                r = num + r;

            }

            r = r.trim();

            r = r.replaceFirst("^0+(?!$)", "");

            if(r.equals(null)){
                r = "0";
            }

            if(top == DLL && !r.equals("0")) {
                r = "-" + r;
            }

        } else if ((isNegative && !operation.isNegative) || (!isNegative && operation.isNegative)) {
            for(int i = 0; i < maxLength; i++) {
                byte currentDLL;
                byte inputDLL;

                if (DLL.lengthIs() <= i) {
                    currentDLL = 0;
                } else {
                    currentDLL = DLL.getPriorItem();
                }
                if (operation.DLL.lengthIs() <= i) {
                    inputDLL = 0;
                } else {
                    inputDLL = operation.DLL.getPriorItem();
                }

                int num = (currentDLL + inputDLL);

                if(extra == true){
                    num = num + carry;
                    extra = false;
                }

                if(num / 10 != 0){
                    carry = (byte)(num / 10);
                    num = (num) % 10;
                    extra = true;
                }

                r = num + r;

                if(i == maxLength - 1 && extra == true){
                    r = carry +r;
                }

            }

            r = r.trim();

            r = r.replaceFirst("^0+(?!$)", "");

            if(r.equals(null)){
                r = "0";
            }

            if(isNegative && !operation.isNegative && !r.equals("0")){
                r = "-" + r;
            }

        } else{
            for(int i = 0; i < maxLength; i++){
                byte topItem = 0;
                byte bottomItem = 0;

                if (bottom.lengthIs() <= i) {
                    bottomItem = 0;
                } else {
                    bottomItem = bottom.getPriorItem();
                }

                topItem = top.getPriorItem();

                int num;

                if (extra == true) {
                    topItem = (byte) (topItem - 1);
                    extra = false;
                }

                if (bottomItem > topItem) {
                    topItem += 10;
                    extra = true;
                }

                num = (topItem - bottomItem);

                r = num + r;

            }

            r = r.trim();

            r = r.replaceFirst("^0+(?!$)", "");

            if(r.equals(null)){
                r = "0";
            }

            if(top == operation.DLL && !r.equals("0")) {
                r = "-" + r;
            }
        }

        result = new LargeInt(r);

        return result;
    }

    // sets the sign of the large integer to negative if positive, negative otherwise
    @Override
    public void setNegative() {
        if(!isNegative) {
            isNegative = true;
        }
        else {
            isNegative = false;
        }
    }

    // returns a string of the largeInt object when called
    @Override
    public String toString() {
        String string = " ";
        DLL.resetForward();
        for(int i = 0; i < DLL.lengthIs(); i++){
            string = string + DLL.getNextItem();
        }
        string = string.trim();

        string = string.replaceFirst("^0+(?!$)", "");

        if(isNegative && !string.equals("0") && !string.equals("")){
            string = "-" + string;
        }
        return string;
    }

}