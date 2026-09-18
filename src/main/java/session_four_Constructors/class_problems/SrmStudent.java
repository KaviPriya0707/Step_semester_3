class SrmStudent {

    static String collegeName;
    static String academicYear;

    String name;

    static {

        collegeName =
            "SRM Institute of Science and Technology";

        academicYear = "2026-2027";

        System.out.println("College info loaded");
    }

    SrmStudent(String name) {

        this.name = name;

        System.out.println(
            "Student record created: " + name
        );
    }
}

class Main {

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        SrmStudent[] students =
            new SrmStudent[names.length];

        for (int i = 0; i < names.length; i++) {

            students[i] =
                new SrmStudent(names[i]);
        }
    }
}
