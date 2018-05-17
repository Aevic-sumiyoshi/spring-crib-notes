package keel.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// example-start
@Configuration
public class MessageConfig implements WebMvcConfigurer {

    final MessageSource messageSource;

    public MessageConfig(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public Validator getValidator() {
        return validator();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        // 精査エラー時のメッセージを、MessageSourceから取得するように設定
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }
}
// example-end