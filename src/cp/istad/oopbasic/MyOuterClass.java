package cp.istad.oopbasic;

public class MyOuterClass {
    static String outerName;
    String normalouterName;

    class MyInnerClass{
        String innerName;

        void printData(){
            System.out.println(normalouterName);
            System.out.println(innerName);
        }
    }



    static class MyStaticClass{
        String innerName;




        void setOuterName(String name){
            outerName = name;
        }

        void printData(){
            System.out.println("Outer Name: " + outerName);
            System.out.println("Inner Name: " + innerName);
        }
    }
}
