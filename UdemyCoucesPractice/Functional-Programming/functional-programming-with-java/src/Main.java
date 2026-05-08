import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        printAllNumberInListStructured(List.of(12,14,1,8,6,12,47,32,1));
        printAllNumberInListFunctional(List.of(1,13,3,5,4,7,20));
        printAllCoursesFromListFunctional(List.of("Spring","Spring boot","MicroServices","API","AWS","ÄZURE"));
    }

    private static void printAllCoursesFromListFunctional(List<String> courses) {
        System.out.println("All  Courses Functional");
        courses.stream()
                .forEach(System.out::println);
        printAllCoursesWhichHaveSpring(courses);
        printAllCoursesFromListWithAtLeast4length(courses);
        printAllCoursesCharacterCount(courses);
    }

    private static void printAllCoursesFromListWithAtLeast4length(List<String> courses) {
        System.out.println("All  Courses whose name has At least 4 length");
        courses.stream()
            .filter(course->course.length()>=4)
            .forEach(System.out::println);
    }

    private static void printAllCoursesWhichHaveSpring(List<String> courses) {
        System.out.println("All  Courses having Spring Common");
        courses.stream()
            .filter(course->course.contains("Spring"))
            .forEach(System.out::println);
    }
    private static void printAllCoursesCharacterCount(List<String> courses) {
        System.out.println("All  Courses Character count");
        courses.stream()
                .map(cources->cources.length())
                .forEach(System.out::println);
    }

    private static void print(int number){
        System.out.println(number);
    }
    private static void printAllNumberInListStructured(List<Integer> integers) {
    //* How to loop
        System.out.println("All  Numbers Structured");
        for (int number : integers) {
            System.out.println(number);
        }
    }
    private static void printAllNumberInListFunctional(List<Integer> integers) {
       //? What to do rather than How to loop
        System.out.println("All Numbers Functional");
        //* integers.stream().forEach(Main::print); //*Method reference
        integers.stream().forEach(System.out::println);//Method reference

        printAllEvenNumberFromListFunctional(integers);
        printAllOddNumberFromListFunctional(integers);
        printSquareOfAllNumberFromListFunctional(integers);
        printCubeOfAllOddNumberFromListFunctional(integers);
    }
    private static void printAllEvenNumberFromListFunctional(List<Integer> integers){
       System.out.println("Even Numbers");

        integers.stream() //! convert to stream
                .filter( number->number%2==0) //* lambda Express
                .forEach(System.out::println);
    }
    private static void printAllOddNumberFromListFunctional(List<Integer> integers){
        System.out.println("Odd Numbers");

        integers.stream()
                .filter( number->number%2!=0) //* lambda Express
                .forEach(System.out::println);
    }

    private static void printSquareOfAllNumberFromListFunctional(List<Integer> integers){
        System.out.println("Square of  Numbers");

        integers.stream()
                .map(number ->number*number) //* lambda Express
                .forEach(System.out::println);
    }

    private static void printCubeOfAllOddNumberFromListFunctional(List<Integer> integers){
        System.out.println("Cube of  Odd Numbers");

        integers.stream()
                .filter(number-> number%2!=0)
                .map(number ->number*number*number) //* lambda Express
                .forEach(System.out::println);
    }

}