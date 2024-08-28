import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Problem 1
        String problem1 = "abcd.135";
        String regex1 = "\\b[A-Za-z]+\\.[0-9]+\\b";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(problem1);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }
        matcher1.reset();
        // Problem 2
        String problem2 = "abcd.135uvqz.7tzik.888";
        String regex2 = "\\.(\\d+)";
        Pattern groupPattern = Pattern.compile(regex2);
        Matcher groupMatcher = groupPattern.matcher(problem2);
        groupMatcher.reset();
        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }
        // Problem 3
        String problem3 = "abcd.135\tuvqz.7\ttzik.888\n";
        String regex3 = "\\d+";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(problem3);
        while (matcher3.find()) {
            System.out.println("Occurrence: " + matcher3.group());
        }
        // Problem 4
        String problem4 = "abcd.135\tuvqz.7\ttzik.888\n";
        String regex4 = "\\.(\\d+)(?:\\t|\\n)";
        Pattern pattern4 = Pattern.compile(regex4);
        Matcher matcher4 = pattern4.matcher(problem4);
        while (matcher4.find()) {
            System.out.println("Start Index: " + matcher4.start(1) + ", End Index: " + (matcher4.end(1) - 1));
        }
        // Problem 5
        String problem5 = "{0, 2}, {0, 7}, {1, 3}, {2, 4}";
        String regex5 = "\\{(.*?)\\}";
        Pattern pattern5 = Pattern.compile(regex5);
        Matcher matcher5 = pattern5.matcher(problem5);
        while (matcher5.find()) {
            System.out.println("Numbers in braces: " + matcher5.group(1));
        }
        // Problem 6
        String problem6 = "This is a sample string without p, q, or r.";
        String result6 = removeLetters(problem6);
        System.out.println("New String: " + result6);
        // Problem 7
        String problem7 = "AbC123";
        boolean containsOnlyCertainChars = checkCharacters(problem7);
        if (containsOnlyCertainChars) {
            System.out.println("String that contains specified characters");
        } else {
            System.out.println("String the contains other characters");
        }
        // Problem 8
        String[] gmailAddresses = {
                "abc.123@gmail.com",
                "78_Ty@gmail.com",
                "abc-34@gmail.com",
                "_%+-23Fg@gmail.com",
        };
        for (String address : gmailAddresses) {
            if (validateGmailAddress(address)) {
                System.out.println(address + " valid gmail address.");
            } else {
                System.out.println(address + " not a valid gmail address.");
            }
        }
        // Problem 9
        String[] urls = {
                "https://www.example.com:8080/path/to/page.html",
                "http://www.example.net/index.html",
                "https://blog.example.com/category/news/",
                "https://www.example.edu/about-us/team.html",
        };
        for (String url : urls) {
            if (isValidURL(url)) {
                System.out.println(url + " valid URL");
            } else {
                System.out.println(url + " invalid URL");
            }
        }
        // Problem 10
        String text = "www.example.com or blog.example.net fail xyz.example.zyx";
        findDomains(text);
        // Problem 11
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string to count on: ");
        String mainString = scanner.nextLine();
        System.out.print("Enter the substring to find count: ");
        String substring = scanner.nextLine();
        int count = substringOccurrences(mainString, substring);
        System.out.println("Number of occurrences of '" + substring + "': " + count);
        // Problem 12
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        boolean containsOnlyLetters = containsOnlyLetters(inputString);
        if (containsOnlyLetters) {
            System.out.println("The string contains only letters");
        } else {
            System.out.println("The string contains non-letters");
        }

        scanner.close();
    }
    public static String removeLetters(String input) {
        String result = input.replaceAll("[pqr]", "");
        if (result.equals(input)) {
            return "Not found";
        } else {
            return result;
        }
    }
    public static boolean checkCharacters(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }
    public static boolean validateGmailAddress(String address) {
        return address.matches("[a-zA-Z0-9._%+-]+@gmail\\.com");
    }
    public static boolean isValidURL(String url) {
        return url.matches("^(http|https)://[a-zA-Z0-9.-]+(:\\d+)?(/[a-zA-Z0-9./_-]*)?$");
    }
    public static void findDomains(String text) {
        String regex = "\\b(?:www\\.|blog\\.)[a-zA-Z0-9.-]+\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Domain name " + matcher.group());
        }
    }
    public static int substringOccurrences(String mainString, String substring) {
        Pattern pattern = Pattern.compile(substring);
        Matcher matcher = pattern.matcher(mainString);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
    public static boolean containsOnlyLetters(String input) {
        return input.matches("[a-zA-Z]+");
    }
}
