package sorisoop.soridam.infra.config.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SoriDamConfigImportSelector.class)
public @interface EnableSoriDamConfig {
	SoriDamConfigGroup[] value();
}

