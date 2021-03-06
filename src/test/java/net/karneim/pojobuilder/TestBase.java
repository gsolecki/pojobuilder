package net.karneim.pojobuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;

import net.karneim.pojobuilder.model.PropertyM;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;

public class TestBase extends Assert {
	public static final String SRC_TESTDATA_DIR = "src/test/java";

	public static ExecutableElement getFirstMethodByName(String name, List<ExecutableElement> methods) {
		for (ExecutableElement e : methods) {
			if (name.equals(e.getSimpleName().toString())) {
				return e;
			}
		}
		return null;
	}

	public static <T> Matcher<Collection<T>> contains(final T element) {
		Matcher<Collection<T>> result = new BaseMatcher<Collection<T>>() {

			@Override
			public boolean matches(Object item) {
				@SuppressWarnings("unchecked")
				Collection<T> actual = (Collection<T>) item;
				return actual.contains(element);
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("contains element ");
				description.appendValue(element);
			}

		};
		return result;
	}

	public static Matcher<Collection<PropertyM>> containsPropertyWithName(final String aName) {
		Matcher<Collection<PropertyM>> result = new BaseMatcher<Collection<PropertyM>>() {
			@Override
			public boolean matches(Object item) {
				@SuppressWarnings("unchecked")
				List<PropertyM> actual = (List<PropertyM>) item;
				for (PropertyM p : actual) {
					if (aName.equals(p.getName().toString())) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("name ");
				description.appendValue(aName);
			}

		};
		return result;
	}

	public static Matcher<Collection<PropertyM>> doesNotContainPropertyWithName(final String aName) {
		Matcher<Collection<PropertyM>> result = new BaseMatcher<Collection<PropertyM>>() {
			@Override
			public boolean matches(Object item) {
				@SuppressWarnings("unchecked")
				List<PropertyM> actual = (List<PropertyM>) item;
				for (PropertyM p : actual) {
					if (aName.equals(p.getName().toString())) {
						return false;
					}
				}
				return true;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("name ");
				description.appendValue(aName);
			}

		};
		return result;
	}
	
	public static Matcher<List<? extends Element>> containsElementWithName(final String aName) {
		Matcher<List<? extends Element>> result = new BaseMatcher<List<? extends Element>>() {

			@Override
			public boolean matches(Object item) {
				@SuppressWarnings("unchecked")
				List<Element> actual = (List<Element>) item;
				for (Element elem : actual) {
					if (aName.equals(elem.getSimpleName().toString())) {
						return true;
					}
				}
				return false;
			}

			@Override
			public void describeTo(Description description) {
				description.appendText("name ");
				description.appendValue(aName);
			}

		};
		return result;
	}

	public static List<PropertyM> filterByName(List<PropertyM> properties, String name) {
		List<PropertyM> result = new ArrayList<PropertyM>();
		for (PropertyM p : properties) {
			if (name == null && p.getName() == null) {
				result.add(p);
			} else if (name != null && name.equals(p.getName())) {
				result.add(p);
			}
		}
		return result;
	}

	public static PropertyM getFirstPropertyByName(List<PropertyM> properties, String name) {
		for (PropertyM p : properties) {
			if (name.equals(p.getName())) {
				return p;
			}
		}
		return null;
	}

}
