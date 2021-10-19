import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class BackPack {    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        comments[] c=new comments[1000];
        int c_no=0;
        for(int i=0;i<1000;i++){
            c[i]=new comments(null,0,true);
        }


        lecture[] l=new lecture[1000];
        int l_no=0;

        assessment[] a=new assessment[1000];
        int a_no=0;

        String currentid="0";

        System.out.println("How many instructors? ");
        int total_instructors=sc.nextInt();

        System.out.println("How many students? ");
        int total_students=sc.nextInt();

        System.out.println();

        student[] ss=new student[1000];
        int ss_no=0;
        for(int iii=0;iii<total_students;iii++){
            ss[iii]=new student(iii);
        }

        
        
        
        
        int option1=0;
        while(option1!=3){
        
            System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");
            
            option1=sc.nextInt();

            if(option1==1){

                int option2=0;
                boolean exitflag=false;
                System.out.println("Instructors:");
                for(int tempi=0;tempi<total_instructors;tempi++)
                    System.out.println(tempi+" - I"+tempi);
                //id input
                System.out.println("Choose id: ");
                int in_id=sc.nextInt();
                
                while(option2!=9){

                    //print welcome instructorid
                    System.out.println("Wecome I"+in_id);
                    
                    //print menu
                    System.out.println("INSTRUCTOR MENU\n1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout");
                    option2=sc.nextInt();
                    
                    if(option2==9){
                        exitflag=true;
                        break;
                    }

                    else if(option2==1){
                        System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
                        int lectureoption=sc.nextInt();
                        if(lectureoption==1){
                            l[l_no]=new slides();

                            System.out.println("Enter topic of slides:");
                            sc.nextLine();
                            String topic=sc.nextLine();

                            System.out.println("Enter number of slides:");
                            int nos=sc.nextInt();

                            System.out.println("Enter content of slides");
                            String s_c[]=new String[nos];
                            sc.nextLine();
                            for(int k=0;k<nos;k++){
                                System.out.print("Content of slide ");
                                System.out.println(k+1); 
                                s_c[k]=sc.nextLine();
                            }
                            l[l_no].add_material(topic,nos,s_c,null,in_id);
                            l_no++;
                        }
                        if(lectureoption==2){
                            l[l_no]=new video();

                            System.out.println("Enter topic of video:");
                            sc.nextLine();
                            String topic=sc.nextLine();

                            System.out.println("Enter filename of video:");
                            String filename=sc.nextLine();
                            if(!check_name_mp4(filename)){
                                System.out.println("Invalid name");
                                continue;
                            }
                                

                            l[l_no].add_material(topic,0,null,filename,in_id);
                            l_no++;
                        }
                    }

                    else if(option2==2){
                        System.out.println("1. Add Assignment\n2. Add Quiz");
                        int assessment=sc.nextInt();
                        if(assessment==1){
                            a[a_no]=new assignment();
                            System.out.println("Enter problem statement: ");
                            sc.nextLine();
                            String ps=sc.nextLine();
                            System.out.println("Enter max marks:");
                            int mm=sc.nextInt();
                            a[a_no].add_data(ps,mm);
                            a_no++;
                        }
                        if(assessment==2){
                            a[a_no]=new quiz();
                            System.out.println("Enter quiz question:");
                            sc.nextLine();
                            String q=sc.nextLine();
                            a[a_no].add_data(q,0);
                            a_no++;
                        }
                    }

                    else if(option2==3){
                        for(int ii=0;ii<l_no;ii++){
                            l[ii].view_material();
                        }
                    }

                    else if(option2==4){
                        for(int ii=0;ii<a_no;ii++){
                            System.out.print("ID: "+ii+" :");
                            a[ii].print_data();
                        }
                        
                    }

                    else if(option2==5){
                        System.out.println("List of assessments: ");
                        for(int ii=0;ii<a_no;ii++){
                            System.out.print("ID: "+ii+" :");
                            a[ii].print_data();
                        }
                        System.out.println("Enter ID of assessment to view submissions:");
                        int ass_id=sc.nextInt();
                        a[ass_id].print_student_ids();
                        System.out.println("Enter -1 to exit");
                        int stud_id=sc.nextInt();
                        if(stud_id==-1)
                            continue;
                        a[ass_id].check(stud_id,in_id);
                        
                    }

                    else if(option2==6){
                        System.out.println("List of Open Assessements:");
                        for(int ii=0;ii<a_no;ii++){
                            if(a[ii].check_open()==true){
                                System.out.print("ID: "+ii+" :");
                                a[ii].print_data();
                            }
                        }
                        System.out.println("Enter id of assignment to close:");
                        int idd=sc.nextInt();
                        a[idd].set_status_closed();

                        
                    }

                    else if(option2==7){
                        for(int i=0;i<c_no;i++){
                            c[i].print_data();
                        }
                        
                    }
                    
                    else if(option2==8){
                        System.out.println("Enter comment:");
                        sc.nextLine();
                        String comment=sc.nextLine();
                        c[c_no]=new comments(comment,in_id,true);
                        
                        c_no++;
                    }
                }
                if(exitflag==true){
                    continue;
                }
            }

            else if(option1==2){

                int option2=0;
                boolean exitflag=false;

                System.out.println("Students:");
                for(int tempi=0;tempi<total_students;tempi++)
                    System.out.println(tempi+" - S"+tempi);
                //id input
                System.out.println("Choose id: ");
                int s_id=sc.nextInt();

                while(option2!=7){
                    
                    //print welcome studentid
                    System.out.println("Wecome S"+s_id);

                    //print menu
                    System.out.println("STUDENT MENU\n1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout");
                    option2=sc.nextInt();

                    if(option2==7){
                        continue;
                    }
                        

                    else if(option2==1){
                        for(int ii=0;ii<l_no;ii++){
                            l[ii].view_material();
                        }

                    }

                    else if(option2==2){
                        for(int ii=0;ii<a_no;ii++){
                            System.out.print("ID: "+ii+" :");
                            a[ii].print_data();
                        }
                        
                    }

                    else if(option2==3){
                        int flag=0;
                        System.out.println("List of pending Assessements:");
                        for(int ii=0;ii<a_no;ii++){
                            if(a[ii].check_open()==true && ss[s_id].check_sub(ii)){
                                System.out.print("ID: "+ii+" :");
                                a[ii].print_data();
                                flag=1;
                            }
                        }
                        if(flag==1){
                            System.out.println("Enter ID of assessment:");
                            int ass_id=sc.nextInt();
                            int checkk=a[ass_id].submission(s_id);
                            if(checkk==0)
                                continue;
                            ss[s_id].save_index(ass_id);
                        }
                        
                    }

                    else if(option2==4){
                        System.out.println("Submissions:");
                        System.out.println();
                        for(int ll=0;ll<a_no;ll++){
                            a[ll].grade_print(s_id);
                        }
                        
                    }

                    else if(option2==5){
                        for(int i=0;i<c_no;i++){
                            c[i].print_data();
                        }
                    }

                    else if(option2==6){
                        System.out.println("Enter comment:");
                        sc.nextLine();
                        String comment=sc.nextLine();
                        c[c_no]=new comments(comment,s_id,false);
                        
                        c_no++;
                    }

                }
                if(exitflag==true){
                    continue;
                }
            }
        }
    }
    public static boolean check_name_mp4(String name){
        int size = name.length();
        if(size<=4)
            return false;
        if(name.substring(size-4).equals(".mp4")){
            return true;
        }
        return false;
    }
    public boolean check_name_zip(String name){
        int size = name.length();
        if(size<=4)
            return false;
        if(name.substring(size-4).equals(".zip")){
            return true;
        }
        return false;
    }
}


