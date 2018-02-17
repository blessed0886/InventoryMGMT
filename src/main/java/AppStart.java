public class AppStart {


    public static void main(String[] args) {
        String userInput;

        System.out.println(" __      __   _                    _                         \n" +
                " \\ \\    / /__| |__ ___ _ __  ___  | |_ ___                   \n" +
                "  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\                  \n" +
                "  _\\_/\\_/\\___|_\\__\\___/_|_|_\\___|  \\__\\___/ _                \n" +
                " / __| |_ ___ _ _ ___  |_ _|_ ___ _____ _ _| |_ ___ _ _ _  _ \n" +
                " \\__ \\  _/ _ \\ '_/ -_)  | || ' \\ V / -_) ' \\  _/ _ \\ '_| || |\n" +
                " |___/\\__\\___/_| \\___| |___|_||_\\_/\\___|_||_\\__\\___/_|  \\_, |\n" +
                "                                                        |__/ ");

        UserInterface userInterface = new UserInterface();
        userInterface.start();

        do{
            System.out.println("Would you like to exit this program?");
            userInput = Console.getUserInputString("Please enter yes or no.");
            if(userInput.equalsIgnoreCase("no")) userInterface.start();
            if(userInput.equalsIgnoreCase("yes")){
                System.out.println("         _____ _              _    __   __                  \n" +
                        "        |_   _| |_  __ _ _ _ | |__ \\ \\ / /__ _  _           \n" +
                        "          | | | ' \\/ _` | ' \\| / /  \\ V / _ \\ || |          \n" +
                        "          |_| |_||_\\__,_|_||_|_\\_\\   |_|\\___/\\_,_|          \n" +
                        "  _  _                       _  _ _          ___            \n" +
                        " | || |__ ___ _____   __ _  | \\| (_)__ ___  |   \\ __ _ _  _ \n" +
                        " | __ / _` \\ V / -_) / _` | | .` | / _/ -_) | |) / _` | || |\n" +
                        " |_||_\\__,_|\\_/\\___| \\__,_| |_|\\_|_\\__\\___| |___/\\__,_|\\_, |\n" +
                        "                                                       |__/ ");
                break;
            }
        } while(!(userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("no")));
    }
}
