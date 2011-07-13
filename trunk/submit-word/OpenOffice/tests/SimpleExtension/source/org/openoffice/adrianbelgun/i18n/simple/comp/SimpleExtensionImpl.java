package org.openoffice.adrianbelgun.i18n.simple.comp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.lib.uno.helper.Factory;
import com.sun.star.lib.uno.helper.WeakBase;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.uno.XComponentContext;

public final class SimpleExtensionImpl extends WeakBase implements
		org.openoffice.adrianbelgun.i18n.simple.XSimpleExtension,
		com.sun.star.lang.XServiceInfo {
	private final XComponentContext m_xContext;
	private static final String m_implementationName = SimpleExtensionImpl.class
			.getName();
	private static final String[] m_serviceNames = { "org.openoffice.adrianbelgun.i18n.simple.SimpleExtension" };

	public SimpleExtensionImpl(XComponentContext context) {
		m_xContext = context;
	};

	public static XSingleComponentFactory __getComponentFactory(
			String sImplementationName) {
		XSingleComponentFactory xFactory = null;

		if (sImplementationName.equals(m_implementationName))
			xFactory = Factory.createComponentFactory(
					SimpleExtensionImpl.class, m_serviceNames);
		return xFactory;
	}

	public static boolean __writeRegistryServiceInfo(XRegistryKey xRegistryKey) {
		return Factory.writeRegistryServiceInfo(m_implementationName,
				m_serviceNames, xRegistryKey);
	}

	// org.openoffice.adrianbelgun.i18n.simple.XSimpleExtension:
	public void printSomething() {
		try {
			PrintStream out = new PrintStream(new File("D:\\Test.txt"));
			out.println("Test");
			out.close();
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		}
}

	// com.sun.star.lang.XServiceInfo:
	public String getImplementationName() {
		return m_implementationName;
	}

	public boolean supportsService(String sService) {
		int len = m_serviceNames.length;

		for (int i = 0; i < len; i++) {
			if (sService.equals(m_serviceNames[i]))
				return true;
		}
		return false;
	}

	public String[] getSupportedServiceNames() {
		return m_serviceNames;
	}

}