interface lecture{
    public void add_material(String a, int b, String[] c, String d, int e);
    public void view_material();
}

class slides implements lecture{
    private String title;
    private int nos;
    private String[] s_c=new String[1000];
    private int id;
    private DateTimeFormatter d = DateTimeFormatter.ofPattern("E LLL dd HH:mm:ss zzz yyyy");
    private ZonedDateTime time;

    slides(){}
    @Override
    public void add_material(String title, int nos, String[] s_c,String x,int id){
        this.title=title;
        this.nos=nos;
        this.s_c=s_c;
        this.id=id;
        this.time = ZonedDateTime.now();
    }

    @Override
    public void view_material(){
        System.out.println("Title: "+title);
        for(int j=0;j<nos;j++){
            System.out.print("Slide "+(j+1));
            System.out.println(": "+s_c[j]);
        }
        System.out.println("Number of slides: "+nos);
        System.out.println("Date of upload: "+d.format(time));
        System.out.println("Uploaded by I "+id);
        System.out.println();

    }
}

class video implements lecture{
    private String topic;
    private String filename;
    private int id;
    private DateTimeFormatter d = DateTimeFormatter.ofPattern("E LLL dd HH:mm:ss zzz yyyy");
    private ZonedDateTime time;


    video(){
    }

    @Override
    public void add_material(String topic,int x, String[] xx, String filename, int id){
        this.topic=topic;
        this.filename=filename;
        this.id=id;
        this.time = ZonedDateTime.now();
    }

