package fr.uga.miage.pc;
import fr.uga.miage.pc.dilemme.front.JDilemme;

public class Main {

	public static void main(String[] args) throws Exception {
		JDilemme test = JDilemme.getInstance();
		test.showFrame();
		/*List<Class> classes = new ArrayList<Class>();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		for(Package pack : loader.getDefinedPackages()) {
			String path = pack.getName();
			classes = FileHelper.GetClasses(path, true);
		}
		List<Class> test = ClassHelper.FilterClass(classes, c -> {
			try {
				return ClassHelper.HaveInterface(c, IStrategie.class) && !Modifier.isAbstract(c.getModifiers());
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} );
		for(Class<?> classe: test) {
			System.out.println(classe.getSimpleName());
		}*/
	}
}
