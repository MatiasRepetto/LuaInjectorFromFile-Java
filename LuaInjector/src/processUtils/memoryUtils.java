package processUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class memoryUtils {
	
	public static int returnProccessId(String procName) throws InterruptedException, IOException {
		String processName = "";
		
		processName = "tasklist.exe /fo csv /nh /fi \"imagename eq " + procName + "\"";
		// Execute the command to get the process ID
	    Process process = Runtime.getRuntime().exec(processName);
	    process.waitFor();

	    // Read the output of the command
	    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	    String line = reader.readLine();
	    int pid = -1;
	    // Extract the process ID from the output
	    if (line != null && !line.isEmpty()) {
	    	String[] parts = line.split(",");
		    String pidS = parts[1].replaceAll("\"", "");
	        pid = Integer.parseInt(pidS);
	    }
	    return pid;
	}
	
	public static String[] luaFileReader(String fileName) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        List<String> lines = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            lines.add(line); 
        }
        
        reader.close();
        String[] resList = lines.toArray(new String[0]);
        
        return resList;
	} 
}