    @Override
    public void view_material(){
        System.out.println("Title of video: "+ topic);
        System.out.println("Video file: "+filename);
        System.out.println("Date of upload: "+d.format(time));
        System.out.println("Uploaded by I "+id);
        System.out.println();


    }
}

class comments{
    private String comment;
    private int id;
    private boolean instructor=true;
    private DateTimeFormatter d = DateTimeFormatter.ofPattern("E LLL dd HH:mm:ss zzz yyyy");
    private ZonedDateTime time;
    comments(String com,int id,boolean instructor){
        this.comment=com;
        this.time=time;
        this.id=id;
        this.instructor=instructor;
        this.time = ZonedDateTime.now();
    }


    void print_data(){
        System.out.print(this.comment+" - ");
        if(instructor==true)
            System.out.println("I"+id);
        else
            System.out.println("S"+id);
        System.out.println(d.format(time));
        System.out.println();
    }
}

interface assessment{
    public void add_data(String a, int b);
    public void print_data();
    public boolean check_open();
    public void set_status_closed();
    public int submission(int id);
    public void print_student_ids();
    public void check(int id,int x);
    public void grade_print(int id);
}

class assignment implements assessment{
    Scanner sc = new Scanner(System.in);
    private String p_s;
    private int max;
    private boolean status=true;
    private ass_submission[] answers=new ass_submission[1000];
    private int as_no=0;
    
    @Override
    public void add_data(String ps, int mm){
        this.p_s=ps;
        this.max=mm;
    }

    @Override
    public void print_data(){
        System.out.print("Assignment: "+p_s+", Max marks: "+max+", Status: ");
        if(status==true){
            System.out.println("Open");
        }
        else
            System.out.println("Closed");
    }

    @Override
    public boolean check_open(){
        return status;
    }

    @Override
    public void set_status_closed(){
        this.status=false;
    }

    @Override
    public int submission(int sid){
        System.out.println("Enter filename of assignment:");
        String answerfile=sc.nextLine();
        if(!check_name_zip(answerfile)){
            System.out.println("Invalid name");
            return 0;
        }
        int answer_sid=sid;
        answers[as_no]=new ass_submission(answerfile,answer_sid);
        as_no++;
        return 1;

    }
    public boolean check_name_zip(String name){
        int size = name.length();
        if(size<=4)
            return false;
        if(name.substring(size-4).equals(".zip")){
            return true;
        }
        return false;
    }
    @Override
    public void print_student_ids(){
        for(int i=0;i<as_no;i++){
            answers[i].check_and_print();
        }
    }

    @Override
    public void check(int sid,int iid){
        for(int i=0;i<as_no;i++){
            if (answers[i].retid()==sid){
                answers[i].grade(iid,max);
            }
        }
    }

    @Override
    public void grade_print(int sid){
        for(int i=0;i<as_no;i++){
            if (answers[i].retid()==sid){
                answers[i].print_data();
            }
        }
    }



}

