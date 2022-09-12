import java.util.Date;
public class AlfredQuotes {
    //  Note: These greetings are not printed to the console,
    //        but returned as a String for use in the testing file.

    // Inputs: None
    // Return Type: String
    // Output: Returns some basic generic greeting that Alfred might say to anyone.
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    // Description: Returns a greeting that includes the person's name.
    // Inputs: String name
    // Return Type: String
    // Example Output: "Hello, Beth Kane. Lovely to see you."
    public String guestGreeting(String name) {
        return String.format("Hello, %s. Lovely to see you.", name);
    }

    // Description: Returns a polite announcement of the current date and time.
    // Inputs: None
    // Return Type: String
    // Example Output: "It is currently Wed Aug 11 16:34:59 PDT 2022."
    public String dateAnnouncement() {
        return String.format("It is currently %s.", new Date());
    }

    // Description: AlfredBot will periodically process audio (Alfred is listening.) Write a method that accepts any string of conversation and responds appropriately.
    // Specifications
    // - If "Alexis" appears in the conversation (in the string) return a snarky response, such as, "Right away, sir. She certainly isn't sophisticated enough for that."
    // - If "Alfred" is in the conversation return an obliging response, for example, "At your service. As you wish, naturally."
    // - If neither name is found, return an appropriate response, for instance, "Right. And with that I shall retire."
    // Inputs: String conversation
    // Return Type: String
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alexis")>-1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }

        if (conversation.indexOf("Alfred")>-1){
            return "At your service. As you wish, naturally.";
        }

        else {
            return "Right. And with that I shall retire.";
        }
    }

	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}