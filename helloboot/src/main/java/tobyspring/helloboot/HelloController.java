package tobyspring.helloboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //metaAnnotation 어노테이션 위에 붙은 어노테이션를 붙어도 작동한다
public class HelloController {
    private final HelloService helloService;
    //private final ApplicationContext applicationContext; //final은 생성자가 완료된 시점까지 초기화가 되어야하는데 생성자 이후에 초기화 되는 메소드에 매개변수로 들어가기 때문에 final을 넣어 줄 수 없다.

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name) {
        if (name == null || name.trim().length() == 0) throw new IllegalArgumentException();
        return helloService.sayHello(name); // null이 아닌경우 네임값이 메소드로 들어가고 null이면 nullpoint예외
    }
}
