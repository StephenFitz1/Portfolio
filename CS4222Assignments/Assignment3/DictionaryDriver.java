public class DictionaryDriver {
    public static void main(String[] args) {
        Dictionary test = new Dictionary("C:\\Users\\steph\\OneDrive\\Desktop\\CS4222\\Assignment2022Part3\\Assignment2022Part3\\src\\Sample.CSV", 5, 10);
        System.out.println(); //Prints out sorted list
//        Dictionary test2 = new Dictionary("src\\Sample.CVS", 4, 4);
        test.add("after"); //Will return that it is already in list
        System.out.println();
        test.add("brass"); //Will return that it is already in list
        System.out.println();
        test.add("formula1");//Will return that it was not find in the list
        System.out.println();
        test.add("hello");

    }
}
