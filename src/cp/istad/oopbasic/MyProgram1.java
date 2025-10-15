package cp.istad.oopbasic;

public class MyProgram1 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.draw();

        Rectangle specialRectangle = new Rectangle(){
            int x = 10;
            @Override
            public void draw() {
                System.out.println("Draw rectangle double line: " + x );
            }
        };
        specialRectangle.draw();
    }
}
