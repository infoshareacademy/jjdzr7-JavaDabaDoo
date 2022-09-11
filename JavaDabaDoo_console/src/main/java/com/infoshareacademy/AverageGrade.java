package com.infoshareacademy;
import java.util.*;
import java.lang.*;

public class AverageGrade {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                int a, i, n;
                double w = 0.0;
                n = scanner.nextInt();
                for( i = 0; i < n; i++ )
                {
                    a = scanner.nextInt();
                    w += a;
                }
                System.out.println(w/n);
            }
        }
