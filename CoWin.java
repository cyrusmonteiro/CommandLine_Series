import java.util.Scanner;

class CoWin{  
        
    public static void main(String args[]){ 
        
        Scanner sc = new Scanner(System.in);


        int v_no=0; 
        int h_no=0;
        int c_no=0;
        int s_no=0;
        vaccine[] v;
        v=new vaccine[1000];
        for(int i=0;i<1000;i++){
            v[i]=new vaccine(null,0,0);
        }

        hospital[] h=new hospital[1000];
        for(int i=0;i<1000;i++){
            h[i]=new hospital(null,0);
        }

        citizen[] c=new citizen[1000];
        for(int i=0;i<1000;i++){
            c[i]=new citizen(null,0,null);
        }

        
        

        System.out.println("\nCoWin Portal initialized....\n");
        while(true) {
            System.out.println("---------------------------------\n 1. Add Vaccine\n 2. Register Hospital\n 3. Register Citizen\n 4. Add Slot for Vaccination\n 5. Book Slot for Vaccination\n 6. List all slots for a hospital\n 7. Check Vaccination Status\n 8. Exit\n ---------------------------------"); 
            int option=sc.nextInt();

            

            switch(option){
                case 1:{
                    System.out.println("Vaccine name: ");
                    sc.nextLine();
                    String name=sc.nextLine();                
                    System.out.println("Number of Doses: ");
                    int no_of_doses=sc.nextInt();
                    if(no_of_doses!=1){
                        System.out.println("Gap Between Doses: ");
                        int gap=sc.nextInt();
                        v[v_no]=new vaccine(name,no_of_doses,gap);
                        v[v_no].printdata();
                        v_no=v_no+1;
                        
                    }
                    else{
                        
                        v[v_no]=new vaccine(name,no_of_doses);
                        v[v_no].printdata();
                        v_no++;
                    }
                    break;
                }
                case 2:{
                    System.out.println("Hospital name: ");
                    sc.nextLine();
                    String name=sc.nextLine();                
                    System.out.println("PinCode: ");
                    int pin=sc.nextInt();
                    h[h_no]=new hospital(name,pin);
                    h[h_no].printdata();
                    h_no++;
                    break;

                }
                case 3:{
                    System.out.println("Citizen name: ");
                    sc.nextLine();
                    String name=sc.nextLine();                
                    System.out.println("Age: ");
                    int age=sc.nextInt();
                    System.out.println("Unique ID: ");
                    sc.nextLine();
                    String id=sc.nextLine();
                    c[c_no]=new citizen(name,age,id);
                    c[c_no].printdata();
                    c_no++;
                    break;

                }

                case 4:{
                    System.out.print("Enter Hospital ID ");
                    int id=sc.nextInt();
                    System.out.println();
                    int ii=0;
                    for(ii=0;ii<h_no;ii++){
                        if(h[ii].checkid(id)==true)
                            break;
                    }
                    System.out.print("Enter number of Slots to be added: ");
                    int number=sc.nextInt();
                    System.out.println();
                    for(int j=0;j<number;j++){
                        System.out.print("Enter Day Number: ");
                        int day=sc.nextInt();
                        System.out.println();
                        System.out.print("Enter quantity: ");
                        int quantity=sc.nextInt();
                        System.out.println();
                        System.out.println("Select Vaccine");
                        for(int k=0;k<v_no;k++){
                            System.out.println(k+". "+v[k].retname());
                        }
                        int vac_index=sc.nextInt();
                        h[ii].newslot(day,quantity,vac_index);
                        h[ii].printslotdata(v);
                    }
                    
                    break;
                }
                case 5:{
                    System.out.println("Enter patient Unique ID: ");
                    sc.nextLine();
                    String id=sc.nextLine();
                    System.out.println("1. Search by area\n2. Search by Vaccine\n3. Exit\nEnter option: ");
                    System.out.println();
                    int op=sc.nextInt();
                    if(op==1){
                        System.out.println("Enter PinCode: ");
                        int pin=sc.nextInt();
                        int jj;
                        for(jj=0;jj<h_no;jj++){
                            if(h[jj].pincheck(pin)==true){
                                h[jj].print_id_name();
                            }
                        }
                        System.out.println("Enter hospital id: ");
                        int hid=sc.nextInt();


                        for(jj=0;jj<h_no;jj++){
                            if(h[jj].hidcheck(hid)==true){
                                h[jj].printallslots(v);
                            }
                        }
                        int slotoption=sc.nextInt();
                        int tt;
                        for(tt=0;tt<c_no;tt++)
                            if(c[tt].checkid(id)==true){
                                System.out.println(tt);
                                break;
                            }
                        
                        int kk;
                        for(kk=0;kk<h_no;kk++){
                            if(h[kk].hidcheck(hid)==true){
                                break;
                            }
                        }

                        if(c[tt].returndue()>h[kk].returnday(slotoption)){
                            System.out.println("No Slots Avalable");
                            break;
                        }
                        
                        if(h[kk].retquantity(slotoption)==0){
                            System.out.println("No Slots Avalable");
                            break;
                        }
                        int vid,dday;
                        vid=h[kk].returnvacindex(slotoption);
                        dday=h[kk].returnday(slotoption);
                        c[tt].update(v,vid,dday);
                        c[tt].printupdatestatement();

                        //reduce quan
                        h[kk].reducequantity(slotoption);


                        
                    }
                    else if(op==2){
                        System.out.println("Enter Vaccine name: ");
                        sc.nextLine();
                        String vac=sc.nextLine();
                        for(int ij=0;ij<h_no;ij++){
                            if(h[ij].returnvactrue(vac,v)==true)
                                h[ij].print_id_name();
                            //v[i].checkname(vac);
                        }
                        int jj;
                        System.out.println("Enter hospital id: ");
                        int hid=sc.nextInt();
                        for(jj=0;jj<h_no;jj++){
                            if(h[jj].hidcheck(hid)==true){
                                h[jj].printallslots(v);
                            }
                        }
                        int slotoption=sc.nextInt();
                        int tt;
                        for(tt=0;tt<c_no;tt++)
                            if(c[tt].checkid(id)==true){
                                System.out.println(tt);
                                break;
                            }
                        
                        int kk;
                        for(kk=0;kk<h_no;kk++){
                            if(h[kk].hidcheck(hid)==true){
                                break;
                            }
                        }

                        if(c[tt].returndue()>h[kk].returnday(slotoption)){
                            System.out.println("No Slots Avalable");
                            break;
                        }
                        
                        if(h[kk].retquantity(slotoption)==0){
                            System.out.println("No Slots Avalable");
                            break;
                        }


                        int vid,dday;
                        vid=h[kk].returnvacindex(slotoption);
                        dday=h[kk].returnday(slotoption);
                        c[tt].update(v,vid,dday);
                        c[tt].printupdatestatement();

                        //reduce quan
                        h[kk].reducequantity(slotoption);

                    }
                    break;
                }

                case 6:{
                    System.out.print("Enter Hospital ID ");
                    int id=sc.nextInt();
                    System.out.println();
                    int ii=0;
                    for(ii=0;ii<h_no;ii++){
                        if(h[ii].checkid(id)==true)
                            break;
                    }
                    h[ii].printallslots(v);
                    break;
                }
                case 7:{
                    
                    System.out.println("Enter patient id: ");
                    sc.nextLine();
                    String id=sc.nextLine();
                    for(int yy=0;yy<c_no;yy++){
                        if(c[yy].checkid(id)==true)
                            c[yy].printstatus();
                    }
                    break;

                }

                case 8:{
                    System.exit(0);
                }

                default:
                    System.out.println("INVALID");
            
            }
                
            
        }
     
    }  
  
}
class vaccine{
    private String name;
    private int no_of_doses;
    private int gap=0;;
    vaccine(String name, int no_of_doses, int gap){
        this.name=name;
        this.no_of_doses=no_of_doses;
        this.gap=gap;
    }
    vaccine(String name, int no_of_doses){
        this.name=name;
        this.no_of_doses=no_of_doses;
    }
    void printdata(){
        System.out.print("Vaccine Name: ");
        System.out.print(this.name);
        System.out.print(", Number of doses: ");
        System.out.print(this.no_of_doses);
        
            System.out.print(", Gap Between Doses: ");
            System.out.print(this.gap);
        
    }
    int retdose(){
        return this.no_of_doses;
        
    }
    int retgap(){
        return this.gap;
    }
    String retname(){
        return this.name;
    }
}


