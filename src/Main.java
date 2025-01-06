import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Enrollee enrollee = null;
    private static boolean enrolled = false;


    public static void main(String[] args) {
        DisplayLoginPage();
    }
    private static void DisplayLoginPage() {
        //login
        boolean run = true;
        while (run) {
            String option = "";
            boolean choosing = true;
            while (choosing) {
                try {
                    System.out.println("███╗   ██╗██╗   ██╗ ██████╗  ██████╗ ██╗███╗   ██╗ ██████╗     ██╗   ██╗███╗   ██╗██╗██╗   ██╗███████╗██████╗ ███████╗██╗████████╗██╗   ██╗██╗\n" +
                            "████╗  ██║╚██╗ ██╔╝██╔═══██╗██╔════╝ ██║████╗  ██║██╔════╝     ██║   ██║████╗  ██║██║██║   ██║██╔════╝██╔══██╗██╔════╝██║╚══██╔══╝╚██╗ ██╔╝██║\n" +
                            "██╔██╗ ██║ ╚████╔╝ ██║   ██║██║  ███╗██║██╔██╗ ██║██║  ███╗    ██║   ██║██╔██╗ ██║██║██║   ██║█████╗  ██████╔╝███████╗██║   ██║    ╚████╔╝ ██║\n" +
                            "██║╚██╗██║  ╚██╔╝  ██║   ██║██║   ██║██║██║╚██╗██║██║   ██║    ██║   ██║██║╚██╗██║██║╚██╗ ██╔╝██╔══╝  ██╔══██╗╚════██║██║   ██║     ╚██╔╝  ╚═╝\n" +
                            "██║ ╚████║   ██║   ╚██████╔╝╚██████╔╝██║██║ ╚████║╚██████╔╝    ╚██████╔╝██║ ╚████║██║ ╚████╔╝ ███████╗██║  ██║███████║██║   ██║      ██║   ██╗\n" +
                            "╚═╝  ╚═══╝   ╚═╝    ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝      ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚══════╝╚═╝   ╚═╝      ╚═╝   ╚═╝");
                    System.out.println("Nyoging University!");
                    System.out.println("[1] Login");
                    System.out.println("[2] Signup");
                    System.out.println("[3] Exit");
                    System.out.print("Choose an option: ");
                    option = scanner.nextLine().trim();
                    if (!option.matches("[0-9]+")) {
                        throw new IllegalArgumentException("Your choice must only contain numbers, Please press ENTER to try again.");
                    }
                    else if (option.length() != 1) {
                        throw new IllegalArgumentException("Invalid input. Please press ENTER to try again");
                    }
                    else{
                        //exit loop
                        choosing = false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    ConsoleClear();
                }
            }
            switch (option) {
                case "1":
                    while(true){
                        ConsoleClear();
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        if(Account.LoginAccess(username,password)){
                            enrollee = Enrollee.EnrolleeData(username);
                            ConsoleClear();
                            run = false;
                            DisplayLobby();
                            break;
                        }
                        else{
                            System.out.println("Incorrect username or password! \n1. Try again. \n2. Exit");
                            System.out.print("Choose an option: ");
                            if(scanner.nextInt() == 2){
                                scanner.nextLine();
                                ConsoleClear();
                                break;
                            }
                            scanner.nextLine();
                        }
                    }

                    break;
                case "2":
                    while (true) {
                        String username= "";
                        while (true){
                            ConsoleClear();
                            System.out.print("Enter Username: ");
                            username = scanner.nextLine();
                            if(Account.hasAccount(username)){
                                System.out.println("Account already exists. Please try a different username.");
                                System.out.println("Click enter to continue.");
                                scanner.nextLine();

                            }else{
                                break;
                            }
                        }

                        while(true){
                            System.out.print("Enter Password: ");
                            String password = scanner.nextLine();

                            System.out.print("Re-enter Password: ");
                            String repassword = scanner.nextLine();

                            if (password.equals(repassword)) {
                                Account account = new Account(username,password);
                                ConsoleClear();
                                break;
                            }else{
                                System.out.println("Password does not match. Please try again");
                            }
                        }
                        break;
                    }
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void DisplayLobby() {
        boolean choosing = true;
        String option = "";
        while (choosing) {
            try {
                System.out.println("██████╗  █████╗ ███████╗██╗  ██╗██████╗  ██████╗  █████╗ ██████╗ ██████╗ ██╗\n" +
                        "██╔══██╗██╔══██╗██╔════╝██║  ██║██╔══██╗██╔═══██╗██╔══██╗██╔══██╗██╔══██╗██║\n" +
                        "██║  ██║███████║███████╗███████║██████╔╝██║   ██║███████║██████╔╝██║  ██║██║\n" +
                        "██║  ██║██╔══██║╚════██║██╔══██║██╔══██╗██║   ██║██╔══██║██╔══██╗██║  ██║╚═╝\n" +
                        "██████╔╝██║  ██║███████║██║  ██║██████╔╝╚██████╔╝██║  ██║██║  ██║██████╔╝██╗\n" +
                        "╚═════╝ ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚═╝");
                System.out.println("Dashboard!");
                System.out.println("[1] Enrollment Page");
                System.out.println("[2] Check Balance");
                System.out.println("[3] Logout");
                System.out.print("Choose an option: ");
                option = scanner.nextLine().trim();
                if (!option.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Your choice must only contain numbers, Please press ENTER to try again.");
                }
                else if (option.length() != 1) {
                    throw new IllegalArgumentException("Invalid input. Please press ENTER to try again");
                }
                else{
                    //exit loop
                    choosing = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            }
        }
        switch (option) {
            case "1":
                ConsoleClear();
                EnrollPage();
                break;
            case "2":
                ConsoleClear();
                DisplayFees();
                break;
            case "3":
                ConsoleClear();
                DisplayLoginPage();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    //SHOWS ENROLL PAGE
    private static void EnrollPage() {
        boolean onEnrollPage = true;
        while(onEnrollPage){
            ConsoleClear();
            System.out.println("███████╗███╗   ██╗██████╗  ██████╗ ██╗     ██╗     ██╗\n" +
                    "██╔════╝████╗  ██║██╔══██╗██╔═══██╗██║     ██║     ██║\n" +
                    "█████╗  ██╔██╗ ██║██████╔╝██║   ██║██║     ██║     ██║\n" +
                    "██╔══╝  ██║╚██╗██║██╔══██╗██║   ██║██║     ██║     ╚═╝\n" +
                    "███████╗██║ ╚████║██║  ██║╚██████╔╝███████╗███████╗██╗\n" +
                    "╚══════╝╚═╝  ╚═══╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝╚═╝");
            System.out.println("Welcome to the Enrollment page!");
            System.out.println("[1] Enroll \n" +
                    "[2] Enrollment Details \n" +
                    "[3] Exit");
            boolean choosing = true;
            String option = "";
            while (choosing) {
                try {
                    System.out.print("Please enter your option: ");
                    option = scanner.nextLine().trim();
                    if (!option.matches("[0-9]+")) {
                        throw new IllegalArgumentException("Your choice must only contain numbers, Please press ENTER to try again.");
                    }
                    else if (option.length() != 1) {
                        throw new IllegalArgumentException("Invalid input. Please press ENTER to try again");
                    }
                    else{
                        //exit loop
                        choosing = false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    ConsoleClear();
                }
            }
            switch (option) {
                case "1":
                    if(enrolled){
                        System.out.println("You are already enrolled!\n" +
                                "Press ENTER to continue");
                        scanner.nextLine();
                    }
                    else{
                        ConsoleClear();
                        onEnrollPage = false;
                        EnrollStage();
                    }
                    break;
                case "2":
                    ConsoleClear();
                    onEnrollPage = false;
                    EditStudentInfo();
                    break;
                case "3":
                    ConsoleClear();
                    onEnrollPage = false;
                    DisplayLobby();
                    break;
            }

        }
    }

    //WHEN USER ENROLLS
    private static void EnrollStage() {
        FillUpFullName();
        FillUpGender();
        FillUpAge();
        FillUpBirthDate();
        FillUpAddress();
        FillUpLRN();
        FillUpContactNumber();
        FillUpEnglish();
        FillUpMath();
        FillUpScience();
        if (enrollee.getEnglish() > 84 && enrollee.getMath() > 84 && enrollee.getScience() > 84) {
            FillUpFatherFullName();
            FillUpFatherOccupation();
            FillUpFatherContactNumber();
            FillUpMotherFullName();
            FillUpMotherOccupation();
            FillUpMotherContactNumber();

            System.out.println("You are now enrolled! Please go to the enrollment page and see your Details.\n" +
                    "Press ENTER to continue");
            scanner.nextLine();
            enrolled = true;
        } else {
            System.out.println("English: " + enrollee.getEnglish() + "\nMath: " + enrollee.getMath() + "\nScience" + enrollee.getScience());
            System.out.println("Unfortunately, your general average in the three major subjects were not met. We might have to cancel your enrollment for now. \n" +
                    "Press ENTER to continue.");
            scanner.nextLine();
        }

        EnrollPage();
    }

    //SHOWS AND LETS USERS EDIT THEIR INFORMATION IF THEIR ACCOUNT IS ENROLLED AND VERIFIED
    private static void EditStudentInfo() {
        ConsoleClear();
        if (enrolled) {
            ConsoleClear();
            System.out.println("███████╗████████╗██╗   ██╗██████╗ ███████╗███╗   ██╗████████╗    ██╗███╗   ██╗███████╗ ██████╗ ██████╗ ███╗   ███╗ █████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                    "██╔════╝╚══██╔══╝██║   ██║██╔══██╗██╔════╝████╗  ██║╚══██╔══╝    ██║████╗  ██║██╔════╝██╔═══██╗██╔══██╗████╗ ████║██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                    "███████╗   ██║   ██║   ██║██║  ██║█████╗  ██╔██╗ ██║   ██║       ██║██╔██╗ ██║█████╗  ██║   ██║██████╔╝██╔████╔██║███████║   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                    "╚════██║   ██║   ██║   ██║██║  ██║██╔══╝  ██║╚██╗██║   ██║       ██║██║╚██╗██║██╔══╝  ██║   ██║██╔══██╗██║╚██╔╝██║██╔══██║   ██║   ██║██║   ██║██║╚██╗██║\n" +
                    "███████║   ██║   ╚██████╔╝██████╔╝███████╗██║ ╚████║   ██║       ██║██║ ╚████║██║     ╚██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║\n" +
                    "╚══════╝   ╚═╝    ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝");
            System.out.println("Full Name       : " + enrollee.getfullName());
            System.out.println("Gender          : " + enrollee.getSex());
            System.out.println("Birth Date      : " + enrollee.getbirthDate());
            System.out.println("Age             : " + enrollee.getAge());
            System.out.println("Address         : " + enrollee.getAddress());
            System.out.println("LRN             : " + enrollee.getLrn());
            System.out.println("Contact Number  : " + enrollee.getContactNumber());

            System.out.println(" ██████╗ ██████╗  █████╗ ██████╗ ███████╗     █████╗ ██╗   ██╗███████╗██████╗  █████╗  ██████╗ ███████╗███████╗\n" +
                    "██╔════╝ ██╔══██╗██╔══██╗██╔══██╗██╔════╝    ██╔══██╗██║   ██║██╔════╝██╔══██╗██╔══██╗██╔════╝ ██╔════╝██╔════╝\n" +
                    "██║  ███╗██████╔╝███████║██║  ██║█████╗      ███████║██║   ██║█████╗  ██████╔╝███████║██║  ███╗█████╗  ███████╗\n" +
                    "██║   ██║██╔══██╗██╔══██║██║  ██║██╔══╝      ██╔══██║╚██╗ ██╔╝██╔══╝  ██╔══██╗██╔══██║██║   ██║██╔══╝  ╚════██║\n" +
                    "╚██████╔╝██║  ██║██║  ██║██████╔╝███████╗    ██║  ██║ ╚████╔╝ ███████╗██║  ██║██║  ██║╚██████╔╝███████╗███████║\n" +
                    " ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝╚═════╝ ╚══════╝    ╚═╝  ╚═╝  ╚═══╝  ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝");
            System.out.println("English         : " + enrollee.getEnglish());
            System.out.println("Math            : " + enrollee.getMath());
            System.out.println("Science         : " + enrollee.getScience());

            System.out.println("██████╗  █████╗ ██████╗ ███████╗███╗   ██╗████████╗    ██╗███╗   ██╗███████╗ ██████╗ ██████╗ ███╗   ███╗ █████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                    "██╔══██╗██╔══██╗██╔══██╗██╔════╝████╗  ██║╚══██╔══╝    ██║████╗  ██║██╔════╝██╔═══██╗██╔══██╗████╗ ████║██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                    "██████╔╝███████║██████╔╝█████╗  ██╔██╗ ██║   ██║       ██║██╔██╗ ██║█████╗  ██║   ██║██████╔╝██╔████╔██║███████║   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                    "██╔═══╝ ██╔══██║██╔══██╗██╔══╝  ██║╚██╗██║   ██║       ██║██║╚██╗██║██╔══╝  ██║   ██║██╔══██╗██║╚██╔╝██║██╔══██║   ██║   ██║██║   ██║██║╚██╗██║\n" +
                    "██║     ██║  ██║██║  ██║███████╗██║ ╚████║   ██║       ██║██║ ╚████║██║     ╚██████╔╝██║  ██║██║ ╚═╝ ██║██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║\n" +
                    "╚═╝     ╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝");
            System.out.println("-- Father --");
            System.out.println("Full Name       : " + enrollee.getFatherFullName());
            System.out.println("Occupation      : " + enrollee.getFatherOccupation());
            System.out.println("Contact Number  : " + enrollee.getFatherContactNumber());
            System.out.println("-- Mother --");
            System.out.println("Full Name       : " + enrollee.getMotherFullName());
            System.out.println("Occupation      : " + enrollee.getMotherOccupation());
            System.out.println("Contact Number  : " + enrollee.getMotherContactNumber());
            System.out.println("==========================================");

            System.out.println("Please select on what Details you want to edit: \n" +
                    "[1] Full Name\n" +
                    "[2] Gender \n" +
                    "[3] Age \n" +
                    "[4] Birth Date \n" +
                    "[5] Address \n" +
                    "[6] Learner Reference Number(LRN) \n" +
                    "[7] Contact Number \n" +
                    "[8] Father's Full Name \n" +
                    "[9] Father's Occupation\n" +
                    "[10] Father's Contact Number\n" +
                    "[11] Mother's Full Name \n" +
                    "[12] Mother's Occupation \n" +
                    "[13] Mother's Contact Number \n" +
                    "[0] Go Back");

            boolean choosing = true;
            String option = "";
            while (choosing) {
                try {
                    System.out.print("Please enter your option: ");
                    option = scanner.nextLine().trim();
                    if (!option.matches("[0-9]+")) {
                        throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                    }
                    else if (Integer.parseInt(option) < 0 && Integer.parseInt(option) > 14) {
                        throw new IllegalArgumentException("Invalid input. Please press ENTER to try again");
                    }
                    else{
                        //exit loop
                        choosing = false;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    ConsoleClear();
                }
            }
            switch (option) {
                case "1":
                    FillUpFullName();
                    EditStudentInfo();
                    break;
                case "2":
                    FillUpGender();
                    EditStudentInfo();
                    break;
                case "3":
                    FillUpAge();
                    EditStudentInfo();
                    break;
                case "4":
                    FillUpBirthDate();
                    EditStudentInfo();
                    break;
                case "5":
                    FillUpAddress();
                    EditStudentInfo();
                    break;
                case "6":
                    FillUpLRN();
                    EditStudentInfo();
                    break;
                case "7":
                    FillUpContactNumber();
                    EditStudentInfo();
                    break;
                case "8":
                    FillUpFatherFullName();
                    EditStudentInfo();
                    break;
                case "9":
                    FillUpFatherOccupation();
                    EditStudentInfo();
                    break;
                case "10":
                    FillUpFatherContactNumber();
                    EditStudentInfo();
                    break;
                case "11":
                    FillUpMotherFullName();
                    EditStudentInfo();
                    break;
                case "12":
                    FillUpMotherOccupation();
                    EditStudentInfo();
                    break;
                case "13":
                    FillUpMotherContactNumber();
                    EditStudentInfo();
                    break;
                case "0":
                    EnrollPage();
            }
        } else {
            ConsoleClear();
            System.out.print("Your account has not been enrolled yet, Please press ENTER to try and enroll to the Enrollment Page!");
            scanner.nextLine();
            ConsoleClear();
            EnrollPage();
        }
    }

    //Student Fees
    private static void DisplayFees() {
        int totalMiscellaneous = enrollee.getAthleticFee() + enrollee.getComputerFee() + enrollee.getCulturalFee() + enrollee.getDevelopmentFee() + enrollee.getGuidanceFee() + enrollee.getLibraryFee() + enrollee.getMedicalAndDentalFee() + enrollee.getRegistrationFee();
        System.out.println("███████╗████████╗██╗   ██╗██████╗ ███████╗███╗   ██╗████████╗    ███████╗███████╗███████╗███████╗\n" +
                "██╔════╝╚══██╔══╝██║   ██║██╔══██╗██╔════╝████╗  ██║╚══██╔══╝    ██╔════╝██╔════╝██╔════╝██╔════╝\n" +
                "███████╗   ██║   ██║   ██║██║  ██║█████╗  ██╔██╗ ██║   ██║       █████╗  █████╗  █████╗  ███████╗\n" +
                "╚════██║   ██║   ██║   ██║██║  ██║██╔══╝  ██║╚██╗██║   ██║       ██╔══╝  ██╔══╝  ██╔══╝  ╚════██║\n" +
                "███████║   ██║   ╚██████╔╝██████╔╝███████╗██║ ╚████║   ██║       ██║     ███████╗███████╗███████║\n" +
                "╚══════╝   ╚═╝    ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝     ╚══════╝╚══════╝╚══════╝");
        String str = new StringBuilder()
                .append(MainFeeStrFormat("Tuition Fee", enrollee.getTuitionFee()) + "\n")
                .append("MISCELLANEOUS\n")
                .append(MainFeeStrFormat("Athletic Fee", enrollee.getAthleticFee()) + "\n")
                .append(SubFeeStrFormat("\tSports facilities and equipments", 100) + "\n")
                .append("\t(Athletic fee)\n")
                .append(SubFeeStrFormat("\tParticipation in Sports Competition", 100) + "\n")
                .append("\t(SCUAA Fee)\n")
                .append(MainFeeStrFormat("Computer Fee", enrollee.getComputerFee()) + "\n")
                .append(SubFeeStrFormat("\tComputer Laboratory Fee", 750) + "\n")
                .append(SubFeeStrFormat("\tAudio-Visual Technology Services", 150) + "\n")
                .append(SubFeeStrFormat("\tInternet Fee", 350) + "\n")
                .append(MainFeeStrFormat("Cultural Fees", enrollee.getCulturalFee()) + "\n")
                .append(MainFeeStrFormat("Development Fees", enrollee.getDevelopmentFee()) + "\n")
                .append(SubFeeStrFormat("\tFederated Supreme Student Council", 25) + "\n")
                .append(SubFeeStrFormat("\tStudent Organization", 100) + "\n")
                .append(SubFeeStrFormat("\tStudent Publication/Newsletter", 100) + "\n")
                .append(SubFeeStrFormat("\tSupreme Student Council", 50) + "\n")
                .append(MainFeeStrFormat("Guidance Fees", enrollee.getGuidanceFee()) + "\n")
                .append(MainFeeStrFormat("Library Fee", enrollee.getLibraryFee()) + "\n")
                .append(MainFeeStrFormat("Medical and Dental Fee", enrollee.getMedicalAndDentalFee()) + "\n")
                .append(SubFeeStrFormat("\tMedical Fee", 50) + "\n")
                .append(SubFeeStrFormat("\tDental Fee", 50) + "\n")
                .append(SubFeeStrFormat("\tInsurance Fee", 30) + "\n")
                .append(MainFeeStrFormat("Registration Fees", enrollee.getRegistrationFee()) + "\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous) + "\n")
                .append("OTHER FEES\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + enrollee.getTuitionFee()) + "\n")
                .toString();
        System.out.println(str);

        if(enrolled) {
            System.out.println(
                    "Options:\n"
                            + "[1] Pay Fees\n"
                            + "[2] Check Balance\n"
                            + "[3] Exit\n"
            );
            int action = 0;
            boolean onChoosing = true;
            while(onChoosing){
                while (true) {
                    try {
                        System.out.print("Choose an action: ");
                        action = scanner.nextInt();
                        if (action > 0 && action < 4) {
                            break;
                        } else {
                            System.out.println("Input not in choices!");
                        }
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid Input!");
                        break;
                    }
                }
                switch (action) {
                    case 1:
                        onChoosing = false;
                        PayFees();
                        break;
                    case 2:
                        onChoosing = false;
                        CheckBalance();
                        break;
                    case 3:
                        //exit (exitwhile loop)
                        ConsoleClear();
                        onChoosing = false;
                        DisplayLobby();
                        break;
                }
            }
        }
        else{
            System.out.println("Press anything to continue!");
            scanner.nextLine();
            ConsoleClear();
            DisplayLobby();
        }
    }

    private static void PayFees() {
        Scanner input = new Scanner(System.in);

        //clear console here
        ConsoleClear();
        int totalMiscellaneous = enrollee.getAthleticFee() + enrollee.getComputerFee() + enrollee.getCulturalFee() + enrollee.getDevelopmentFee() + enrollee.getGuidanceFee() + enrollee.getLibraryFee() + enrollee.getMedicalAndDentalFee() + enrollee.getRegistrationFee();
        String currentFees = new StringBuilder()
                .append("███████╗████████╗██╗   ██╗██████╗ ███████╗███╗   ██╗████████╗    ███████╗███████╗███████╗███████╗\n" +
                        "██╔════╝╚══██╔══╝██║   ██║██╔══██╗██╔════╝████╗  ██║╚══██╔══╝    ██╔════╝██╔════╝██╔════╝██╔════╝\n" +
                        "███████╗   ██║   ██║   ██║██║  ██║█████╗  ██╔██╗ ██║   ██║       █████╗  █████╗  █████╗  ███████╗\n" +
                        "╚════██║   ██║   ██║   ██║██║  ██║██╔══╝  ██║╚██╗██║   ██║       ██╔══╝  ██╔══╝  ██╔══╝  ╚════██║\n" +
                        "███████║   ██║   ╚██████╔╝██████╔╝███████╗██║ ╚████║   ██║       ██║     ███████╗███████╗███████║\n" +
                        "╚══════╝   ╚═╝    ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝   ╚═╝       ╚═╝     ╚══════╝╚══════╝╚══════╝")
                .append(MainFeeStrFormat("[1] Tuition Fee", enrollee.getTuitionFee()) + "\n")
                .append(MainFeeStrFormat("[2] Athletic Fee", enrollee.getAthleticFee()) + "\n")
                .append(MainFeeStrFormat("[3] Computer Fee", enrollee.getComputerFee()) + "\n")
                .append(MainFeeStrFormat("[4] Cultural Fees", enrollee.getCulturalFee()) + "\n")
                .append(MainFeeStrFormat("[5] Development Fees", enrollee.getDevelopmentFee()) + "\n")
                .append(MainFeeStrFormat("[6] Guidance Fees", enrollee.getGuidanceFee()) + "\n")
                .append(MainFeeStrFormat("[7] Library Fee", enrollee.getLibraryFee()) + "\n")
                .append(MainFeeStrFormat("[8] Medical and Dental Fee", enrollee.getMedicalAndDentalFee()) + "\n")
                .append(MainFeeStrFormat("[9] Registration Fees", enrollee.getRegistrationFee()) + "\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous) + "\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + enrollee.getTuitionFee()) + "\n")
                .append("[0]Exit \n")
                .toString();
        System.out.println(currentFees);
        System.out.print("What school fees would you like to pay? ");
        int action = -1;
        while (true) {
            try {
                action = input.nextInt();
                if (action >= 0 && action < 10) {
                    break;
                } else {
                    System.out.println("Input not in choices!");
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid Input!");
                break;
            }
        }
        int pay = 0;
        switch (action) {
            case 1:
                //clear console here
                System.out.println("Tuition Fee: " + enrollee.getTuitionFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getTuitionFee()){
                        System.out.println("Amount exceeds tuition fee!");
                    }
                    else if(pay == enrollee.getTuitionFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payTuitionFee(pay);
                break;
            case 2:
                //clear console here
                System.out.println("Athletic Fee: " + enrollee.getAthleticFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getAthleticFee()){
                        System.out.println("Amount exceeds athletic fee!");
                    }
                    else if(pay == enrollee.getAthleticFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payAthleticFee(pay);
                break;
            case 3:
                //clear console here
                System.out.println("Computer Fee: " + enrollee.getComputerFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getComputerFee()){
                        System.out.println("Amount exceeds computer fee!");
                    }
                    else if(pay == enrollee.getComputerFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payComputerFee(pay);
                break;
            case 4:
                System.out.println("Cultural Fee: " + enrollee.getCulturalFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getCulturalFee()){
                        System.out.println("Amount exceeds cultural fee!");
                    }
                    else if(pay == enrollee.getCulturalFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payCuluralFee(pay);
                break;
            case 5:
                System.out.println("Development Fee: " + enrollee.getDevelopmentFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getDevelopmentFee()){
                        System.out.println("Amount exceeds developtment fee!");
                    }
                    else if(pay == enrollee.getDevelopmentFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payDevelopmentFee(pay);
                break;
            case 6:
                System.out.println("Guidance Fee: " + enrollee.getGuidanceFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getGuidanceFee()){
                        System.out.println("Amount exceeds guidance fee!");
                    }
                    else if(pay == enrollee.getGuidanceFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payGuidanceFee(pay);
                break;
            case 7:
                System.out.println("Library Fee: " + enrollee.getLibraryFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getLibraryFee()){
                        System.out.println("Amount exceeds library fee!");
                    }
                    else if(pay == enrollee.getLibraryFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payLibraryFee(pay);
                break;
            case 8:
                System.out.println("Medical and Dental Fee: " + enrollee.getMedicalAndDentalFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getMedicalAndDentalFee()){
                        System.out.println("Amount exceeds medical fee!");
                    }
                    else if(pay == enrollee.getMedicalAndDentalFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payMedicalAndDentalFee(pay);
                break;
            case 9:
                System.out.println("Registration Fee: " + enrollee.getRegistrationFee());
                System.out.print("How much would you like to pay? ");
                while(true){
                    pay = input.nextInt();
                    if(pay > enrollee.getRegistrationFee()){
                        System.out.println("Amount exceeds registration fee!");
                    }
                    else if(pay == enrollee.getRegistrationFee()){
                        System.out.println("Amount fully paid! Thank you!");
                        break;
                    }
                    else if(pay < 0){
                        System.out.println("Amount can't be negative!");
                    }
                    else{
                        break;
                    }
                }
                enrollee.payRegistrationFee(pay);
                break;
            case 0:
                ConsoleClear();
                DisplayFees();
                break;
        }
        ConsoleClear();
        DisplayFees();
    }


    private static void CheckBalance(){
        //clear console here
        ConsoleClear();

        int totalMiscellaneous = enrollee.getAthleticFee() + enrollee.getComputerFee() + enrollee.getCulturalFee() + enrollee.getDevelopmentFee() + enrollee.getGuidanceFee() + enrollee.getLibraryFee() + enrollee.getMedicalAndDentalFee() + enrollee.getRegistrationFee();
        String currentFees= new StringBuilder()
                .append("Current School Fees: \n")
                .append(MainFeeStrFormat("Tuition Fee", enrollee.getTuitionFee())+"\n")
                .append(MainFeeStrFormat("Athletic Fee", enrollee.getAthleticFee())+"\n")
                .append(MainFeeStrFormat("Computer Fee", enrollee.getComputerFee())+"\n")
                .append(MainFeeStrFormat("Cultural Fees", enrollee.getCulturalFee())+"\n")
                .append(MainFeeStrFormat("Development Fees", enrollee.getDevelopmentFee())+"\n")
                .append(MainFeeStrFormat("Guidance Fees", enrollee.getGuidanceFee())+"\n")
                .append(MainFeeStrFormat("Library Fee", enrollee.getLibraryFee())+"\n")
                .append(MainFeeStrFormat("Medical and Dental Fee", enrollee.getMedicalAndDentalFee())+"\n")
                .append(MainFeeStrFormat("Registration Fees", enrollee.getRegistrationFee())+"\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous)+"\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + enrollee.getTuitionFee())+"\n")
                .toString();
        System.out.println(currentFees);
        System.out.print("Press Enter to Go Back!");
        scanner.nextLine();
        ConsoleClear();
        DisplayFees();
    }

    //Fill up
    private static void FillUpFullName() {
        boolean fillingUp = true;
        String fullName = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your full name (First Name, Middle Name, Last Name): ");
                fullName = scanner.nextLine().trim().toUpperCase(); // Read the input and remove any leading/trailing spaces

                // Validate the full name: It should not be empty and should only contain letters and spaces
                if (fullName.isEmpty()) {
                    throw new IllegalArgumentException("Full name cannot be empty, Please press ENTER to try again. ");
                }
                // Check if the name contains only letters and spaces (no digits or special characters)
                if (!fullName.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Full name can only contain letters and spaces, Please press ENTER to try again. ");

                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                // Handle invalid full name scanner (e.g., empty or contains invalid characters)
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setfullName(fullName);
    }

    //Gender
    private static void FillUpGender() {
        boolean fillingUp = true;
        String gender = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Gender (M for male, F for female): ");
                gender = scanner.nextLine().trim().toUpperCase(); // Read, trim, and convert to uppercase

                // Validate scanner: it must be 'M' or 'F'
                if (gender.length() != 1 || (gender.charAt(0) != 'M' && gender.charAt(0) != 'F')) {
                    throw new IllegalArgumentException("Invalid input, Press ENTER to try again");
                }

                // If the scanner is valid, set the full gender description and break the loop
                gender = gender.equals("M") ? "Male" : "Female";
                fillingUp = false;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // Display the error message from the exception
                scanner.nextLine();
            }
        }
        enrollee.setSex(gender);
    }

    //Birthdate
    private static void FillUpBirthDate() {
        boolean fillingUp = true;
        String birthDate = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Birthdate (i.ex. November 11, 2003 ):");
                birthDate = scanner.nextLine().trim().toUpperCase();
                // Regex pattern to match only letters, digits, commas, dots, and spaces
                if (!birthDate.matches("[a-zA-Z0-9., ]*")) {
                    throw new IllegalArgumentException("Invalid input, please type your Birth Date again.");
                }
                fillingUp = false;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setbirthDate(birthDate);
    }

    //Age
    private static void FillUpAge() {
        boolean fillingUp = true;
        int age = 0;
        while (fillingUp) {
            try {
                System.out.print("Please enter your age: ");
                age = Integer.parseInt(scanner.nextLine().trim());

                // Validate the age: it must be positive
                if (age <= 0) {
                    throw new IllegalArgumentException("Age must be a positive number, Please press ENTER to try again.");
                }

                // If the scanner is valid, exit the loop
                fillingUp = false;

            } catch (NumberFormatException e) {
                // Handle non-integer scanners (e.g., letters, special characters)
                System.out.println("Invalid input. Age must not contain special characters. Please press ENTER to type your age again.");
                scanner.nextLine();
                ConsoleClear();

            } catch (IllegalArgumentException e) {
                // Handle age that is <= 0
                System.out.println(e.getMessage()); // Print the error message from the exception
                scanner.nextLine();
            }
        }
        enrollee.setAge(age);
    }

    //Address
    private static void FillUpAddress() {
        boolean fillingUp = true;
        String address = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Address: ");
                address = scanner.nextLine().trim();

                // Regex pattern to match only letters, digits, commas, dots, and spaces
                if (!address.matches("[a-zA-Z0-9., ]*")) {
                    throw new IllegalArgumentException("Invalid input. Please press ENTER to try again.");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setAddress(address);
    }

    //LRN
    private static void FillUpLRN() {
        boolean fillingUp = true;
        String lrn = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Learner Reference Number (LRN): ");
                lrn = scanner.nextLine().trim();

                // Check if the LRN only contains numbers
                if (!lrn.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Invalid input, LRN should contain only numbers. Please press ENTER to try again.");
                }
                //check for valid lrn length
                if (lrn.length() != 12) {
                    throw new IllegalArgumentException("LRN must be exactly 12 digits long. Please press ENTER to try again");
                }
                //exit loop
                fillingUp = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setLrn(lrn);
    }

    //LRN
    private static void FillUpContactNumber() {
        boolean fillingUp = true;
        String contactNumber = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your contact number: ");
                contactNumber = scanner.nextLine().trim();
                // Check if the LRN only contains numbers
                if (!contactNumber.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                }
                if (contactNumber.length() != 11) {
                    throw new IllegalArgumentException("Contact Number must be exactly 11 digits long. Please press ENTER to try again");
                }
                //exit loop
                fillingUp = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setContactNumber(contactNumber);
    }

    //Student Grade English
    private static void FillUpEnglish() {
        boolean fillingUp = true;
        int english = 0;
        while (fillingUp) {
            try {
                System.out.print("Please enter your general average in English (estimated): ");
                english = scanner.nextInt();
                scanner.nextLine();

                // Check for valid general average
                if (english <= 0) {
                    throw new IllegalArgumentException("General Average must not be negative, Please press ENTER to try again.");
                } else if (english > 100) {
                    throw new IllegalArgumentException("General Average should not exceed 100, Please press ENTER to try again.");
                }
                //exit loop
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            } catch (InputMismatchException e) {
                System.out.println("General Average should only contain numbers, Please press ENTER to try again.");
                scanner.nextLine();
            }
        }
        enrollee.setEnglish(english);
    }

    //Student Grade Math
    private static void FillUpMath() {
        boolean fillingUp = true;
        int math = 0;
        while (fillingUp) {
            try {
                System.out.print("Please enter your general average in Math (estimated): ");
                math = scanner.nextInt();
                scanner.nextLine();

                // Check for valid general average
                if (math <= 0) {
                    throw new IllegalArgumentException("General Average must not be negative, Please press ENTER to try again.");
                } else if (math > 100) {
                    throw new IllegalArgumentException("General Average should not exceed 100, Please press ENTER to try again.");
                }
                //exit loop
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            } catch (InputMismatchException e) {
                System.out.println("General Average should only contain numbers, Please press ENTER to try again.");
                scanner.nextLine();
            }
        }
        enrollee.setMath(math);
    }

    //Student Grade Science
    private static void FillUpScience() {
        boolean fillingUp = true;
        int science = 0;
        while (fillingUp) {
            try {
                System.out.print("Please enter your general average in Science (estimated): ");
                science = scanner.nextInt();
                scanner.nextLine();

                // Check for valid general average
                if (science <= 0) {
                    throw new IllegalArgumentException("General Average must not be negative, Please press ENTER to try again.");
                } else if (science > 100) {
                    throw new IllegalArgumentException("General Average should not exceed 100, Please press ENTER to try again.");
                }
                //exit loop
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            } catch (InputMismatchException e) {
                System.out.println("General Average should only contain numbers, Please press ENTER to try again.");
                scanner.nextLine();
            }
        }
        enrollee.setScience(science);
    }

    //FATHER'S INFORMATION
    //FullName
    private static void FillUpFatherFullName() {
        boolean fillingUp = true;
        String fatherFullName = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Father's full name (First Name, Middle Name, Last Name): ");
                fatherFullName = scanner.nextLine().trim().toUpperCase(); // Read the input and remove any leading/trailing spaces

                // Validate the full name: It should not be empty and should only contain letters and spaces
                if (fatherFullName.isEmpty()) {
                    throw new IllegalArgumentException("Full name cannot be empty, Please press ENTER to try again. ");
                }
                // Check if the name contains only letters and spaces (no digits or special characters)
                if (!fatherFullName.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Full name can only contain letters and spaces, Please press ENTER to try again. ");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                // Handle invalid full name scanner (e.g., empty or contains invalid characters)
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setFatherFullName(fatherFullName);
    }

    //Father Occupation
    private static void FillUpFatherOccupation() {
        boolean fillingUp = true;
        String fatherOccupation = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Father's Occupation: ");
                fatherOccupation = scanner.nextLine().trim().toUpperCase(); // Read the input and remove any leading/trailing spaces

                // Validate the full name: It should not be empty and should only contain letters and spaces
                if (fatherOccupation.isEmpty()) {
                    throw new IllegalArgumentException("Occupation cannot be empty, Please press ENTER to try again. ");
                }
                // Check if the name contains only letters and spaces (no digits or special characters)
                if (!fatherOccupation.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Occupation can only contain letters and spaces, Please press ENTER to try again. ");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                // Handle invalid full name scanner (e.g., empty or contains invalid characters)
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setFatherOccupation(fatherOccupation);
    }

    //Father Contact Number
    private static void FillUpFatherContactNumber() {
        boolean fillingUp = true;
        String fatherContactNumber = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Father's contact number: ");
                fatherContactNumber = scanner.nextLine().trim();
                // Check if the LRN only contains numbers
                if (!fatherContactNumber.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                }
                if (fatherContactNumber.length() != 11) {
                    throw new IllegalArgumentException("Contact Number must be exactly 11 digits long. Please press ENTER to try again");
                }
                //exit loop
                fillingUp = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setFatherContactNumber(fatherContactNumber);
    }

    //MOTHER'S INFORMATION
    //FullName
    private static void FillUpMotherFullName() {
        boolean fillingUp = true;
        String motherFullName = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Mother's full name (First Name, Middle Name, Last Name): ");
                motherFullName = scanner.nextLine().trim().toUpperCase(); // Read the input and remove any leading/trailing spaces

                // Validate the full name: It should not be empty and should only contain letters and spaces
                if (motherFullName.isEmpty()) {
                    throw new IllegalArgumentException("Full name cannot be empty, Please press ENTER to try again. ");
                }
                // Check if the name contains only letters and spaces (no digits or special characters)
                if (!motherFullName.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Full name can only contain letters and spaces, Please press ENTER to try again. ");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                // Handle invalid full name scanner (e.g., empty or contains invalid characters)
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setMotherFullName(motherFullName);
    }

    //Father Occupation
    private static void FillUpMotherOccupation() {
        boolean fillingUp = true;
        String motherOccupation = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Mother's Occupation: ");
                motherOccupation = scanner.nextLine().trim().toUpperCase(); // Read the input and remove any leading/trailing spaces

                // Validate the full name: It should not be empty and should only contain letters and spaces
                if (motherOccupation.isEmpty()) {
                    throw new IllegalArgumentException("Occupation cannot be empty, Please press ENTER to try again. ");
                }
                // Check if the name contains only letters and spaces (no digits or special characters)
                if (!motherOccupation.matches("[a-zA-Z ]+")) {
                    throw new IllegalArgumentException("Occupation can only contain letters and spaces, Please press ENTER to try again. ");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                // Handle invalid full name scanner (e.g., empty or contains invalid characters)
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setMotherOccupation(motherOccupation);
    }

    //Father Contact Number
    private static void FillUpMotherContactNumber() {
        boolean fillingUp = true;
        String motherContactNumber = "";
        while (fillingUp) {
            try {
                System.out.print("Please enter your Mother's contact number: ");
                motherContactNumber = scanner.nextLine().trim();
                // Check if the LRN only contains numbers
                if (!motherContactNumber.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                }
                if (motherContactNumber.length() != 11) {
                    throw new IllegalArgumentException("Contact Number must be exactly 11 digits long. Please press ENTER to try again");
                }
                //exit loop
                fillingUp = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        enrollee.setMotherContactNumber(motherContactNumber);
    }
    public static void ConsoleClear() {
        for(int i = 0; i <69; i++){
            System.out.println();
        }

//        System.out.print("\033[H\033[2J");
//        System.out.flush();
    }
    private static String MainFeeStrFormat(String str,int num){
        int trimmedLength = str.trim().length();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == '\t'){
                //change depending on console tab(\t) length
                trimmedLength += 4;
            }
        }
        for(int i = 0; i < 100-trimmedLength; i++){
            str += " ";
        }
        str += num;
        return str;
    }
    private static String SubFeeStrFormat(String str,int num){
        int trimmedLength = str.trim().length();
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == '\t'){
                //change depending on console tab(\t) length + 8 (e.g 8+8)
                trimmedLength += 16;
            }
        }
        for(int i = 0; i < 100-trimmedLength; i++){
            str += " ";
        }
        str += num;
        return str;
    }

}