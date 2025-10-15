package cp.istad.oopbasic;

public class MyProgramJava {
    public static void main(String[] args) {
//        MyOuterClass.outerName = "Sakkda1";
        MyOuterClass.MyStaticClass inner= new MyOuterClass
                .MyStaticClass();
        inner.innerName = "ISTAD\n";
        inner.setOuterName("Chaya");
        inner.printData();

        MyOuterClass outer = new MyOuterClass();
        outer.normalouterName = "Normal Outer Name";
        MyOuterClass.MyInnerClass normalInner = outer.new MyInnerClass();
        normalInner.innerName = "Inner Class Normal";
        normalInner.printData();

    }
}

