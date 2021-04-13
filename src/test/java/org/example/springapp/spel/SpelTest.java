package org.example.springapp.spel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SpelTest {

    private ApplicationContext context;
    private StandardEvaluationContext evalContext;
    private SpelExpressionParser parser;

    @BeforeEach
    public void setUp() {
        context = new AnnotationConfigApplicationContext(AppContextConfig.class);
        evalContext = new StandardEvaluationContext();
        parser = new SpelExpressionParser();
    }

    private <T> T parse(String spel, Class<T> returnType) {
        Expression expression = parser.parseExpression(spel);
        return expression.getValue(returnType);
    }

    private <T> T parse(String spel, Class<T> returnType, Object objectRoot) {
        Expression expression = parser.parseExpression(spel);
        return expression.getValue(objectRoot, returnType);
    }

    private <T> T parse(String spel, Class<T> returnType, EvaluationContext evalContext) {
        Expression expression = parser.parseExpression(spel);
        return expression.getValue(evalContext, returnType);
    }

    @Test
    public void testLiteral() {
        assertEquals("SpEL", parse("'SpEL'", String.class));
    }

    @Test
    public void testProperty() {
        Biscuit biscuit = new Biscuit("Digestive", false);
        assertEquals("Digestive", parse("type", String.class, biscuit));
    }

    @Test
    public void testCollection() {
        List<Biscuit> biscuits = Arrays.asList(
                new Biscuit("Digestive", false),
                new Biscuit("Bourbon", true),
                new Biscuit("Shortbread", false)
        );
        assertEquals("Bourbon", parse("[1].type", String.class, biscuits));
    }

    @Test
    public void testMethod() {
        assertEquals("Hello world", parse("'Hello'.concat(' world')", String.class));
    }

    @Test
    public void testOperators() {
        assertTrue(parse("2 > 1 && 9 % 3 == 0", Boolean.class));
        assertTrue(parse("2 gt 1 and 9 mod 3 eq 0", Boolean.class));
        assertTrue(parse("42 instanceof T(Integer)", Boolean.class));
    }

    @Test
    public void testVariables() {
        evalContext.setVariable("myName", "Stuart");
        assertEquals("Stuart", parse("#myName", String.class, evalContext));
    }

    @Test
    public void testBeanReference() {
        evalContext.setBeanResolver(new BeanFactoryResolver(context));
        User user = parse("@user", User.class, evalContext);
        assertNotNull(user);
    }
}
