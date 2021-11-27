import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class one {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books");
        int n=sc.nextInt();
        book array[]=new book[n];
        for(int i=0;i<n;i++){
            array[i]=new book();
        }
        System.out.println("Enter number of racks");
        int k=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<n;i++){
            System.out.println("Enter book name");
            String name=sc.nextLine();
            System.out.println(name);
            System.out.println("Enter ISBN number");
            int isbn=sc.nextInt();
            System.out.println("Enter barcode number");
            int bn=sc.nextInt();
            sc.nextLine();
            array[i].setter(isbn, bn, name);
        }
        bubbleSort(array);

        book arrangement[][]=new book[k][n/k];
        for(int i=0;i<k;i++){
            for(int j=0;j<n/k;j++){
                arrangement[i][j]=new book();
            }
        }
        int ii=0;
        for(int i=0;i<k;i++){
            System.out.print("Rack"+i+": ");
            for(int j=0;j<n/k;j++){
                arrangement[i][j]=array[ii];
                ii++;
                
                System.out.print("("+arrangement[i][j].gettitle().getname()+","+arrangement[i][j].getisbn().getnumber()+","+arrangement[i][j].getbarcode().getnumber()+")");
            }
            System.out.println();
        }
    }

    public static void bubbleSort(book arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].compareTo(arr[j+1])==1)
                {
                    book temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}

interface Comparable<T> {
    public int compareTo(T other);
    
}


class ISBN implements Comparable<ISBN>{
    int number;

    public void setnumber(int n){
        number=n;
    }
    public int getnumber(){
        return number;
    }

    @Override
    public int compareTo(ISBN n){
        if(number==n.getnumber())
            return 0;
        else if(number<n.getnumber())
            return -1;
        else
            return 1;
    }
}

class title implements Comparable<title>{
    String name;
    public void setname(String s){
        name=s;
    }
    public String getname(){
        return name;
    }

    @Override
    public int compareTo(title n){
        String nameC1=name.toLowerCase();
        String nameC2=n.getname().toLowerCase();
        int len=0;
        if(nameC1.length()<nameC1.length()) 
            len=nameC1.length();
        else if(nameC1.length()>nameC1.length())
            len=nameC2.length();
        else
            len=nameC2.length();
        for(int i=0;i<len;i++){
            if(nameC1.charAt(i)>nameC2.charAt(i))
                return 1;
            else if(nameC1.charAt(i)<nameC2.charAt(i))
                return -1;
        }
        if(nameC1.length()>nameC1.length()) 
            return 1;
        else if(nameC1.length()<nameC1.length())
            return -1;
        return 0;
    }

}

class barcode implements Comparable<barcode> {
    int number;
    public void setnumber(int n){
        number=n;
    }
    public int getnumber(){
        return number;
    }

    @Override
    public int compareTo(barcode n){
        if(number==n.getnumber())
            return 0;
        else if(number<n.getnumber())
            return -1;
        else
            return 1;
    }
}

class book implements Comparable<book>{
    ISBN number=new ISBN();
    title name=new title();
    barcode n=new barcode();
    public void setter(int i, int bn, String s){
        number.setnumber(i);
        n.setnumber(bn);
        name.setname(s);
    }
    public title gettitle(){
        return name;
    }
    public ISBN getisbn(){
        return number;
    }
    public barcode getbarcode(){
        return n;
    }
    @Override
    public int compareTo(book b){
        if(this.name.compareTo(b.gettitle())==1)
            return 1;
        else if(this.name.compareTo(b.gettitle())==0){
            if(this.number.compareTo(b.getisbn())==1)
                return 1;
            else if(this.number.compareTo(b.getisbn())==0)
                if(this.n.compareTo(b.getbarcode())==1){
                    return 1;
                }
        }
        return -1;
    }
    
}



