package jniPackage;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;

public class JNI {
	public static Kernel32.HANDLE attach(int pid) {
		Kernel32 kernel32 = Kernel32.INSTANCE;
		Kernel32.HANDLE processHandle = kernel32.OpenProcess(WinNT.PROCESS_ALL_ACCESS, false, pid);
		return processHandle;
    }
    
    public static void detach(Kernel32.HANDLE pHandle) {
    	// Detach to the target process on Windows
    	Kernel32 kernel32 = Kernel32.INSTANCE;
    	kernel32.CloseHandle(pHandle);
    }
}
