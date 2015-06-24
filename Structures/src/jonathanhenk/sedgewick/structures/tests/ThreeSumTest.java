package jonathanhenk.sedgewick.structures.tests;

import jonathanhenk.sedgewick.structures.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

import java.io.File;

import com.google.common.io.Files;
import com.google.common.math.DoubleMath;

import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.In;


/**
 * Unit test for ResizingArrayStack
 */
public class ThreeSumTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ThreeSumTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ThreeSumTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	public static int count(int[] a)
	{ // Count triples that sum to 0.
	int N = a.length;
	int cnt = 0;
	for (int i = 0; i < N; i++)
		for (int j = i+1; j < N; j++)
			for (int k = j+1; k < N; k++)
				if (a[i] + a[j] + a[k] == 0)
					cnt++;
	return cnt;
	}


	// public void testThreeSumWithTime()
	// {
	// 	FileUtils fileutils = new FileUtils();
	// 	Queue<File> files = new Queue<File>();
	// 	files = fileutils.getFilesRecursive("C:\\Users\\Jon\\algs4\\InputDataFiles\\");
	// 	Out out = new Out("C:\\Users\\Jon\\algs4\\Results\\results.txt");
	// 	for (File f : files)
	// 	{
	// 		try {
	// 		In in = new In(f);
	// 		int[] values = in.readAllInts();

	// 		Stopwatch sw = new Stopwatch();
	// 		int triples = count(values);
	// 		StringBuilder sb = new StringBuilder();
	// 		sb.append(Files.getNameWithoutExtension(f.toString()));
	// 		sb.append(", count=");
	// 		sb.append(triples);
	// 		sb.append(", time=");
	// 		sb.append(String.valueOf(sw.elapsedTime()));
	// 		out.println(sb);
	// 		sw = null;
	// 		StdOut.println(sb);
	// 				} catch (NullPointerException e)
	// 	{
	// 		StdOut.println("File f=" + f.toString());
	// 	}
	// 	}
	// }

	public void testRandom()
	{
		int i=1;
		while (i*i*i <= 1000)
			i++;
		StdOut.println("i=" + String.valueOf(i));

		i=1;
		while (i*i*i <= 60000)
			i++;
		StdOut.println("i=" + String.valueOf(i));

		i=1;
		while (i*i*i <= 3600000)
			i++;
		StdOut.println("i=" + String.valueOf(i));

	}

}


