import java.util.Scanner;
import java.util.Arrays;
import java.util.*;


public class matrices {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ch=0;
        matrix m[]=new matrix[1000];
        int m_no=0;
        while(ch!=16){
            System.out.println("1. Take matrices as input and label them with appropriate matrix-types.\n2. Create matrices of requested matrix-types and label them with appropriate matrix-types.\n3. Change the elements of a matrix as long as the fixed matrix-type labels remain valid.\n4. Display all the matrix-type labels of a requested matrix.\n5. Perform addition, subtraction, multiplication & division.\n6. Perform element-wise operations.\n7. Transpose matrices.\n8. Inverse matrices.\n9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n10. Compute determinants.\n11. Use singleton matrices as scalars, if requested.\n12. Compute A+A^T for a matrix A.\n13. Compute Eigen vectors and values.\n14. Solve sets of linear equations using matrices.\n15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n16. Exit");
            ch=sc.nextInt();

            if(ch==1){
                System.out.println("Enter number of rows ");
                int rows=sc.nextInt();
                System.out.println("Enter number of columns ");
                int columns=sc.nextInt();
                int arr[][]=new int[rows][columns];
                for(int i=0;i<rows;i++){
                    for(int j=0;j<columns;j++){
                        System.out.println("Enter element ["+i+"]["+j+"]");
                        arr[i][j]=sc.nextInt();
                    }
                }
                //identity--------------------------------
                boolean identity_flag=true;
                if(rows==columns){
                    for(int i=0;i<rows;i++){
                        for(int j=0;j<columns;j++){
                            if(i==j&&arr[i][j]!=1){
                                identity_flag=false;
                            }
                            if(i!=j&&arr[i][j]!=0){
                                identity_flag=false;
                            }
                                
                                
                                            
                        }
                    }
                }
                else
                    identity_flag=false;
                if(identity_flag==true){
                    m[m_no]=new identity();
                    
                    m[m_no].make(arr,rows,columns);
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                    continue;
                }              
                //singleton---------------------------------
                if(rows==1 && columns==1){
                    m[m_no]=new singleton();
                    
                    m[m_no].make(arr,rows,columns);
                    m[m_no].printm();

                    m[m_no].printid();
                    m_no++;
                    continue;
                }

                //Null--------------------------------------
                boolean nullflag=true;
                for(int i=0;i<rows;i++){
                    for(int j=0;j<columns;j++){
                        if(arr[i][j]!=0){
                            nullflag=false;
                            break;
                        }
                    }
                    if(nullflag==false)
                        break;
                }
                if(nullflag==true){
                    m[m_no]=new null_m();                    
                    m[m_no].make(arr,rows,columns);
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                    continue;
                }

                //Ones--------------------------------------
                boolean onesflag=true;
                for(int i=0;i<rows;i++){
                    for(int j=0;j<columns;j++){
                        if(arr[i][j]!=1){
                            onesflag=false;
                            break;
                        }
                    }
                    if(onesflag==false)
                        break;
                }
                if(onesflag==true){
                    m[m_no]=new ones();                    
                    m[m_no].make(arr,rows,columns);
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                    continue;
                }

                //scalar-------------------------------------
                if(rows==columns&&rows==2){
                    if(arr[0][0]==arr[1][1]&&arr[0][1]==0&&arr[1][0]==0){
                        m[m_no]=new scalar();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }
                if(rows==columns&&rows==3){
                    if(arr[0][0]==arr[1][1]&&arr[0][0]==arr[2][2]&&arr[0][1]==0&&arr[1][0]==0&&arr[0][2]==0&&arr[1][2]==0&&arr[2][1]==0&&arr[2][0]==0){
                        m[m_no]=new scalar();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }

                //row----------------------------------------------
                if(rows==1){
                    m[m_no]=new row();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                }

                //column----------------------------------------------
                if(columns==1){
                    m[m_no]=new column();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                }

                //diagonal--------------------------------------------
                if(rows==columns&&rows==2){
                    if(arr[0][1]==0&&arr[1][0]==0){
                        m[m_no]=new diagonal();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }
                if(rows==columns&&rows==3){
                    if(arr[0][1]==0&&arr[1][0]==0&&arr[0][2]==0&&arr[1][2]==0&&arr[2][1]==0&&arr[2][0]==0){
                        m[m_no]=new diagonal();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }

                //lower triangular--------------------------------------
                if(rows==columns&&rows==2){
                    if(arr[0][1]==0){
                        m[m_no]=new lower();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }
                if(rows==columns&&rows==3){
                    if(arr[0][1]==0&&arr[0][2]==0&&arr[1][2]==0){
                        m[m_no]=new lower();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }

                //upper triangular--------------------------------------------
                if(rows==columns&&rows==2){
                    if(arr[1][0]==0){
                        m[m_no]=new upper();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }
                if(rows==columns&&rows==3){
                    if(arr[1][0]==0&&arr[2][1]==0&&arr[2][0]==0){
                        m[m_no]=new upper();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }

                //Singular---------------------------------------------
                if(rows==columns){
                    if(matrix.retdeter(arr,rows,columns)==0)
                    {
                        m[m_no]=new singular();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }
                }

                //symmetric-------------------------------------------
                int b[][]=new int[columns][rows];
                if(rows==columns){
                    b=matrix.transpos(arr,b,rows,columns);
                    if(Arrays.deepEquals(arr, b)){
                        m[m_no]=new symmetric();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }


                }

                //skew symmetric----------------------------------------
                int c[][]=new int[columns][rows];
                if(rows==columns){
                    c=matrix.transpos(arr,c,rows,columns);
                    for(int i=0;i<columns;i++){
                        for(int j=0;j<rows;j++){
                            c[i][j]=-c[i][j];
                        }
                    }
                    if(Arrays.deepEquals(arr, c)){
                        m[m_no]=new skew();                    
                        m[m_no].make(arr,rows,columns);
                        m[m_no].printm();
                        m[m_no].printid();
                        m_no++;
                        continue;
                    }


                }

                //square-----------------------------------------
                if(rows==columns){
                    m[m_no]=new square();                    
                    m[m_no].make(arr,rows,columns);
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                    continue;
                }
                
                //rectangle
                m[m_no]=new rectangular();                    
                m[m_no].make(arr,rows,columns);
                m[m_no].printm();
                m[m_no].printid();
                m_no++;
                continue;    
            

            }

            if(ch==2){
                System.out.println("Enter desirable matrix type: ");
                sc.nextLine();
                String x=sc.nextLine();
                if(x.compareTo("Rectangular")==0){
                    int arr[][]={{1,2,3},{2,3,4}};
                    m[m_no]=new rectangular();
                    m[m_no].make(arr,2,3);
                    System.out.println("Rectagular matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Row")==0){
                    int arr[][]={{1,2,3}};
                    m[m_no]=new row();
                    m[m_no].make(arr,1,3);
                    System.out.println("Row matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Column")==0){
                    int arr[][]={{1},{2},{3}};
                    m[m_no]=new column();
                    m[m_no].make(arr,3,1);
                    System.out.println("Column matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Square")==0){
                    int arr[][]={{1,2},{3,4}};
                    m[m_no]=new square();
                    m[m_no].make(arr,2,2);
                    System.out.println("Square matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Symmetric")==0){
                    int arr[][]={{1,1,-1},{1,2,0},{-1,0,5}};
                    m[m_no]=new symmetric();
                    m[m_no].make(arr,3,3);
                    System.out.println("Symmetric matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Skew")==0){
                    int arr[][]={{0,1,-2},{-1,0,3},{2,-3,0}};
                    m[m_no]=new skew();
                    m[m_no].make(arr,3,3);
                    System.out.println("Skew Symmetric matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Upper Triangular")==0){
                    int arr[][]={{1,2,3},{0,6,4},{0,0,6}};
                    m[m_no]=new upper();
                    m[m_no].make(arr,3,3);
                    System.out.println("Upper Triangular matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Lower Triangular")==0){
                    int arr[][]={{1,0,0},{4,2,0},{6,5,6}};
                    m[m_no]=new lower();
                    m[m_no].make(arr,3,3);
                    System.out.println("Lower Triangular matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Singular")==0){
                    int arr[][]={{3,8,1},{-4,1,1},{-4,1,1}};
                    m[m_no]=new singular();
                    m[m_no].make(arr,3,3);
                    System.out.println("Singular matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Diagonal")==0){
                    int arr[][]={{1,0,0},{0,2,0},{0,0,6}};
                    m[m_no]=new diagonal();
                    m[m_no].make(arr,3,3);
                    System.out.println("Diagonal matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Scalar")==0){
                    int arr[][]={{2,0,0},{0,2,0},{0,0,2}};
                    m[m_no]=new scalar();
                    m[m_no].make(arr,3,3);
                    System.out.println("Scalar matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Identity")==0){
                    int arr[][]={{1,0,0},{0,1,0},{0,0,1}};
                    m[m_no]=new identity();
                    m[m_no].make(arr,3,3);
                    System.out.println("Diagonal matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }
                
                if(x.compareTo("Singleton")==0){
                    int arr[][]={{4}};
                    m[m_no]=new diagonal();
                    m[m_no].make(arr,1,1);
                    System.out.println("Singleton matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Ones")==0){
                    int arr[][]={{1,1,1},{1,1,1}};
                    m[m_no]=new ones();
                    m[m_no].make(arr,2,3);
                    System.out.println("Ones matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }

                if(x.compareTo("Null")==0){
                    int arr[][]={{0,0,0},{0,0,0}};
                    m[m_no]=new null_m();
                    m[m_no].make(arr,2,3);
                    System.out.println("Null matrix: ");
                    m[m_no].printm();
                    m[m_no].printid();
                    m_no++;
                }
                
            }

            if(ch==3){
                System.out.println("Enter id of matrix you wish to change elements of: ");
                int id=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id)
                        break;
                }
                rectangular temp=(rectangular)m[i];
                if(temp.checklast("Null Matrix")==true){
                    System.out.println("Can't change elements");
                }

                if(temp.checklast("Ones Matrix")==true){
                    System.out.println("Can't change elements");
                }

                if(temp.checklast("Identity Matrix")==true){
                    System.out.println("Can't change elements");
                }

                if(temp.checklast("Singleton Matrix")==true){
                    System.out.println("Enter element to replace element at [0][0]: ");
                    int ele=sc.nextInt();
                    m[i].set(0,0,ele);
                }

                if(temp.checklast("Scalar Matrix")==true){
                    System.out.println("Can't change elements");
                }

                if(temp.checklast("Skew Symmetric Matrix")==true){
                    System.out.println("Cant change any one element");
                }

                

                if(temp.checklast("Diagonal Matrix")==true||temp.checklast("Symmetric Matrix")){
                    if(m[i].retrows()==2){
                        System.out.println("Choose coordinate of element to change:\n1. 0,0\n2. 1,1");
                        int ch_2=sc.nextInt();
                        System.out.println("Enter element to insert ");
                        int ele=sc.nextInt();
                        if(ch_2==1){
                            m[i].set(0,0,ele);
                        }
                        if(ch_2==2){
                            m[i].set(1,1,ele);
                        }
                    }
                    if(m[i].retrows()==3){
                        System.out.println("Choose coordinate of element to change:\n1. 0,0\n2. 1,1\n3. 2,2");
                        int ch_2=sc.nextInt();
                        System.out.println("Enter element to insert ");
                        int ele=sc.nextInt();
                        if(ch_2==1){
                            m[i].set(0,0,ele);
                        }
                        if(ch_2==2){
                            m[i].set(1,1,ele);
                        }
                        if(ch_2==3){
                            m[i].set(2,2,ele);
                        }
                    }
                }

                if(temp.checklast("Singular Matrix")==true){
                    System.out.println("Enter row index of element to change");
                    int row_no=sc.nextInt();
                    if(row_no>=temp.retrows()){
                        System.out.println("Invalid");
                        continue;
                    }
                    System.out.println("Enter column index of element to change");
                    int column_no=sc.nextInt();
                    if(column_no>=temp.retcolumns()){
                        System.out.println("Invalid");
                        continue;
                    }
                    System.out.println("Enter element to insert: ");
                    int ele=sc.nextInt();
                    temp.set(row_no,column_no,ele);
                    if(matrix.retdeter(temp.retmat(),temp.retrows(),temp.retcolumns())!=0){
                        System.out.println("Invalid");
                        continue;
                    }
                    m[i].set(row_no,column_no,ele);
                }

                if(temp.checklast("Rectangular Matrix")==true || temp.checklast("Square Matrix")==true || temp.checklast("Row Matrix")==true || temp.checklast("Column Matrix")==true){
                    System.out.println("Enter row index of element to change");
                    int row_no=sc.nextInt();
                    if(row_no>=m[i].retrows()){
                        System.out.println("Invalid");
                        continue;
                    }
                    System.out.println("Enter column index of element to change");
                    int column_no=sc.nextInt();
                    if(column_no>=m[i].retcolumns()){
                        System.out.println("Invalid");
                        continue;
                    }
                    System.out.println("Enter element to insert: ");
                    int ele=sc.nextInt();
                    m[i].set(row_no,column_no,ele);
                }

                if(temp.checklast("Upper Triangular Matrix")==true){
                    System.out.println("Enter row index of element to change");
                    int row_no=sc.nextInt();
                    if(row_no>=m[i].retrows()){
                        System.out.println("Invalid");
                        continue;
                    }
                    
                    System.out.println("Enter column index of element to change");
                    int column_no=sc.nextInt();
                    if(column_no>=m[i].retcolumns()){
                        System.out.println("Invalid");
                        continue;
                    }

                    if(m[i].retrows()==2){
                        if(row_no==1 && column_no==0){
                            System.out.println("Invalid");
                            continue;
                        }                        
                    }
                    if(m[i].retrows()==3){
                        if(row_no==1 && column_no==0){
                            System.out.println("Invalid");
                            continue;
                        }
                        if(row_no==2 && column_no==0){
                            System.out.println("Invalid");
                            continue;
                        }
                        if(row_no==2 && column_no==1){
                            System.out.println("Invalid");
                            continue;
                        }                        
                    }


                    System.out.println("Enter element to insert: ");
                    int ele=sc.nextInt();
                    m[i].set(row_no,column_no,ele);
                }

                if(temp.checklast("Lower Triangular Matrix")==true){
                    System.out.println("Enter row index of element to change");
                    int row_no=sc.nextInt();
                    if(row_no>=m[i].retrows()){
                        System.out.println("Invalid");
                        continue;
                    }
                    
                    System.out.println("Enter column index of element to change");
                    int column_no=sc.nextInt();
                    if(column_no>=m[i].retcolumns()){
                        System.out.println("Invalid");
                        continue;
                    }

                    if(m[i].retrows()==2){
                        if(row_no==0 && column_no==1){
                            System.out.println("Invalid");
                            continue;
                        }                        
                    }
                    if(m[i].retrows()==3){
                        if(row_no==0 && column_no==1){
                            System.out.println("Invalid");
                            continue;
                        }
                        if(row_no==0 && column_no==2){
                            System.out.println("Invalid");
                            continue;
                        }
                        if(row_no==1 && column_no==2){
                            System.out.println("Invalid");
                            continue;
                        }                        
                    }


                    System.out.println("Enter element to insert: ");
                    int ele=sc.nextInt();
                    m[i].set(row_no,column_no,ele);
                }



            }
            
            if(ch==4){
                System.out.println("Enter id of matrix: ");
                int id=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id)
                        break;
                }
                rectangular temp=(rectangular)m[i];
                temp.printlabels();
            }

            if (ch==5){
                System.out.println("Choose operation:\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
                int ch_2=sc.nextInt();
                System.out.println("Enter id 1:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                System.out.println("Enter id 2:");
                int id_2=sc.nextInt();
                int j;
                for(j=0;j<m_no;j++){
                    if(m[j].retid()==id_2)
                        break;
                }
                if(ch_2==1){
                    m[i].add(m[j]);
                }
                if(ch_2==2){
                    m[i].subtract((m[j]));
                }
                if(ch_2==3){
                    if(m[i].retcolumns()!=m[j].retrows())
                        System.out.println("Error: Incompatible dimensions");
                    if(m[j] instanceof null_m){
                        int result[][]=new int [m[i].retrows()][m[j].retcolumns()];
                        for(int ii=0;ii<m[i].retrows();ii++){
                            for(int jj=0;jj<m[j].retcolumns();jj++){
                                result[ii][jj]=0;
                                System.out.print(result[ii][jj]+" ");
                            }
                            System.out.println();
                        }
                    }
                    if(m[i] instanceof null_m){
                        int result[][]=new int [m[i].retrows()][m[j].retcolumns()];
                        for(int ii=0;ii<m[i].retrows();ii++){
                            for(int jj=0;jj<m[j].retcolumns();jj++){
                                result[ii][jj]=0;
                                System.out.print(result[ii][jj]+" ");
                            }
                            System.out.println();
                        }
                    }
                    else
                        m[i].multiply(m[j]);
                }
                if(ch_2==4){
                    if(m[j] instanceof singular){
                        System.out.println("Singular matrix cannot be divisor");
                        continue;
                    }
                        
                    m[i].divide(m[j]);
                }

            }

            if(ch==6){
                System.out.println("Choose operation:\n1.Addition\n2.Subtraction\n3.Multiplication\n4.Division");
                int ch_2=sc.nextInt();
                System.out.println("Enter id 1:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                System.out.println("Enter id 2:");
                int id_2=sc.nextInt();
                int j;
                for(j=0;j<m_no;j++){
                    if(m[j].retid()==id_2)
                        break;
                }
                if(ch_2==1){
                    m[i].add(m[j]);
                }
                if(ch_2==2){
                    m[i].subtract((m[j]));
                }
                if(ch_2==3){
                    m[i].elemultiply(m[j]);
                }
                if(ch_2==4){
                    m[i].eledivide(m[j]);
                }
            }

            if(ch==7){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                m[i].transposeee();
            }

            if(ch==8){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                if(m[i] instanceof square){
                    square temp=(square)m[i];
                    temp.inverseee();
                }
                else{
                    System.out.println("Not square");
                }
            }

            if(ch==11){
                System.out.println("Enter id of singleton:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                int scalar=m[i].ret(0,0);
                System.out.println("Enter id of matrix to multiply scalar with:");
                int id_2=sc.nextInt();
                int ii;
                for(ii=0;ii<m_no;ii++){
                    if(m[ii].retid()==id_2)
                        break;
                }
                m[ii].multiplyscalar(scalar);
            }

            if(ch==9){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                m[i].rowwisemean();
                m[i].columnwisemean();
                m[i].allmean();
            }
            
            if(ch==10){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                if(m[i] instanceof diagonal){
                    diagonal temp=(diagonal)m[i];
                    temp.getdeter();
                    continue;
                }
                if(m[i] instanceof square){
                    square temp=(square)m[i];
                    temp.getdeter();
                    continue;
                }

            }

            if(ch==12){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                m[i].tplus();
            }

            if(ch==13){
                System.out.println("Enter id:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                System.out.println("EigenValues:");
                m[i].evectors();
            }

            if(ch==14){
                System.out.println("Enter id of square matrix:");
                int id_1=sc.nextInt();
                int i;
                for(i=0;i<m_no;i++){
                    if(m[i].retid()==id_1)
                        break;
                }
                System.out.println("Enter id of column matrix. Note: this should have same number of rows as the one you entered just now: ");
                int id_2=sc.nextInt();
                int j;
                for(j=0;j<m_no;j++){
                    if(m[j].retid()==id_2)
                        break;
                }

                m[i].linear(m[j]);
            }

            if(ch==15){
                System.out.println("Enter matrix type: ");
                sc.nextLine();
                String x=sc.nextLine();
                for(int i=0;i<m_no;i++){
                    rectangular temp=(rectangular)m[i];
                    if(temp.check(x)==true){
                        m[i].printm();
                        m[i].printid();
                    }
                }
            }

            if(ch==16){
                break;
            }
        }
        
    }
}

class matrix{ 
    static int id_count=0;
    int id;
    private int rows=0, columns=0;
    int mat[][]=new int[0][0];
    matrix(){
        this.rows=1;
        this.columns=1;
        id_count++;
        this.id=id_count;
    }
    public void make(int arr[][],int rows,int columns){   
        this.rows=rows;
        this.columns=columns;    
        this.mat=arr;
    }

    void printm(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    void add(matrix m){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(mat[i][j]+m.ret(i,j)+" ");
            }
            System.out.println();
        }
    }

    void subtract(matrix m){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(mat[i][j]-m.ret(i,j)+" ");
            }
            System.out.println();
        }
    }

    void elemultiply(matrix m){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(mat[i][j]*m.ret(i,j)+" ");
            }
            System.out.println();
        }
    }

    void eledivide(matrix m){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print((float)mat[i][j]/(float)m.ret(i,j)+" ");
            }
            System.out.println();
        }
    }

    void multiply(matrix m){
        int result[][]=new int[rows][m.retcolumns()];
        for(int i=0;i<rows;i++){
            for(int j=0;j<m.retcolumns();j++){
                result[i][j]=0;
                for(int k=0;k<columns;k++){
                    result[i][j]+=mat[i][k]*m.ret(k,j);
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    void divide(matrix m){
        float result[][]=new float[rows][m.retcolumns()];
        int b[][]=m.retmat();
        float c[][]=new float[rows][columns];
        c=inverse(b,c,rows,columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<m.retcolumns();j++){
                result[i][j]=0;
                for(int k=0;k<columns;k++){
                    result[i][j]+=mat[i][k]*c[k][j];
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }    
    }

    void transposeee(){
        int b[][]=new int[columns][rows];
        b=matrix.transpos(mat, b, rows, columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }

    

    

    void multiplyscalar(int scalar){
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print((mat[i][j]*scalar)+" ");
            }
            System.out.println();
        }
    }

    void tplus(){
        int b[][]=new int[columns][rows];
        b=matrix.transpos(mat, b, rows, columns);
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                System.out.print((b[i][j]+mat[i][j])+" ");
            }
            System.out.println();
        }
    }

    void rowwisemean(){
        int mean=0;
        for(int i=0;i<rows;i++){
            mean=0;
            for(int j=0;j<columns;j++){
                mean+=mat[i][j];
            }
            System.out.println("Row "+i+" mean: "+mean/columns);
        }
    }

    void columnwisemean(){
        int mean=0;
        for(int i=0;i<columns;i++){
            mean=0;
            for(int j=0;j<rows;j++){
                mean+=mat[j][i];
            }
            System.out.println("Column "+i+" mean: "+mean/rows);
        }
    }

    void allmean(){
        int mean=0;
        for(int i=0;i<columns;i++){
            for(int j=0;j<rows;j++){
                mean+=mat[j][i];
            }
        }
        System.out.println("Total mean: "+mean/(rows*columns));
    }

    void linear(matrix m){
        float inv[][]=new float[rows][columns];
        inv=inverse(mat,inv,rows,columns);
        float result[][]=new float[rows][m.retcolumns()];
        for(int i=0;i<rows;i++){
            for(int j=0;j<m.retcolumns();j++){
                result[i][j]=0;
                for(int k=0;k<columns;k++){
                    result[i][j]+=inv[i][k]*m.ret(k,j);
                }
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }

    }

    double[] evalues(){
        int trace=0;
        for(int i=0;i<rows;i++){
            trace+=mat[i][i];
        }
        double evalue[]=new double[2];
        float d=retdeter(mat,rows,columns);
        System.out.println((trace+Math.sqrt(Math.pow(trace,2)-4*d))/2);
        System.out.println((trace-Math.sqrt(Math.pow(trace,2)-4*d))/2);

        evalue[0]=(trace+Math.sqrt(Math.pow(trace,2)-4*d))/2;
        evalue[1]=(trace-Math.sqrt(Math.pow(trace,2)-4*d))/2;
        return evalue;
    }

    void evectors(){
        double[] evalue=this.evalues();
        double[][] evectorx={{1},{0}};
        double[][] evectory={{1},{0}};
        if(mat[0][1]==0){
            evectorx[1][0]=(evalue[0]-mat[0][0])/mat[0][1];
        }
        else{
            evectorx[1][0]=mat[0][1]/(evalue[0]-mat[1][1]);
        }
        if(mat[1][0]==0){
            evectory[1][0]=(evalue[1]-mat[0][0])/mat[0][1];
        }
        else{
            evectory[1][0]=mat[0][1]/(evalue[1]-mat[1][1]);
        }
        System.out.println(evectorx[0][0]+" "+evectory[0][0]);
        System.out.println(evectorx[1][0]+" "+evectory[1][0]);
    }
    
    //returns and prints----------------------------------------------------------------
    int ret(int i,int j){
        return this.mat[i][j];
    }
    void set(int i,int j,int ele){
        this.mat[i][j]=ele;
    }
    void printid(){
        System.out.println("ID:"+id);
    }
    int retid(){
        return this.id;
    }
    void passrows(int rows){
        this.rows=rows;
    }
    int retrows(){
        return rows;
    }
    int retcolumns(){
        return columns;
    }
    int [][] retmat(){
        return mat;
    }


    //static--------------------------------------------------------------------------------
    static float retdeter(int mat[][],int rows,int columns){
        if(rows==columns && rows==1){
            return mat[0][0];
        }
        if(rows==columns && rows==2){
            float deter= (mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]);
            return deter;
        }

        if(rows==columns && rows==3){
            float deter= ((mat[0][0]*((mat[1][1]*mat[2][2])-(mat[1][2]*mat[2][1])))-(mat[0][1]*((mat[1][0]*mat[2][2])-(mat[1][2]*mat[2][0]))) + (mat[0][2]*((mat[1][0]*mat[2][1])-(mat[1][1]*mat[2][0]))));
            return deter;
        }
        return 0;
           
    }

    static int[][] transpos(int a[][],int b[][],int rows,int columns){
        int i, j;
        for (i = 0; i < rows; i++)
            for (j = 0; j < columns; j++)
                b[i][j] = a[j][i];
        return b;
    }

    static float[][] inverse(int a[][],float b[][],int rows,int columns){
        float det=retdeter(a,rows,columns);
        if(rows==2){
            b[1][1]=a[0][0];
            b[0][0]=a[1][1];
            b[0][1]=-a[0][1];
            b[1][0]=-a[1][0];
            for(int i=0;i<2;i++){
                for(int j=0;j<2;j++){
                    b[i][j]=b[i][j]/det;
                }
            }
            return b;
        }

        if(rows==3){
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    b[i][j]=(((a[(j+1)%3][(i+1)%3]*a[(j+2)%3][(i+2)%3])- (a[(j+1)%3][(i+2)%3] * a[(j+2)%3][(i+1)%3]))/det);
                }   
            } 
            return b;       
        }
        return b;
    }
    


}

class rectangular extends matrix{
    String[] labels= new String[15];
    int f;
    rectangular(){
        this.append("Rectangular Matrix",0);
    }
    void append(String x,int l_no){
        labels[l_no]=x;
        f=l_no;
    }
    void printlabels(){
        for(int i=0;i<=f;i++){
            System.out.println(labels[i]);
        }
    }
    boolean check(String x){
        for(int i=0;i<=f;i++){

            if(labels[i].compareTo(x)==0){
                return true;
            }
        }
        return false;
    }
    boolean checklast(String x){
        if(labels[f].compareTo(x)==0){
            return true;
        }
        return false;
    }
    
}

class square extends rectangular{
    square(){
        super();
        this.append("Square Matrix",1);
    }

    void inverseee(){
        float b[][]=new float [retrows()][retcolumns()];
        b=matrix.inverse(mat, b, retrows(), retcolumns());
        for(int i=0;i<retrows();i++){
            for(int j=0;j<retcolumns();j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
    }

    void getdeter(){
        float d=retdeter(mat, retrows(), retcolumns());
        System.out.println(d);
    }
}

class symmetric extends square{
    symmetric(){
        super();
        this.append("Symmetric matrix",2);
    }
}

class skew extends square{
    skew(){
        super();
        this.append("Skew Symmetric Matrix",2);
    }
}

class singular extends square{
    singular(){
        super();
        this.append("Singular Matrix",2);
    }
}

class lower extends square{
    lower(){
        super();
        this.append("Lower Triangular Matrix",2);
    }
}

class upper extends square{
    upper(){
        super();
        this.append("Upper Triangular Matrix",2);
    }
}

class diagonal extends square{
    diagonal(){
        super();
        this.append("Diagonal Matrix",2);
    }
    @Override
    void getdeter(){
        int result=1;
        for(int i=0;i<this.retrows();i++){
            result=result*this.ret(i,i);
        }
        System.out.println(result);
    }
}

class scalar extends diagonal{
    scalar(){
        super();
        this.append("Scalar Matrix",3);
    }
}

class singleton extends scalar{
    singleton(){
        super();
        this.append("Singleton Matrix",4);
    }
    @Override
    void rowwisemean(){
        System.out.println(ret(0,0));
    }

    @Override
    void columnwisemean(){
        System.out.println(ret(0,0));
    }
    @Override
    void allmean(){
        System.out.println(ret(0,0));
    }

    @Override
    void getdeter(){
        System.out.println(ret(0,0));
    }
}

class identity extends scalar{
    identity(){
        super();
        this.append("Identity Matrix",4);
    }
}

class null_m extends rectangular{
    null_m(){
        super();
        this.append("Null Matrix",1);
    }
}

class ones extends rectangular{
    ones(){
        super();
        this.append("Ones Matrix",1);
    }
}

class row extends rectangular{
    row(){
        super();
        this.append("Row Matrix",1);
    }
}

class column extends rectangular{
    column(){
        super();
        this.append("Column Matrix",1);
    }
}