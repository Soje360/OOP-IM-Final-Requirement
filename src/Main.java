import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Enrollee obj1 = new Enrollee();
    private static boolean enrolled = false;
    private static boolean run = true;
    private static boolean paying = true;

    public static void main(String[] args) {
        DisplayLoginPage();
    }

    private static void DisplayLoginPage() {
        //login
        boolean isLogin = true;
        while (isLogin) {
            System.out.println("Welcome to the Nyoging University!");
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //access.verifyLogin();
                    ConsoleClear();
                    DisplayLobby();
                    break;
                case 2:
                    //access.verifySignup();
                    ConsoleClear();
                    break;
                case 3:
                    isLogin = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private static void DisplayLobby() {
        System.out.println("Dashboard!");
        System.out.println("1. Enrollment Page");
        System.out.println("2. Check Balance");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                EnrollPage();
                break;
            case 2:
                DisplayFees();
                while (enrolled) {
                    DisplayOptions();
                    Choosing();
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

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
                ConsoleClear();
            }
        }
        obj1.setfullName(fullName);
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
                    throw new IllegalArgumentException("Invalid scanner, Press ENTER to try again");
                }

                // If the scanner is valid, set the full gender description and break the loop
                gender = gender.equals("M") ? "Male" : "Female";
                fillingUp = false;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // Display the error message from the exception
                scanner.nextLine();
                ConsoleClear();
            }
        }
        obj1.setSex(gender);
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
                    throw new IllegalArgumentException("Invalid scanner, please type your Birth Date again.");
                }
                fillingUp = false;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            }
        }
        obj1.setbirthDate(birthDate);
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
                System.out.println("Invalid scanner. Age must not contain special characters. Please press ENTER to type your age again.");
                scanner.nextLine();
                ConsoleClear();

            } catch (IllegalArgumentException e) {
                // Handle age that is <= 0
                System.out.println(e.getMessage()); // Print the error message from the exception
                scanner.nextLine();
                ConsoleClear();
            }
        }
        obj1.setAge(age);
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
                    throw new IllegalArgumentException("Invalid scanner. Please press ENTER to try again.");
                }
                fillingUp = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            }
        }
        obj1.setAddress(address);
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
                    throw new IllegalArgumentException("Invalid scanner, LRN should contain only numbers. Please press ENTER to try again.");
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
                ConsoleClear();
            }
        }
        obj1.setLrn(lrn);
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
                ConsoleClear();
            }
        }
        obj1.setContactNumber(contactNumber);
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
                ConsoleClear();
            }
        }
        obj1.setEnglish(english);
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
                ConsoleClear();
            }
        }
        obj1.setMath(math);
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
                ConsoleClear();
            }
        }
        obj1.setScience(science);
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
                ConsoleClear();
            }
        }
        obj1.setFatherFullName(obj1.fatherFullname);
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
                ConsoleClear();
            }
        }
        obj1.setFatherOccupation(fatherOccupation);
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
                ConsoleClear();
            }
        }
        obj1.setFatherContactNumber(fatherContactNumber);
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
                ConsoleClear();
            }
        }
        obj1.setMotherFullName(motherFullName);
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
                ConsoleClear();
            }
        }
        obj1.setMotherFullName(obj1.motherOccupation);
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
                ConsoleClear();
            }
        }
        obj1.setMotherContactNumber(motherContactNumber);
    }

    //SHOWS ENROLL PAGE
    private static void EnrollPage() {
        ConsoleClear();
        System.out.println("Welcome to the Enrollment page!");
        System.out.println("[1] Enroll \n" +
                "[2] Show my Enrollment Details \n" +
                "[3] Go Back to lobby");
        boolean choosing = true;
        while (choosing) {
            try {
                System.out.print("Please enter your option: ");
                String option = scanner.nextLine().trim();
                // Check if the LRN only contains numbers
                if (!option.matches("[0-9]+")) {
                    throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                }
                if (option.length() != 1) {
                    throw new IllegalArgumentException("Invalid scanner. Please press ENTER to try again");
                }
                //exit loop
                choosing = false;
                switch (option) {
                    case "1":
                        EnrollStage();
                        break;
                    case "2":
                        EditStudentInfo();
                        break;
                    case "3":
                        System.out.println("Back to the lobby");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
                ConsoleClear();
            }
        }
    }

    //WHEN USER ENROLLS
    private static void EnrollStage() {
        boolean enrolling = true;
        while (enrolling) {
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
            FillUpFatherFullName();
            FillUpFatherOccupation();
            FillUpFatherContactNumber();
            FillUpMotherFullName();
            FillUpMotherOccupation();
            FillUpMotherContactNumber();


            if (obj1.getEnglish() > 84 && obj1.getMath() > 84 && obj1.getScience() > 84) {
                System.out.println("You are now enrolled! Please go to the enrollment page and see your Details.");
                enrolled = true;
            } else {
                System.out.println(obj1.getEnglish() + " " + obj1.getMath() + " " + obj1.getScience());
                System.out.println("Unfortunately, your general average in the three major subjects were not met. We might have to cancel your enrollment for now. \n" +
                        "Please press ENTER to go back to the enrollment page.");
                scanner.nextLine();
            }
            enrolling = false;
            EnrollPage();
        }
    }

    //SHOWS AND LETS USERS EDIT THEIR INFORMATION IF THEIR ACCOUNT IS ENROLLED AND VERIFIED
    private static void EditStudentInfo() {
        ConsoleClear();
        if (enrolled) {
            ConsoleClear();
            System.out.println("========== STUDENT INFORMATION ==========");
            System.out.println("Full Name       : " + obj1.getfullName());
            System.out.println("Gender          : " + obj1.getSex());
            System.out.println("Birth Date      : " + obj1.getbirthDate());
            System.out.println("Age             : " + obj1.getAge());
            System.out.println("Address         : " + obj1.getAddress());
            System.out.println("LRN             : " + obj1.getLrn());
            System.out.println("Contact Number  : " + obj1.getContactNumber());

            System.out.println("\n========== GRADE AVERAGES ==========");
            System.out.println("English         : " + obj1.getEnglish());
            System.out.println("Math            : " + obj1.getMath());
            System.out.println("Science         : " + obj1.getScience());

            System.out.println("\n========== PARENT INFORMATION ==========");
            System.out.println("-- Father --");
            System.out.println("Full Name       : " + obj1.getFatherFullName());
            System.out.println("Occupation      : " + obj1.getFatherOccupation());
            System.out.println("Contact Number  : " + obj1.getFatherContactNumber());
            System.out.println("-- Mother --");
            System.out.println("Full Name       : " + obj1.getMotherFullName());
            System.out.println("Occupation      : " + obj1.getMotherOccupation());
            System.out.println("Contact Number  : " + obj1.getMotherContactNumber());
            System.out.println("==========================================");

            System.out.println("Please select on what Details you want to edit: \n" +
                    "[1] Full Name\n" +
                    "[2] Gender \n" +
                    "[3] Age \n" +
                    "[4] Birth Date \n" +
                    "[5] Address \n" +
                    "[6] Learner Reference Number(LRN) \n" +
                    "[7] Contact Number \n" +
                    "[8] General Average(English) \n" +
                    "[9] General Average(Math) \n" +
                    "[10] General Average(Science) \n" +
                    "[11] Father's Full Name \n" +
                    "[12] Father's Occupation\n" +
                    "[13] Father's Contact Number\n" +
                    "[14] Mother's Full Name \n" +
                    "[15] Mother's Occupation \n" +
                    "[16] Mother's Contact Number \n" +
                    "[0] Go Back");

            boolean choosing = true;
            while (choosing) {
                try {
                    System.out.println("Please enter your option: ");
                    String option = scanner.nextLine().trim();
                    // Check if the LRN only contains numbers
                    if (!option.matches("[0-9]+")) {
                        throw new IllegalArgumentException("Contact Number should only contain numbers, Please press ENTER to try again.");
                    }
                    if (option.length() < 0 && option.length() > 16) {
                        throw new IllegalArgumentException("Invalid scanner. Please press ENTER to try again");
                    }
                    //exit loop
                    choosing = false;
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
                            FillUpEnglish();
                            EditStudentInfo();
                            break;
                        case "9":
                            FillUpMath();
                            EditStudentInfo();
                            break;
                        case "10":
                            FillUpScience();
                            EditStudentInfo();
                            break;
                        case "11":
                            FillUpFatherFullName();
                            EditStudentInfo();
                            break;
                        case "12":
                            FillUpFatherOccupation();
                            EditStudentInfo();
                            break;
                        case "13":
                            FillUpFatherContactNumber();
                            EditStudentInfo();
                            break;
                        case "14":
                            FillUpMotherFullName();
                            EditStudentInfo();
                            break;
                        case "15":
                            FillUpMotherOccupation();
                            EditStudentInfo();
                            break;
                        case "16":
                            FillUpMotherContactNumber();
                            EditStudentInfo();
                            break;
                        case "0":
                            EnrollPage();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                    ConsoleClear();
                }
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
        int totalMiscellaneous = obj1.getAthleticFee() + obj1.getComputerFee() + obj1.getCulturalFee() + obj1.getDevelopmentFee() + obj1.getGuidanceFee() + obj1.getLibraryFee() + obj1.getMedicalAndDentalFee() + obj1.getRegistrationFee();
        System.out.println("Student Fees:\n");
        String str = new StringBuilder()
                .append(MainFeeStrFormat("Tuition Fee", obj1.getTuitionFee()) + "\n")
                .append("MISCELLANEOUS\n")
                .append(MainFeeStrFormat("Athletic Fee", obj1.getAthleticFee()) + "\n")
                .append(SubFeeStrFormat("\tSports facilities and equipments", 100) + "\n")
                .append("\t(Athletic fee)\n")
                .append(SubFeeStrFormat("\tParticipation in Sports Competition", 100) + "\n")
                .append("\t(SCUAA Fee)\n")
                .append(MainFeeStrFormat("Computer Fee", obj1.getComputerFee()) + "\n")
                .append(SubFeeStrFormat("\tComputer Laboratory Fee", 750) + "\n")
                .append(SubFeeStrFormat("\tAudio-Visual Technology Services", 150) + "\n")
                .append(SubFeeStrFormat("\tInternet Fee", 350) + "\n")
                .append(MainFeeStrFormat("Cultural Fees", obj1.getCulturalFee()) + "\n")
                .append(MainFeeStrFormat("Development Fees", obj1.getDevelopmentFee()) + "\n")
                .append(SubFeeStrFormat("\tFederated Supreme Student Council", 25) + "\n")
                .append(SubFeeStrFormat("\tStudent Organization", 100) + "\n")
                .append(SubFeeStrFormat("\tStudent Publication/Newsletter", 100) + "\n")
                .append(SubFeeStrFormat("\tSupreme Student Council", 50) + "\n")
                .append(MainFeeStrFormat("Guidance Fees", obj1.getGuidanceFee()) + "\n")
                .append(MainFeeStrFormat("Library Fee", obj1.getLibraryFee()) + "\n")
                .append(MainFeeStrFormat("Medical and Dental Fee", obj1.getMedicalAndDentalFee()) + "\n")
                .append(SubFeeStrFormat("\tMedical Fee", 50) + "\n")
                .append(SubFeeStrFormat("\tDental Fee", 50) + "\n")
                .append(SubFeeStrFormat("\tInsurance Fee", 30) + "\n")
                .append(MainFeeStrFormat("Registration Fees", obj1.getRegistrationFee()) + "\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous) + "\n")
                .append("OTHER FEES\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + obj1.getTuitionFee()) + "\n")
                .toString();
        System.out.println(str);
    }

    private static void DisplayOptions() {
        System.out.println(
                "Options:\n"
                        + "[1] Pay Fees\n"
                        + "[2] Check Balance\n"
                        + "[3] Exit\n"
        );
    }

    private static void Choosing() {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose an action: ");
        int action = 0;
        boolean choosing = true;
        while (choosing) {
            try {
                action = input.nextInt();
                if (action > 0 && action < 4) {
                    choosing = false;
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
                while (paying) {
                    PayFees();
                }
                break;
            case 2:
                CheckBalance();
                break;
            case 3:
                //exit (exitwhile loop)
                run = false;
                break;
        }
    }

    private static void PayFees() {
        Scanner input = new Scanner(System.in);

        //clear console here
        ConsoleClear();
        int totalMiscellaneous = obj1.getAthleticFee() + obj1.getComputerFee() + obj1.getCulturalFee() + obj1.getDevelopmentFee() + obj1.getGuidanceFee() + obj1.getLibraryFee() + obj1.getMedicalAndDentalFee() + obj1.getRegistrationFee();
        String currentFees = new StringBuilder()
                .append("Current School Fees: \n")
                .append(MainFeeStrFormat("[1] Tuition Fee", obj1.getTuitionFee()) + "\n")
                .append(MainFeeStrFormat("[2] Athletic Fee", obj1.getAthleticFee()) + "\n")
                .append(MainFeeStrFormat("[3] Computer Fee", obj1.getComputerFee()) + "\n")
                .append(MainFeeStrFormat("[4] Cultural Fees", obj1.getCulturalFee()) + "\n")
                .append(MainFeeStrFormat("[5] Development Fees", obj1.getDevelopmentFee()) + "\n")
                .append(MainFeeStrFormat("[6] Guidance Fees", obj1.getGuidanceFee()) + "\n")
                .append(MainFeeStrFormat("[7] Library Fee", obj1.getLibraryFee()) + "\n")
                .append(MainFeeStrFormat("[8] Medical and Dental Fee", obj1.getMedicalAndDentalFee()) + "\n")
                .append(MainFeeStrFormat("[9] Registration Fees", obj1.getRegistrationFee()) + "\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous) + "\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + obj1.getTuitionFee()) + "\n")
                .append("[0]Exit \n")
                .toString();
        System.out.println(currentFees);
        System.out.print("What school fees would you like to pay? ");
        int action = -1;
        boolean choosing = true;
        while (choosing) {
            try {
                action = input.nextInt();
                if (action >= 0 && action < 10) {
                    choosing = false;
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
                //clear console here
                ConsoleClear();
                System.out.println("Tuition Fee: " + obj1.getTuitionFee());
                System.out.print("How much would you like to pay? ");
                obj1.payTuitionFee(input.nextInt());
                break;
            case 2:
                //clear console here
                ConsoleClear();
                System.out.println("Tuition Fee: " + obj1.getTuitionFee());
                System.out.print("How much would you like to pay? ");
                obj1.payAthleticFee(input.nextInt());
                break;
            case 3:
                //clear console here
                ConsoleClear();
                System.out.println("Computer Fee: " + obj1.getComputerFee());
                System.out.print("How much would you like to pay? ");
                obj1.payComputerFee(input.nextInt());
                break;
            case 4:
                //clear console here
                ConsoleClear();
                System.out.println("Cultural Fee: " + obj1.getCulturalFee());
                System.out.print("How much would you like to pay? ");
                obj1.payCuluralFee(input.nextInt());
                break;
            case 5:
                //clear console here
                ConsoleClear();
                System.out.println("Development Fee: " + obj1.getDevelopmentFee());
                System.out.print("How much would you like to pay? ");
                obj1.payDevelopmentFee(input.nextInt());
                break;
            case 6:
                //clear console here
                ConsoleClear();
                System.out.println("Guidance Fee: " + obj1.getGuidanceFee());
                System.out.print("How much would you like to pay? ");
                obj1.payGuidanceFee(input.nextInt());
                break;
            case 7:
                //clear console here
                ConsoleClear();
                System.out.println("Library Fee: " + obj1.getLibraryFee());
                System.out.print("How much would you like to pay? ");
                obj1.payLibraryFee(input.nextInt());
                break;
            case 8:
                //clear console here
                ConsoleClear();
                System.out.println("Medical and Dental Fee: " + obj1.getMedicalAndDentalFee());
                System.out.print("How much would you like to pay? ");
                obj1.payMedicalAndDentalFee(input.nextInt());
                break;
            case 9:
                //clear console here
                ConsoleClear();
                System.out.println("Registration Fee: " + obj1.getRegistrationFee());
                System.out.print("How much would you like to pay? ");
                obj1.payRegistrationFee(input.nextInt());
                break;
            case 0:
                paying = false;
                break;
        }
    }

    public static void ConsoleClear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void CheckBalance(){
        //clear console here
        ConsoleClear();

        int totalMiscellaneous = obj1.getAthleticFee() + obj1.getComputerFee() + obj1.getCulturalFee() + obj1.getDevelopmentFee() + obj1.getGuidanceFee() + obj1.getLibraryFee() + obj1.getMedicalAndDentalFee() + obj1.getRegistrationFee();
        String currentFees= new StringBuilder()
                .append("Current School Fees: \n")
                .append(MainFeeStrFormat("Tuition Fee", obj1.getTuitionFee())+"\n")
                .append(MainFeeStrFormat("Athletic Fee", obj1.getAthleticFee())+"\n")
                .append(MainFeeStrFormat("Computer Fee", obj1.getComputerFee())+"\n")
                .append(MainFeeStrFormat("Cultural Fees", obj1.getCulturalFee())+"\n")
                .append(MainFeeStrFormat("Development Fees", obj1.getDevelopmentFee())+"\n")
                .append(MainFeeStrFormat("Guidance Fees", obj1.getGuidanceFee())+"\n")
                .append(MainFeeStrFormat("Library Fee", obj1.getLibraryFee())+"\n")
                .append(MainFeeStrFormat("Medical and Dental Fee", obj1.getMedicalAndDentalFee())+"\n")
                .append(MainFeeStrFormat("Registration Fees", obj1.getRegistrationFee())+"\n")
                .append(MainFeeStrFormat("\t\tTOTAL MISCELLANEOUS:", totalMiscellaneous)+"\n")
                .append(MainFeeStrFormat("\t\tGRAND TOTAL:", totalMiscellaneous + obj1.getTuitionFee())+"\n")
                .toString();
        System.out.println(currentFees);
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