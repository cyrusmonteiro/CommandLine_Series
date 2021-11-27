import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

public class two {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1)coloured or 2)b&w");
        int choice=sc.nextInt();

        System.out.println("Enter number of rows of pixels");
        int rows=sc.nextInt();
        System.out.println("Enter number of columns of pixels");
        int columns=sc.nextInt();
        photo [][] matrix=new photo[rows][columns];

        if(choice==1){

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    System.out.println("Enter red value of "+i+","+j);
                    int r=sc.nextInt();
                    System.out.println("Enter blue value of "+i+","+j);
                    int b=sc.nextInt();
                    System.out.println("Enter green value of "+i+","+j);
                    int g=sc.nextInt();
                    photo p=new photo(r,b,g);
                    matrix[i][j]=p;

                }
            }
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    matrix[i][j].display();
                }
                System.out.println();
            }
            System.out.println();
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    matrix[i][j].negative();
                }
                System.out.println();
            }

        }

        if(choice==2){

            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    System.out.println("Enter grey value of "+i+","+j);
                    int g=sc.nextInt();
                    photo p=new photo(g);
                    matrix[i][j]=p;

                }
            }
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    matrix[i][j].bwdisplay();
                }
                System.out.println();
            }
            System.out.println();
            for(int i=0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    matrix[i][j].bwnegative();
                }
                System.out.println();
            }
        }

        
        int choice2=-1;
        while(choice2!=4){
            System.out.println("Do you want to 1)Update 2)Display 3)Display negative 4)Exit");
            choice2=sc.nextInt();
        if(choice2==1){
            System.out.println("Enter row number of pixel");
            int i=sc.nextInt();
            System.out.println("Enter column number of pixel");
            int j=sc.nextInt();
            if(choice==1){
                System.out.println("Enter red value of "+i+","+j);
                int r=sc.nextInt();
                System.out.println("Enter blue value of "+i+","+j);
                int b=sc.nextInt();
                System.out.println("Enter green value of "+i+","+j);
                int g=sc.nextInt();
                photo p=new photo(r,b,g);
                matrix[i][j]=p;

                for(int ii=0;ii<rows;ii++){
                    for(int jj=0;jj<columns;jj++){
                        matrix[ii][jj].display();
                    }
                    System.out.println();
                }

            }
            if(choice==2){
                System.out.println("Enter grey value of "+i+","+j);
                int g=sc.nextInt();
                photo p=new photo(g);
                matrix[i][j]=p;

                for(int ii=0;ii<rows;ii++){
                    for(int jj=0;jj<columns;jj++){
                        matrix[ii][jj].bwdisplay();
                    }
                    System.out.println();
                }


            }
        }
        if(choice2==2){
            if(choice==1){
                for(int ii=0;ii<rows;ii++){
                    for(int jj=0;jj<columns;jj++){
                        matrix[ii][jj].display();
                    }
                    System.out.println();
                }
            }
            if(choice==2){
                for(int ii=0;ii<rows;ii++){
                    for(int jj=0;jj<columns;jj++){
                        matrix[ii][jj].bwdisplay();
                    }
                    System.out.println();
                }
            }
        }

        if(choice2==3){
            if(choice==1){
                for(int i=0;i<rows;i++){
                    for(int j=0;j<columns;j++){
                        matrix[i][j].negative();
                    }
                    System.out.println();
                }
            }
            if(choice==2){
                for(int i=0;i<rows;i++){
                    for(int j=0;j<columns;j++){
                        matrix[i][j].bwnegative();
                    }
                    System.out.println();
                }
            }
        }}
    }
}

class pixelcolour<T>{
    T n;
    pixelcolour(T n){
        this.n=n;
    }

    public int negate(){
        int nn=(int)n;
        return 255-nn;
    }
    public T getn(){
        return n;
    }
}

class photo{
    pixelcolour r,b,g;
    photo(int r,int b,int g){
        this.r=new pixelcolour(r);
        this.b=new pixelcolour(b);
        this.g=new pixelcolour(g);
    }

    photo(int grey){
        this.g=new pixelcolour(grey);
    }

    public void display(){
        System.out.print("("+r.getn()+","+b.getn()+","+g.getn()+")");
    }

    public void negative(){
        pixelcolour red=r;
        pixelcolour blue=b;
        pixelcolour green=g;
        System.out.print("("+red.negate()+","+blue.negate()+","+green.negate()+")");
    }

    public void bwnegative(){
        pixelcolour grey=g;
        System.out.print("("+grey.negate()+")");
    }

    public void bwdisplay(){
        System.out.print("("+g.getn()+")");
    }
}