package testcases.CWE111_Unsafe_JNI;

import testcasesupport.AbstractTestCaseBadOnly;
import testcasesupport.IO;
import java.io.*;
import java.util.logging.Level;

public class CWE111_Unsafe_JNI__console_01 {

native String test(String s1, int len);
public void bad() throws IOException {
    InputStreamReader readerInputStream = null;
    boolean staticTrue = true;
    StackTraceElement stackTraceElement = null;
    int intNumber = 0;
    IO.writeLine(stackTraceElement.toString());
}
/* Below is the main(). It is only used when building this testcase on 
     * its own for testing or for building a binary to use in testing binary 
     * analysis tools. It is not used when compiling all the testcases as one 
     * application, which is how source code analysis tools are tested. 
	 */
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    StackTraceElement stackTraceElement = null;
}
}