class quiz implements assessment{
    Scanner sc = new Scanner(System.in);
    private String question;
    private boolean status=true;
    private quiz_submission[] answers=new quiz_submission[1000];
    private int qs_no=0;
    private String answer;
    private int answer_sid;

    @Override
    public void add_data(String qq,int x){
        this.question=qq;
    }

    @Override
    public void print_data(){
        System.out.print("Question: "+question+", Status: ");
        if(status==true){
            System.out.println("Open");
        }
        else
            System.out.println("Closed");
    }

    @Override
    public boolean check_open(){
        return status;
    }

    @Override
    public void set_status_closed(){
        this.status=false;
    }

    @Override
    public int submission(int s_id){
        System.out.println(question);
        answer=sc.nextLine();
        answer_sid=s_id;
        answers[qs_no]=new quiz_submission(answer,answer_sid);
        qs_no++;
        return 1;
    }

    @Override
    public void print_student_ids(){
        for(int i=0;i<qs_no;i++){
            answers[i].check_and_print();
        }
    }
    @Override
    public void check(int sid,int iid){
        for(int i=0;i<qs_no;i++){
            if (answers[i].retid()==sid){
                answers[i].grade(iid);
            }
        }
    }

    @Override
    public void grade_print(int sid){
        for(int i=0;i<qs_no;i++){
            if (answers[i].retid()==sid){
                answers[i].print_data();
            }
        }
    }
}

class quiz_submission{
    Scanner sc = new Scanner(System.in);
    private int student_id;
    private String answer;
    private int instructor_id;
    private int grades;
    private boolean status=false; //true=checked

    quiz_submission(String answer,int sid){
        this.answer=answer;
        this.student_id=sid;
    }
    public void check_and_print(){
        if(status==false){
            System.out.println(student_id+". S"+student_id);
        }
    }
    public int retid(){
        return student_id;
    }
    public void grade(int iid){
        instructor_id=iid;
        System.out.println("Answer: "+answer);
        System.out.println("Marks scored: ");
        grades=sc.nextInt();
        status=true;
    }
    public void print_data(){
        System.out.println("Answer: "+ answer);
        System.out.print("Status: ");
        if(status==true){
            System.out.println("Graded");
            System.out.println("Marks scored: "+grades);
            System.out.println("Graded by: I"+instructor_id);
            
        }
        else
            System.out.println("Ungraded");
    }
}

class ass_submission{
    Scanner sc=new Scanner(System.in);
    private int student_id;
    private String filename;
    private int grades;
    private int instructor_id;
    private boolean status=false; //true=checked

    ass_submission(String answer,int sid){
        this.filename=answer;
        this.student_id=sid;
    }

    public void check_and_print(){
        if(status==false){
            System.out.println(student_id+". S"+student_id);
        }
    }
    public int retid(){
        return student_id;
    }
    public void grade(int iid,int mm){
        instructor_id=iid;
        System.out.println("Submission:");
        System.out.println("Submission: "+filename);
        System.out.println("Max Marks: "+mm);
        System.out.println("Marks scored: ");
        grades=sc.nextInt();
        status=true;
    }
    public void print_data(){
        System.out.println("Submission: "+ filename);
        System.out.print("Status: ");
        if(status==true){
            System.out.println("Graded");
            System.out.println("Marks scored: "+grades);
            System.out.println("Graded by: I"+instructor_id);
            
        }
        else
            System.out.println("Ungraded");
    }

}

class student{
    private int id;
    private int[] s=new int[1000];
    
    int s_no=0;

    student(int iii){
        this.id=iii;
        for(int i=0;i<1000;i++){
            s[i]=-1;
        }
    }
    void save_index(int index){
        s[s_no]=index;
        s_no++;
    }
    boolean check_sub(int ii){
        for(int j=0;j<s_no;j++){
            if(s[j]==ii)
                return false;
        }
        return true;
    }
}

class instructorrr{
    private int id;
    instructorrr(int id){
        this.id=id;
    }
}