class hospital{
    private String name;
    private int pin,x=1,s_no=0;
    private int hid;
    static int id=100000;
    private slot[] s=new slot[1000];
    
    

    hospital(String name,int pin){
        this.name=name;
        this.pin=pin;
        hospital.id=hospital.id+x;
        this.hid=hospital.id;
    }


    void printdata(){
        System.out.print("Hospital Name: ");
        System.out.print(this.name);
        System.out.print(", Pincode: ");
        System.out.print(this.pin);
        System.out.print(", Unique ID: ");
        System.out.println(this.hid);
    }

    boolean checkid(int ide){
        if (hid==ide)
            return true;
        return false;

    }

    void newslot(int day,int quantity,int vac_index){
        s[s_no]=new slot(day,quantity,vac_index);
        s_no++;
    }
    void printslotdata(vaccine[] v){
        s[s_no-1].printdata(v,this.hid);
        
    }
    void printallslots(vaccine[] v){
        for(int xx=0;xx<s_no;xx++){
            System.out.print(xx+". ");
            s[xx].printdailydata(v);
        }
    }
    boolean pincheck(int p){
        if(pin==p)
            return true;
        return false;
    }
    void print_id_name(){
        System.out.print(this.hid);
        System.out.print(" ");
        System.out.println(this.name);
    }
    boolean hidcheck(int hid){
        if(this.hid==hid)
            return true;
        else 
            return false;
    }
    int returnvacindex(int slotoption){
        return s[slotoption].returnvi();
    }
    int returnday(int slotoption){
        return s[slotoption].returnd();
    }
    void reducequantity(int slotoption){
        s[slotoption].rq();
    }
    boolean returnvactrue(String vac,vaccine v[]){
        for(int i=0;i<s_no;i++){
            if(s[i].returnvt(vac,v)==true)
                return true;
        }
        return false;
    }
    int retquantity(int slotoption){
        return s[slotoption].retq();
    }


}


