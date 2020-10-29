package Project;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        double x = readDouble("Euler number power");
        double epsilon = readDouble("epsilon");
        int n = readInt("number of term");

        printResults("sum", findSumSeries(x, n,0,0));
        printResults("limited by epsilon", findSumSeries(x, n, 1, epsilon));
        printResults("limited by epsilon/10", findSumSeries(x, n, 1,epsilon / 10));
        printResults("right", findRightResult(x));
    }

    private static double findSumSeries(double x, int n, int index, double epsilon)
    {
        double term = 1;
        double sum = 1;
        double sumWithEpsilon = 1;

        for (int i = 1; Math.abs(term) > epsilon; i++)
        {
            term *= x / i;

            if (i <= n)
            {
                sum += term;
            }

            sumWithEpsilon += term;
        }

        double[] arraySums= {sum, sumWithEpsilon};
        return arraySums[index];
    }

    private static double findRightResult(double x)
    {
        return Math.pow(Math.E, x);
    }

    private static int readInt(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s ", name);
        return scanner.nextInt();
    }

    private static double readDouble(String name)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Input %s ", name);
        return scanner.nextDouble();
    }

    private static void printResults(String name, double result)
    {
        System.out.printf("The %s result is %1f\n", name, result);
    }
}
