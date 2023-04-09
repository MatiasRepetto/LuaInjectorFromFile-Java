package LuaInjector;
import org.luaj.vm2.*;


public class luaInjectorClass {
	public static void luaInjector_exec(Globals l, String[] toExec) {
		for(String s: toExec) {
			l.load(s).call();
		}
	}

} 

