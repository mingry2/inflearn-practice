package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component가 붙은 클래스를 모두 Bean으로 등록함
        // 해당 패키지 부터 하위 패키지까지 모두 탐색 (탐색할 패키지를 지정할 수 있다. -> 패키지를 지정하지 않으면 모든 자바코드, 라이브러리 등 모두 탐색하기 때문에 시간이 오래걸린다.)
//        basePackages = "hello.core.member",
        // 클래스로 지정할 수 있음 -> 해당클래스가 있는 패키지부터 하위까지
//        basePackageClasses = AutoAppConfig.class,
        // 지정하지 않으면 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치
        // 강의의 유지를 위해 앞서 수동으로 Bean을 등록해주는 AppConfig 클래스에도 @Component가 붙어있기 때문에 충돌을 막기 위해 제외시킴
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
