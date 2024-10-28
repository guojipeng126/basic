import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        List<User> uList = new ArrayList();
        User u1 = new User();
        u1.setAddr("a1;a2;a3;a4;a5");
        User u2 = new User();
        u2.setAddr("b1;b2;b3;b4;b5");
        uList.add(u1);
        uList.add(u2);
        List<String> addrList = uList.stream().map(x -> x.getAddr()).flatMap(x-> Arrays.stream(x.split(";"))).collect(Collectors.toList());

        System.out.println(Arrays.toString(addrList.toArray()));




    }


}

class User{
    private String addr;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}

