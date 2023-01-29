package hello.core.singleton;

public class StatefulService {

    //공유된 메서드를 사용하는게 아니라
//    private int price; //상태를 유지하는 필드
//
//    public void order(String name, int price) {
//        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제
//    }


    //지역변수를 사용해서 써야함
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        return price;
    }

//    public int getPrice() {
//        return price;
//    }
}
