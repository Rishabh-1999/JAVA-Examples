public class Main {
public static void main(String[] args) {
    Derived d = new Derived(4,8);
    d.Display();
}
}
class Derived {
    private int x,y;
    Derived(){}
    Derived(int x,int y) {
        this.x=x;
        this.y=y;
    }
    void Display() {
        System.out.println(x+" "+y);
    }
}