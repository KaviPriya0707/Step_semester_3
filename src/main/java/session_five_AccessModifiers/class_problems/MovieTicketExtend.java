class MovieTicket {
}

class PremiumMovieTicket extends MovieTicket {
}

class AccessChecker {

    static String classifyAccess(
            String fieldModifier,
            String accessorContext) {

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (accessorContext.equals("SAME_CLASS")) {

            if (fieldModifier.equals("private") ||
                fieldModifier.equals("default") ||
                fieldModifier.equals("protected")) {

                return "ALLOWED";
            }
        }

        if (accessorContext.equals("SAME_PACKAGE")) {

            if (fieldModifier.equals("default") ||
                fieldModifier.equals("protected")) {

                return "ALLOWED";
            }
        }

        if (accessorContext.equals(
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (fieldModifier.equals("protected")) {
                return "ALLOWED";
            }
        }

        return "DENIED";
    }
}

class Main {

    public static void main(String[] args) {

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            AccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        System.out.println(
            AccessChecker.classifyAccess(
                "private",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );
    }
}
