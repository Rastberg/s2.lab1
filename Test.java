
class SpozaZakresuException extends Exception {}

class LiczbyPierwsze
{
  int []tabp;
  boolean []tab;
  private int rozmiar(int n)
  {
      int k = 0;
      tab = new boolean[n+1];
      tab[0] = false;
      tab[1] = false;
      for(int i = 2;i<=n;i++)
      {
          tab[i] = true;
      }
      for(int i = 2 ; i<n;i++)
          for(int j = 2*i;j<=n;j+=i)
              tab[j] = false;
      for(int i = 0;i<n;i++)
          if(tab[i])
              k++;
      return k;
  }
 LiczbyPierwsze(int n)
 {

     int size = rozmiar(n);
     tabp = new int[size];
     int i=0;
     while(i<size)
     {
         for(int j =0;j<(tab.length-1);j++) {
             if (tab[j] == true)
             {
                 tabp[i]=j;
                 i++;
             }
         }
     }
 }

 public int liczba(int m) throws SpozaZakresuException
 {
     if(m > tabp.length || m <0) throw new SpozaZakresuException();
     return tabp[m];
 }
}
public class Test {
    public static void main(String[] args)
    {

	 try {
         int a = Integer.parseUnsignedInt(args[0]);
         LiczbyPierwsze l = new LiczbyPierwsze(a);
         try {
             System.out.println(l.liczba(1));
             System.out.println(l.liczba(a));
         }catch (Exception ex)
         {System.out.println("Test");}

         for(int i = 1;i < args.length;i++)
         {
             try{
               int temp = Integer.parseInt(args[i]);
               try {
                   System.out.println(temp + " - " + l.liczba(temp));
               }
               catch (SpozaZakresuException ex)
                         {System.out.println(args[i]+ "- Liczba spoza zakresu");}
             }catch (NumberFormatException ex)
             {System.out.println(args[i]+"- Nieprawidlowa danna");}

         }

     }catch (NumberFormatException ex)
    {
        System.out.println(args[0]+" Nieprawidlowy zakres");
        System.exit(-1);
    }

    }
}
