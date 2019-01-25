package pagerank_user;

import java.util.*;

/**
 *
 * @author Sunny
 */
public class PageRank_User
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter the number of pages : ");
        int n = input.nextInt();

        int link[][] = new int[n][n];
        int outLinks[] = new int[n];
        double pageRank[] = new double[n];
        double dampingFactor = 0.85;

        System.out.println("\n------Enter the links among pages. [1 if link exists and 0 if not]------");

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                link[i][j] = 0;
            outLinks[i] = 0;
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j)
                {
                    System.out.print("\nIs there a link from page " + (char)(i + 65) + " to page " + (char)(j + 65) + " : ");
                    int t = input.nextInt();
                    if(t == 1)
                    {
                        link[i][j] = 1;
                        outLinks[i]++;
                    }
                }

        System.out.print("\n\n------Enter the initial page rank values of each page------\n");

        for(int i = 0; i < n; i++)
        {
            System.out.print("\nInitial Pagerank value of page " + (char)(i + 65) + " is : ");
            pageRank[i] = input.nextDouble();
        }

        for(int k = 0; k < n; k++)
        {
        	double term = 0;
            for(int i = (k + 1) % n ; (i != k) ; i = (i + 1) % n )
            {
                if( (link[i][k] == 1) && (outLinks[i] != 0) )
                    term += pageRank[i] / outLinks[i];	//Calculating sum of vote weightages for each page
            }
            /*
				Applying the formula: PR(A) = (1-d) + d (PR(T1)/C(T1) + ... + PR(Tn)/C(Tn))
				where,
					PR(Ti) : Page Rank value for the page Ti
					d     : Damping Factor
					C(Ti) : The number of outgoing links for page Ti
					PR(Ti)/C(Ti) : Fraction of vote weightage for page Ti
            */
            pageRank[k] = (1 - dampingFactor) + dampingFactor * (term);
        }

        System.out.println("\n\n------The final Pagerank values are------");
        for(int i = 0; i < n; i++)
            System.out.println("\nThe pagerank value of page " + (char)(i + 65) + " is : " + pageRank[i]);
    }

}