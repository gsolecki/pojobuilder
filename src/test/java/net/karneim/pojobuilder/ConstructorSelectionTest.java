package net.karneim.pojobuilder;

import net.karneim.pojobuilder.model.BuilderM;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import testdata.constructor.ClassLevelAnnotation;
import testdata.constructor.ConstructorLevelAnnotation;
import testenv.AddToSourceTree;
import testenv.ProcessingEnvironmentRunner;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(ProcessingEnvironmentRunner.class)
@AddToSourceTree({ TestBase.SRC_TESTDATA_DIR })
public class ConstructorSelectionTest extends TestBase {
	private static String APPLE_CLASSNAME_CLASS = ClassLevelAnnotation.Apple.class.getCanonicalName();
    private static String BANANA_CLASSNAME_CLASS = ClassLevelAnnotation.Banana.class.getCanonicalName();
    private static String CHERRY_CLASSNAME_CLASS = ClassLevelAnnotation.Cherry.class.getCanonicalName();
    private static String DEWBERRY_CLASSNAME_CLASS = ClassLevelAnnotation.Dewberry.class.getCanonicalName();
    private static String APPLE_CLASSNAME_CONSTRUCTOR = ConstructorLevelAnnotation.Apple.class.getCanonicalName();
    private static String BANANA_CLASSNAME_CONSTRUCTOR = ConstructorLevelAnnotation.Banana.class.getCanonicalName();
    private static String CHERRY_CLASSNAME_CONSTRUCTOR = ConstructorLevelAnnotation.Cherry.class.getCanonicalName();
    private static String DEWBERRY_CLASSNAME_CONSTRUCTOR = ConstructorLevelAnnotation.Dewberry.class.getCanonicalName();

    private ProcessingEnvironment env;

	private BuilderModelProducer underTest;

	@Before
	public void setup() {
		env = ProcessingEnvironmentRunner.getProcessingEnvironment();
		TypeMUtils typeMUtils = new TypeMUtils();
		underTest = new BuilderModelProducer(env, typeMUtils);
	}

	@Test
    public void testSingleDefaultConstructorViaClassLevelAnnotation() {
        testSingleDefaultConstructor(APPLE_CLASSNAME_CLASS);
    }

    @Test
    public void testSingleDefaultConstructorViaConstructorLevelAnnotation() {
        testSingleDefaultConstructor(APPLE_CLASSNAME_CONSTRUCTOR);
    }

	private void testSingleDefaultConstructor(String appleClassname) {
		// Given:
		TypeElement pojoTypeElement = env.getElementUtils().getTypeElement(appleClassname);

		// When:
		Output output = underTest.produce(new Input(pojoTypeElement));
		BuilderM builder = output.getBuilder();

		// Then:
		assertEquals("builder classname", "AppleBuilder", builder.getType().getSimpleName());
		assertEquals("size of properties", 0, builder.getProperties().size());
	}

    @Test
    public void testSingleAnnotatedConstructorWithRenamingViaClassLevelAnnotation() {
        testSingleAnnotatedConstructorWithRenaming(BANANA_CLASSNAME_CLASS);
    }

    @Test
    public void testSingleAnnotatedConstructorWithRenamingViaConstructorLevelAnnotation() {
        testSingleAnnotatedConstructorWithRenaming(BANANA_CLASSNAME_CONSTRUCTOR);
    }

    private void testSingleAnnotatedConstructorWithRenaming(String bananaClassname) {
        // Given:
        TypeElement pojoTypeElement = env.getElementUtils().getTypeElement(bananaClassname);

        // When:
        Output output = underTest.produce(new Input(pojoTypeElement));
        BuilderM builder = output.getBuilder();

        // Then:
        assertEquals("builder classname", "BananaBuilder", builder.getType().getSimpleName());
        assertEquals("size of properties", 1, builder.getProperties().size());
        assertThat(builder.getProperties(), containsPropertyWithName("colour"));
    }

    @Test
    public void testDefaultConstructorWhereOtherChoicesExistViaClassLevelAnnotation() {
        testDefaultConstructorWhereOtherChoicesExist(CHERRY_CLASSNAME_CLASS);
    }

    @Test
    public void testDefaultConstructorWhereOtherChoicesExistViaConstructorLevelAnnotation() {
        testDefaultConstructorWhereOtherChoicesExist(CHERRY_CLASSNAME_CONSTRUCTOR);
    }

    private void testDefaultConstructorWhereOtherChoicesExist(String cherryClassname) {
        // Given:
        TypeElement pojoTypeElement = env.getElementUtils().getTypeElement(cherryClassname);

        // When:
        Output output = underTest.produce(new Input(pojoTypeElement));
        BuilderM builder = output.getBuilder();

        // Then:
        assertEquals("builder classname", "CherryBuilder", builder.getType().getSimpleName());
        assertEquals("size of properties", 1, builder.getProperties().size());
        assertThat(builder.getProperties(), containsPropertyWithName("colour"));
    }

    @Test
    public void testNonDefaultConstructorWhereOtherChoicesExistViaClassLevelAnnotation() {
        testNonDefaultConstructorWhereOtherChoicesExist(DEWBERRY_CLASSNAME_CLASS);
    }

    @Test
    public void testNonDefaultConstructorWhereOtherChoicesExistViaConstructorLevelAnnotation() {
        testNonDefaultConstructorWhereOtherChoicesExist(DEWBERRY_CLASSNAME_CONSTRUCTOR);
    }

    private void testNonDefaultConstructorWhereOtherChoicesExist(String dewberryClassname) {
        // Given:
        TypeElement pojoTypeElement = env.getElementUtils().getTypeElement(dewberryClassname);

        // When:
        Output output = underTest.produce(new Input(pojoTypeElement));
        BuilderM builder = output.getBuilder();

        // Then:
        assertEquals("builder classname", "DewberryBuilder", builder.getType().getSimpleName());
        assertEquals("size of properties", 1, builder.getProperties().size());
        assertThat(builder.getProperties(), containsPropertyWithName("colour"));
    }

}