class citizen{
    private String name;
    private String id;
    private int age;
    private String status;
    private int doses=0;
    private int due;
    private String vacname;

    citizen(String name, int age, String id){
        this.name=name;
        this.age=age;
        this.id=id;
        this.status="Registered";
        this.doses=0;
        this.due=0;
        this.vacname=null;
    }
    void printdata(){
        System.out.print("Citizen Name: ");
        System.out.print(this.name);
        System.out.print(", Age: ");
        System.out.print(this.age);
        System.out.print(", Unique ID: ");
        System.out.println(this.id);
        if(age<=18){
            System.out.println("Only above 18 are allowed");
        }
    }
    boolean checkid(String ide){
        if(this.id.equals(ide)==true)
            return true;
        return false;
    }
    void printstatus(){
        System.out.println(status);
        System.out.print("Vaccine given: ");
        System.out.println(vacname);
        System.out.println("Number of Doses given: "+doses);
        System.out.println("Next due date: "+ due);
    }
    void update(vaccine[] v, int vid,int day){
        vacname=v[vid].retname();
        if(v[vid].retdose()==1){
            this.status="Fully Vaccinated";
            this.doses=1;
            this.due=0;
        }
        else{
            if(v[vid].retdose()==this.doses+1){
                this.status="Fully Vaccinated";
                this.doses+=1;
                this.due=0;
            }
            else if(v[vid].retdose()>this.doses+1){
                this.status="Partially Vaccinated";
                this.doses+=1;
                this.due=day+v[vid].retgap();
            }

        }

    }
    void printupdatestatement(){
        System.out.print(this.name);
        System.out.print(" vaccinated with ");
        System.out.println(vacname);
    }
    boolean citcheck(String ide){
        if(this.id==ide){
            return true;
        }
        return false;
    }
    int returndue(){
        return this.due;
    }

}

class slot{
    private int day;
    private int quantity;
    private int vac_index;
    private int hosid;
    slot(int day, int quantity, int vac_index){
        this.day=day;
        this.quantity=quantity;
        this.vac_index=vac_index;
    }

    void printdata(vaccine v[],int hosid){
        System.out.print("Slot added by Hospital "+hosid);
        System.out.print(" for Day "+day);
        System.out.print(" ,Available Quantity "+quantity);
        System.out.print(" of Vaccine");
        System.out.println( v[vac_index].retname());
    }

    void printdailydata(vaccine[] v){
        System.out.print("Day: "+day);
        System.out.print(" Vaccine: ");
        System.out.print(v[vac_index].retname());
        System.out.println(" Available Qty: "+quantity);
    }
    int returnvi(){
        return this.vac_index;
    }
    int returnd(){
        return this.day;
    }
    void rq(){
        this.quantity-=1;
    }
    boolean returnvt(String vac,vaccine v[]){
        if(vac.equals(v[vac_index].retname())==true)
            return true;
        return false;
    }
    int retq(){
        return this.quantity;
    }

}

