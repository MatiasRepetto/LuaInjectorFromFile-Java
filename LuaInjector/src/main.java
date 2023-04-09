import LuaInjector.*;
import processUtils.*;
import java.io.IOException;
import com.sun.jna.platform.win32.Kernel32;
import jniPackage.*;
import java.util.Scanner;
import org.luaj.vm2.*;
import org.luaj.vm2.lib.jse.*;



public class main {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert the lua file name");
		String fName = scanner.nextLine();
		System.out.println("Insert the Win Process name");
		String pName = scanner.nextLine();
		String[] fLines = memoryUtils.luaFileReader(fName);
		int pId = memoryUtils.returnProccessId(pName);
		Globals L;
		try {
			Kernel32.HANDLE pMainHandle;
			pMainHandle = JNI.attach(pId);
			L = JsePlatform.standardGlobals();
			luaInjectorClass.luaInjector_exec(L, fLines);
			JNI.detach(pMainHandle);
		}catch (Exception e) {
			System.err.println("Error injecting Lua code: " + e.getMessage());
		} 
	}

}
