/*
 * @description Declare that the function throws "Exception" rather than a specific exception.  In this test case, we don't necessarily throw an exception to differentiate it from other test cases.
 *
 * */

package testcases.CWE397_Throw_Generic;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.logging.Level;

public class CWE397_Throw_Generic__declare_Exception_01 extends AbstractTestCase 
{
    public void bad() throws Exception /* FLAW: Method is declared as throwing Exception, which is very generic */ 
    {
        int thisIsATest;
        FileInputStream streamFileInput = null; /* May throw a FileNotFoundException */
        IO.writeLine("File 'filename.txt' exists");
        thisIsATest = 1;

        System.out.println("this is a test" + thisIsATest);
        System.out.println(thisIsATest);

        long thisIsALong = 4440;
        streamFileInput.wait(thisIsALong, thisIsATest);

        try 
        {
            streamFileInput.close();
        } 
        catch (IOException exceptIO) 
        {
            IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
        }
    }

    private void good1() throws FileNotFoundException /* FIX: Declare that method throws a specific exception */
    {
        FileInputStream streamFileInput = new FileInputStream("filename.txt"); /* May throw a FileNotFoundException */
        IO.writeLine("File 'filename.txt' exists");
        
        try 
        {
            streamFileInput.close();
        } 
        catch (IOException exceptIO) 
        {
            IO.logger.log(Level.WARNING, "Error closing FileInputStream", exceptIO);
        }
    }

    public void good() throws FileNotFoundException
    {
        good1();
    }

    /* Below is the main(). It is only used when building this testcase on
     * its own for testing or for building a binary to use in testing binary
     * analysis tools. It is not used when compiling all the testcases as one
     * application, which is how source code analysis tools are tested. 
	 */
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}