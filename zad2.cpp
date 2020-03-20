// zad2.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//Bohdan Tkachenko 256630 L1_Zadanie2

#include <iostream>
#include <string>
#include <vector>
using namespace std;



class LiczbyPierwsze
{
    vector<int> v;
public:
    LiczbyPierwsze(int n)
 {
    int *tab = new int[n + 1];
    tab[0] = false;
    tab[1] = false;
    for (int i = 2; i <= n; i++)
    {
        tab[i] = true;
    }
    for (int i = 2; i < n; i++)
        for (int j = 2 * i; j <= n; j += i)
            tab[j] = false;
    for (int i = 0; i < n; i++)
        if (tab[i])
            v.push_back(i);
    delete tab;
 }
        int liczba(int m) throw (string) 
        {
            if (m > v.size() || m < 0)
                throw (string)"Liczba spoza zakresu";
            return v[m];
        }
         
};










int main(int argc, char *argv[])
{
    int *args = new int[argc];
    cout<<argc<<endl;
    
    for (int i = 1; i < argc; i++)
    {
        args[i] = atoi(argv[i]);
        
    }
    if (args[1] <= 0)
    {
        cout << "Nieprawidlowy zakres" << endl;
        return -1;
    }
    
    LiczbyPierwsze *l = new LiczbyPierwsze(args[1]);
    

    for(int i = 2;i<argc;i++)
    {
        if(*argv[i]=='0' || args[i] !=0)
        {
            try { cout << args[i] << " - " << l->liczba(args[i]) << endl; }
            catch (string ex) { cout << argv[i] << " - " << ex << endl; }
        }
        else { cout << argv[i] << " - Nieprawidlowa danna" << endl; }
    }
    
    delete[]args;
    delete l;
}
