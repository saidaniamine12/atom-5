package net.thevpc.gaming.atom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by vpc on 9/23/16.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtomSpriteCollisionTask {
    String name() default "";
    String sceneEngine() default "";
    String kind() ;
    Scope scope() default Scope.PROTOTYPE;
}
