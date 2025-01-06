import java.util.*;
abstract class EnrolleeData{
    //primary key
//    private String username;
//    private void setUsername(String username){
//        this.username = username;
//    }
//    public EnrolleeData(String username){
//        setUsername(username);
//    }


    //student information
    protected String fullName;
    protected String sex;
    protected String birthDate;
    protected int age;
    protected String address;
    protected String lrn;
    protected String contactNumber;
    //student grade average
    protected int english;
    protected int math;
    protected int science;
    //parent information (father)
    protected String fatherFullname;
    protected String fatherOccupation;
    protected String fatherContactNumber;
    //parent information (mother)
    protected String motherFullname;
    protected String motherOccupation;
    protected String motherContactNumber;

    //setter
    public abstract void setfullName(String fullName);
    public abstract void setSex(String sex);
    public abstract void setbirthDate(String birthDate);
    public abstract void setAge(int age);
    public abstract void setAddress(String address);
    public abstract void setLrn(String lrn);
    public abstract void setContactNumber(String contactNumber);

    public abstract void setEnglish(int english);
    public abstract void setMath(int math);
    public abstract void setScience(int science);

    public abstract void setFatherFullName(String fatherFullname);
    public abstract void setFatherOccupation(String fatherOccupation);
    public abstract void setFatherContactNumber(String fatherContactNumber);

    public abstract void setMotherFullName(String motherFullname);
    public abstract void setMotherOccupation(String motherOccupation);
    public abstract void setMotherContactNumber(String motherContactNumber);

    //getter
    public abstract String getfullName();
    public abstract String getSex();
    public abstract String getbirthDate();
    public abstract int getAge();
    public abstract String getAddress();
    public abstract String getLrn();
    public abstract String getContactNumber();

    public abstract int getEnglish();
    public abstract int getMath();
    public abstract int getScience();

    public abstract String getFatherFullName();
    public abstract String getFatherOccupation();
    public abstract String getFatherContactNumber();

    public abstract String getMotherFullName();
    public abstract String getMotherOccupation();
    public abstract String getMotherContactNumber();
}
class Enrollee extends EnrolleeData{
    private String username;

    public Enrollee(String username){
        this.username = username;
        database.add(this);
    }

    //Enrollee Database
    private static List<Enrollee> database = new ArrayList<>();


    //Get Data
    public static Enrollee EnrolleeData(String username){
        Enrollee temp = new Enrollee(username);
        for(Enrollee e: database){
            if(e.username.equals(username)){
                temp = e;
                break;
            }
        }
        return temp;
    }
    //Modify Data


















    //Student Fees
     private int tuitionFee = 2300;
     private int athleticFee = 200;
     private int computerFee = 1250;
     private int culturalFee = 100;
     private int developmentFee = 275;
     private int guidanceFee = 50;
     private int libraryFee = 75;
     private int medicalAndDentalFee= 130;
     private int registrationFee = 100;

    public void payTuitionFee(int tuitionFee){
        this.tuitionFee -= tuitionFee;
    }
    public void payAthleticFee(int athleticFee){
        this.athleticFee -= athleticFee;
    }
    public void payComputerFee(int computerFee){
        this.computerFee -= computerFee;
    }
    public void payCuluralFee(int culturalFee){
        this.culturalFee -= culturalFee;
    }
    public void payDevelopmentFee(int developmentFee){
        this.developmentFee -= developmentFee;
    }
    public void payGuidanceFee(int guidanceFee){
        this.guidanceFee -= guidanceFee;
    }
    public void payLibraryFee(int libraryFee){
        this.libraryFee -= libraryFee;
    }
    public void payMedicalAndDentalFee(int medicalAndDentalFee){
        this.medicalAndDentalFee -= medicalAndDentalFee;
    }
    public void payRegistrationFee(int registrationFee){
        this.registrationFee -= registrationFee;
    }

    //get
    public int getTuitionFee(){
        return tuitionFee;
    }
    public int getAthleticFee(){
        return athleticFee;
    }
    public int getComputerFee(){
        return computerFee;
    }
    public int getCulturalFee(){
        return culturalFee;
    }
    public int getDevelopmentFee(){
        return developmentFee;
    }
    public int getGuidanceFee(){
        return guidanceFee;
    }
    public int getLibraryFee(){
        return libraryFee;
    }
    public int getMedicalAndDentalFee(){
        return medicalAndDentalFee;
    }
    public int getRegistrationFee(){
        return registrationFee;
    }

    //StudentInformation
    @Override
    public void setfullName(String fullName){
        this.fullName = fullName;
    }
    @Override
    public void setSex(String sex){
        this.sex = sex;
    }
    @Override
    public void setbirthDate(String birthDate){
        this.birthDate = birthDate;
    }
    @Override
    public void setAge(int age){
        this.age = age;
    }
    @Override
    public void setAddress(String address){
        this.address = address;
    }
    @Override
    public void setLrn(String lrn){
        this.lrn = lrn;
    }
    @Override
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }

    @Override
    public String getfullName(){
        return this.fullName;
    }
    @Override
    public String getSex(){
        return this.sex;
    }
    @Override
    public String getbirthDate(){
        return this.birthDate;
    }
    @Override
    public int getAge(){
        return this.age;
    }
    @Override
    public String getAddress(){
        return this.address;
    }
    @Override
    public String getLrn(){
        return this.lrn;
    }
    @Override
    public String getContactNumber(){
        return this.contactNumber;
    }

    //StudentGrade
    @Override
    public void setEnglish(int english){
        this.english = english;
    }
    @Override
    public void setMath(int math){
        this.math = math;
    }
    @Override
    public void setScience(int science){
        this.science = science;
    }

    @Override
    public int getEnglish(){
        return this.english;
    }
    @Override
    public int getMath(){
        return this.math;
    }
    @Override
    public int getScience(){
        return this.science;
    }
    //Father information
    @Override
    public void setFatherFullName(String fatherFullname){
        this.fatherFullname = fatherFullname;
    }
    @Override
    public void setFatherOccupation(String fatherOccupation){
        this.fatherOccupation = fatherOccupation;
    }
    @Override
    public void setFatherContactNumber(String fatherContactNumber){
        this.fatherContactNumber = fatherContactNumber;
    }

    @Override
    public String getFatherFullName(){
        return this.fatherFullname;
    }
    @Override
    public String getFatherOccupation(){
        return this.fatherOccupation;
    }
    @Override
    public String getFatherContactNumber(){
        return this.fatherContactNumber;
    }
    //Mother information
    @Override
    public void setMotherFullName(String motherFullname){
        this.motherFullname = motherFullname;
    }
    @Override
    public void setMotherOccupation(String motherOccupation){
        this.motherOccupation = motherOccupation;
    }
    @Override
    public void setMotherContactNumber(String motherContactNumber){
        this.motherContactNumber = motherContactNumber;
    }

    @Override
    public String getMotherFullName(){
        return this.motherFullname;
    }
    @Override
    public String getMotherOccupation(){
        return this.motherOccupation;
    }
    @Override
    public String getMotherContactNumber(){
        return this.motherContactNumber;
    }
}
