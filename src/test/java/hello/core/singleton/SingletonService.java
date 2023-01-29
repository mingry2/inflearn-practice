package hello.core.singleton;

public class SingletonService {

    //static으로 만들면 class에 딱 한번만 올라가기 때문에 더 만들지 않고 하나로 공유가능
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    //이렇게 해도 다른 곳에서 동일한 객체를 만들어버리면 소용없음
    //해결방안 private 으로 !
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
