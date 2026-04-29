//package data;
//
//import entity.Laptop;
//import entity.gaminglaptop;
//import entity.outdatedlaptop;
//import service.LaptopService;
//
//public class Data {
//
//    private LaptopService ltp = new LaptopService();
//
////    public void addDatabase() {
////        Employee exp1 = new Experience("1", "Huynh Loi Thanh", "20/09/2002", "0920516389", "Loihuynh@gmail.com", 130, 5,
////                "A");
////        Employee exp2 = new Experience("2", "Thanh Loi Huynh", "01/06/2002", "0923456782", "1huynhloi@gmail.com", 150,
////                2, "B");
////        Employee exp3 = new Experience("3", "Loi Thanh Huynh", "11/12/2002", "0123553381", "huynh2loi@gmail.com", 2,
////                3, "C");
////        Employee exp4 = new Experience("4", "Nguyen Duc Hieu", "23/12/2002", "0123456789", "duchieu@gmail.com", 400,
////                15, "A");
////        Employee fre1 = new Fresher("5", "Nguyen Quoc Khanh", "11/02/2002", "0783984721", "quockhanh@gmail.com", 150,
////                "20/09/2020", "A", "SGU");
////        Employee fre2 = new Fresher("6", "Nguyen Khanh Quoc", "12/02/2002", "0783984721", "quockhanh2@gmail.com", 140,
////                "20/09/2020", "B", "FPT");
////        Employee fre3 = new Fresher("7", "Quoc Nguyen Khanh", "13/02/2002", "0783984721", "quockhanh3@gmail.com", 4,
////                "20/09/2020", "C", "BKU");
////        Employee fre4 = new Fresher("8", "Duc Hieu Nguyen", "12/03/2002", "0123456789", "hieuduc@gmail.com", 400,
////                "20/09/2021", "B", "FTU");
////        Employee int1 = new Intern("9", "Bui Doan Buu Khanh", "29/02/2002", "0123456789", "buukhanh@gmail.com", 85,
////                "IT", 2, "SGU");
////        Employee int2 = new Intern("10", "Bui Doan Khanh Buu", "29/02/2002", "0123456789", "buukhanh@gmail.com", 70,
////                "Software", 1, "UIT");
////        Employee int3 = new Intern("11", "Bui Khanh Buu Doan", "29/02/2002", "0123456789", "buukhanh@gmail.com", 1,
////                "Designer", 3, "VLU");
////        Employee int4 = new Intern("12", "Hieu Duc Nguyen", "23/01/2002", "0123456789", "nguyenhieu@gmail.com", 300,
////                "Tester", 20, "HUFLIT");
////
////        Employee exp5 = new Experience("13", "Nguyen Duc Hieu", "23/12/2002", "0123456789", "duchieu@gmail.com", 200,
////                10, "A");
////        Employee exp6 = new Experience("14", "Nguyen Duc Hieu", "23/12/2002", "0123456789", "duchieu@gmail.com", 200,
////                10, "B");
////        Employee exp7 = new Experience("15", "Nguyen Duc Hieu", "23/12/2002", "0123456789", "duchieu@gmail.com", 200,
////                10, "C");
////
////        this.employeeManager.insert(exp1);
////        this.employeeManager.insert(exp2);
////        this.employeeManager.insert(exp3);
////        this.employeeManager.insert(exp4);
////        this.employeeManager.insert(fre1);
////        this.employeeManager.insert(fre2);
////        this.employeeManager.insert(fre3);
////        this.employeeManager.insert(fre4);
////        this.employeeManager.insert(int1);
////        this.employeeManager.insert(int2);
////        this.employeeManager.insert(int3);
////        this.employeeManager.insert(int4);
////        this.employeeManager.insert(exp5);
////        this.employeeManager.insert(exp6);
////        this.employeeManager.insert(exp7);
////    }
//
//    /**
//     * Employee
//     * type = 0 => Experience
//     * type = 1 => Fresher
//     * type = 2 => Intern
//     */
//    public void insert(int type) {
//        Employee employee = null;
//        if (type == 0) {
//            employee = insertExperience();
//        }
//        if (type == 1) {
//            employee = insertFresher();
//        }
//        if (type == 2) {
//            employee = insertIntern();
//        }
//
//        this.employeeManager.insert(employee);
//    }
//
////    private Experience insertExperience() {
////        Experience experience = new Experience();
////        var scanner = ScannerFactory.getScanner();
////        System.out.print("ID: ");
////        String id = scanner.nextLine();
////        System.out.print("Name: ");
////        String name = scanner.nextLine();
////        System.out.print("Birthday: ");
////        String birthday = scanner.nextLine();
////        System.out.print("Phone: ");
////        String phone = scanner.nextLine();
////        System.out.print("Email: ");
////        String email = scanner.nextLine();
////        System.out.print("Work Hour: ");
////        float workingHours = Float.parseFloat(scanner.nextLine());
////        System.out.print("Year Of Experience: ");
////        int yearOfExperience = Integer.parseInt(scanner.nextLine());
////        System.out.print("Pro Skill: ");
////        String proSkill = scanner.nextLine();
////
////        experience.setId(id);
////        experience.setFullName(name);
////        experience.setBirthday(birthday);
////        experience.setPhone(phone);
////        experience.setEmail(email);
////        experience.setWorkingHours(workingHours);
////        experience.setYearOfExperience(yearOfExperience);
////        experience.setProSkill(proSkill);
////
////        return experience;
////    }
//
////    private Intern insertIntern() {
////
////        Intern intern = new Intern();
////        var scanner = ScannerFactory.getScanner();
////        System.out.print("ID: ");
////        String id = scanner.nextLine();
////        System.out.print("Name: ");
////        String name = scanner.nextLine();
////        System.out.print("Birthday: ");
////        String birthday = scanner.nextLine();
////        System.out.print("Phone: ");
////        String phone = scanner.nextLine();
////        System.out.print("Email: ");
////        String email = scanner.nextLine();
////        System.out.print("Work Hour: ");
////        float workingHours = Float.parseFloat(scanner.nextLine());
////        System.out.print("Major: ");
////        String major = scanner.nextLine();
////        System.out.print("Semester: ");
////        int semester = Integer.parseInt(scanner.nextLine());
////        System.out.print("University Name: ");
////        String universityName = scanner.nextLine();
////
////        intern.setId(id);
////        intern.setFullName(name);
////        intern.setPhone(phone);
////        intern.setEmail(email);
////        intern.setBirthday(birthday);
////        intern.setWorkingHours(workingHours);
////        intern.setMajor(major);
////        intern.setSemester(semester);
////        intern.setUniversityName(universityName);
////
////        return intern;
////    }
//
////    private Fresher insertFresher() {
////        Fresher fresher = new Fresher();
////        var scanner = ScannerFactory.getScanner();
////        System.out.print("ID: ");
////        String id = scanner.nextLine();
////        System.out.print("Name: ");
////        String name = scanner.nextLine();
////        System.out.print("Birthday: ");
////        String birthday = scanner.nextLine();
////        System.out.print("Phone: ");
////        String phone = scanner.nextLine();
////        System.out.print("Email: ");
////        String email = scanner.nextLine();
////        System.out.print("Work Hour: ");
////        float workingHours = Float.parseFloat(scanner.nextLine());
////        System.out.print("Graduation Date: ");
////        String graduationDate = scanner.nextLine();
////        System.out.print("Graduation Rank: ");
////        String graduationRank = scanner.nextLine();
////        System.out.print("University Name: ");
////        String universityName = scanner.nextLine();
////
////        fresher.setId(id);
////        fresher.setFullName(name);
////        fresher.setBirthday(birthday);
////        fresher.setPhone(phone);
////        fresher.setEmail(email);
////        fresher.setWorkingHours(workingHours);
////        fresher.setGraduationDate(graduationDate);
////        fresher.setGraduationRank(graduationRank);
////        fresher.setEducation(universityName);
////
////        return fresher;
////    }
//
////    public void showByID(String id) {
////        Employee employee = this.employeeManager.findById(id);
////        employee.showInfo();
////    }
////
////    public void SortEmployeeByTotalSalary_MinDownMax() {
////        employeeManager.sortByTotalSalaryMinDownMax();
////    }
////
////    public void SortEmployeeByTotalSalary_MaxDownMin() {
////        employeeManager.sortByTotalSalaryMaxDownMin();
////    }
////
////    public void SortEmployeeByID_MinDownMax() {
////        employeeManager.sortByIDMinDownMax();
////    }
////
////    public void SortEmployeeByID_MaxDownMin() {
////        employeeManager.sortByIDMaxDownMin();
////    }
//
//    // Cập nhật lại các thông tin của nhân viên
////    public void update(String id) {
////        Employee employee = this.employeeManager.findById(id);
////        var scanner = ScannerFactory.getScanner();
////
////        System.out.print("Name: ");
////        String name = scanner.nextLine();
////        System.out.print("Birthday: ");
////        String birthday = scanner.nextLine();
////        System.out.print("Phone: ");
////        String phone = scanner.nextLine();
////        System.out.print("Email: ");
////        String email = scanner.nextLine();
////        System.out.print("Work Hour: ");
////        float workingHours = Float.parseFloat(scanner.nextLine());
////
////        employee.setFullName(name);
////        employee.setBirthday(birthday);
////        employee.setPhone(phone);
////        employee.setEmail(email);
////        employee.setWorkingHours(workingHours);
////
////        employee.updateInfoOfStaff();// Nhập các thông tin đặc biệt của từng loại nhân viên
////    }
//
////    // Xóa nhân viên theo id
////    public void delete(String id) {
////        if (this.employeeManager.deleteById(id)) {
////            System.out.println("Employee has been deleted.");
////        } else {
////            System.out.println("Employee is not found.");
////        }
////    }
////
////    // Hiển thị các nhân viên loại Experience
////    public void showExperienceEmployee() {
////        this.employeeManager.findByType(0).forEach(Employee::showInfo);
////        // forEach() + "::": duyệt các phần tử của List Employee bằng cách sử dụng
////        // phương thức tham chiếu.
////    }
////
////    // Hiển thị các nhân viên loại Fresher
////    public void showFresherEmployee() {
////        this.employeeManager.findByType(1).forEach(Employee::showInfo);
////        // forEach() + "::": duyệt các phần tử của List Employee bằng cách sử dụng
////        // phương thức tham chiếu.
////    }
////
////    // Hiển thị các nhân viên loại Intern
////    public void showInternEmployee() {
////        this.employeeManager.findByType(2).forEach(Employee::showInfo);
////        // forEach() + "::": duyệt các phần tử của List Employee bằng cách sử dụng
////        // phương thức tham chiếu.
////    }
////
////    // Hiển thị tất cả nhân viên
////    public void showAllEmployee() {
////        this.employeeManager.findAll().forEach(Employee::showInfo);
////        // forEach() + "::": duyệt các phần tử của List Employee bằng cách sử dụng
////        // phương thức tham chiếu.
////    }
//}