package in.hiddenbrains.calc.Calculations;

public class SimpleCalcCalculation {

    public static String Solution(String StringToCalculate){

        Double answer;
        Double[] numbers = new Double[100];
        String[] operations = new String[100];
        int flagtemp = 0;
        StringBuffer stringBuffer = new StringBuffer(StringToCalculate);

        if(stringBuffer.charAt(0)=='-'){
            flagtemp = 1;
            stringBuffer = stringBuffer.deleteCharAt(0);
            if(stringBuffer.length()==0){
                return "wrong selection";
            }
        }
        if(stringBuffer.charAt(stringBuffer.length()-1) == '+'
                || stringBuffer.charAt(stringBuffer.length()-1) == '-'
                || stringBuffer.charAt(stringBuffer.length()-1) == '*'
                || stringBuffer.charAt(stringBuffer.length()-1) == '/'
                || stringBuffer.charAt(stringBuffer.length()-1) == '.' ){
            return "operator not allowed at last";
        }
        StringBuffer temp = new StringBuffer();

        int j=0;
        int k=0;

        for(int i=0 ; i<stringBuffer.length();i++){

            if(stringBuffer.charAt(i) == '+' || stringBuffer.charAt(i) == '-'
                    || stringBuffer.charAt(i) == '*' || stringBuffer.charAt(i) == '/'){
                if(stringBuffer.charAt(i+1) == '+' || stringBuffer.charAt(i+1) == '-' ||
                        stringBuffer.charAt(i+1) == '*' || stringBuffer.charAt(i+1) == '/'){
                    return " two operators can't be adjacent";
                }
                numbers[j++]=Double.parseDouble(String.valueOf(temp));
                temp.delete(0,temp.length());
                operations[k++]= String.valueOf(stringBuffer.charAt(i));
            }
            else
            {
                temp.append(stringBuffer.charAt(i));
            }
        }

        numbers[j++]=Double.parseDouble(String.valueOf(temp));
        if(flagtemp == 1) {
            numbers[0] = numbers[0] * (-1);
        }

        for(int i=0;i<k;){

            if(operations[i].equals("/")) {
                String tempanswer = MathsOperations.division(numbers[i], numbers[i + 1]);
                if(tempanswer.equals("error"))
                    return "cant devide by zero";
                else
                     numbers[i] = Double.parseDouble(tempanswer);

                for (int m = i + 1; m < numbers.length-1; m++) {
                        numbers[m] = numbers[m + 1];
                }
                for (int m = i ; m < operations.length-1; m++) {
                    operations[m] = operations[m + 1];
                }
                k--;
                i=0;
            }

            else if(operations[i].equals("*")) {
                Double tempanswer = MathsOperations.multiplication(numbers[i], numbers[i + 1]);
                numbers[i] = tempanswer;

                for (int m = i + 1; m < numbers.length-1; m++) {
                    numbers[m] = numbers[m + 1];
                }
                for (int m = i ; m < operations.length-1; m++) {
                    operations[m] = operations[m + 1];
                }
                k--;
                i=0;
            }
            else{
                i++;
            }
        }

        for(int i=0;i<k;){

            if(operations[i].equals("+")) {
                Double tempanswer = MathsOperations.addition(numbers[i], numbers[i + 1]);
                numbers[i] = tempanswer;

                for (int m = i + 1; m < numbers.length-1; m++) {
                    numbers[m] = numbers[m + 1];
                }
                for (int m = i ; m < operations.length-1; m++) {
                    operations[m] = operations[m + 1];
                }
                k--;
                i=0;
            }

            else if(operations[i].equals("-")) {
                Double tempanswer = MathsOperations.substraction(numbers[i], numbers[i + 1]);
                numbers[i] = tempanswer;

                for (int m = i + 1; m < numbers.length-1; m++) {
                    numbers[m] = numbers[m + 1];
                }
                for (int m = i ; m < operations.length-1; m++) {
                    operations[m] = operations[m + 1];
                }
                k--;
                i=0;
            }
            else{
                i++;
            }
        }


        return numbers[0].toString();

    }
}
