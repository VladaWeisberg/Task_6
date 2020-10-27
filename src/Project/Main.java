package Project;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        double x = readDouble("Euler number power");
        int n = readInt("number of term");

        printResults("first", findSumTerms(x, n));
        printResults("second", findSumBigTerms(x, n));
        printResults("third", findSumSmallTerms(x, n));
        printResults("fourth", findFunctionValue(x));
    }

    private static double findInverseFactorial(int n)
    {
        if (n != 0)
        {
            int fact = 1;

            for (int i = 1; i <= n; i++)
            {
                fact = fact * i;
            }

            return 1.0 / fact;
        }
        return 1;
    }

    private static double findSumElement(double x, int n)
    {
        double pow = Math.pow(x, n);
        double fact = findInverseFactorial(n);

        return pow * fact;
    }
    private static double findSumTerms(double x, int n)
    {
        double sum = 0;

        for (int i = 0; i < n; i++)
        {
            double sumElement = findSumElement(x, i);

            sum = sum + sumElement;
        }

        return sum;
    }

    private static double findSumBigTerms(double x, int n)
    {
        double sum = 0;

        for (int i = 0; i <= n; i++)
        {
            double sumElement = findSumElement(x, i);

            if (Math.abs(sumElement) > Math.E)
            {
                sum = sum + sumElement;
            }
        }
        return sum;
    }

    private static double findSumSmallTerms(double x, int n)
    {
        double sum = 0;

        for (int i = 0; i <= n; i++)
        {
            double sumElement = findSumElement(x, i);

            if (Math.abs(sumElement) > Math.E / 10)
            {
                sum = sum + sumElement;
            }
        }
        return sum;
    }

    private static double findFunctionValue(double x)
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
        System.out.printf("The result of %s operation is %1f\n", name, result);
    }
}
