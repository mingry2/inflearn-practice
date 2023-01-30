package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Component가 붙은 클래스를 모두 Bean으로 등록함
        // 강의의 유지를 위해 앞서 수동으로 Bean을 등록해주는 AppConfig 클래스에도 @Component가 붙어있기 때문에 충돌을 막기 위해 제외시킴
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
